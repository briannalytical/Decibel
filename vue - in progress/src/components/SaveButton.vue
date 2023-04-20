<template>
  <div class="songlist">

<button class="save-button" v-on:click="showForm = !showForm">&#8595; Save</button>
    <form v-show="showForm" v-on:submit.prevent="savePlaylist">
      <input type="text" placeholder="Playlist Name" class="playlist-name" required v-model="playlist.playlistName"><br>
      <button type="submit" class="submit-save">Go!</button>
    </form>
  </div>
</template>

<script>
import SongListService from "@/services/SongListService";

export default {
  name: "SongList",
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
      playlistToAdd: {},
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
      this.playlistToAdd = this.$store.state.playlist
      this.playlistToAdd.playlistName = this.playlist.playlistName
      SongListService.savePlaylist(this.playlistToAdd)
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