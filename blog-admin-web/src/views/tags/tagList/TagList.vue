<template>
  <div class="m-container-small m-padded-tb-big">
    <div class="ui container">
      <table class="ui teal table">
<!--        <thead>-->
<!--        <tr>-->
<!--          <th></th>-->
<!--          <th>名称</th>-->
<!--          <th>颜色</th>-->
<!--          <th>操作</th>-->
<!--        </tr>-->
<!--        </thead>-->
<!--        <tbody>-->
<!--        <tr v-if="pageTag"-->
<!--            v-for="item in pageTag.list"-->
<!--            :key="item.id"-->
<!--        >-->
<!--          <td>{{ item.id }}</td>-->
<!--          <td>{{ item.name }}</td>-->
<!--          <td :style="{'color': item.tagColour}">{{ item.tagColour }}</td>-->
<!--          <td>-->
<!--            <a @click="editorTag(item.id)" class="ui mini teal basic button">编辑</a>-->
<!--            <a @click="deleteTag(item.id)" class="ui mini red basic button">删除</a>-->
<!--          </td>-->
<!--        </tr>-->
<!--        </tbody>-->
        <el-table
                :data="pageTag.list"
                style="width: 100%">
          <el-table-column
                  label="id"
                  width="180">
            <template slot-scope="scope">
              <span>{{ scope.row.id }}</span>
            </template>
          </el-table-column>
          <el-table-column
                  label="名称"
                  width="180">
            <template slot-scope="scope">
              <span>{{ scope.row.name }}</span>
            </template>
          </el-table-column>
          <el-table-column
                  label="色彩"
                  width="180">
            <template slot-scope="scope">
              <el-tag :style="{'color': scope.row.tagColour, 'border-color': scope.row.tagColour }">
                {{ scope.row.tagColour }}
              </el-tag>
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
          <th colspan="6">
            <div class="block">
              <el-pagination
                  layout="prev, pager, next"
                  :page-size=pageTag.pageSize
                  :page-count="4"
                  background
                  @current-change="pageTo"
                  :total=pageTag.total>
              </el-pagination>
            </div>
            <a @click="addBtn" class="ui addType mini right floated teal basic button">新增</a>
          </th>
        </tr>
        </tfoot>
      </table>
    </div>
  </div>
</template>

<script>
  export default {
    name: "TagList",
    data() {
      return {
        pageTag: {  },
        pageNum: 0
      }
    },
    activated() {  },
    mounted() {
      if (this.$route.query.tagMassage) {
        this.open('编辑')
      }
      this.getPageTag()
    },
    methods: {
      getPageTag() {
        $.get({
          url: 'pagetags',
          data: { 'pageNum': this.pageNum },
          success: res => {
            this.pageTag = res
          }
        })
      },
      handleEdit(index, row) {
        this.$router.push({
          path: '/tags/input',
          query: {
            tagId: row.id
          }
        })
      },
      handleDelete(idnex, row) {
        let msg = confirm('确认删除 '+ row.name + ' 标签吗？')
        if (msg) {
          $.post({
            url: 'deleteTag',
            data: { 'id': row.id },
            success: res => {
              if (res === 0){
                this.getPageTag()
                this.open("删除")
              } else {
                this.openError("删除")
              }
            }
          })
        }
      },
      addBtn() {
        this.$router.push('/tags/input')
      },
      pageTo(pageNum) {
        this.pageNum = pageNum
        this.getPageTag()
      },
      open(msg) {
        this.$message({
          message: msg + '标签成功。',
          type: 'success'
        });
      },
      openError(msg) {
        this.$message.error(msg + '标签失败！');
      },
    }
  }
</script>

<style scoped>

</style>
