<template>
  <div class="m-container-small m-padded-tb-massive" style="max-width: 30em!important;">
    <div class="ur container" style="margin-top: 24%">
      <div class="ui middle aligned center aligned grid">
        <div class="column">
          <h2 class="ui teal image header">
            <div class="content">
              博客管理系统
            </div>
          </h2>
          <form class="ui large form">
            <div class="ui stacked segment">
              <div class="field">
                <div class="ui left icon input">
                  <i class="user icon"></i>
                  <input type="text" v-model="username" placeholder="用户名">
                </div>
              </div>
              <div class="field">
                <div class="ui left icon input">
                  <i class="lock icon"></i>
                  <input type="password" v-model="password" placeholder="密码">
                </div>
              </div>
              <button @click="login" type="button" class="ui fluid large teal submit button">登 录</button>
            </div>
            <div v-if="isShowMassage">
              <div class="ui error mini message"></div>
              <div class="ui mini negative message">用户名和密码错误</div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Login",
    data() {
      return {
        isShowMassage: false,
        username: '',
        password: ''
      }
    },
    activated() {
      this.setNav(false)
      document.onkeydown = e => {
        if (e.keyCode === 13) {
          this.login()
        }
      }
    },
    deactivated() {
      this.setNav(true)
      document.onkeydown = null
    },
    inject: ['setNav'],
    methods: {
      login() {
        $.post({
          url: 'login',
          data: {'userName': this.username, 'password': this.password},
          success: res => {
            this.isShowMassage = res
            if (res === 0) {
              this.$router.push('/blogs')
            } else  {
            }
            this.username = ''
            this.password = ''
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>