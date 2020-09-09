<template>
  <div class="m-container m-padded-tb-big">
    <div class="ui container">
      <div class="ui stackable grid">
        <div class="eleven wide column">
          <div class="m-dialog-shadow">
            <!-- 标题 -->
            <div class="ui top attached segment m-navbar">
              <div class="ui middle aligned two column grid">
                <div class="column">
                  <h3 class="ui title header">文章</h3>
                </div>
                <div class="right aligned column">
                  共 <h4 class="ui orange header m-inline-block" >{{pageBlog.total}}</h4> 篇
                </div>
              </div>
            </div>
            <!-- /标题 -->
            <blog-list :paging="paging" :pageNum="pageNum" :pageBlog="pageBlog"></blog-list>
          </div>
        </div>
        <div class="five wide column">
          <!-- 分类 -->
          <div class="ui segments m-dialog-shadow type-box">
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
            <div class="ui segment border-top-none">
              <div class="ui fluid vertical menu">
                <router-link
                  :to="'/type/' + item.id"
                  class="item" v-for="item in listType"
                  :key="item.id"
                >
                  <span>{{item.name}}</span>
                  <div class="ui teal basic left pointing label">
                    {{item.value}}
                  </div>
                </router-link>
              </div>
            </div>
          </div>
          <!-- /分类 -->
          <!-- 标签 -->
          <div class="ui segments m-margin-top m-dialog-shadow tag-box">
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
            <div class="ui segment border-top-none">
              <router-link
                 :to="'/tag/' + item.id"
                 class="ui basic left pointing label m-margin-tb-tiny tag-item"
                 v-for="item in listTag" :key="item.id"
                 :style="{'color': item.tagColour, 'border-color': item.tagColour}">
                <span>{{item.name}}</span>
                <div class="detail" >
                  {{item.value}}
                </div>
              </router-link>
            </div>
          </div>
          <!-- /标签 -->
          <!-- 最新推荐 -->
          <div class="ui segments m-margin-top m-dialog-shadow">
            <div class="ui secondary segment m-navbar border-bot">
              <i class="bookmark icon"></i>最新推荐
            </div>
            <div class="ui segment"
                 v-for="(item, index) in listRecommend"
                 :key="item.id"
                 :class="index === 0 ? 'border-top-none' : ''">
              <router-link
              :to="'/blog/' + item.id" class="m-font-color">
                {{item.title}}
              </router-link>
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
        pageNum: 0,
        pageBlog: {},
        listType: [],
        listTag: [],
        listRecommend: [],
        loading: []
      }
    },
    created() {
      this.openLoading();
    },
    mounted() {
      this.getPageBlog()
      this.getListType()
      this.getListTag()
      this.getListRecommend()
      this.addVisit()
    },
    methods: {
      getPageBlog() {
        $.get({
          url: 'blogs',
          data: {'pageNum': this.pageNum},
          success: res => {
            this.pageBlog = res
            this.loading.close();
          }
        })
      },
      getListType() {
        $.get({
          url: 'homeTypes',
          success: res => {
            this.listType = res
          }
        })
      },
      getListTag() {
        $.get({
          url: 'homeTags',
          success: res => {
            this.listTag = res
          }
        })
      },
      getListRecommend() {
        $.get({
          url: 'recommendBlogs',
          success: res => {
            this.listRecommend = res
          }
        })
      },
      addVisit() {
        $.get({
          url: 'addVisit',
        })
      },
      paging(pageNum) {
        this.pageNum = pageNum
        this.getPageBlog()
      },
      // 打开加载层
      openLoading() {
        this.loading = this.$loading({
          lock: true,
          text: "拼命读取中",
          spinner: "el-icon-loading",
          background: "rgba(0, 0, 0, 0.5)"
        });
      }
    },
  }
</script>

<style scoped>

</style>
