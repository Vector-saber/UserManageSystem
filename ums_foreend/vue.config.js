const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      '/backend': {
        target: 'http://localhost:8081/',
        changeOrigin: true,
        pathRewrite: { '^/backend': '' }
      }
    }
  }
})
