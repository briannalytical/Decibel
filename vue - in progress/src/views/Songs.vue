<template>
  <div>
    <div
      class="playlist-url"
      v-for="currentPlaylist in filterPlaylist"
      v-bind:key="currentPlaylist.id"
    >
      <div id="main">
        <div id="these-darn-buttons">
          <back-button></back-button>
          <save-button></save-button>
        </div>
        <div class="player-container">
          <iframe
            style="border-radius: 12px"
            v-bind:src="currentPlaylist.playlistUrl"
            width="100%"
            height="352"
            frameBorder="0"
            allowfullscreen=""
            allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture"
            loading="lazy"
          ></iframe>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import SaveButton from "../components/SaveButton.vue";
import BackButton from "../components/BackButton.vue";
import SongListService from "../services/SongListService";
export default {
  data() {
    return {
      songs: [],
      playlist: [],
      currentPlaylist: "",
      mood: {},
      components: {
        BackButton,
        SaveButton,
      },
    };
  },
  created() {
    SongListService.getPlaylist()
      .then((response) => {
        this.playlist = response.data;
        this.mood = this.$store.state.moodId;
      })
      .catch((err) => console.error(err));
  },
  computed: {
    filterPlaylist() {
      console.log(this.playlist);
      return this.playlist.filter((playlist) => {
        return playlist.playlistName.toLowerCase() == this.mood.mood;
      });
    },
  },
};
</script>
<style scoped>
#these-darn-buttons {
  display: flex;
  justify-content: space-around;
  margin-bottom: 20px;
  width: 25vw;
}
iframe {
  border: solid 2px #feba4c;
  border-radius: 4%;
}
.player-container {
  display: flex;
  width: 45vw;
  height: 45vh;
}
#main {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding-top: 180px;
}
</style>







