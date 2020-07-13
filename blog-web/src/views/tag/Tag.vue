<template>
  <div class="m-container-small m-padded-tb-big">
    <div class="ui container">
      <!-- header -->
      <div class="ui top attached segment m-navbar">
        <div class="ui middle aligned two column grid">
          <div class="column">
            <h3 class="ui teal header">标签</h3>
          </div>
          <div class="right aligned column">
            共 <h4 class="ui orange header m-inline-block"> {{tagList.length}} </h4> 个
          </div>
        </div>
      </div>
      <!-- /header -->
      <div class="ui bottom attached segment teal">
        <router-link
          :to="'/tag/' + item.id"
          v-for="item in tagList"
          :key="item.id"
          tag="div"
          :class="{teal:$route.params.tagid === item.id}"
          @click.native="getBlog(item.id)"
          class="ui basic left pointing large label m-margin-tb-tiny"
        >
          <span>{{item.name}}</span>
          <div class="detail">{{item.blogs.length}}</div>
        </router-link>
      </div>

      <blog-list :paging="paging" :pageNum="pageNum" :pageBlog="pageBlog"></blog-list>

    </div>
  </div>
</template>

<script>

  import BlogList from "components/blogList/BlogList"

  export default {
    name: "Tag",
    components: { BlogList },
    data() {
      return {
        tagList: null,
        pageBlog: {},
        tagId : 0,
        pageNum: 0
      }
    },
    // 组件处于活跃时
    activated() {
      $.get({
        url: 'tags',
        success: res => {
          this.tagList = res
          if (!this.$route.params.tagid) {
            this.$router.push('/tag/' + res[0].id)
            this.getBlog(res[0].id)
          } else {
            this.getBlog(this.$route.params.tagid)
          }
        }
      })
    },
    // 组件失去活跃时
    deactivated() {  },
    methods: {
      getBlog(id) {
        if (id !== -1) {
          this.tagId = id
        }
        $.get({
          url: 'blogTag',
          data: {'tagId': this.tagId, 'pageNum': this.pageNum},
          success: res => {
            this.pageBlog = res
          }
        })
      },
      paging(pageNum) {
        this.pageNum = pageNum
        this.getBlog(-1)
      }
    }
  }

</script>

<style scoped>

</style>