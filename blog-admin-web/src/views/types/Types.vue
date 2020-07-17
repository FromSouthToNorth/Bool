<template>
  <div>
    <crumbs :menuList="menuList"></crumbs>
    <router-view></router-view>
  </div>
</template>

<script>
  import Crumbs from "components/crumbs/Crumbs"
  export default {
    name: "Types",
    components: { Crumbs },
    data() {
      return {
        menuList: [
          {
            id: 1,
            name: '发布',
            url: '/types/input'
          },
          {
            id: 2,
            name: '列表',
            url: '/types/list'
          }
        ]
      }
    }
  }
</script>

<style scoped>

</style>