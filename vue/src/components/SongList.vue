<template>
  <div class="song-list">
      <song-list-item v-for="song in songs" :key="song.id" :song="song"></song-list-item>
    </div>
</template>

<script>
import SongListItem from './SongListItem.vue'

export default {
name: 'song-list-item', 
    components: {
        SongListItem
    },
    props: {
        songs: {
            type: Array,
            required: true
        }
    }

}
</script>

<style>
/*
ADD TO COMMENTS AS NEEDED WITH NAME AND DATE WHEN CHANGES/ADDITIONS/QUESTIONS ARE MADE
Travis notes 4-10: 
The components SongDetail, SongListItem, and Songlist, will be used in the Generator and List views.
1. this is the list of songs. Takes an array of songs as a prop and loops through it v-for. 
2. in the loop it uses the SongListItem to show each song. 
3, key is for a unique id for each song *the id property*
*/
</style>