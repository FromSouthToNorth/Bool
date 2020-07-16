<template>
  <div>
    <crumbs :menuList="menuList"></crumbs>
    <keep-alive>
      <router-view></router-view>
    </keep-alive>
  </div>
</template>

<script>
  import Crumbs from 'components/crumbs/Crumbs'
  export default {
    name: "Blogs",
    components: {Crumbs},
    data() {
      return {
        menuList: [
          { id: 1, name: '发布', url: '/blog/input'},
          { id: 2, name: '列表', url: '/blog/list' }
        ]
      }
    },
    activated() {  }
  }
</script>

<style scoped>

</style>