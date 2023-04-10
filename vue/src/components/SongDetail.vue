<template>
  <div class="song-detail">
      <h1>{{ song.title }}</h1>
      <p>Artist: {{ song.artist }}</p>
      <p>Mood: {{ song.mood }}</p>
      <p>Genre: {{ song.genre }}</p>
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
.song-detail {
    margin-bottom: 20px;
}
/* 
ADD TO COMMENTS AS NEEDED WITH NAME AND DATE WHEN CHANGES/ADDITIONS/QUESTIONS ARE MADE
Travis Notes 4-10:
The components SongDetail, SongListItem, and Songlist, will be used in the Generator and List views. 
This component will display detailed info about specific songs. its pretty similar to SongListItem. 
Takes a song item as a prop and shows the song title, artis, mood, and genere in paragraph tags when 
it's selected from the list.*/

</style>