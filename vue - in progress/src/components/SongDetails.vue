<template>
  <div class="songDetail">
      <h2>Songs {{ song.title}}</h2>
      <SongList v-bind:song="song" />
    

  </div>
</template>

<script>

import SongList from './SongList.vue'
import SongListService from '@/services/SongListService'

export default {
  name: 'song-detail',
  components: {
    SongList
  },
  data() {
    return {
      song: {}
    }
  },
  created(){
    const mood= this.$route.params.mood;
    SongListService.getSongsByMood(mood)
    .then( response => {
      this.song = response.data;
    }).catch( err => console.error(err) );
    
  }

}
</script>

<style>

</style>