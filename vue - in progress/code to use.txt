<template>
  <div class="generator">
      <h1>What would you like to listen to?</h1>
      <select v-model="selectedMood">
          <option v-for="mood in moods" :key="mood">{{ mood }}</option>
      </select>
      <select v-model="selectedGenre">
          <option v-for="genre in genres" :key="genre">{{ genre }}</option>
      </select>
      <button @click="generatePlaylist">Generate</button>
      <song-list :songs="playlist"></song-list>
  </div> 
</template>

<script>
import SongList from '../components/SongList.vue';
import { generateSongsByMoodAndGenre } from "@/services/songListServices";

export default {
    components: {
        SongList
    },
    data() {
        return {
            moods: ["Happy", "Sad", "Angry", "Romantic", "Silly", "Unhinged", "Motivated", "Chill", "Workout"],
            genres: ["Rock", "Hip-Hop", "Rap", "Classical", "Electronic", "Jazz", "Blues", "Country",
             "Pop", "Alternative", "Anime", "Funk"],
            selectedMood: "",
            selectedGenre: "",
            playlist: []
        };
    },
    methods: {
        async generatePlaylist(){
            this.playlist = await generateSongsByMoodAndGenre(
                this.selectedMood,
                this.selectedGenre
            );
        }
    }
};
</script>

<style>
/* 
Trav Notes 4-10: 
main page for generating a playlist has 2 drop down menus for mood and genre. a generate button, and a 
component called SongList that displays the genrated playlist. the generatePlaylist method takes both 
selections from songListServices and updates the playlist data 
*/

</style>