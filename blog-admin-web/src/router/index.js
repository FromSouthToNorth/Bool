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
    path: '/home',
    component: () => import('views/home/Home')
  },
  {
    path: '/blogs',
    component: () => import('views/blogs/Blogs'),
    children: [{
      path: '',
      redirect: 'list'
    }, {
      path: 'list',
      component: () => import('views/blogs/blogList/BlogList')
    }, {
      path: 'input',
      component: () => import('views/blogs/blogInput/BlogInput')
    }]
  },
  {
    path: '/types',
    component: () => import('views/types/Types'),
    children: [{
      path: '',
      redirect: 'list'
    }, {
      path: 'list',
      component: () => import('views/types/typeList/TypeList')
    }, {
      path: 'input',
      component: () => import('views/types/typeInput/TypeInput')
    }]
  },
  {
    path: '/tags',
    component: () => import('views/tags/Tags'),
    children: [{
      path: '',
      redirect: 'list'
    }, {
      path: 'list',
      component: () => import('views/tags/tagList/TagList')
    }, {
      path: 'input',
      component: () => import('views/tags/tagInput/TagInput')
    }]
  },
  {
    path: '/comment',
    component: () => import('views/comment/Comment')
  },
  {
    path: '/comments',
    component: () => import('views/comment/Comments')
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
