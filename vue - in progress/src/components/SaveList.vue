<template>
  <div id="main">

<div v-for="currentPlaylist in playlist" v-bind:key="currentPlaylist.playlistId" >
  <b-button class="expand-btn" v-b-toggle="'currentPlaylist.playlistId'" variant="primary">{{currentPlaylist.playlistName}}</b-button>
  <b-collapse v-bind:id="'currentPlaylist.playlistId'" class="mt-2">
    <b-card >
      <p class="card-text">{{currentPlaylist.songs}}</p>
    </b-card>
  </b-collapse>
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

.expand-btn {
  height: auto;
}

.save-button:hover {
    background-color: #077bff;
    color: #ffffff;
}
</style>