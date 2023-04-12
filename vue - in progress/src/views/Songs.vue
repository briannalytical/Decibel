<template>
  <div>
    <SongDetails />
    <div class="back-button-container">
      <back-button></back-button>
    </div>
  </div>
</template>

<script>
import SongDetails from "@/components/SongDetails";
import BackButton from "../components/BackButton.vue";

export default {
  components: {
    SongDetails,
    BackButton,
  },
};
</script>

<style scoped>
.back-button-container {
  position: absolute;
  top: 10px;
  left: 10px;
  z-index: 10;
}
</style>