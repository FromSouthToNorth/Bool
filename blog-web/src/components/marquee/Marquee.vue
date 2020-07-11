<template>
  <div class="ui shape m-dialog-shadow">
    <div class="sides">
      <div class="side" v-for="item in carousel.items" :key="item.id">
        <a>
          <img :src="item.src" @load="loadOK" alt />
        </a>
      </div>
    </div>
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
            { id: 2, src: 'https://202007002.oss-cn-chengdu.aliyuncs.com/images/blogHomeMarquee/20200711111019.png' }
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
          }, 3000);
        }
      }
    }
  }
</script>

<style scoped>
  .ui.shape {
    width: 100%;
    border-radius: 4px;
  }
  .sides .side img {
    width: 100%;
    border-radius: 4px;
    height: 280px;
  }
  .sides .side {
    width: 100%;
    height: 280px;
  }
</style>