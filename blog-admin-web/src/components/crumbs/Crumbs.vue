<template>
  <div class="ui attached pointing menu">
    <div class="ui container">
      <div class="right menu">
        <router-link
          tag="a"
          v-if="menuList"
          v-for="item in menuList"
          :key="item.id"
          :to='item.url'
          class="item"
          :class="{active: $route.path==item.url}"
          >
          {{ item.name }}
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Crumbs",
    props: {
      menuList: {
        type: Array,
        default: [
          {id: 1, name: '发布', url: '"/blog/input' },
          {id: 2, name: '列表', url: '"/blog/list' }
        ]
      }
    },
  }
</script>

<style scoped>

</style>