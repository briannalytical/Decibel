np<template>
  <div>
 <div v-for="currentPlaylist in playlist" v-bind:key="currentPlaylist.playlistId">
   <p>{{currentPlaylist.playlistName}}</p>
   
 </div>
 <p>Test</p>
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
     created() {
      

    SongListService.getPlaylistById()
      .then((response) => {
        this.playlist = response.data;
      })
      .catch((err) => console.error(err));
     },

   

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