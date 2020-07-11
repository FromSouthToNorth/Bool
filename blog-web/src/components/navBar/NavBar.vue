<template>
  <nav class="ui inverted attached segment m-padded-tb-min m-nav">
    <div class="ui container">
      <div class="ui inverted secondary stackable menu">
        <h2 class="ui header item">
          <a href="" @click="navSkip('/home')" class="ui teal">HyZt</a>
        </h2>
        <a href="#"
           @click="navSkip('/home')"
           class="m-item item"
           :class="{active:$route.path.indexOf('/home')!==-1,'m-mobile-hide':toggleClass}"
          >
          <i class="mini home icon"></i> 首页
        </a>
        <a href="#"
           @click="navSkip('/type')"
           class="m-item item"
           :class="{active:$route.path.indexOf('/type')!==-1,'m-mobile-hide':toggleClass}"
          >
          <i class="mini idea icon"></i> 分类
        </a>
        <a href="#"
           @click="navSkip('/tag')"
           class="m-item item"
           :class="{active:$route.path.indexOf('/tag')!==-1,'m-mobile-hide':toggleClass}"
          >
          <i class="mini tags icon"></i> 标签
        </a>
        <a href="#"
           @click="navSkip('/archives')"
           class="m-item item"
           :class="{active:$route.path.indexOf('/archives')!==-1,'m-mobile-hide':toggleClass}"
          >
          <i class="mini clone icon"></i> 归档
        </a>
        <a href="#"
           @click="navSkip('/about')"
           class="m-item item"
           :class="{active:$route.path.indexOf('/about')!==-1,'m-mobile-hide':toggleClass}"
          >
          <i class="mini info icon"></i> 关于我
        </a>
        <!-- 搜索 -->
        <div class="right m-item item" :class="{'m-mobile-hide':toggleClass}">
          <div class="ui icon inverted transparent input">
            <input type="text" name="query" placeholder="请输入搜索内容...">
            <i class="search link icon"></i>
          </div>
        </div>
        <!-- /搜索 -->
      </div>
    </div>
    <a @click="menuToggle" class="ui menu toggle black icon button m-right-top m-mobile-show">
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
        searchKey: ""
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
    }
  }
</script>

<style scoped>

</style>