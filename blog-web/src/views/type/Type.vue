<template>
  <div class="m-container-small m-padded-tb-big">
    <div class="ui container m-dialog-shadow">
      <!-- header -->
      <div v-if="typeList" class="ui top attached segment m-navbar">
        <div class="ui middle aligned two column grid">
          <div class="column">
            <h3 class="ui title header">分类</h3>
          </div>
          <div class="right aligned column">
            共 <h4 class="ui orange header m-inline-block" > {{typeList.length}} </h4> 个
          </div>
        </div>
      </div>
      <!-- /header -->
      <div class="ui bottom attached segment teal type-box" v-if="typeList">
        <router-link
          tag="div"
          v-for="item in typeList"
          :key="item.id"
          @click.native="getBlog(item.id)"
          :to="'/type/' + item.id"
          class="ui labeled button m-margin-tb-tiny"
          :class="{active: $route.params.typeid == item.id}"
        >
          <span href="#"  class="ui basic button"
             :class="{teal: $route.params.typeid == item.id}">
            {{item.name}}
          </span>
          <div class="ui basic left pointing label"
               :class="{teal: $route.params.typeid == item.id}">
            {{item.value}}
          </div>
        </router-link>
      </div>

      <blog-list :paging="paging" :pageNum="pageNum" :pageBlog="pageBlog"></blog-list>

    </div>
  </div>
</template>

<script>
  import BlogList from "components/blogList/BlogList"
  export default {
    name: "Type",
    components: { BlogList },
    data() {
      return {
        typeList: null,
        pageBlog: {},
        typeId : 0,
        pageNum: 0,
        loading: []
      }
    },
    created() {
      this.openLoading();
    },
    // 组件处于活跃时
    activated() {
      $.get({
        url: 'types',
        success: res => {
          this.typeList = res
          if (!this.$route.params.typeid) {
            this.$router.push('/type/' + res[0].id)
            this.getBlog(res[0].id)
            this.loading.close();
          } else {
            this.getBlog(this.$route.params.typeid)
            this.loading.close();
          }
        }
      })
    },
    // 组件失去活跃时
    deactivated() {  },
    methods: {
      getBlog(id) {
        if (id !== -1) {
          this.typeId = id
        }
        $.get({
          url: 'blogType',
          data: {'typeId': this.typeId, 'pageNum': this.pageNum},
          success: res => {
            this.pageBlog = res
          }
        })
      },
      paging(pageNum) {
        this.pageNum = pageNum
        this.getBlog(-1)
      },
      // 打开加载层
      openLoading() {
        this.loading = this.$loading({
          lock: true,
          text: "拼命读取中",
          spinner: "el-icon-loading",
          background: "rgba(0,0,0,0.7)"
        });
      }
    }
  }
</script>

<style scoped>

</style>
