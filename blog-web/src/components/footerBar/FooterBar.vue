<template>
  <footer class="ui vertical segment footer-box">
    <div class="ui center aligned footer-main">
      <div class="footer-page-views">
        <ul class="page-views">
          <li>蒲公英和炊烟都在等你</li>
          <li class="visit-total">本站访问次数：{{ VisitTotal }}</li>
          <li class="github-icon"><a href="https://github.com/FromSouthToNorth" target="_blank"><i class="github icon"></i></a></li>
          <li><a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=598050554&site=qq&menu=yes"><i class="qq icon"></i></a></li>
        </ul>
      </div>
      <div class="footer-info">
        <ul class="icp">
          <li>
            <a target="_blank" href="http://www.beian.miit.gov.cn/">蜀ICP备20019889号</a>
          </li>
          <li class="public-security">
            <a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=51012202000694">川公网安备 51012202000694号</a>
          </li>
        </ul>
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
