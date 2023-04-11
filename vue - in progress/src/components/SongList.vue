<template>
  <div class="songlist">
      <div v-for="currentSong in songs" v-bind:key="currentSong.id">
      {{currentSong.title}}
      <SongListItem />
        <div class="moods">
            <Mood />
        </div>
      </div>
  </div>
</template>

<script>

import SongListItem from '@/components/SongListItem'
import SongListService from '@/services/SongListService'
import Mood from './Mood.vue'

export default {
    name: 'song-list',
    components: {
        SongListItem,
        Mood
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