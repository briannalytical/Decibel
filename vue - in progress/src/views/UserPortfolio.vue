<template>
  
   <main id="main-flex">

<div  id="playlist-name" class="accordion" role="tablist">
    <b-card no-body class="mb-1" v-for="(currentPlaylist, index) in playlist" v-bind:key="currentPlaylist.playlistId">
      <b-card-header header-tag="header" class="p-1" role="tab">
        <b-button block v-b-toggle="'accordion-' + index" variant="info">{{currentPlaylist.playlistName}}</b-button>
      </b-card-header>
      <b-collapse class="collapsed-items" v-bind:id="'accordion-' + index" visible accordion="my-accordion" role="tabpanel">
        <b-card-body >
          <b-card-text>{{currentPlaylist.songs}}</b-card-text>
        </b-card-body>
      </b-collapse>
    </b-card>


    
  <div id="user-picture">
        <img v-bind:src="require('../assets/user-profile.png')">
        
        <button id="upload-button" v-on:click.prevent="uploadPhoto">Upload User Picture</button>
      </div>

      <div id="username">
        <h1>Username</h1>
      </div>

       <div id="user-info">
        <h2>User Info</h2>
      </div>

      <div id="playlist-image">
        <img v-bind:src="require('../assets/music-placeholder.png')"><p>playlistImage</p><button id="upload-button-playlist-image" v-on:click.prevent="uploadPhoto">Upload Playlist Image</button>
        <img v-bind:src="require('../assets/music-placeholder.png')"><p>playlistImage</p><button id="upload-button-playlist-image" v-on:click.prevent="uploadPhoto">Upload Playlist Image</button>
        <img v-bind:src="require('../assets/music-placeholder.png')"><p>playlistImage</p><button id="upload-button-playlist-image" v-on:click.prevent="uploadPhoto">Upload Playlist Image</button>
        <img v-bind:src="require('../assets/music-placeholder.png')"><p>playlistImage</p><button id="upload-button-playlist-image" v-on:click.prevent="uploadPhoto">Upload Playlist Image</button>
      
        
      </div>
</div>
    
    
    </main>
    
 
</template>

<script>


import SongListService from "@/services/SongListService";
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

   components:{

   

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


<style>

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

main #main-flex {
    display: inline-flex;
    justify-content: flex-start;
    align-items: flex-start;
    flex-direction: row;
    flex-wrap: nowrap;
}
#user-picture{
  display: flex;
}

#user-info{
  display: flex;
}

#username{
  display: flex;
}

#playlist-image{
  display: flex;
}
#playlist-name{
  display: flex;
}
#upload-button-playlist-image{

}

#upload-button-playlist-image{
  
}


</style>




