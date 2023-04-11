<template>
  <div class="songlist">
      <div v-for="currentSong in songs" v-bind:key="currentSong.id">
      {{currentSong.title}}
      </div>
  </div>
</template>

<script>

//import SongListItem from '@/components/SongListItem'
import SongListService from '@/services/SongListService'

export default {
    name: 'song-list',
    components: {
        //SongListItem
    },
    data() {
        return {
            songs: []
        }
    },
    created() {
        SongListService.getAllSongs()
        .then(response => {
            this.songs = response.data;
        })
        .catch(err => console.error(err) );

    }

}
</script>

<style>

</style>