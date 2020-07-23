<template>
  <div>
    <!-- 主体 -->
    <div id="waypoint" class="m-container-small m-padded-tb-large">
      <div class="ui container m-dialog-shadow" v-if="blog">
        <div class="ui top attached segment m-navbar">
          <div class="ui horizontal link list">
            <div class="item">
              <img :src="blog.user.avatar" alt="" class="ui avatar image">
              <div class="content"><a href="#" class="header">{{blog.user.nickname}}</a></div>
            </div>
            <div class="item">
              <i class="calendar alternate icon"></i>
              <span>{{ChangeDateFormat(blog.updateTime)}}</span>
            </div>
            <div class="item">
              <i class="eye icon"></i>
              <span>{{blog.views}}</span>
            </div>
            <div class="item">
              <i class="comment outline icon"></i>
              <span>{{blog.commentTotal}}</span>
            </div>
          </div>
        </div>
        <div class="ui attached segment">
          <!-- 图片区域 -->
          <img :src="blog.firstPicture" alt="" class="ui fluid rounded image">
        </div>
        <div class="ui attached padded segment">
          <!-- 内容 -->
          <div class="ui right aligned basic segment">
            <div class="ui label orange basic label">{{blog.flag}}</div>
          </div>
          <h2 class="ui center aligned header">{{blog.title}}</h2>
          <div id="content"
               v-highlight
               v-html="blog.content"
               class="typo js-toc-content typo-selection m-padded-lr-responsive">
          </div>
          <!-- 标签 -->
          <div class="m-padded-lr-responsive">
            <router-link :to="'/tag/'+ item.id"
            class="ui basic teal left pointing label"
            style="margin: 4px; font-size: 10px"
            :style="{'color': item.tagColour + '!important', 'border-color': item.tagColour + '!important'}"
            v-for="item in blog.tags"
            :key="item.id"
            >
              {{item.name}}
            </router-link>
          </div>
          <!-- 赞赏 -->
          <div class="ui center aligned basic segment">
            <button id="payButton" class="ui orange basic circular button">赞赏</button>
          </div>
          <div class="ui payQ flowing popup transparent hidden">
            <div class="ui orange basic label">
              <div class="ui images" style="font-size: inherit!important;">
                <div class="image">
                  <img src="~assets/images/wechat.png" alt="" class="ui rounded bordered image" style="width: 120px">
                  <div>微信</div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- 博客信息 -->
        <blog-info
        v-if="blog.shareStatement"
        :nickname="blog.user.nickname"
        :createTime="ChangeDateFormat(blog.createTime)"
        ></blog-info>
        <!-- 评论区 -->
        <comment-bar
        v-if="blog.commentabled"
        ></comment-bar>
      </div>
    </div>
    <!-- 主体 -->
    <!-- 电梯 -->
    <div id="toolbar" class="m-padded m-fixed m-right-bottom" style="">
      <div class="ui vertical icon buttons">
        <button type="button" @click="$router.back(-1)" class="ui teal button">返回</button>
        <button type="button" class="ui toc teal button">目录</button>
        <a href="#comment-container" class="ui button">留言</a>
        <div id="toTop-btn" class="ui icon button"><i class="chevron up icon"></i></div>
      </div>
    </div>
    <!-- /电梯 -->
    <div class="ui toc-container flowing popup transition hidden" style="width: 160px; font-size: 14px">
      <ol class="js-toc">
      </ol>
    </div>
  </div>
</template>

<script>

  import CommentBar from "components/commentBar/CommentBar"
  import BlogInfo from "components/blogInfo/BlogInfo"

  import tocbot from "../../assets/js/tocbot.min"
  import { imgAmp } from "../../utlis/imgAmp"
  import ChangeDateFormat from "../../utlis/changeDateFormat"

  export default {
    name: "Blog",
    components: {BlogInfo, CommentBar },
    data() {
      return {
        blog: null,
      }
    },
    deactivated() {
      this.blog = null;
    },
    activated() {
      if (this.$route.params.bid) {
        $.get({
          url: 'blog',
          data: { 'id': this.$route.params.bid },
          success: res => {
            this.blog = res;
            $(window).scrollTo(0, 10)
            this.setTO()
          }
        })
      }
    },
    methods: {
      ChangeDateFormat(data) {
        return ChangeDateFormat(data)
      },
      setTO() {
        setTimeout(() => {
          this.litsenAll()
          this.tocbotInit()
          var html = `<div style="width: 100%; overflow: auto;"></div>`
          $('.tablee').wrap(html)
        }, 200)
      },
      litsenAll() {
        imgAmp('js-toc-content')
        $('#payButton').popup({
          popup: $('.payQ.popup'),
          on: 'click',
          position: "bottom center"
        })
        $('#toTop-btn').click(function () {
          $(window).scrollTo(0, 500)
        })
        $('.toc.button').popup({
          popup: $('.toc-container.popup'),
          on: 'click',
          position: "left center"
        })
      },
      tocbotInit() {
        tocbot.init({
          // Where to render the table of contents.
          tocSelector: ".js-toc",
          // Where to grab the headings to build the table of contents.
          contentSelector: "#content",
          // Which headings to grab inside of the contentSelector element.
          headingSelector: "h1, h2, h3, h4"
        })
      }
    }
  }
</script>

<style scoped>
  @import "~assets/css/tocbot.css";
  @import "~assets/css/typo.css";
</style>