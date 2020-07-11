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
            共 <h3 class="ui orange header m-inline-block"> 12 </h3> 篇
          </div>
        </div>
      </div>
      <!-- /header -->
        <h2 class="ui center aligned header">2017</h2>
        <div class="ui fluid vertical menu m-dialog-shadow">
          <a href="#" class="item">
            <span>
              <i class="mini teal circle icon"></i><span></span>
              <div class="ui teal basic left pointing label m-padded-min">06月22</div>
            </span>
            <div class="ui orange basic left pointing label m-padded-min">原创</div>
          </a>
        </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Archives"
  }
</script>

<style scoped>

</style>