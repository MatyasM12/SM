module.exports = {
  devServer: {
    port: 4200,
    proxy: {
      "/api/*": {
        target: "http://localhost:8080",
        secure: false,
        changeOrigin: true
      },
      "/auth/*": {
        target: "http://localhost:8080",
        secure: false,
        changeOrigin: true
      }
    }
  }
};