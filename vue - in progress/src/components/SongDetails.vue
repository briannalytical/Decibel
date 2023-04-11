<template>
  <div class="songDetail">
    <h2>Moods {{ song.mood }}</h2>
    <Mood v-bind:mood="mood" />
    <h2>Songs {{ song.title }}</h2>
    <SongList v-bind:song="song" />
  </div>
</template>

<script>
import SongList from "./SongList.vue";
import SongListService from "@/services/SongListService";

export default {
  name: "song-detail",
  components: {
    SongList,
  },
  data() {
    return {
      song: {},
      mood: {},
    };
  },
  created() {
    const moodId = this.$route.params.id;
    SongListService.getAllMoodsById(moodId)
      .then((response) => {
        this.mood = response.data;
      })
      .catch((err) => console.error(err));
  },
};
</script>

<style>
</style>