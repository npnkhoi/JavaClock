<template>
  <div class="main-page absolute h-full w-full">
    <router-link to='/'> [Home] </router-link>
    <router-link to='/clock'> [Clock] </router-link>
    <router-link to='/login'> [Log in] </router-link>
    <router-link to='/signup'> [Sign up] </router-link>    
    <br>
    <router-view />
  </div>
</template>

<script>

export default {
  name: 'App',
}
</script>

<style>
.main-page {
  color: #7289da;
  background-color: #23272a;
}
</style>
