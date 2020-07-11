<template>
  <div class="m-container-small m-padded-tb-big">
    <div class="ui container">
      <div class="ui stackable grid">
        <div class="eleven wide column">
          <div class="ui segment m-dialog-shadow">
            <img src="https://images.unsplash.com/photo-1593370629580-4e25015f9b84?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60"
                 alt="" class="ui rounded fluid image">
          </div>
        </div>
        <div class="five wide column">
          <div class=" m-dialog-shadow">
            <div class="ui top attached segment m-navbar">
              <div class="ui header">关于我</div>
            </div>
            <div class="ui teal attached segment">
              <p class="m-text">一个Java初学者</p>
              <p class="m-text">一个编程爱好者</p>
              <p class="m-text">正在学习和探索编写高效代码的方法</p>
            </div>
            <div class="ui attached segment">
              <div class="ui orange basic left pointing label m-margin-tb-tiny">编程</div>
              <div class="ui orange basic left pointing label m-margin-tb-tiny">计算机</div>
              <div class="ui orange basic left pointing label m-margin-tb-tiny">看书</div>
            </div>
            <div class="ui attached segment">
              <div class="ui teal basic left pointing label m-margin-tb-tiny">HTML</div>
              <div class="ui teal basic left pointing label m-margin-tb-tiny">CSS</div>
              <div class="ui teal basic left pointing label m-margin-tb-tiny">Java</div>
              <div class="ui teal basic left pointing label m-margin-tb-tiny">MySQL</div>
            </div>
            <div class="ui bottom attached segment">
              <a href="https://github.com/FromSouthToNorth" class="ui circular icon button violet"><i
                      class="github icon"></i></a>
              <a href="#" class="ui wechat circular icon button teal"><i class="wechat icon"></i></a>
              <a href="#" class="ui qq circular icon button blue" data-content="598050554" data-position="bottom left"><i
                      class="qq icon"></i></a>
            </div>
            <div class="ui wei-chat-qr flowing popup transparent hidden">
              <img src="~assets/images/wechat.png" alt="" class="ui rounded image"
                   style="width: 80px;">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "About"
  }
</script>

<style scoped>

</style>