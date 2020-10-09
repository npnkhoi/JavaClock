import { createStore } from 'vuex'
import createPersistedState from 'vuex-persistedstate'

const store = createStore({
    plugins: [
        createPersistedState({
            key: 'vuex',
            storage: window.localStorage
          })
    ],
    state () {
        return {
            name: null,
            auth: 'GUEST',
        }
    },
    actions: {
        login (context, name) {
            context.commit('setName', name)
            context.commit('setAuth', "LOGGED_IN")
        },
        logout (context) {
            context.commit('setAuth', "GUEST")
            context.commit('setName', "")
        }
    },
    mutations: {
        setName (state, name) {
            state.name = name;
        },
        setAuth (state, auth) {
            state.auth = auth;
        }
    },
    
})

export default store