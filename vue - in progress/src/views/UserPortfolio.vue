<template>
  
   

    <main id="main-grid">
      <div id="user-picture">
        <img v-bind:src="require('../assets/user-profile.png')">
        
        <button v-on:click.prevent="uploadPhoto">Upload User Picture</button>
      </div>

      <div id="username">
        <h1>Username</h1>
      </div>

       <div id="user-info">
        <h2>User Info</h2>
      </div>

      <div id="playlist-image">
        <img v-bind:src="require('../assets/music-placeholder.png')"><p>playlistImage</p>
        <img v-bind:src="require('../assets/music-placeholder.png')"><p>playlistImage</p>
        <img v-bind:src="require('../assets/music-placeholder.png')"><p>playlistImage</p>
        <img v-bind:src="require('../assets/music-placeholder.png')"><p>playlistImage</p>
      
        
      </div>
      <div id="playlist-name">
        <p>Name</p>
        <p>Name</p>
        <p>Name</p>
        <p>Name</p>
      </div>
      <SongList />
    </main>
 
</template>

<script>
import SongList from '@/components/SongList'
export default {
  components: SongList,
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


<style>

#main-grid {
  display: inline-grid;
  grid-template-columns: 2fr 1fr 3fr;
  grid-template-areas:
    "user-picture  user-picture . username        username      username"
    "user-info     user-info    . playlist-image  playlist-name playlist-name";
    

  grid-template-rows: 2fr 4fr;
  row-gap: 20px;
  column-gap: 50px;
  align-items: vertical;
  align-items: center;
}


main #user-picture{
    grid-area: user-picture;
    justify-content: center;
    text-align: center;
}
main #username{
    grid-area: username;
    justify-content: center;
    text-align: center;
}
main #user-info{
    grid-area: user-info;
    justify-content: left;
    text-align: center;
}

main #playlist-image{
    grid-area: playlist-image;
    justify-content: center;
    text-align: center;
}

main #playlist-name{
    grid-area: playlist-name;
    justify-content: center;
    text-align: center;
}

h1 {
  font-size: 4em;
}


h2 {
  font-size: 1.8em;
  line-height: 1.45em;
}


#user-picture img {
  width: 20vw;
  height: 35vh;
  border-radius: 50%;
}

</style>




