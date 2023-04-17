<template>
 
  


<body>

    <header>
  
    </header>

    <main id="main-grid">
        <h1 id="headline">Username</h1>

        <div id="user-picture">
        
        <button v-on:click.prevent="uploadPhoto">Upload User Picture</button>
        </div>
            
      
        <div id="student-info" >
            <h2>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam porttitor ipsum diam, mattis maximus
                magna facilisis sed. Donec luctus metus vulputate turpis eleifend mollis. Praesent ut aliquet
                justo.
            </h2>
        </div>

       

      

        

        <div id="experience-grid">
            <div id="experience-code">
                <h3><i class="fas fa-code"></i> code</h3>
                <p>
                    Proin imperdiet, nibh at maximus efficitur, arcu turpis vulputate ex, vel molestie dui quam non ipsum. Cras ex purus, mollis id risus at, vestibulum suscipit mauris. Nunc auctor mauris nec pulvinar condimentum. Aliquam ut elit vehicula, ultrices purus a, euismod ex. Ut rhoncus gravida nisl. Proin eu rhoncus mi. In rutrum dapibus metus, a auctor est lobortis ut. In imperdiet a est in hendrerit.
                </p>
            </div>
            <div id="experience-database">
                <h3><i class="fas fa-database"></i> database</h3>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus posuere vulputate erat, tempor finibus diam cursus vitae. Fusce rutrum, urna accumsan tincidunt accumsan, neque erat condimentum risus, consequat volutpat lacus mauris ac tortor. Integer quam purus, imperdiet ac ante non, pharetra scelerisque justo. Cras bibendum vulputate elit at tincidunt. Ut id auctor turpis, in vulputate neque. Integer pellentesque orci augue, a varius orci ultrices sit amet.
                </p>
            </div>
            <div id="experience-web">
                <h3><i class="fas fa-info"></i> web</h3>
                <p>
                    Quisque rutrum orci ac nisi scelerisque, eget iaculis massa aliquet. Sed aliquet quis dolor non placerat. Suspendisse faucibus, elit at suscipit pharetra, augue velit elementum dolor, ac pellentesque leo sem sed nibh. Ut sit amet sapien nisl. Sed aliquet quis dolor non placerat. Suspendisse faucibus, elit at suscipit pharetra, augue velit elementum dolor, ac pellentesque leo sem sed nibh. Ut sit amet sapien nisl. Praesent a justo vel turpis porta volutpat sed malesuada massa.
                </p>
            </div>
            <div id="experience-design">
                <h3><i class="fas fa-palette"></i> design</h3>
                <p>
                    Nulla metus metus, ullamcorper vel, tincidunt sed, euismod in, nibh. Quisque volutpat condimentum velit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nam nec ante. Sed lacinia, urna non tincidunt mattis, tortor neque adipiscing diam, a cursus ipsum ante quis turpis. Nulla facilisi. Ut fringilla. Suspendisse potenti. Nunc feugiat mi a tellus consequat imperdiet. Vestibulum sapien. Proin quam.
                </p>
            </div>
        </div>
    </main>
    <footer>
        <p></p>
    </footer>
</body>



</template>

<script>
export default {
    methods: {
        uploadPhoto() {
             window.cloudinary.openUploadWidget(
        { cloud_name: '<your-cloud-name>',
          upload_preset: '<your-upload-preset>'
        },
        (error, result) => {
          if (!error && result && result.event === "success") {
            console.log('Done uploading..: ', result.info);          }
        }).open();
        }
    }

}
</script>

<style>

</style>






<style scoped>




body {
    margin-left: 7%;
    margin-right: 7%;
    background-color: #BADEFC;
}

h1 {
    font-size: 2em;
}

h1#headline {
    font-size: 4em;
    margin-top: 0.15em;
    margin-bottom: 0.15em;
    color: #505355;
    border-bottom: solid 1px black;
}

h2 {
    font-size: 1.8em;
    line-height: 1.45em;
}


header img {
    height: 25px;
}

.student-gray {
    color: #505355;
}

.italic-text {
    font-style: italic;
}

#student-picture img{
    border-radius: 50%;
}
#main-grid {
    display :grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-areas:   "picture           username              username "        
                            ""
                            "student-profile  student-profile       student-contact"
                            "experience         experience          experience";
    grid-template-rows: auto auto auto;
    row-gap: 20px;
    column-gap: 50px;
    align-items: vertical;
    align-items: center;
    
}
#experience-grid{
    display:grid;
    row-gap: 20px;
    column-gap: 50px;
    grid-template-columns:1fr 1fr ;
    grid-template-areas:   "experience-code           experience-code"
                            "experience-database      experience-database"
                            "experience-web            experience-design";

align-items: vertical;
align-items: center;
                        }

main {
    grid-area: main;
}

main #headline{
    grid-area: headline;
}

main #student-picture {

    grid-area: stupid-picture;
    justify-content: center;
    text-align: center;
}

main #student-profile {

    grid-area: student-profile;
}

main #student-quote {
    grid-area: student-quote;
}

main #student-contact {
    grid-area: student-contact;
    font-style: italic;
    justify-self: center;
    text-align: center;
    color: gray;
}


#experience-grid {
    grid-area: experience;
}

 #experience-code {
    grid-area: experience-code;
}

 #experience-database {
    grid-area: experience-database;
}

 #experience-web {
    grid-area: experience-web;
}

 #experience-design {
    grid-area: experience-design;
}


 @media  (max-width:1024px) {
    main#main-grid {
        grid-template-columns: 1fr 1fr;
        grid-template-areas: "headline          headline"
                             "student-quote   stupid-picture"
                             "student-quote   student-contact"
                             "student-profile   student-profile" 
                             "experience        experience";
                             row-gap: 20px;
                             column-gap: 35px;
        
        }

        #experience-grid {
            grid-template-columns: 1fr 1fr;
            grid-template-areas:"experience-code experience-web"
                                "experience-database experience-design";
                                row-gap: 20px;
                                column-gap: 20px;
        }
    }

        @media  (max-width:451px) {
            main#main-grid {
                grid-template-columns: 1fr;
                grid-template-areas: "headline"
                                     "stupid-picture"
                                     "student-contact"
                                     "student-quote"
                                     "student-profile"
                                     "experience";
                                     
                                     row-gap: 20px;
                                     column-gap: 35px;
                
                }
                #experience-grid{
                grid-template-columns: 1fr;
                grid-template-areas: "experience-code"
                                    "experience-web"
                                    "experience-database"
                                    "experience-design";
                                     
                                     row-gap: 20px;
                                     column-gap: 35px;
                }
        

        }
    