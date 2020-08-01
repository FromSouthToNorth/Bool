<template>
  <footer class="ui vertical segment m-footer">
    <div class="ui center aligned container">
      <div class="m-padded-tb-tb" id="web-meta">
        <div>
          <p style="color: #606266;">蒲公英和炊烟都在等你 | 本站访问次数: <span style="color: #303133;">{{VisitTotal}}</span></p>
        </div>
      </div>
      <p class="m-text-spaced m-text-thi m-padded-tb-tb">
        <a target="_blank" href="http://www.beian.miit.gov.cn/" style=" color: #303133;">蜀ICP备20019889号-1</a>
      </p>
      <div style="width:300px;margin:0 auto; padding: 0 0 20px;">
        <a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=51012202000694" style="display:inline-block;text-decoration:none;height:20px;line-height:20px;"><img src="~assets/images/for-the-record-icon.png" style="float:left;"/><p style="float:left;height:20px;line-height:20px;margin: 0px 0px 0px 5px; color:#303133;">川公网安备 51012202000694号</p></a>
      </div>
    </div>
  </footer>
</template>

<script>
  export default {
    name: "FooterBar",
    props: {
      VisitTotal: {
        type: Number,
        default: 0
      }
    }
  }
</script>

<style scoped>

</style>
