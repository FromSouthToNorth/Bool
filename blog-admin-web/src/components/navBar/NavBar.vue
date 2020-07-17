<template>
  <nav class="ui inverted attached segment m-padded-tb-min m-nav">
    <div class="ui container">
      <div class="ui inverted secondary stackable menu">
        <h2 class="ui teal header item">后台管理</h2>
        <a class="m-item item m-mobile-hide"
           v-if="routerList"
           v-for="item in routerList"
           :key="routerList.id"
           :class="{ active: $route.path.indexOf(item.url) !== -1 }"
           @click="navJump(item.url)"
        >
          <i class="mini icon" :class="item.icon"></i>
          {{ item.name }}
        </a>
        <div class="right menu m-item m-mobile-hide">
          <div class="ui inline dropdown item">
            <div class="text">
              <img class="ui circular avatar image" :src="user.avatar" alt="">
              {{ user.nickname }}
            </div>
            <i class="dropdown icon"></i>
            <div class="menu">
              <a class="item" @click="logout">注销</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <a class="ui menu toggle black icon button m-right-top m-mobile-show">
      <i class="sidebar icon"></i>
    </a>
  </nav>
</template>

<script>

  import { setCookie, getCookie } from "../../utils/cookie"

  export default {
    name: "NavBar",
    data() {
      return {
        user: {
          nickname: '',
          avatar: '',
          email: ''
        },
        routerList: [
          {id: 1,name: '博客', icon: 'home', url: '/blogs'},
          {id: 2,name: '分类', icon: 'idea', url: '/types'},
          {id: 3,name: '标签', icon: 'tags', url: '/tags'},
          {id: 4,name: '评论', icon: 'comment alternate outline', url: '/comment'}
        ]
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
      // 注销菜单
      $(".ui.dropdown").dropdown({
        on: "hover"
      })
      // 汉堡按钮
      $(".menu.toggle").click(function() {
        $(".m-item").toggleClass("m-mobile-hide");
      })
    },
    methods: {
      navJump(url) {
        if (this.$route.path.indexOf(url)) {
          this.$router.push(url)
        }
      },
      // 注销
      logout() {
        $.get({
          url: 'logout',
          success: res => {
            if (res) {
              this.$router.push('/login')
            }
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>