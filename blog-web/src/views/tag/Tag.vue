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
      <div class="ui top attached segment">
        <div class="ui padded vertical segment stackable m-padded-large">
          <div class="ui middle aligned mobile reversed stackable grid">
            <div class="eleven wide column">
              <h3 class="ui header">
                <a href="#" class="m-black"></a>
              </h3>
              <p class="blog-text m-text"></p>
              <div class="ui grid">
                <div class="row">
                  <div class="six wide column">
                    <div class="ui mini horizontal link list">
                      <div class="item">
                        <img src="https://images.unsplash.com/photo-1592786999269-63f5b72a2553?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=100&q=100"
                             alt="" class="ui avatar image">
                        <div class="content"><a href="#" class="header">小王八</a>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="right aligned ten wide column">
                    <a href=""
                       class="ui teal basic label m-padded-tiny m-opacity-mini"
                       >Java基础</a>
                  </div>
                </div>
                <div class="row">
                  <div class="sixteen wide column m-font-color">
                                    <span class="m-margin-lr-small">
                                        <i class="calendar alternate icon"></i><span
                                            >2020-06-22</span>
                                    </span>
                    <span class="m-margin-lr-small">
                                        <i class="eye icon"></i><span >66</span>
                                    </span>
                    <span class="m-margin-lr-small">
                                        <i class="comment outline icon"></i><span></span>
                                    </span>
                  </div>
                </div>
                <div class="row">
                  <div class="column">
                    <a href="#" class="ui teal basic left pointing label m-padded-comm m-margin">spring</a>
                  </div>
                </div>
              </div>
            </div>
            <div class="ui five wide column">
              <a href="#" >
                <img src="https://images.unsplash.com/photo-1592786999269-63f5b72a2553?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=350"
                     alt="" class="ui rounded image fluid">
              </a>
            </div>
          </div>
        </div>
      </div>
      <div class="ui bottom attached segment" style="padding: 6px">
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Tag"
  }
</script>

<style scoped>

</style>