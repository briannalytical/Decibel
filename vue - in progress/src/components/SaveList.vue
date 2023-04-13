<template>
  <div>
 <div v-for="currentPlaylist in savedPlaylist" v-bind:key="currentPlaylist.playlistId">
     <button class="save-button" @click="savePlaylist">
     &#8592; Save Playlist  
  </button>
 </div>
  </div>
</template>

<script>
import SongListService from "@/services/SongListService";
export default {
  data() {
    return {
      playlist: [],
    }
  },

    name: 'savelist',
    computed: {

      savedPlaylist() {
        return this.playlist.filter(playlist => {
          if(playlist.playlistId == this.$store.state.playlistId) {
            return true
          }
        })
      }
    },
     created() {
       const playlistId = this.$route.params.id;

    SongListService.getPlaylistById(playlistId)
      .then((response) => {
        this.playlist = response.data;
      })
      .catch((err) => console.error(err));
     },

     methods: {
    savePlaylist() {
      const playlistId = this.$route.params.id;
        this.$router.push({
            name:"savelist", 
            params: {
              id: playlistId
            }
        })
    }
    }

}
</script>

<style>
.save-button {
    background-color: #f8f9fa;
    border: none;
    color: #077bff;
    /* padding: 8px 16px; */
    font-size: 16px;
    cursor: pointer;
    /* text-decoration: none; */
    border-radius: 4px;
    transition: background-color 0.3s, color 0.3s;
}

.save-button:hover {
    background-color: #077bff;
    color: #ffffff;
}
</style>