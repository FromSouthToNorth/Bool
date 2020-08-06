<template>
  <div id="app">
    <div class="m-background">
      <el-backtop></el-backtop>
      <nav-bar></nav-bar>
      <keep-alive>
        <router-view></router-view>
      </keep-alive>
      <footer-bar :VisitTotal="VisitTotal"></footer-bar>
    </div>
  </div>
</template>

<script>

  import NavBar from "components/navBar/NavBar"
  import FooterBar from "components/footerBar/FooterBar";
  import 'ajax/base'
  var _hmt = _hmt || []

  export default {
    name: 'App',
    components: {
      NavBar,
      FooterBar
    },
    data() {
      return {
        VisitTotal: 0
      }
    },
    mounted() {
      this.getVisitTotal()
      this.baidustatistical()
    },
    methods: {
      getVisitTotal() {
        $.get({
          url: 'getVisitTotal',
          success: res => {
            this.VisitTotal = res
          }
        })
      },
      baidustatistical() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?1a1f039af1dd3609fee0034a9d1767e5";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      }
    }
  }

</script>

<style>

</style>
