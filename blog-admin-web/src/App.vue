<template>
  <div id="app">
    <div class="m-background">
      <nav-bar v-if="navShow"></nav-bar>
      <keep-alive>
        <router-view></router-view>
      </keep-alive>
      <footer-bar v-if="navShow"></footer-bar>
    </div>
  </div>
</template>

<script>

  import "ajax/base"
  import NavBar from "components/navBar/NavBar"
  import FooterBar from "components/footerBar/FooterBar";

  export default {
    name: 'App',
    data() {
      return {
        navShow: true
      }
    },
    components: { NavBar, FooterBar },
    beforeUpdate() {
      if (this.$route.path != '/login') {
        $.get({
          url: "islogin",
          success: res => {
            if (!res && this.$route.path != "/login") {
              this.$router.push("/login");
            }
          }
        })
      }
    },
    provide() {
      return {
        setNav: this.setNav
      }
    },
    methods: {
      setNav(flag) {
        this.navShow = flag;
      }
    }
  }
</script>

<style>
  @import "assets/css/myCss.css";
  @import "assets/css/base.css";
</style>
