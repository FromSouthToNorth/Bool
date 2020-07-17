import Vue from 'vue'
import VueRouter from "vue-router"

Vue.use(VueRouter)

const routes =[
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    component: () => import('views/login/Login')
  },
  {
    path: '/blogs',
    component: () => import('views/blogs/Blogs'),
    children: [{
      path: '',
      redirect: 'list'
    },
    {
      path: 'list',
      component: () => import('views/blogs/blogList/BlogList')
    },
    {
      path: 'input',
      component: () => import('views/blogs/blogInput/BlogInput.vue')
    }]
  }
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

router.beforeEach((to, from, next) => {
  next()
})

export default router