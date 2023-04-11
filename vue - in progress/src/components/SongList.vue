<template>
  <div class="moods">
    <div v-for="currentMood in mood" v-bind:key="currentMood.id">
      <router-link
        v-bind:to="{ name: 'mood' }">
        {{ currentMood.mood }}
        <Mood v-bind:mood="currentMood"/>
      </router-link>
      <div class="songlist">
        <div v-for="currentSong in songs" v-bind:key="currentSong.id">
          {{ currentSong.title }}
          <SongListItem />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import SongListItem from "@/components/SongListItem";
import SongListService from "@/services/SongListService";
import Mood from "./Mood.vue";

export default {
  name: "song-list",
  components: {
    SongListItem,
    Mood,
  },
  data() {
    return {
      songs: [],
      mood: [],
    };
  },
  created() {
    SongListService.getAllSongs()
      .then((response) => {
        this.songs = response.data;
      })
      .catch((err) => console.error(err));

    SongListService.getAllMoods()
      .then((response) => {
        this.mood = response.data;
      })
      .catch((err) => console.error(err));
    
    
    
  },
};
</script>

<style>
</style>