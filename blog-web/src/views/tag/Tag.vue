<template>
  <div class="m-container-small m-padded-tb-big">
    <div class="ui container">
      <!-- header -->
      <div class="ui top attached segment m-navbar">
        <div class="ui middle aligned two column grid">
          <div class="column">
            <h3 class="ui teal header">标签</h3>
          </div>
          <div class="right aligned column">
            共 <h4 class="ui orange header m-inline-block"> 12 </h4> 个
          </div>
        </div>
      </div>
      <!-- /header -->
      <div class="ui bottom attached segment teal">
        <a href="#"
           class="ui basic left pointing large label m-margin-tb-tiny">
          <span></span>
          <div class="detail">3</div>
        </a>
      </div>

      <blog-list></blog-list>

<!--      <div class="ui bottom attached segment" style="padding: 6px">-->
<!--      </div>-->
    </div>
  </div>
</template>

<script>

  import BlogList from "components/blogList/BlogList"

  export default {
    name: "Tag",
    components: { BlogList }
  }

</script>

<style scoped>

</style>