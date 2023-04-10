<template>
  <div class="song-list-item">
      <p>{{ song.title }} - {{ song.artist}} - {{ song.mood}} - {{ song.genre }}</p>
  </div>
</template>

<script>
export default {
    props: {
        song: {
            type: Object,
            required: true
        }
    }
}
</script>

<style scoped>
    .song-list-item {
        margin-bottom: 10px;
    }
/* ADD TO COMMENTS AS NEEDED WITH NAME AND DATE WHEN CHANGES/ADDITIONS/QUESTIONS ARE MADE
Travis notes 4-10: 
The components SongDetail, SongListItem, and Songlist, will be used in the Generator and List views. 
1. This is an individual song item in the list. 
2. takes a song object as a prop with title, artist, mood, genre properties. 
3. displays song info in a paragraph element.
4. Anticipating usage within a loop to show multiple songs in a list. */
</style>

