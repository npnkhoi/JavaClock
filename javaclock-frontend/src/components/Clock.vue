<template>
  <div class="clock-wrapper h-full w-full flex flex-col justify-center items-center">
    <div class="title text-4xl"> Welcome {{ name }} to Java Clock</div>
    <div class="time"> {{ currentTime }} </div>
  </div>
  
</template>

<script>
import moment from 'moment';
import { mapState } from 'vuex'

export default {
  data () {
    return {
      currentTime: "Loading",
    }
  },
  computed: {
    ...mapState({
      name: state => state.name
    })
  },
  mounted: function () {
    console.log(this.name);
    setInterval(() => {
      this.currentTime = moment().format('HH:mm:ss');
    }, 1000);
    console.log(this.name);
  }
}
</script>

<style>

.time {
  font-size: 150px;
  letter-spacing: 7px;
}
</style>