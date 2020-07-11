<template>
  <div>
    <!---->
    <div class="ui attached segment teal">
      <div class="ui padded vertical segment stackable m-padded-large"
      v-for="item in pageBlog.list" :key="item.id">
        <div class="ui middle aligned mobile reversed stackable grid">
          <div class="eleven wide column">
            <h3 class="ui header">
              <a href="#" class="m-black">{{item.title}}</a>
            </h3>
            <p class="blog-text m-text">{{item.description}}</p>
            <div class="ui grid">
              <div class="row">
                <div class="six wide column">
                  <div class="ui mini horizontal link list">
                    <div class="item">
                      <img :src="item.user.avatar" alt="" class="ui avatar image">
                      <div class="content">
                        <router-link to="/about" class="header">{{item.user.nickname}}</router-link>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="right aligned ten wide column">
                  <a href="" class="ui teal basic label m-padded-tiny m-opacity-mini" >{{item.type.name}}</a>
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
                  <a href="" class="ui teal basic left pointing label m-padded-comm m-margin"
                     v-for="tag in item.tags"
                     :key="tag.id"
                     style="margin-top: 1rem">{{tag.name}}</a>
                </div>
              </div>
            </div>
          </div>
          <div class="ui five wide column">
            <a href="#" >
              <img :src="item.firstPicture" alt="..." class="ui rounded image fluid">
            </a>
          </div>
        </div>
      </div>
    </div>
    <!---->
    <!-- 分页 -->
    <div class="ui bottom attached segment">
      <div class="ui middle aligned two column grid">
        <div class="column">
          <a href="" class="ui mini teal basic button" >上一页</a>
        </div>
        <div class="right aligned column">
          <a href="" class="ui mini teal basic button" >下一页</a>
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

      }
    },
    props: {
      pageData: {
        page: 0
      },
      pageBlog: {}
    },
    methods: {
      ChangeDateFormat(date) {
        return ChangeDateFormat(date).substring(0, 10)
      }
    }
  }
</script>

<style scoped>

</style>