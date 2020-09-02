<template>
  <div class="blog-box">
    <div v-loading="loading"></div>
    <!---->
    <div class="ui attached segment blog-list-box">
      <div class="ui padded vertical segment stackable m-padded-large"
        v-for="item in pageBlog.list"
        :key="item.id"
        v-if="pageBlog"
      >
        <div class="ui middle aligned mobile reversed stackable grid">
          <div class="eleven wide column">
            <h6 class="ui blog-title header">
              <router-link :to="'/blog/'+item.id" tag="a" class="m-black">
                {{item.title}}
              </router-link>
              <a href="#" class="m-black"></a>
            </h6>
            <p class="blog-text m-text">{{item.description}}</p>
            <div class="ui grid">
              <div class="row">
                <div class="six wide column">
                  <div class="ui mini horizontal link list">
                    <div class="item">
                      <img :src="item.user.avatar" alt="" class="ui avatar image">
                      <div class="content">
                        <router-link to="/about" class="header">
                          {{item.user.nickname}}
                        </router-link>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="right aligned ten wide column blog-type-box">
                  <router-link tag="a" :to="'/type/' + item.type.id"
                    class="ui teal basic label m-padded-tiny m-opacity-mini"
                    style="font-size: 10px;"
                  >
                    {{item.type.name}}
                  </router-link>
                </div>
              </div>
              <div class="row">
                <div class="sixteen wide column m-font-color">
                  <span class="m-margin-lr-small">
                    <i class="calendar alternate icon"></i>
                    <span >{{ChangeDateFormat(item.updateTime)}}</span>
                  </span>
                  <span class="m-margin-lr-small">
                    <i class="eye icon"></i>
                    <span>{{item.views}}</span>
                  </span>
                  <span class="m-margin-lr-small">
                    <i class="comment outline icon"></i>
                    <span>{{item.commentTotal}}</span>
                  </span>
                </div>
              </div>
              <div class="row">
                <div class="column blog-tag-box">
                  <router-link :to="'/tag/' + tag.id" tag="a"
                     class="ui teal basic left pointing label m-padded-comm"
                     :style="{'color': tag.tagColour + '!important', 'border-color': tag.tagColour + '!important'}"
                     v-for="tag in item.tags"
                     :key="tag.id"> {{tag.name}}
                  </router-link>
                </div>
              </div>
            </div>
          </div>
          <div class="ui five wide column">
            <router-link :to="'/blog/' + item.id">
              <el-image :src="item.firstPicture" alt="" class="ui rounded image fluid blog-img"></el-image>
            </router-link>
          </div>
        </div>
      </div>
    </div>
    <!---->
    <!-- 分页 -->
    <div class="ui page-box bottom attached segment" v-if="pageBlog.pages > 1">
      <div class="ui middle aligned two column grid">
        <div class="right aligned column" style="width: 100%;">
          <div class="block">
            <el-pagination
                layout="prev, pager, next"
                :page-size=pageBlog.pageSize
                pager-count="4"
                background
                @current-change="pageClick"
                :total=pageBlog.total>
            </el-pagination>
          </div>
        </div>
      </div>
    </div>
    <!-- /分页 -->
  </div>
</template>

<script>

  import ChangeDateFormat from "../../utlis/changeDateFormat";

  export default {
    name: "BlogList",
    data() {
      return {
        isActive: true,
        pageNum: 1,
        loading: true
      }
    },
    props: {
      paging: {
        type: Function,
        default: null
      },
      pageBlog: {  }
    },
    mounted() {
    },
    activated() { this.delayLoading() },
    methods: {
      ChangeDateFormat(date) {
        return ChangeDateFormat(date).substring(0, 10)
      },
      pageClick(page) {
        this.pageNum = page
        this.paging(page)
      },
      delayLoading() {
        setTimeout(() => {
          this.loading = false
        }, 600)
      }
    },
  }
</script>

<style>
.el-pagination.is-background .el-pager li:not(.disabled).active {
  background-color: #00b5ad;
}
</style>
