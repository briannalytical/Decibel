<template>
  
   

    <main id="main-grid">
      <div id="user-picture">
        <img
          src="https://files.slack.com/files-tmb/T0GNFLF6D-F05354D0QTH-c2d9ab6f5f/download_360.png"
          alt="placeholder"
        />
        <button v-on:click.prevent="uploadPhoto">Upload User Picture</button>
      </div>

      <div id="username">
        <h1>Username</h1>
      </div>

       <div id="user-info">
        <h1>User Info</h1>
      </div>

      <div id="playlist-image">
        <p
          img
          src="https://files.slack.com/files-tmb/T0GNFLF6D-F053N53AGRJ-df616dd4f7/screenshot_2023-04-17_110337_480.png"
        >
          playlistImage
        </p>
        <p
          img
          src="https://files.slack.com/files-tmb/T0GNFLF6D-F053N53AGRJ-df616dd4f7/screenshot_2023-04-17_110337_480.png"
        >
          playlistImage
        </p>
        <p
          img
          src="https://files.slack.com/files-tmb/T0GNFLF6D-F053N53AGRJ-df616dd4f7/screenshot_2023-04-17_110337_480.png"
        >
          playlistImage
        </p>
        <p
          img
          src="https://files.slack.com/files-tmb/T0GNFLF6D-F053N53AGRJ-df616dd4f7/screenshot_2023-04-17_110337_480.png"
        >
          playlistImage
        </p>
      </div>
      <div id="playlist-name">
        <p>Name</p>
        <p>Name</p>
        <p>Name</p>
        <p>Name</p>
      </div>
    </main>
 
</template>

<script>
export default {
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
    justify-content: center;
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
  font-size: 2em;
}


h2 {
  font-size: 1.8em;
  line-height: 1.45em;
}


#user-picture img {
  border-radius: 50%;
}

</style>




