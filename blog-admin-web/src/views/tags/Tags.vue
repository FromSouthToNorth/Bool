<template>
  <div>
    <crumbs :menuList="menuList"></crumbs>
    <router-view></router-view>
  </div>
</template>

<script>
  import Crumbs from "../../components/crumbs/Crumbs"
  export default {
    name: "Tags",
    components: {Crumbs},
    data() {
      return {
        menuList: [
          {
            id: 1,
            name: '发布',
            url: '/tags/input'
          },
          {
            id: 2,
            name: '列表',
            url: '/tags/list'
          }
        ]
      }
    }
  }
</script>

<style scoped>

</style>