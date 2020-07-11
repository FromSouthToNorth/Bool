import Vue from 'vue'
import VueRouter from "vue-router"

Vue.use(VueRouter)

const routes = [
  {
    path: '',
    redirect: '/home'
  },
  {
    path: '/home',
    component: () => import('views/homeBlog/HomeBlog')
  },
  {
    path: '/type',
    component: () => import('views/type/Type')
  },
  {
    path: '/tag',
    component: () => import('views/tag/Tag')
  },
  {
    path: '/archives',
    component: () => import('views/archives/Archives')
  },
  {
    path: '/about',
    component: () => import('views/about/About')
  }
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router
