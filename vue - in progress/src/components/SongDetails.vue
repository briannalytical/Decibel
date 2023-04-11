<template>
  <div class="songDetail">
      <h2>Songs {{ song.title}}</h2>
      <SongListItem v-bind:song="song" />
    

  </div>
</template>

<script>

import SongListItem from './SongListItem.vue'
//import SongListService from '@/services/SongListService'

export default {
  name: 'song-detail',
  components: {
    SongListItem
  },
  data() {
    return {
      song: {}
    }
  },
  // created(){
  //   const songId= this.$route.params.id;
  //   SongListService.getSongsById(songId)
  //   .then( response => {
  //     this.song = response.data;
  //   }).catch( err => console.error(err) );
    
  // }

}
</script>

<style>

</style>