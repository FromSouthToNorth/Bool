import "assets/css/myCss.css"
import "assets/css/typo.css"
import Vue from 'vue'
import App from './App.vue'
import router from "./router"
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

Vue.config.productionTip = false

Vue.use(hljs)
Vue.use(ElementUI)
Vue.directive('highlight', function (el) {
  let blocks = el.querySelectorAll('pre')
  blocks.forEach((block) => {
    hljs.highlightBlock(block)
  })
})

new Vue({
  render: h => h(App),
  router
}).$mount('#app')
