<template>
  <div class="m-container-small m-padded-tb-big">
    <div class="ui container">
      <!-- header -->
      <div class="ui top attached segment m-navbar m-dialog-shadow">
        <div class="ui middle aligned two column grid">
          <div class="column">
            <h3 class="ui teal header">搜索{{$route.query.key}}的结果</h3>
          </div>
          <div class="right aligned column">
            共 <h4 class="ui orange header m-inline-block"> {{pageBlog.total}} </h4> 条
          </div>
        </div>
      </div>
      <!-- /header -->

      <blog-list :paging="paging" :pageNum="pageNum" :pageBlog="pageBlog"></blog-list>

    </div>
  </div>
</template>

<script>

  import BlogList from "components/blogList/BlogList"

  export default {
    name: "Search",
    components: { BlogList },
    data() {
      return {
        pageNum: 0,
        query: '',
        pageBlog: {  }
      }
    },
    activated() {
      if (this.$route.query.key == null || this.$route.query.key === '') {
        this.$router.push('/')
      } else {
        this.getBlog()
      }
    },
    // watch: {
    //   $route(newRoute) {
    //     this.getBlog()
    //   }
    // },
    methods: {
      getBlog() {
        this.query = this.$route.query.key
        $.get({
          url: 'search',
          data: { 'query': this.query, 'pageNum': this.pageNum },
          success: res => {
            this.pageBlog = res
            console.log(res);
          }
        })
      },
      paging(pageNum) {
        this.pageNum = pageNum
        this.getBlog()
      }
    }
  }

</script>

<style scoped>

</style>