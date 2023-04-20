<template>
  <div id="PlaylistAccordion-case">
    
    <div class="accordion" role="tablist">
      <b-card
        no-body
        class="mb-1"
        v-for="(currentPlaylist, index) in playlist"
        v-bind:key="currentPlaylist.id"
      >
        <b-card-header header-tag="header" class="p-1" role="tab">
          <b-button block v-b-toggle="'accordion-' + index" variant="info">{{
            currentPlaylist.playlistName
          }}</b-button>
        </b-card-header>

        <b-collapse
          class="collapsed-items"
          v-bind:id="'accordion-' + index"
          visible
          accordion="my-accordion"
          role="tabpanel"
        >
          <b-card-body>
            <div class="player-container">
              <iframe
                style="border-radius: 12px"
                v-bind:src="currentPlaylist.playlistUrl"
                width="100%"
                height="100%"
                frameBorder="0"
                allowfullscreen=""
                allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture"
                loading="lazy"
              ></iframe>
              <PlaylistImage />
            </div>
            <!-- <table id="table">
              <tbody
                v-for="song in currentPlaylist.songs"
                v-bind:key="song.songId"
              >
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
              </tbody>
            </table> -->
          </b-card-body>
        </b-collapse>
      </b-card>
    </div>
  </div>
</template>

<script>
import SongListService from "@/services/SongListService";
import PlaylistImage from "@/components/PlaylistImage";

export default {
  // name: "savelist",

  data() {
    return {
      songs: [],
      playlist: [],
      showForm: false,
      moodSongs: "",
    };
  },
  components: {
    PlaylistImage
  },

  computed: {
    filterPlaylist() {
      const savedPlaylist = this.playlist.filter(( playlist) => {
      if (playlist.playlistName.toLowerCase() == this.mood.mood) {
        return true;
      }
      });
      return savedPlaylist;
    },
  },
  created() {
    // SongListService.getAllSongs()
    //   .then((response) => {
    //     this.songs = response.data;
    //   })
    //   .catch((err) => console.error(err));

    // SongListService.getAllMoods()
    //   .then((response) => {
    //     this.mood = response.data;
    //   })
    //   .catch((err) => console.error(err));

    // SongListService.getPlaylistById()
    //   .then((response) => {
    //     this.playlist = response.data;
    //   })
    //   .catch((err) => console.error(err));

    SongListService.getPlaylist()
      .then((response) => {
        this.playlist = response.data;
        this.playlist = this.playlist.slice(9)
        this.mood = this.$store.state.moodId;
      })
      .catch((err) => console.error(err));
  },
};
</script>

<style scoped>
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
.collapsed-items {
  background-color: #525252;
  border: none;
  color: papayawhip;
  font-size: 16px;
  cursor: pointer;
  border-radius: 4px;
  transition: background-color 0.3s, color 0.3s;
}
.accordion {
  display: flex;
  flex-direction: column;
  width: 50vw;
  align-content: center;
  justify-content: center;
}
.btn-info {
  font-family: "Sofia Sans Condensed", sans-serif;
  background: #6e61d5;
  height: 40px;
  width: 100%;
  border: none;
  color: #f9e47f;
  font-size: 1.5em;
  font-weight: bold;
  line-height: 1;
  letter-spacing: 4px;
}

.btn-info:focus {
  background: #8324ac;
}

.btn-info:hover {
  background: #8324ac;
}

.mb-1 {
  background-color: rgba(255, 0, 0, 0);
  border: none;
}

.card-header {
  border: none;
  background-color: rgba(255, 0, 0, 0);
}
</style>