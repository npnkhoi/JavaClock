<template>
  <div class="main-page absolute h-full w-full flex flex-col items-center">
    <div class="navigation-bar m-4">
      <router-link to='/'> [Clock] </router-link>
      <router-link to='/login' v-show="auth==='GUEST'">[Log in]</router-link>
      <button v-show="auth==='LOGGED_IN'" @click="logout"> [Log out] </button>
      <router-link to='/signup'> [Sign up (WIP)] </router-link>
    </div>
    <router-view />
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'App',
  computed: {
    ...mapState({
      auth: state => state.auth
    })
  },
  methods: {
    logout () {
      this.$store.dispatch("logout")
    }
  }
}
</script>

<style>
.main-page {
  color: #7289da;
  background-color: #23272a;
}
</style>
