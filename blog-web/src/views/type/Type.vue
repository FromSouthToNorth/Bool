<template>
  <div class="m-container-small m-padded-tb-big">
    <div class="ui container">
      <!-- header -->
      <div class="ui top attached segment m-navbar">
        <div class="ui middle aligned two column grid">
          <div class="column">
            <h3 class="ui teal header">分类</h3>
          </div>
          <div class="right aligned column">
            共 <h4 class="ui orange header m-inline-block" > 12 </h4> 个
          </div>
        </div>
      </div>
      <!-- /header -->
      <div class="ui bottom attached segment teal">
        <div class="ui labeled button m-margin-tb-tiny" >
          <a href="#"  class="ui basic button">Spring</a>
          <div class="ui basic left pointing label" >2
          </div>
        </div>
      </div>

      <blog-list></blog-list>

      <div class="ui bottom attached segment grid" style="padding: 6px">
      </div>
    </div>
  </div>
</template>

<script>
  import BlogList from "components/blogList/BlogList"
  export default {
    name: "Type",
    components: { BlogList }
  }
</script>

<style scoped>

</style>