<template>
  <div>
    <p>something</p>
    <form class="login" @submit.prevent="login">
      <h1>Sign in</h1>
      <label>Email</label>
      <input required v-model="username" type="text" placeholder="Name"/>
      <label>Password</label>
      <input required v-model="password" type="password" placeholder="Password"/>
      <hr/>
      <button type="submit">Login</button>
    </form>
    <button @click="this.logout">LOGOUT</button>
  </div>
</template>

<script>
  export default {
    name: "Home",
    data() {
      return {
        username: "",
        password: ""
      }
    },
    methods: {
      login() {
        let username = this.username;
        let password = this.password;
        this.$store.dispatch('login', {username, password})
          .then((resp) => {
            console.log('logged NIN', resp);
            this.$router.push({'path': '/secure'})
          })
          .catch(err => console.log(err))
      },
      logout() {
        this.$store.dispatch('logout')
          .then(() => this.$router.push('/'))
          .catch(err => console.log(err))
      }
    }
  }
</script>

<style scoped>

</style>