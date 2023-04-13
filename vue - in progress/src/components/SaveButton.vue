<template>
  <button class="save-button" @click="savePlaylist">
    &#8592; Save Playlist
  </button>
</template>

<script>
import SongListService from "../services/SongListService";

export default {
  methods: {
    savePlaylist() {
      SongListService.savePlaylist(this.$store.state.playlist)
        .then((response) => {
          this.playlist = response.data;
          this.$router.push({
            name: "savelist",
          });
        })
        .catch((err) => console.error(err));
    },
  },
};
</script>

<style scoped>
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