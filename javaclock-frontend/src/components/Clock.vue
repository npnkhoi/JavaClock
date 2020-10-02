<template>
  <div class="clock-wrapper h-full w-full flex flex-col justify-center items-center">
    <div class="title text-4xl"> Java Clock</div>
    <div class="time"> {{ currentTime }} </div>
  </div>
  
</template>

<script>
import moment from 'moment';

export default {
  data () {
    return {
      currentTime: "Loading"
    }
  },
  mounted: function () {
    setInterval(() => {
      this.currentTime = moment().format('HH:mm:ss');
    }, 1000);
  }
}
</script>

<style>

.time {
  font-size: 150px;
  letter-spacing: 7px;
}
</style>