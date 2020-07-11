<template>
  <div class="m-container m-padded-tb-large">
    <div class="ui container">
      <div class="ui stackable grid">
        <div class="eleven wide column">
          <div class="m-dialog-shadow">
            <!-- 标题 -->
            <div class="ui top attached segment m-navbar">
              <div class="ui middle aligned two column grid">
                <div class="column">
                  <h3 class="ui teal header">文章</h3>
                </div>
                <div class="right aligned column">
                  共 <h4 class="ui orange header m-inline-block" > 12 </h4> 篇
                </div>
              </div>
            </div>
            <!-- /标题 -->
            <blog-list :pageData="pageData" :pageBlog="pageBlog"></blog-list>
          </div>
        </div>
        <div class="five wide column">
          <!-- 分类 -->
          <div class="ui segments m-dialog-shadow">
            <div class="ui secondary segment m-navbar">
              <div class="ui two column grid">
                <div class="column">
                  <i class="idea icon"></i>分类
                </div>
                <div class="right aligned column">
                  <router-link to="/type">
                    more <i class="angle double right icon"></i>
                  </router-link>
                </div>
              </div>
            </div>
            <div class="ui teal segment">
              <div class="ui fluid vertical menu">
                <a href="#"  class="item" v-for="item in listType">
                  <span>{{item.name}}</span>
                  <div class="ui teal basic left pointing label">{{item.blogs.length}}</div>
                </a>
              </div>
            </div>
          </div>
          <!-- /分类 -->
          <!-- 标签 -->
          <div class="ui segments m-margin-top m-dialog-shadow">
            <div class="ui secondary segment m-navbar">
              <div class="ui two column grid">
                <div class="column">
                  <i class="tags icon"></i>标签
                </div>
                <div class="right aligned column">
                  <router-link to="/tag">
                    more <i class="angle double right icon"></i>
                  </router-link>
                </div>
              </div>
            </div>
            <div class="ui teal segment">
              <a href="" class="ui teal basic left pointing label m-margin-tb-tiny"
                 v-for="item in listTag" :key="item.id">
                <span>{{item.name}}</span>
                <div class="detail" >{{item.blogs.length}}</div>
              </a>
            </div>
          </div>
          <!-- /标签 -->
          <!-- 最新推荐 -->
          <div class="ui segments m-margin-top m-dialog-shadow">
            <div class="ui secondary segment m-navbar">
              <i class="bookmark icon"></i>最新推荐
            </div>
            <div class="ui segment"
            v-for="item in listRecommend" :key="item.id">
              <a href="#"  class="m-font-color" >{{item.title}}</a>
            </div>
          </div>
          <!-- /最新推荐 -->
          <!-- 旋转木马 -->
          <marquee></marquee>
          <!-- /旋转木马 -->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import Marquee from "components/marquee/Marquee"
  import BlogList from "components/blogList/BlogList"
  export default {
    name: "HomeBlog",
    components: { Marquee, BlogList },
    data() {
      return {
       pageData: {
         page: 0
       },
       pageBlog: {},
       listType: [],
       listTag: [],
       listRecommend: []
      }
    },
    mounted() {
      this.getPageBlog()
      this.getListType()
      this.getListTag()
      this.getListRecommend()
    },
    methods: {
      getPageBlog() {
        $.get({
          url: 'blogs',
          success: res => {
            this.pageBlog = res
            console.log(this.pageBlog);
          }
        })
      },
      getListType() {
        $.get({
          url: 'homeTypes',
          success: res => {
            this.listType = res
            console.log(this.listType);
          }
        })
      },
      getListTag() {
        $.get({
          url: 'homeTags',
          success: res => {
            this.listTag = res
            console.log(this.listTag);
          }
        })
      },
      getListRecommend() {
        $.get({
          url: 'recommendBlogs',
          success: res => {
            this.listRecommend = res
            console.log(this.listRecommend);
          }
        })
      }
    },
  }
</script>

<style scoped>

</style>