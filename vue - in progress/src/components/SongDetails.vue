<template>
  <div class="songDetail">
   
    <h2>Playlist</h2>
    <SongList v-bind:song="song" />
  </div>
</template>

<script>
import SongList from "./SongList.vue";

export default {
  name: "song-detail",
  components: {
    SongList,
  },
  data() {
    return {
      song: {},

    };
  },
};
</script>

<style>

</style>