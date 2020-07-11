<template>
  <div class="m-container m-padded-tb-large">
    <div class="ui container">
      <div class="ui stackable grid">
        <div class="eleven wide column">
          <div class="m-dialog-shadow">
            <!-- 标题 -->
            <div class="ui top attached segment m-navbar">
              <div class="ui middle aligned two column grid">
                <div class="column">
                  <h3 class="ui teal header">文章</h3>
                </div>
                <div class="right aligned column">
                  共 <h4 class="ui orange header m-inline-block" > 12 </h4> 篇
                </div>
              </div>
            </div>
            <!-- /标题 -->
            <div class="ui attached segment teal">
              <div class="ui padded vertical segment stackable m-padded-large" >
                <div class="ui middle aligned mobile reversed stackable grid">
                  <div class="eleven wide column">
                    <h3 class="ui header"><a href="#"  class="m-black" ></a></h3>
                    <p class="blog-text m-text" ></p>
                    <div class="ui grid">
                      <div class="row">
                        <div class="six wide column">
                          <div class="ui mini horizontal link list">
                            <div class="item">
                              <img  src="https://images.unsplash.com/photo-1592786999269-63f5b72a2553?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=100&q=100" alt="" class="ui avatar image">
                              <div class="content"><a href="#"  class="header" >小王八</a></div>
                            </div>
                          </div>
                        </div>
                        <div class="right aligned ten wide column">
                          <a href=""  class="ui teal basic label m-padded-tiny m-opacity-mini" >Java基础</a>
                        </div>
                      </div>
                      <div class="row">
                        <div class="sixteen wide column m-font-color">
                                            <span class="m-margin-lr-small">
                                                <i class="calendar alternate icon"></i><span >2020-06-22</span>
                                            </span>
                          <span class="m-margin-lr-small">
                                                <i class="eye icon"></i><span ></span>
                                            </span>
                          <span class="m-margin-lr-small">
                                                <i class="comment outline icon"></i><span></span>
                                            </span>
                        </div>
                      </div>
                      <div class="row">
                        <div class="column">
                          <a href="" class="ui teal basic left pointing label m-padded-comm m-margin"  style="margin-top: 1rem">spring</a>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="ui five wide column">
                    <a href="#" >
                      <img  src="https://images.unsplash.com/photo-1592786999269-63f5b72a2553?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=350" alt="" class="ui rounded image fluid">
                    </a>
                  </div>
                </div>
              </div>
            </div>
            <div class="ui bottom attached segment">
              <div class="ui middle aligned two column grid">
                <div class="column">
                  <a href="" class="ui mini teal basic button" >上一页</a>
                </div>
                <div class="right aligned column">
                  <a href="" class="ui mini teal basic button" >下一页</a>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="five wide column">
          <!-- 分类 -->
          <div class="ui segments m-dialog-shadow">
            <div class="ui secondary segment m-navbar">
              <div class="ui two column grid">
                <div class="column">
                  <i class="idea icon"></i>分类
                </div>
                <div class="right aligned column">
                  <a href="" >more <i class="angle double right icon"></i></a>
                </div>
              </div>
            </div>
            <div class="ui teal segment">
              <div class="ui fluid vertical menu">
                <a href="#"  class="item" ><span ></span><div class="ui teal basic left pointing label" ></div></a>
              </div>
            </div>
          </div>
          <!-- /分类 -->
          <!-- 标签 -->
          <div class="ui segments m-margin-top m-dialog-shadow">
            <div class="ui secondary segment m-navbar">
              <div class="ui two column grid">
                <div class="column">
                  <i class="tags icon"></i>标签
                </div>
                <div class="right aligned column">
                  <a href="" >more <i class="angle double right icon"></i></a>
                </div>
              </div>
            </div>
            <div class="ui teal segment">
              <a href="" >
                <span ></span>
                <div class="detail" ></div>
              </a>
            </div>
          </div>
          <!-- /标签 -->
          <!-- 最新推荐 -->
          <div class="ui segments m-margin-top m-dialog-shadow">
            <div class="ui secondary segment m-navbar">
              <i class="bookmark icon"></i>最新推荐
            </div>
            <div class="ui segment" >
              <a href="#"  class="m-font-color" >用户故事(User Story)</a>
            </div>
          </div>
          <!-- /最新推荐 -->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "HomeBlog"
  }
</script>

<style scoped>

</style>