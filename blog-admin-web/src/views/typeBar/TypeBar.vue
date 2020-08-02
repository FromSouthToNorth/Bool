<template>
  <div class="chart el-card el-card__body">
    <div id="type-bar" style="width: 370px; height: 320px"></div>
  </div>
</template>

<script>
export default {
  name: "typeBar",
  data() {
    return {
      typeBar: {
        names: {  },
        values: {  }
      }
    }
  },
  activated() {
    this.getData()
    this.drawChart()
  },
  methods: {
    getData() {
      $.get({
        url: 'typebar',
        success: res => {
          this.typeBar.names = res.names
          this.typeBar.values = res.values
          this.drawChart()
        }
      })
    },
    drawChart() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById("type-bar"));
      // 指定图表的配置项和数据
      let option = {
        title: {
          text: "博客分类 柱状图"
        },
        tooltip: {  },
        legend: {
          data: ["数量"]
        },
        xAxis: [{
          type: 'category',
          data: this.typeBar.names,
          axisTick: {
            alignWithLabel: true
          },
          axisLabel: {
            interval: 0
          }
        }],
        yAxis: {},
        series: [
          {
            name: "数量",
            type: "bar",
            data: this.typeBar.values
          }
        ]
      };
      myChart.setOption(option);
    },
  }
}
</script>

<style scoped>

</style>
