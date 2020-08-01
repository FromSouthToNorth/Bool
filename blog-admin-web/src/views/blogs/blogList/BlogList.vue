<template>
  <div class="m-padded-tb-big">
    <div class="ui container">
      <form class="ui secondary segment form">
        <div class="inline fields">
          <div class="field">
            <el-input v-model="title" placeholder="请输入标题"></el-input>
          </div>
          <div class="field">
            <div class="ui labeled acton input">
              <template>
                <el-select v-model="typeId" clearable placeholder="请选择">
                  <el-option
                      v-for="item in typeList"
                      :key="item.id"
                      :label="item.name"
                      :value="item.id">
                  </el-option>
                </el-select>
              </template>
              <el-button @click="clear"
                size="mini"
                style="margin-left: 10px"
                icon="el-icon-setting">清除</el-button>
            </div>
          </div>
          <div class="field">
            <div class="ui checkbox">
              <el-switch
                  v-model="recommend"
                  inactive-text="是否推荐">
              </el-switch>
            </div>
          </div>
          <div class="field">
            <el-button type="primary"
              @click="search"
              size="mini"
              icon="el-icon-search" plain>搜索</el-button>
          </div>
        </div>
      </form>
      <div id="table-container">
        <table class="ui compact teal table">
          <el-table
              :data="pageBlog.list"
              style="width: 100%">
            <el-table-column
                label="名称"
                width="">
              <template slot-scope="scope">
                <el-popover trigger="hover" placement="top">
                  <div class="block">
                    <el-image :src="scope.row.firstPicture" style="width: 200px;"></el-image>
                  </div>
                  <div slot="reference" class="name-wrapper">
                    <el-tag size="medium">{{ scope.row.title }}</el-tag>
                  </div>
                </el-popover>
              </template>
            </el-table-column>
            <el-table-column
                label="类型">
              <template slot-scope="scope">
                <span>{{ scope.row.type.name }}</span>
              </template>
            </el-table-column>
            <el-table-column
                width="100px;"
                label="是否推荐">
              <template slot-scope="scope">
                <el-tag
                    :type="scope.row.recommend ? 'success' : 'warning'"
                    disable-transitions
                    :text="scope.row.recommend ? isRecommend = '是': isPublished = '否'">
                  {{ isRecommend }}
                </el-tag>
              </template>
            </el-table-column>
            <el-table-column
                width="100px;"
                label="状态">
              <template slot-scope="scope">
                <el-tag
                  :type="scope.row.published ? 'success' : 'warning'"
                  disable-transitions
                  :text="scope.row.published ? isPublished = '是': isPublished = '否'">
                  {{ isPublished }}
                </el-tag>
              </template>
            </el-table-column>
            <el-table-column
                label="更新日期"
                width="180">
              <template slot-scope="scope">
                <i class="el-icon-time"></i>
                <span style="margin-left: 10px">{{ getTime(scope.row.updateTime) }}</span>
              </template>
            </el-table-column>
            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button
                    size="mini"
                    icon="el-icon-edit"
                    @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                <el-button
                    size="mini"
                    type="danger"
                    icon="el-icon-delete"
                    @click="handleDelete(scope.$index, scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
          <tfoot>
          <tr>
            <th colspan="7">
              <div class="block">
                <el-pagination
                    layout="prev, pager, next"
                    :page-size=pageBlog.pageSize
                    :page-count="4"
                    background
                    @current-change="pageTo"
                    :total=pageBlog.total>
                </el-pagination>
              </div>
              <a @click="addBtn()" class="ui mini right floated teal basic button" style="margin-top: 20px">新增</a>
            </th>
          </tr>
          </tfoot>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "BlogList",
    data() {
      return {
        title: '',
        typeId: '',
        recommend: true,
        showRecommend: '是',
        pageNum: 0,
        pageBlog: {  },
        typeList: [  ],
        value: '',
        isPublished: '',
        isRecommend: '',
      }
    },
    activated() {
      $.get({
        url: 'types',
        success: res => {
          this.typeList = res
        }
      })
      this.getPageBlog()
      if (this.$route.query.massage) {
        this.open('编辑')
      }
    },
    methods: {
      getComment(id) {
        this.$router.push({
          path: '/comment',
          query: {
            blogId: id
          }
        })
      },
      getPageBlog() {
        $.get({
          url: 'blogs',
          data: { 'pageNum': this.pageNum },
          success: res => {
            this.pageBlog = res
          }
        })
      },
      getTime(time) {
        return time.substring(0, 10)
      },
      pageTo(pageNum) {
        this.pageNum = pageNum
        this.getPageBlog()
      },
      search() {
        $.post({
          url: '/blog/search',
          data: { 'pageNum': this.pageNum, 'title': this.title, 'typeId': this.typeId, 'recommend': this.recommend },
          success: res => {
            this.pageBlog = res
          }
        })
      },
      handleDelete(index, row) {
        let meg = confirm('确认删除标题为：'+ row.title + ' 的博客吗？')
        if (meg) {
          $.get({
            url: '/blog/delete',
            data: { 'id': row.id },
            success: res => {
              if (res === 1) {
                this.getPageBlog()
                this.open('删除')
              } else {
                this.openError('删除')
              }
            }
          })
        }
      },
      open(msg) {
        this.$message({
          message: msg + '博客成功。',
          type: 'success'
        });
      },
      openError(msg) {
        this.$message.error(msg + '博客失败！');
      },
      // 跳转编辑页面
      handleEdit(index, row) {
        this.$router.push({
          path: '/blogs/input',
          query: {
            blogId: row.id
          }
        })
      },
      clear() {
        this.title = ''
        this.typeId = ''
        this.recommend = true
        this.getPageBlog()
      },
      addBtn() {
        this.$router.push('/blogs/input')
      }
    }
  }
</script>

<style scoped>

</style>
