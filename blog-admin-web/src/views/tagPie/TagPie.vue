<template>
  <div class="chart el-card el-card__body" style="margin-left: 24px;">
    <div id="type-pie" style="width: 340px; height: 320px;"></div>
  </div>
</template>

<script>
export default {
  name: "TypePie",
  data() {
    return {
      typePie: {  },
      tagName: {  }
    }
  },
  activated() {
    this.getData()
  },
  methods: {
    getData() {
      $.get({
        url: 'tagdata',
        success: res => {
          this.typePie = res
          this.pieChart()
        }
      })
    },
    pieChart() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById("type-pie"));
      let option = {
        title: {
          text: '博客标签统计',
          left: 'center'
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        // legend: {
        //   orient: 'vertical',
        //   left: 'left',
        //   data: this.tagName
        // },
        series: [
          {
            name: '标签的博客数量',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: this.typePie,
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      };
      myChart.setOption(option)
    }
  }
}
</script>

<style scoped>

</style>
