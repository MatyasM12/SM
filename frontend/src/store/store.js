import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

let store = new Vuex.Store({
    state: {
      status: '',
      user: {},
      loggedIn: localStorage.getItem('logged'),
    },
    mutations: {
      auth_request(state) {
        state.status = 'loading'
      },
      auth_success(state, user) {
        console.log('success!');
        state.user = user;
        console.log('commit end', state);
      },
      logout_success(state) {
        state.loggedIn = false;
      }
    },
    actions: {
      login({commit}, user) {
        return new Promise((resolve, reject) => {
          let formData = new FormData();
          console.log(user);
          formData.append('username', user.username);
          formData.append('password', user.password);
          console.log('going');
          Vue.http.post('/api/auth/login', formData)
            .then(response => {
              if (response.status === 200) {
                console.log(response);
                Vue.http.get('/api/authorize/getCurrentUser').then(resp => {
                  commit('auth_success', user);
                  localStorage.setItem('logged', 'true');
                  console.log(resp, store);
                  resolve(resp);
                });
              }
            })
        })
      },
      logout({commit}) {
        return new Promise((resolve, reject) => {
          localStorage.removeItem('logged');
          commit('logout_success');
          console.log('removed!');
        })
      }
    },
    getters: {
      isLoggedIn: state => !!state.loggedIn,
    }
  },
);

export default store