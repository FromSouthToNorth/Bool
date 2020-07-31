<template>
  <div id="comment-container" class="ui teal segment m-container-small" style="margin-top: 50px!important;">
    <div v-for="(value, key) in comments"
      :key="key"
    >
      <div class="ui threaded comments" style="max-width: 100%;" v-if="isComment">
        <h3 class="ui dividing header">{{ key }}</h3>
        <div class="comment"
             v-for="item in value"
             :key="item.id"
        >
          <a class="avatar">
            <img :src="item.avatar">
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
      <div class="ui orange" v-else>
        <h3>没有找到评论</h3>
      </div>
    </div>
  </div>
</template>

<script>

  import ChangeDateFormat from "../../utils/ChangeDateFormat";

  export default {
    name: "Comments",
    data() {
      return {
        comments: {  },
        isComment: true
      }
    },
    mounted() {
      this.getComments()
    },
    methods: {
      getComments() {
        $.get({
          url: 'comments',
          success: res => {
            this.comments = res
          }
        })
      },
      ChangeDateFormat(date) {
        return ChangeDateFormat(date)
      }
    }
  }
</script>

<style scoped>

</style>
