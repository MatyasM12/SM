<template>
  <div id="app">
    <Navbar></Navbar>
    <router-view/>
  </div>
</template>

<script>
  import HelloWorld from './components/HelloWorld.vue'
  import Navbar from "./components/Navbar";

  export default {
    name: 'app',
    methods: {
      doSomething: function () {
        console.log('no');
        let formData = new FormData();
        formData.append('username', 'bb@yahoo.com');
        formData.append('password', '123');
        this.$http.post('/api/auth/login', formData).then(resp => console.log(resp))
      },
    },
    components: {
      Navbar,
      HelloWorld
    },
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
  }
</style>
