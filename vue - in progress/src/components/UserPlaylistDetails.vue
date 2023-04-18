<template>
  <div class="user-playlist-details-container">
    <h2 class="playlist-name">{{  }}</h2>
    <h2 class="playlist-mood"> {{  }}</h2>
        <div class="user-playlist-table-container">
            <transition name="slide">
                <button class="playlist-name" @click="dropIt">{{  }}</button>
                <table class="playlist-table" v-if="isDropped">
                <tr class="playlist-details">
                    <th class="table-title">Title</th>
                    <th class="table-artist">Artist</th>
                    <th class="table-mood">Mood</th>
                    <th class="table-genre">Genre</th>
                </tr>
                <tr class="playlist-songs">
                    <td class="playlist-content"></td>
                    <td class="playlist-content">Limp Bizkit</td>
                    <td class="playlist-content">Limp Bizkit</td>
                    <td class="playlist-content">Limp Bizkit</td>
                </tr>
                <tr class="playlist-songs">
                    <td class="playlist-content">Limp Bizkit</td>
                    <td class="playlist-content">Limp Bizkit</td>
                    <td class="playlist-content">Limp Bizkit</td>
                    <td class="playlist-content">Limp Bizkit</td>
                </tr>
                </table>
            </transition>
        </div>
  </div>

</template>

<script>
export default {
  name: "user-playlist-details",
  props: {},
  data() {
    return {
      // variable needed from playlist page & method for expand
    };
  },
};
</script>

<style>
body {
    font-family: Arial, Helvetica, sans-serif;
}

.user-playlist-details-container {
    text-align: center;
}

.user-playlist-details-container > nav, ol {
    text-align: left !important;
    list-style-type: none;
}

li {
    display: inline-block;
}

.user-playlist-details-container li:nth-child(2) {
    padding: 0 0 0 20px;
}

.user-playlist-details-container > h2 {
    display: inline-block;
    vertical-align: middle;
    padding: 5vh;
}

.playlist-mood {
    font-style: italic;
}

.user-playlist-details-container .playlist-mood {
    margin-left: 10vw;
}

.user-playlist-table-container {
    height: 20vh;
    justify-content: center;
    display: flex;
}

.playlist-details {
    background-color:aquamarine;
}

.playlist-details > * {
    width: 15vw;
    border: 1px solid black;
}

td {
    border: 1px solid black;
    text-align: center;
}
</style>