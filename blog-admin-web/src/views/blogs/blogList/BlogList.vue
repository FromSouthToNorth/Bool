<template>
  <div class="m-padded-tb-big">
    <div class="ui container">
      <form class="ui secondary segment form">
        <div class="inline fields">
          <div class="field">
            <input type="text" v-model="title" placeholder="标题">
          </div>
          <div class="field">
            <div class="ui labeled acton input">
              <div class="ui type selection dropdown">
                <input type="hidden" v-model="typeId">
                <i class="dropdown icon"></i>
                <div class="default text">分类</div>
                <div class="menu">
                  <div class="item"
                  v-if="typeList"
                  v-for="item in typeList"
                  :key="item.id"
                  :data-value="item.id"
                  >{{ item.name }}</div>
                </div>
              </div>
              <button @click="clear" class="ui compact clear button" type="button">clear</button>
            </div>
          </div>
          <div class="field">
            <div class="ui checkbox">
              <input type="checkbox"
                     @click="recommend=!recommend"
                     :checked="recommend"
                     id="recommend">
              <label for="recommend">推荐</label>
            </div>
          </div>
          <div class="field">
            <button type="button" @click="search" class="ui mini teal basic button"><i class="search icon"></i>搜索</button>
          </div>
        </div>
      </form>
      <div id="table-container">
        <table class="ui compact teal table">
          <thead>
          <tr>
            <th></th>
            <th>标题</th>
            <th>类型</th>
            <th>推荐</th>
            <th>状态</th>
            <th>更新时间</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <tr v-if="pageBlog"
          v-for="item in pageBlog.list"
          :key="item.id"
          >
            <td>{{ item.id }}</td>
            <td>{{ item.title }}</td>
            <td>{{ item.type.name }}</td>
            <td v-text="item.recommend ? '是' : '否'"></td>
            <td v-text="item.published ? '发布' : '草稿'"></td>
            <td>{{ getTime(item.updateTime) }}</td>
            <td>
              <a @click="blogEditor(item.id)" class="ui mini teal basic button">编辑</a>
              <a @click="getComment(item.id)" class="ui mini blue basic button">查看评论</a>
              <a @click="deleteBlog(item.id)" class="ui mini red basic button">删除</a>
            </td>
          </tr>
          </tbody>
          <tfoot>
          <tr>
            <th colspan="7">
              <div class="ui mini pagination menu">
                <a @click="pageTo(pageBlog.prePage)" v-if="!pageBlog.isFirstPage"  class="item">上一页</a>
                <a @click="pageTo(pageBlog.nextPage)" v-if="!pageBlog.isLastPage" class="item">下一页</a>
              </div>
              <a @click="addBtn()" class="ui mini right floated teal basic button" style="margin-top: 20px">新增</a>
            </th>
          </tr>
          </tfoot>
        </table>
<!--        <div class="ui success message">-->
<!--          <i class="close icon"></i>-->
<!--          <div class="header">提示：</div>-->
<!--          <p></p>-->
<!--        </div>-->
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
        pageNum: 0,
        pageBlog: {  },
        typeList: [  ]
      }
    },
    activated() {
      $(".ui.dropdown").dropdown({
        on: "hover"
      })
      $("#clear-btn").on("click", () => {
        $(".ui.types.dropdown").dropdown("clear");
        this.data.typeId = "";
      })
      $.get({
        url: 'types',
        success: res => {
          this.typeList = res
        }
      })
      this.getPageBlog()
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
      // 跳转编辑页面
      blogEditor(blogId) {
        this.$router.push({
          path: '/blogs/input',
          query: {
            blogId: blogId
          }
        })
      },
      deleteBlog(blogId) {
        let meg = confirm('确认删除编号：'+ blogId + '吗？')
        if (meg) {
          $.get({
            url: '/blog/delete',
            data: { 'id': blogId },
            success: res => {
              if (res === 1) {
                this.getPageBlog()
              }
            }
          })
        }
      },
      clear() {
        this.title = ''
        this.typeId = ''
        this.recommend = true
      },
      addBtn() {
        this.$router.push('/blogs/input')
      }
    }
  }
</script>

<style scoped>

</style>