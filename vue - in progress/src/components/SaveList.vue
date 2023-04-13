<template>
  <div>
 <div>
   <p v-for="currentPlaylist in savedPlaylist" v-bind:key="currentPlaylist.playlistId"></p>
   <p>{{currentPlaylist.playlistId}}</p>
   <p>{{currentPlaylist.playlistName}}</p>
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

    name: 'save-list',
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
    SongListService.getPlaylistById()
      .then((response) => {
        this.playlist = response.data;
      })
      .catch((err) => console.error(err));
     }

}
</script>

<style>

</style>