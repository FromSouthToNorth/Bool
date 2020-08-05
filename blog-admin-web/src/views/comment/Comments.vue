<template>
  <div class="m-container-min m-padded-tb-big">
    <div class="ui container ">
      <el-card class="box-card" shadow="hover">
        <div v-for="(value, key) in comments.map"
             :key="key"
        >
          <div class="ui threaded comments" style="max-width: 100%;">
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
                  <span>{{ item.nickname }}</span>
                  <div class="ui mini basic teal left pointing label m-padded-min"
                       v-if="item.adminComment"
                  >博主</div>
                </a>
                <div class="metadata">
                  <span class="date">{{ ChangeDateFormat(item.createTime) }}</span>
                </div>
                <div class="text">
                  {{item.content}}
                </div>
                <div class="actions">
                  <el-button
                      size="mini"
                      type="danger"
                      plain
                      icon="el-icon-delete"
                      @click="messageBox(item.id)">删除</el-button>
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
                      <span style="color: #00B5AD;">{{ reply.parentNickname }}</span>
                    </a>
                    <div class="metadata">
                      <span class="date">{{ ChangeDateFormat(reply.createTime) }}</span>
                    </div>
                    <div class="text" >
                      {{ reply.content }}
                    </div>
                    <div class="actions">
                      <el-button
                          size="mini"
                          type="danger"
                          plain
                          icon="el-icon-delete"
                          @click="messageBox(reply.id)">删除</el-button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="ui orange" v-show="!isComment">
          <el-link type="success" @click="$router.back(-1)">返回上一页</el-link>
        </div>
      </el-card>
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
        isComment: null,
      }
    },
    activated() {
      this.installData()
    },
    methods: {
      getComments() {
        $.get({
          url: 'comments',
          success: res => {
            this.comments = res
            this.isComment = res.comment
            if (!this.comments.comment) {
              this.openWarn()
            }
          }
        })
      },
      getByBlogIdComment(id) {
       $.get({
         url: 'comment',
         data: { 'id': id },
         success: res => {
           this.comments = res
           this.isComment = res.comment
           if (!this.comments.comment) {
             this.openWarn()
           }
         }
       })
      },
      ChangeDateFormat(date) {
        return ChangeDateFormat(date)
      },
      openWarn() {
        this.$message({
          message: '太惨了吧~博客还没有人评论哦！',
          type: 'warning'
        });
      },
      deleteComment(id) {
        $.get({
          url: 'deletecomment',
          data: { 'id': id },
          success: res => {
            if (res === 1) {
              this.installData()
              this.open()
            } else {
              this.openError()
            }
          }
        })
      },
      installData() {
        if (this.$route.query.blogId) {
          this.getByBlogIdComment(this.$route.query.blogId)
        } else {
          this.getComments()
        }
      },
      open() {
        this.$message({
          message: '评论删除成功！',
          type: 'success'
        });
      },
      openError() {
        this.$message.error('评论删除失败！');
      },
      messageBox(id) {
        this.$confirm('此操作将永久删除该评论和其子评论, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.deleteComment(id)
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      }
    }
  }
</script>

<style scoped>

</style>
