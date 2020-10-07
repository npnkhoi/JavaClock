<template>
<div class="login-wrapper flex flex-col items-center w-1/4 bg-gray-800 rounded-sm p-2">
    <div class="text-white text-lg"> Who are you? </div>
    <input 
        type="text" 
        name="username" 
        class="login-entry" 
        placeholder="username"
        id=""
    >
    <input 
        type="password" 
        name="password" 
        class="login-entry" 
        placeholder="password"
        id=""
    >
    <button 
        type="submit" 
        class="bg-transparent mt-1 py-1 px-4 border border-blue-500 rounded
            hover:border-transparent hover:bg-blue-500 hover:text-white ">Log in</button>
</div>
</template>

<script>
export default {
    
}
</script>

<style>
.login-entry {
    margin: 5px;
    padding: 5px;
    border-radius: 2px;
}
</style>