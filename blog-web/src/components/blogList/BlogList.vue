<template>
  <div>
    <!---->
    <div class="ui top attached segment teal">
      <div class="ui padded vertical segment stackable m-padded-large"
        v-for="item in pageBlog.list" :key="item.id"
      >
        <div class="ui middle aligned mobile reversed stackable grid">
          <div class="eleven wide column">
            <h3 class="ui header">
              <router-link :to="'/blog/'+item.id" tag="a" class="m-black">
                {{item.title}}
              </router-link>
              <a href="#" class="m-black"></a>
            </h3>
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
                <div class="right aligned ten wide column">
                  <router-link  tag="a" :to="'/type/' + item.type.id"
                    class="ui teal basic label m-padded-tiny m-opacity-mini" >
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
                <div class="column">
                  <router-link :to="'/tag/' + tag.id" tag="a"
                     class="ui teal basic left pointing label m-padded-comm m-margin"
                     :style="{'color': tag.tagColour + '!important', 'border-color': tag.tagColour + '!important'}"
                     v-for="tag in item.tags"
                     :key="tag.id"
                     style="margin-top: 1rem !important; font-size: 10px;">{{tag.name}}
                  </router-link>
                </div>
              </div>
            </div>
          </div>
          <div class="ui five wide column">
            <router-link :to="'/blog/' + item.id">
              <img :src="item.firstPicture" alt="..." class="ui rounded image fluid">
            </router-link>
          </div>
        </div>
      </div>
    </div>
    <!---->
    <!-- 分页 -->
    <div class="ui bottom attached segment">
      <div class="ui middle aligned two column grid">
        <div class="column">
        </div>
        <div class="right aligned column">
          <div class="ui mini teal pagination menu">
            <a @click="pageClick(1)"
               v-show="!pageBlog.isFirstPage"
               :class="{active: pageBlog.firstPage === pageNum}"
               class="item"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
             首页
            </font></font></a>
            <a @click="pageClick(pageBlog.prePage)"
               v-show="pageBlog.hasPreviousPage "
               class="item"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
              <i class="angle double left icon"></i>
            </font></font></a>
            <a @click="pageClick(item)"
               :class="{active: item === pageNum}"
               class="item"
               v-for="item in pageBlog.navigatepageNums"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
              {{item}}
            </font></font></a>
            <a @click="pageClick(pageBlog.pageNum + 1)"
               v-show="pageBlog.hasNextPage "
               class="item"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
              <i class="angle double right icon"></i>
            </font></font></a>
            <a @click="pageClick(pageBlog.pages)"
               v-show="!pageBlog.isLastPage"
               :class="{active: pageBlog.pages === pageNum}"
               class="item"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
              尾页
            </font></font></a>
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
        pageNum: 1
      }
    },
    props: {
      paging: {
        type: Function,
        default: null
      },
      pageBlog: {}
    },
    methods: {
      ChangeDateFormat(date) {
        return ChangeDateFormat(date).substring(0, 10)
      },
      pageClick(page) {
        this.pageNum = page
        this.paging(page)
      }
    },
  }
</script>

<style scoped>

</style>