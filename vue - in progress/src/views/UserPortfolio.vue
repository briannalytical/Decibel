<template>
  <div>
    <div id="prime">
      <div id="main-1">
        <img
          v-if="userImageUrl != null"
          class="img"
          v-bind:src="userImageUrl"
        />
        <img v-else v-bind:src="require('../assets/user-profile.png')" />
        <button v-on:click.prevent="uploadPhoto">Upload User Picture</button>
        <div id="user-info">
          <p>This is a user description.</p>
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
      userImageUrl: null,
    };
  },

  name: "savelist",
  created() {
    this.getProfilePhoto();

    SongListService.getPlaylistById()
      .then((response) => {
        this.playlist = response.data;
        this.playlist = this.playlist.slice(0,8)
      })
      .catch((err) => console.error(err));
  },
  components: { PlaylistAccordion },
  methods: {
    getProfilePhoto() {
      SongListService.getUserProfile().then((response) => {
        if (response.status != 200) {
          //TODO: error
          return;
        }

        this.userImageUrl = response.data["userProfilePicture"];
      });
    },
    uploadPhoto() {
      window.cloudinary
        .openUploadWidget(
          {
            cloud_name: "dhneofixj",
            upload_preset: "ml_default",
          },
          (error, result) => {
            if (!error && result && result.event === "success") {
              console.log("Done uploading..: ", result.info.url);

              // Send the uploaded image URL to the backend
              SongListService.updateUserProfile(result.info.url).then(
                (response) => {
                  if (response.status != 200) {
                    //TODO: error
                    return;
                  }

                  // Set the newly uploaded photo
                  this.userImageUrl = result.info.url;
                }
              );
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
  color: #ffefd5;
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

.img {
  max-height: 225px;
  max-width: 225px;
}

#spacer {
  width: 14vw;
}

#prime {
  display: flex;
  align-items: flex-start;
}

p {
  font-family: "Oswald", sans-serif;
  font-size: 1em;
  border-bottom: solid 1.5px #ffefd5;
  color: #ffefd5;
  margin-bottom: 45px;
}
</style>







