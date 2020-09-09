module.exports = {
  configureWebpack: {
    resolve: {
      alias: {
        'assets': '@/assets',
        'common': '@/common',
        'components': '@/components',
        'views': '@/views',
        'ajax': '@/ajax'
      }
    },
    externals: {
      vue: 'Vue',
      'vue-router': 'VueRouter',
      'semantic': 'Semantic',
      'jquery': '$',
      // 'highlight.js': 'hljs'
    }
  },
}
