<template>
  <div class="list">
      <h1>Your Songs</h1>
      <song-list :songs="songs"></song-list>
  </div>
</template>

<script>
import SongList from "@/components/SongList.vue";
import { getAllSongs } from "@/services/songListServices";

export default {
    components: {
        SongList
    },
    data() {
        return {
            songs: []
        };
    },
    async created() {
        this.songs = await getAllSongs();
    }
};
</script>

<style>
/*
Trav Notes 4-10
displays a list of available songs. uses SongList component and gets them using getAllSongs function
in the sonfListServvices. Theyre assigned to the songs data wehn the component is created using "created"  */
</style>