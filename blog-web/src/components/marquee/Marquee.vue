<template>
  <div class="ui shape m-dialog-shadow" style="margin-top: 1rem;">
    <el-carousel :interval="5000">
      <el-carousel-item v-for="item in carousel.items" :key="item.id">
        <el-image :src="item.src" style="width: 100%; height: 100%"></el-image>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
  export default {
    name: "Marquee",
    data() {
      return {
        loadCount: 0,
        carousel: {
          items: [
            { id: 1, src: 'https://202007002.oss-cn-chengdu.aliyuncs.com/images/blogHomeMarquee/20200711110957.png' },
            { id: 2, src: 'https://202007002.oss-cn-chengdu.aliyuncs.com/images/blogHomeMarquee/20200714224447.png' },
            { id: 3, src: 'https://202007002.oss-cn-chengdu.aliyuncs.com/images/blogHomeMarquee/%E6%BB%91%E6%9D%BF.jpg' }
          ]
        }
      }
    },
    methods: {
      loadOK() {
        this.loadCount++;
        if (this.loadCount === this.carousel.items.length) {
          $(".shape").shape();
          setInterval(() => {
            $(".shape").shape("flip left");
          }, 5000);
        }
      }
    }
  }
</script>

<style>
  .ui.shape {
    width: 100%;
    border-radius: 4px;
    overflow:hidden;
  }
  .ui.shape .el-carousel__container {
    height: 200px;
  }
</style>
