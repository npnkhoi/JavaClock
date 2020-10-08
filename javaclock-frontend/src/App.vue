<template>
  <div class="main-page absolute h-full w-full flex flex-col items-center">
    <div class="navigation-bar m-4">
      <router-link to='/'> [Clock] </router-link>
      <router-link to='/login'> [Log in] </router-link>
      <router-link to='/signup'> [Sign up (WIP)] </router-link>    
    </div>
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
