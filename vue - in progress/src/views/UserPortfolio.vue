<template>
  <div id="page-container">
    <div class="username">
      <h2>Username</h2>
        <div id="user-details">
          <img class="img" v-bind:src="require('../assets/user-profile.png')" />
          <button class="upload" v-on:click.prevent="uploadPhoto">Upload User Picture</button>
          <h5 class="user-info">User Info</h5>
            <div id="accordian">
              <PlaylistAccordian />
            </div>
        </div>
    </div>
  </div>
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
#page-container {
  margin: 5vw;
  display: flex !important;
}

h2 {
  text-align: center;
  font-size: 4em;
}

#user-details {
  display: flex !important;
}

#user-details > .img .upload .user-info {
  flex-direction: column !important;
}


h2 {
  font-size: 4em;
}

.btn {
  display: flex;
}

.b-button {
  display: flex;
  justify-content: space-between;
  align-content: center;
  gap: 10px;
}

</style>







