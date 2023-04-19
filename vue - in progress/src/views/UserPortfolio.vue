<template>
  <main id="main-flex">
    <div id="user-picture">
      <img v-bind:src="require('../assets/user-profile.png')" />

      <button v-on:click.prevent="uploadPhoto">Upload User Picture</button>
    </div>

    <div id="username">
      <h1>Username</h1>
    </div>

    <div id="user-info">
      <h2>User Info</h2>
    </div>
<PlaylistAccordian />
    <!-- <div id="playlist-image">
      <img v-bind:src="require('../assets/music-placeholder.png')" />
      <p>playlistImage</p>
      <img v-bind:src="require('../assets/music-placeholder.png')" />
      <p>playlistImage</p>
      <img v-bind:src="require('../assets/music-placeholder.png')" />
      <p>playlistImage</p>
      <img v-bind:src="require('../assets/music-placeholder.png')" />
      <p>playlistImage</p>
    </div>
    <div id="playlist-name">
      <p>Name</p>
      <p>Name</p>
      <p>Name</p>
      <p>Name</p>
    </div> -->
    
  </main>
</template>

<script>
import PlaylistAccordian from "@/components/PlaylistAccordian";
import SongListService from "@/services/SongListService";
// import SongList from '@/components/SongList'
export default {
  data() {
    return {
      playlist: [],
    }
  },

    name: 'savelist',
     created() {
      

    SongListService.getPlaylistById()
      .then((response) => {
        this.playlist = response.data;
      })
      .catch((err) => console.error(err));
     },
  components: { PlaylistAccordian,
},
  methods: {
    uploadPhoto() {
      window.cloudinary
        .openUploadWidget(
          {
            cloud_name: "<your-cloud-name>",
            upload_preset: "<your-upload-preset>",
          },
          (error, result) => {
            if (!error && result && result.event === "success") {
              console.log("Done uploading..: ", result.info);
            }
          }
        )
        .open();
    },
  },
};
</script>


<style scoped>
main #main-flex {
  display: flex;
  justify-content: flex-start;
  align-items: flex-start;
  flex-direction: row;
  flex-wrap: nowrap;
}

#user-picture {
  display: flex;
}

h1 {
  display: flex;
  font-size: 4em;
}
/* 
h2 {
  display: flex;
  font-size: 1.8em;
  line-height: 1.45em;
}
#upload-button-playlist-image{

#user-picture img {
  display: flex;
  width: 20vw;
  height: 35vh;
  border-radius: 50%;
} */



</style>







