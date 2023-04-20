<template>
  <div>
  
    
    
    <div class="playlist-url" v-for="currentPlaylist in filterPlaylist" v-bind:key="currentPlaylist.id">
      <iframe style="border-radius:12px" v-bind:src="currentPlaylist.playlistUrl" width="100%" height="352" frameBorder="0" allowfullscreen="" allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture" loading="lazy"></iframe>
    </div>
  </div>
</template>

<script>


import SongListService from "../services/SongListService.js"

export default {
  data() {
    return {
      songs: [],
      playlist: [],
      currentPlaylist: "",
      mood: {},

  components: {
  

  },
    
}
},
 created(){
   SongListService.getPlaylist()
   .then((response) => {
        this.playlist = response.data;
        this.mood = this.$store.state.moodId
      })
      .catch((err) => console.error(err));
    
  },
  computed: {
    filterPlaylist() {
      console.log(this.playlist)
      return this.playlist.filter((playlist) => {
        return playlist.playlistName.toLowerCase() == this.mood.mood
      })
    }
  }
};
</script>

<style scoped>
</style>