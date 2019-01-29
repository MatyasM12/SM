import Vue from 'vue'
import App from './App.vue'
import BootstrapVue from 'bootstrap-vue'
import Router from './router/router';
import Store from './store/store';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import VueResource from "vue-resource"

Vue.config.productionTip = false;
Vue.use(BootstrapVue);
Vue.use(VueResource);

new Vue({
  render: h => h(App),
  router: Router,
  store: Store,
}).$mount('#app');
