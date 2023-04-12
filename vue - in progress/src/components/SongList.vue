<template>
  <div class="songlist">
    <table id="table">
      <tr class="column">
        <th>Title</th>
        <th>Artist</th>
        <th>Mood</th>
        <th>Genre</th>
      </tr>
      <tr v-for="currentSong in songs" v-bind:key="currentSong.id">
        <td>{{ currentSong.title }}</td>
        <td>{{ currentSong.artist }}</td>
        <td>{{ currentSong.mood }}</td>
        <td>{{ currentSong.genre }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import SongListService from "@/services/SongListService";

export default {
  name: "song-list",
  components: {},
  data() {
    return {
      songs: [],
    };
  },
  created() {
    SongListService.getAllSongs()
      .then((response) => {
        this.songs = response.data;
      })
      .catch((err) => console.error(err));
  },

<<<<<<< HEAD
    SongListService.getAllMoods()
      .then((response) => {
        this.mood = response.data;
      })
      .catch((err) => console.error(err));

      SongListService.getSongsByMood()
        .then((response) => {
            this.mood.id = response.data;
        }).catch((err) => console.error(err));
      }
     
=======
  methods: {
    
  }
>>>>>>> 844d41a56e4f964ba101e0b08b112c629b3c2dd5
};
</script>

<style>
table {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}

table,
th,
td {
  border: 1px solid;
}

th,
td {
  padding: 15px;
  text-align: left;
}

th {
  background-color: #fffb001e;
  color: rgb(0, 0, 0);
}
</style>