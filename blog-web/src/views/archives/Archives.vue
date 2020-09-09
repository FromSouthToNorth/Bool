<template>
  <div class="m-container-small m-padded-tb-big">
    <div class="ui container">
      <!-- header -->
      <div class="ui top attached segment padded m-navbar m-dialog-shadow">
        <div class="ui middle aligned two column grid">
          <div class="column">
            <h3 class="ui title header">归档</h3>
          </div>
          <div class="right aligned column">
            共 <h3 class="ui orange header m-inline-block"> {{blogCount}} </h3> 篇
          </div>
        </div>
      </div>
      <!-- /header -->
      <div v-for="(value, key) in mapArchives" :key="key">
        <h2 class="ui center aligned header" style="margin: 20px;">{{key}}</h2>
        <el-timeline>
          <el-timeline-item
              v-for="item in value"
              :key="item.id"
              :timestamp="ChangeDateFormat(item.updateTime)"
              placement="top"
              color="#00B5AD"
          >
            <el-card>
              <el-image
                  style="width: 60px; height: 44px"
                  :src="item.firstPicture"
              ></el-image>
              <div class="archives-text-box">
                <h4>{{ item.title }}</h4>
                <p>
                  <el-tag effect="plain"
                          size="mini"
                          type="warning"
                  > {{ item.flag }} </el-tag>
                  {{ dateFormat(item.updateTime) }}
                </p>
              </div>
              <router-link :to="'/blog/'+item.id" tag="a" class="cover-link">
              </router-link>
            </el-card>
          </el-timeline-item>
        </el-timeline>
      </div>
    </div>
  </div>
</template>

<script>

  import ChangeDateFormat from "@/utlis/changeDateFormat";

  export default {
    name: "Archives",
    data() {
      return {
        blogCount: null,
        mapArchives: null,
        loading: []
      }
    },
    created() {
      this.openLoading();
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
          this.loading.close();
        }
      })
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
      dateFormat(date) {
        return ChangeDateFormat(date)
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

<style>
  .el-timeline-item__timestamp.is-top {
    font-weight: 500;
  }

  .el-card__body h4 {
    font-weight: 500;
    color: #606266;
    /*cursor: pointer;*/
    padding-bottom: 10px;
  }

  .archives-text-box {
    margin-left: 20px;
    display: inline-block;
  }

  .el-card__body .archives-text-box p {
    font-size: 12px;
    color: #909399;
  }

  .cover-link {
    cursor: pointer;
    display: block;
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    z-index: 4;
    background: url(data:image/gif;base64,R0lGODlhAQABAIAAAP///////yH5BAEHAAEALAAAAAABAAEAAAICTAEAOw==) repeat;
  }
</style>
