<template>
    <div id="playlist-image-description">
      <img
          v-if="userPlaylistImage != null"
          v-bind:src="userPlaylistImage"
        />
        <img v-else v-bind:src="require('../assets/music-placeholder.png')" />
        <!-- <button v-on:click.prevent="uploadPhoto">Upload Playlist Photo</button> -->
        <p>This is an image description.</p>
    </div>

</template>

<script>
export default {
};
</script>

<style scoped>

div {
    display: flex;
    justify-content: space-evenly;
    align-items: center;
}

button {
    font-family: 'Sofia Sans Condensed', sans-serif;
    display: flex;
    background-color: #6176d5;
    border: none;
    border-radius: 3px;
    color: #ffefd5;
    cursor: pointer;
    /* display: block; */
    font-size: 14px;
    /* margin-bottom: 1rem; */
    /* padding: 0.5rem 0.5rem; */
    text-align: center;
    width: 150px;
    height: 40px;
    line-height: 40px;
    justify-content: space-around;
    align-items: center;
    
}

button:hover {
    background-color: #5a1a75;
}

img {
    max-height: 100px;
    max-width: 100px;
}

p {
    font-family: "Oswald", sans-serif;
  font-size: 1em;
  color: #ffefd5;
}


</style>