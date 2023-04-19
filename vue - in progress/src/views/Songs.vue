<template>
  <div>
   
    <div class="back-button-container">
      <back-button></back-button>
      <iframe src="https://open.spotify.com/embed/playlist/37i9dQZF1EIcpc1Z28flXB?utm_source=generator&theme=0" width="100%" height="380" frameBorder="0" allowfullscreen="" allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture">
      </iframe>
    
    </div>
  </div>
</template>

<script>

import BackButton from "../components/BackButton.vue";


export default {
  components: {
  
    BackButton,
   
  },
};
</script>

<style scoped>

</style>