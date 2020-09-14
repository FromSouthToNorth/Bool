<template>
  <nav class="ui attached segment m-padded-tb-min m-nav">
    <div class="ui container">
      <div class="ui secondary stackable menu">
        <div class="nav-logo">
          <h2 class="ui header item">
            <router-link to="/" class="ui teal hyzt-logo" tag="a">
              HyZt
            </router-link>
          </h2>
        </div>
        <router-link
            to="/"
            tag="a"
           class="m-item item"
           :class="{active:$route.path.indexOf('/home')!==-1,'m-mobile-hide':toggleClass}"
          >
          <i class="home icon"></i> 首页
        </router-link>
        <a href="#"
           @click="navSkip('/type')"
           class="m-item item"
           :class="{active:$route.path.indexOf('/type')!==-1,'m-mobile-hide':toggleClass}"
          >
          <i class="idea icon"></i> 分类
        </a>
        <a href="#"
           @click="navSkip('/tag')"
           class="m-item item"
           :class="{active:$route.path.indexOf('/tag')!==-1,'m-mobile-hide':toggleClass}"
          >
          <i class="tags icon"></i> 标签
        </a>
        <a href="#"
           @click="navSkip('/archives')"
           class="m-item item"
           :class="{active:$route.path.indexOf('/archives')!==-1,'m-mobile-hide':toggleClass}"
          >
          <i class="clone icon"></i> 归档
        </a>
        <a href="#"
           @click="navSkip('/about')"
           class="m-item item"
           :class="{active:$route.path.indexOf('/about')!==-1,'m-mobile-hide':toggleClass}"
          >
          <i class="info icon"></i> 关于我
        </a>
        <!-- 搜索 -->
        <div class="right m-item item" :class="{'m-mobile-hide':toggleClass}">
          <div class="ui icon transparent input">
            <label>
              <input type="text" v-model="searchKey" placeholder="请输入搜索内容..." @keyup.enter="search">
            </label>
            <i @click="search" class="search link icon"></i>
          </div>
        </div>
        <!-- /搜索 -->
      </div>
    </div>
    <a @click="menuToggle" class="ui menu toggle icon button m-right-top m-mobile-show nav-button">
      <i class="sidebar icon"></i>
    </a>
  </nav>
</template>

<script>
  export default {
    name: "NavBar",
    data() {
      return {
        toggleClass: true,
        headerClass: true,
        searchKey: "",
      }
    },
    methods: {
      menuToggle() {
        this.toggleClass = !this.toggleClass
      },
      navSkip(link) {
        if (this.$route.path.indexOf(link)){
          this.menuToggle()
          this.$router.push(link)
        }
      },
      search() {
        if (this.searchKey !== null && this.searchKey !== '') {
          this.$router.push({
            path: '/search',
            query: {
              key: this.searchKey
            }
          })
          this.searchKey = ''
        } else {
          this.message()
        }
      },
      message()  {
        this.$notify.error({
          title: '提示',
          message: '请输入搜索的关键字~',
        });
      },
    }
  }
</script>

<style scoped>

</style>
