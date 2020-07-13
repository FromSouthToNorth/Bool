<template>
  <div class="ui bottom attached segment">
    <!-- 留言区域 -->
    <div id="comment-container" class="ui teal segment">
      <div>
        <div class="ui threaded comments" style="max-width: 100%;">
          <h3 class="ui dividing header">评论</h3>
          <div class="comment"
          v-for="item in comments" :key="item.id"
          >
            <a class="avatar">
              <img :src="item.avatar" alt="">
            </a>
            <div class="content">
              <a class="author">
                <span>{{item.nickname}}</span>
                <div class="ui mini basic teal left pointing label m-padded-min"
                     v-if="item.adminComment"
                >博主</div>
              </a>
              <div class="metadata">
                <span class="date">{{ChangeDateFormat(item.createTime)}}</span>
              </div>
              <div class="text">
                {{item.content}}
              </div>
              <div class="actions">
                <a class="reply" data-commentid="1" data-commentnickname="Matt">回复</a>
              </div>
            </div>
            <div class="comments" v-if="item.replyComments.length > 0">
              <div class="comment"
              v-for="reply in item.replyComments"
              >
                <a class="avatar">
                  <img :src="reply.avatar">
                </a>
                <div class="content">
                  <a class="author">
                    <span>{{reply.nickname}}</span>&nbsp;
                    <div class="ui mini basic teal left pointing label m-padded-min"
                    v-if="reply.adminComment"
                    >博主</div>&nbsp;
                    <span style="color: #00B5AD;">{{reply.parentNickname}}</span>
                  </a>
                  <div class="metadata">
                    <span class="date">{{ChangeDateFormat(reply.createTime)}}</span>
                  </div>
                  <div class="text" >
                    {{reply.content}}
                  </div>
                  <div class="actions">
                    <a class="reply" data-commentid="1" data-commentnickname="Matt">回复</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div id="comment-form" class="ui form">
      <input type="hidden" name="blog.id">
      <input type="hidden" name="parentComment.id" value="-1">
      <div class="field">
        <textarea name="content" placeholder="请输入评论信息..."></textarea>
      </div>
      <div class="fields">
        <div class="field m-mobile-wide m-margin-bottom-small">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="nickname" placeholder="姓名">
          </div>
        </div>
        <div class="field m-mobile-wide m-margin-bottom-small">
          <div class="ui left icon input">
            <i class="mail icon"></i>
            <input type="email" name="email" placeholder="邮箱">
          </div>
        </div>
        <div class="field m-mobile-wide m-margin-bottom-small">
          <button id="comment-btn" type="button" class="ui teal button m-mobile-wide"><i class="edit icon"></i>发布</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

  import ChangeDateFormat from "../../utlis/changeDateFormat";

  export default {
    name: "CommentBar",
    data() {
      return {
        comments: [],
        data: {
          "parentComment.id": -1,
          "blog.id": 0,
          nickname: "",
          email: "",
          content: "",
          avatar:
            "http://47.113.92.137:8888/upload/io/img/2020/4/6/1586149620923.png"
        }
      }
    },
    activated() {
      if (this.$route.params.bid) {
        this.data["blog.id"] = this.$route.params.bid
        this.getCommentList(this.$route.params.bid)
      }
      //评论表单验证
      $(".ui.form").form({
        fields: {
          title: {
            identifier: "content",
            rules: [
              {
                type: "empty",
                prompt: "请输入评论内容"
              }
            ]
          },
          content: {
            identifier: "nickname",
            rules: [
              {
                type: "empty",
                prompt: "请输入你的大名"
              }
            ]
          },
          type: {
            identifier: "email",
            rules: [
              {
                type: "email",
                prompt: "请填写正确的邮箱地址"
              }
            ]
          }
        }
      });
    },
    methods: {
      ChangeDateFormat(date) {
        return ChangeDateFormat(date)
      },
      getCommentList(id) {
        $.get({
          url: 'comments',
          data: { 'blogId' : id },
          success: res => {
            this.comments = res
            console.log(res);
          }
        })
      },
    }
  }
</script>

<style scoped>

</style>