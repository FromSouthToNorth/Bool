<template>
  <div class="m-container-small m-padded-tb-big">
    <div class="ui container">
      <!-- header -->
      <div class="ui top attached segment padded m-navbar m-dialog-shadow">
        <div class="ui middle aligned two column grid">
          <div class="column">
            <h3 class="ui teal header">归档</h3>
          </div>
          <div class="right aligned column">
            共 <h3 class="ui orange header m-inline-block"> {{blogCount}} </h3> 篇
          </div>
        </div>
      </div>
      <!-- /header -->
      <div v-for="(value, key) in mapArchives" :key="key">
        <h2 class="ui center aligned header" style="margin: 20px;">{{key}}</h2>
        <div class="ui fluid vertical menu m-dialog-shadow"
             v-loading="loading">
          <router-link
            class="item"
            v-for="item in value"
            :key="item.id"
            :to="'/blog/'+ item.id"
          >
            <span>
              <i class="mini teal circle icon"></i>
              <span>{{item.title}}</span>
              <div class="ui teal basic left pointing label m-padded-min">{{ChangeDateFormat(item.updateTime)}}</div>
            </span>
            <div class="ui orange basic left pointing label m-padded-min">{{item.flag}}</div>
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

  export default {
    name: "Archives",
    data() {
      return {
        blogCount: null,
        mapArchives: null,
        loading: true
      }
    },
    mounted() {
      $.get({
        url: 'blogTotal',
        success: res => {
          this.blogCount = res
        }
      })
      $.get({
        url: 'blogArchive',
        success: res => {
          this.mapArchives = res
        }
      })
      this.delayLoading()
    },
    deactivated() {  },
    methods: {
      ChangeDateFormat(date) {
        var arr = date.split("T");
        var d = arr[0];
        var darr = d.split("-");

        var t = arr[1];
        var tarr = t.split(".000");
        var marr = tarr[0].split(":");

        var dd =
          // parseInt(darr[0]) +
          // "年" +
          parseInt(darr[1]) + "月" + parseInt(darr[2]) + "日";
        //parseInt(marr[0])
        // ":" +
        // parseInt(marr[1]) +
        // ":" +
        // parseInt(marr[2]);
        return dd;
      },
      delayLoading() {
        setTimeout(() => {
          this.loading = false
        }, 600)
      }
    }
  }

</script>

<style scoped>

</style>
