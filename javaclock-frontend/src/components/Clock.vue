<template>
  <div class="container w-full m-0 bg-gray-400">
    <div class="time text-red-600"> {{ currentTime }} </div>
  </div>
  
</template>

<script>
import moment from 'moment';

export default {
  data () {
    return {
      currentTime: "Loading clock"
    }
  },
  mounted: function () {
    setInterval(() => {
      this.currentTime = moment().format('MMMM Do YYYY, h:mm:ss a');
    }, 1000);
  }
}
</script>

<style>

</style>