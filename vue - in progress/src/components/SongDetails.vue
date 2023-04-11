<template>
  <div class="songDetail">
    <h2>Moods {{ mood.id }}</h2>
    <Mood v-bind:mood="mood" />
    <h2>Songs {{ song.title }}</h2>
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
      mood: {},
    };
  },
  
  
};
</script>

<style>
</style>