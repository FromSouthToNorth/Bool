<template>
  <div class="ui container wscn-http404-container">
    <div class="ui stackable grid wscn-http404">
      <div class="eleven wide column pic-404">
        <img class="ui fluid image pic-404__parent" src="~/assets/404_images/404.png" alt="404">
      </div>
      <div class="five wide column">
        <div class="bullshit">
          <div class="bullshit__oops">
            404错误!
          </div>
          <div class="bullshit__headline">
            {{ message }}
          </div>
          <div class="bullshit__info">
            对不起，您正在寻找的页面不存在。尝试检查URL的错误，然后按浏览器上的刷新按钮或尝试在我们的应用程序中找到其他内容。
          </div>
          <router-link to="/" class="bullshit__return-home">
            返回首页
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "404",
  computed: {
    message() {
      return '找不到网页！'
    }
  }
}
</script>

<style scoped>

.wscn-http404-container {
  padding: 60px 0;
}

.bullshit {
  padding: 30px 0;
}

.bullshit .bullshit__oops {
  font-size: 32px;
  font-weight: bold;
  line-height: 40px;
  color: #1482f0;
  margin-bottom: 20px;
}

.bullshit .bullshit__headline {
  font-size: 20px;
  line-height: 24px;
  color: #222;
  font-weight: bold;
  margin-bottom: 10px;
}

.bullshit .bullshit__info {
  font-size: 12px;
  line-height: 20px;
  color: grey;
  margin-bottom: 30px;
}

.bullshit .bullshit__return-home {
  display: block;
  float: left;
  width: 110px;
  height: 36px;
  background: #1482f0;
  border-radius: 100px;
  text-align: center;
  color: #fff;
  font-size: 14px;
  line-height: 36px;
  cursor: pointer;
}

</style>
