<template>
  <div id="app">
    <nav-bar></nav-bar>
    <router-view></router-view>
    <footer-bar  :VisitTotal="VisitTotal"></footer-bar>
  </div>
</template>

<script>

  import NavBar from "components/navBar/NavBar"
  import FooterBar from "components/footerBar/FooterBar";
  import 'ajax/base'

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
    },
    methods: {
      getVisitTotal() {
        $.get({
          url: 'getVisitTotal',
          success: res => {
            this.VisitTotal = res
          }
        })
      }
    }
  }

</script>

<style>

</style>
