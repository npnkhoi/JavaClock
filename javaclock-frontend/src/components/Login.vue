<template>
<div class="login-wrapper flex flex-col items-center w-1/3 bg-gray-800 rounded-sm p-2">
    <div class="text-white text-lg"> Who are you? </div>
    <input 
        type="text" 
        name="username" 
        class="login-entry" 
        placeholder="username"
        id="username"
        v-model="username"
    >
    <input 
        type="password" 
        name="password" 
        class="login-entry" 
        placeholder="password"
        id="password"
        v-model="password"
    >
    
    <p 
        class="notification text-gray-600 italic"

    > 
        {{ notification }} 
    </p>
    <button
        class="bg-transparent mt-1 py-1 px-4 border border-blue-500 rounded hover:border-transparent hover:bg-blue-500 hover:text-white"
        @click="submit"
    >
        Submit
    </button>
</div>
</template>

<script>
import { login } from '../utils/api'

const MESSAGE_TABLE = {
    "SUCCESS": "Login succefully! Redirecting ...",
    "WRONG_INFO": "Wrong username or password",
    "MISSING_FIELD": "Missing at least one entry"
}

export default {
    data () {
        return {
            username: '',
            password: '',
            notification: '',
            redNotification: false
        }
    },
    methods: {
        submit: async function () {
            const userInfo = {username: this.username, password: this.password};
            try {
                this.notification = "Loading ..."
                const res = await login(userInfo);
                this.notification = MESSAGE_TABLE[res.data.message];
                if (res.data.message === "SUCCESS") {
                    this.$store.dispatch('login', res.data.payload.name)
                    window.location.href = "/"
                } else {
                    this.redNotification = true;
                }
            } catch (e) {
                console.log(e);
            }
        }
    }
}
</script>

<style>
.login-entry {
    margin: 5px;
    padding: 5px;
    border-radius: 2px;
}
</style>