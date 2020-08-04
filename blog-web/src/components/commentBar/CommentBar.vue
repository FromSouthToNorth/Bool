<template>
  <div class="ui bottom attached segment">
    <!-- 留言区域 -->
    <div id="comment-container" class="ui teal segment">
      <div>
        <div class="ui threaded comments" style="max-width: 100%;" v-if="comments">
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
                <a class="reply"
                   @click="replyComment(item.id, item.nickname)"
                   :data-commentid="item.id"
                   :data-commentnickname="item.nickname">回复</a>
              </div>
            </div>
            <div class="comments" v-if="item.replyComments.length > 0">
              <div class="comment"
              v-for="reply in item.replyComments"
              >
                <a class="avatar">
                  <img :src="reply.avatar" alt="">
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
                    <a class="reply" data-commentid="1" data-commentnickname="Matt"
                    :data-commentid="reply.id"
                    :data-commentIckName="reply.parentNickname"
                    @click="replyComment(reply.id, reply.parentNickname)"
                    >回复</a>
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
        <textarea name="content" v-model="data.content" placeholder="请输入评论信息..."></textarea>
      </div>
      <div class="fields">
        <div class="field m-mobile-wide m-margin-bottom-small">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="nickname" placeholder="昵称"
            :datafld="isDisabled"
            v-model="data.nickname"
            >
          </div>
        </div>
        <div class="field m-mobile-wide m-margin-bottom-small">
          <div class="ui left icon input">
            <i class="mail icon"></i>
            <input type="email" name="email" placeholder="邮箱" v-model="data.email">
          </div>
        </div>
        <div class="field m-mobile-wide m-margin-bottom-small">
          <button @click="commentPost" type="button" class="ui teal button m-mobile-wide m-margin-bottom-small">
            <i class="edit icon"></i>发布
          </button>
          <button @click="delInput" type="button" class="ui teal basic button m-mobile-wide m-margin-bottom-small">
            <i class="eraser icon"></i>清空
          </button>
          <button id="error-message" style="display: none;"></button>
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
        isDisabled: true,
        comments: [],
        data: {
          'parentComment.id': -1,
          'blog.id': 0,
          nickname: '',
          email: '',
          content: '',
          avatar: 'https://202007002.oss-cn-chengdu.aliyuncs.com/images/avatar.png',
        }
      }
    },
    mounted() {
      $('#error-message').popup({
        position: 'top center',
        target: '.popup-err-intput',
        title: '提示',
        on: 'click',
        content: '稍等一会再留言吧'
      })
      // 获取评论内容
      if (this.$route.params.bid) {
        this.data['blog.id'] = this.$route.params.bid
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
                prompt: "请输入你的名称"
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
    activated() {  },
    methods: {
      commentPost() {
        var boo = $('.ui.form').form('validate form')
        if (boo) {
          $.post({
            url: 'comments',
            data: this.data,
            success: res => {
              if (res === 0) {
                this.getCommentList(this.$route.params.bid)
                $(window).scrollTo('#comment-container', 400)
                this.delInput()
              } else {
                $('#error-message').click()
              }
              this.isDisabled = true
            }
          })
        } else {
          console.log('校验失败');
        }
      },
      delInput() {
        $("[name='content']")
        .attr('placeholder', '请输入评论信息...')
        .focus()
        $("[name='email']")
        .attr('placeholder', '邮箱')
        $("[name='nickname']")
        .attr('placeholder', '昵称')
        this.data.content = ''
        this.data['parentComment.id'] = -1
        this.data.nickname = ''
        this.data.email = ''
      },
      replyComment(id, nickname) {
        $("[name='content']")
        .attr('placeholder', '@' + nickname)
        .focus()
        this.data['parentComment.id'] = id
        $(window).scrollTo($('#comment-form'), 500)
      },
      ChangeDateFormat(date) {
        return ChangeDateFormat(date)
      },
      getCommentList(id) {
        $.get({
          url: 'comments',
          data: { 'blogId' : id },
          success: res => {
            this.comments = res
          }
        })
      },
    }
  }
</script>

<style scoped>

</style>
