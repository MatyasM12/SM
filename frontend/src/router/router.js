import Vue from 'vue';
import Router from 'vue-router';
import Home from "../components/Home";
import SecureComp from "../components/SecureComp";
import store from '../store/store';

Vue.use(Router);

let router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/home',
      name: 'home',
      component: Home
    },
    {
      path: '/secure',
      name: 'secure',
      component: SecureComp,
      meta: {
        requiresAuth: true
      },
    }
  ]
});

router.beforeEach((to, from, next) => {
  if (to.matched.some(route => route.meta.requiresAuth)) {
    console.log(store);
    if (store.getters.isLoggedIn) {
      console.log('logged in!');
      next();
      return;
    }
    next('/home')
  } else {
    next()
  }
});

export default router;