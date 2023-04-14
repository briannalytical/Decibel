<template>
  <div>
    <SongDetails />
    <div class="back-button-container">
      <back-button></back-button>
      <save-button></save-button>
    </div>
  </div>
</template>

<script>
import SongDetails from "@/components/SongDetails";
import BackButton from "../components/BackButton.vue";
import SaveButton from "../components/SaveButton.vue";

export default {
  components: {
    SongDetails,
    BackButton,
    SaveButton
  },
};
</script>

<style scoped>
.back-button-container {
  position: absolute;
  top: 50px;
  left: 20px;
  z-index: 10;
}
</style>