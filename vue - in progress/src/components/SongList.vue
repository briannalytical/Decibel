<template>
  <div class="songlist">

<button class="save-button" v-on:click="showForm = !showForm">&#8595; Save</button>
    <form v-show="showForm" v-on:submit.prevent="savePlaylist">
      <input type="text" placeholder="Playlist Name" class="playlist-name" required v-model="playlist.playlistName"><br>
      <button type="submit" class="submit-save">Go!</button>
    </form>
    
    <table id="table">
      <tr class="column">
        <th>Title</th>
        <th>Artist</th>
        <th>Genre</th>
      </tr>
      <tr v-for="currentSong in filteredSongs" v-bind:key="currentSong.id">
        <td>{{ currentSong.title }}</td>
        <td>{{ currentSong.artist }}</td>
       <td>{{ currentSong.genre }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import SongListService from "@/services/SongListService";

export default {
  name: "song-list",
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
  components: {},
  data() {
    return {
      songs: [],
      playlist: {
        playlistName: "",
        songs: [],
        playlistId:"",
        playlistImage:""

      },
      showForm: false,
      moodSongs: ""
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
 
     methods: {
    savePlaylist() {
       const songs = this.songs.filter((song) => {
        if (song.moodId == this.$store.state.moodId) {
          return true;
        }
      });
      this.playlist.songs = songs
      SongListService.savePlaylist(this.playlist)
        .then((response) => {
          this.playlist = response.data;
          this.$router.push({
            name: "user-profile",
          });
        })
        .catch((err) => console.error(err));
    },
}
};
</script>

<style>
</style>