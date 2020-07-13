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
        <router-link :to="'/tag/' + item.id" href="#" v-for="item in tagList"
           class="ui basic left pointing large label m-margin-tb-tiny">
          <span>{{item.name}}</span>
          <div class="detail">{{item.blogs.length}}</div>
        </router-link>
      </div>

      <blog-list></blog-list>

<!--      <div class="ui bottom attached segment" style="padding: 6px">-->
<!--      </div>-->
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
        tagList: []
      }
    },
    activated() {
      this.getTagBlog()
    },
    methods: {
      getTagBlog() {
        $.get({
          url: 'tags',
          success: res => {
            this.tagList = res
            console.log(res);
          }
        })
      },
      getBlog() {
        $.get({
          
        })
      }
    }
  }

</script>

<style scoped>

</style>