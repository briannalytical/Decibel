<template>
      <div class="songlist">
                   <!-- <SongListItem /> -->
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
// import SongListItem from "@/components/SongListItem";
import SongListService from "@/services/SongListService";


export default {
  name: "song-list",
  components: {
    // SongListItem,
 },
  data() {
    return {
      songs: [],
      // mood: [],
    };
  },
  created() {
    SongListService.getAllSongs()
      .then((response) => {
        this.songs = response.data;
      })
      .catch((err) => console.error(err));

    // SongListService.getAllMoods()
    //   .then((response) => {
    //     this.mood = response.data;
    //   })
    //   .catch((err) => console.error(err));

      }
    
    
    
  
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