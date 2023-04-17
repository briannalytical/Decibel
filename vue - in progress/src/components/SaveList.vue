<template>
  <div id="main">

<div class="accordion" role="tablist">
    <b-card no-body class="mb-1" v-for="(currentPlaylist, index) in playlist" v-bind:key="currentPlaylist.playlistId">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block v-b-toggle="'accordion-' + index" variant="info">{{currentPlaylist.playlistName}}</b-button>
      </b-card-header>
      <b-collapse class="collapsed-items" v-bind:id="'accordion-' + index" visible accordion="my-accordion" role="tabpanel">
        <b-card-body >
          <b-card-text>{{currentPlaylist.songs}}</b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>

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

/* .btn-info { 
  background-color: green;
  color:#07ff1c;
  font-size: 24em;
}

.mb-1 {
  background-color: green;
  color:#07ff1c;
}

.collapsed-items {
    background-color: #960909;
    border: none;
    color: #07ff1c;

    font-size: 16px;
    cursor: pointer;

    border-radius: 4px;
    transition: background-color 0.3s, color 0.3s;
}

.expand-btn {
  height: auto;
}

.save-button:hover {
    background-color: #077bff;
    color: #ffffff;
} */

</style>