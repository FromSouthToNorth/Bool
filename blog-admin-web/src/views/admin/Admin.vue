<template>
  <div class="user el-card el-card__body">
    <div class="user-info">
      <div class="block"><el-avatar :size="100" :src="user.avatar"></el-avatar></div>
      <div class="user-name">{{ user.nickname }}</div>
    </div>
    <div class="user-info-list">
      上次登录时间：
      <span>{{ user.loginTime }}</span>
    </div>
  </div>
</template>

<script>
import {getCookie, setCookie} from "@/utils/cookie"
export default {
name: "Admin",
  data() {
    return {
      user: {
        nickname: '',
        avatar: '',
        loginTime: ''
      }
    }
  },
  mounted() {
    // 获取头像名称
    if (this.$route.path !== '/') {
      $.get({
        url: 'user',
        success: res => {
          this.user = res;
          setCookie('user', JSON.stringify(res))
        },
        error: res => {
          console.log(res, 'navBar')
        }
      })
    } else if (getCookie('user')) {
      this.user = JSON.parse(getCookie('user'))
    }
  },
  methods: {  }
}
</script>

<style>
  .user .block,
  .user .user-name {
    display: inline-block;
  }
  .user .user-name {
    padding-left: 20px;
    color: #303133;
    font-size: 20px;
    font-weight: 600;
  }
  .user .user-info {
    padding: 10px;
    border-bottom: #DCDFE6 solid 2px;
    margin-bottom: 20px;
  }
  .user .user-info-list {
    font-size: 13px;
    color: #999;
    line-height: 25px;
  }
  /*.user .user-info-list > span {*/
  /*  margin-left: 20px;*/
  /*}*/
</style>
