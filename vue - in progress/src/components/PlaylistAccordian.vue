<template>
  <div id="save-list-main">

<div class="accordion" role="tablist">
    <b-card no-body class="mb-1" v-for="(currentPlaylist, index) in playlist" v-bind:key="currentPlaylist.playlistId">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block v-b-toggle="'accordion-' + index" variant="info">{{currentPlaylist.playlistName}}</b-button>
      </b-card-header>


      <b-collapse class="collapsed-items" v-bind:id="'accordion-' + index" visible accordion="my-accordion" role="tabpanel">
        <b-card-body >

    <table id="table">
      <tbody v-for="(song) in currentPlaylist.songs" v-bind:key="song.songId">
      <tr class="column">
        <th>Title</th>
        <th>Artist</th>
        <th>Genre</th>
      </tr>

        <tr>
        
        <td>{{ song.title }}</td>
        <td>{{ song.artist }}</td>
       <td>{{ song.genre }}</td>
      </tr>
      <!-- <tr v-for="currentSong in filteredSongs" v-bind:key="currentSong.id">
        
        <td>{{ currentPlaylist.song.title }}</td>
        <td>{{ currentSong.artist }}</td>
       <td>{{ currentSong.genre }}</td>
      </tr> -->
      </tbody>
    </table>

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
  name: 'savelist',

  data() {
    return {
      songs: [],
      playlist: {
        playlistName: "",
        songs: []

      },
      showForm: false,
      moodSongs: ""
    };
  },
 components: {},
    
    computed: {
    filteredSongs() {
      const songs = this.songs.filter((song) => {
        if (song.moodId == this.$store.state.moodId) {
          return true;
        }
      });
      return songs;
    }
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

    SongListService.getPlaylistById()
      .then((response) => {
        this.playlist = response.data;
      })
      .catch((err) => console.error(err));
     },

}
</script>

<style scoped>

.btn {
  display: flex;
}

.b-button {
display: flex;
justify-content: space-between;
align-content: center;
gap: 10px;
}

#playlist-generic {
  display: flex;
  height: 100%;
  width: 50px;
  padding-right: 10px;
}

</style>