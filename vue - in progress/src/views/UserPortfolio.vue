<template>
  <div>
    <div id="prime">
    <div id="main-1">
      <img v-bind:src="require('../assets/user-profile.png')" />
      <button v-on:click.prevent="uploadPhoto">Upload User Picture</button>
      <div id="user-info">
        <!-- <h2>User Info</h2> -->
      </div>
    </div>

    <div id="accordion-case">
      <h1 id="username">Username</h1>
      <p>Your Playlists</p>
      <PlaylistAccordion />
    </div>
  </div>
  </div>
</template>

<script>
import PlaylistAccordion from "@/components/PlaylistAccordion";
import SongListService from "@/services/SongListService";
// import SongList from '@/components/SongList'
export default {
  data() {
    return {
      playlist: [],
    };
  },

  name: "savelist",
  created() {
    SongListService.getPlaylistById()
      .then((response) => {
        this.playlist = response.data;
      })
      .catch((err) => console.error(err));
  },
  components: { PlaylistAccordion },
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
#username {
  display: flex;
  font-family: serif;
  color:#ffefd5;
  font-size: 10em;
  margin-bottom: 150px;
  letter-spacing: 5px;
}

#prime {
  padding-top: 180px;
}

#accordion-case {
  display: inline-flex;
  flex-direction: column;
  align-items: center;
  width: 75%;
  height: 100%;
}

#main-1 {
  flex-direction: column;
  display: inline-flex;
  justify-content: center;
  align-items: center;
  align-content: center;
  gap: 15px;
 padding-left: 25px;
}

#spacer {
  width: 14vw;
}

#prime {
  display:flex;
  align-items: flex-start;
}

p {
  font-family: "Oswald", sans-serif;
  font-size: 2em;
  border-bottom: solid 1.5px #ffefd5;
  color:#ffefd5;
  margin-bottom: 45px;
}

</style>







