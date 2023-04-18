<template>
  <div id="main">
    <div id="musicplayer">
         <MusicPlayer></MusicPlayer>
    </div>
    <div id="header-section">
      <div id="logo-fun">
        <img id="logo-jazz" v-bind:src="require('../assets/DBLogo-wht.png')" />
        <img id="logo-jazz" v-bind:src="require('../assets/DBLogo-red-ish.png')" />
        <img id="logo-jazz" v-bind:src="require('../assets/DBLogo-gold.png')" />
        <img id="logo-jazz" v-bind:src="require('../assets/DBLogo-yellow.png')" />
        <img id="logo-jazz" v-bind:src="require('../assets/DBLogo-more-blu.png')" />
        <img id="logo-jazz" v-bind:src="require('../assets/DBLogo-purple.png')" />
        <img id="logo-jazz" v-bind:src="require('../assets/DBLogo-Blk.png')" />
      </div>
      <br>
      <h1>Welcome to Decibel</h1>
      <p>How would you like to generate your playlist?</p>
    </div>
    <div id="speech-box">
      <h2>Tell us how you feel.</h2>
      <speech-recognition @mood-detected="onMoodDetected"></speech-recognition>
    </div>
    <p class="or">Or</p>
    <div id="dropdown-section-one">
      <div id="mood-dropdown">
        <select
          v-on:change="updateMood"
          v-model="moodId"
          name="mood"
          class="mood"
        >
        <option value="" selected disabled hidden>Select Mood</option>
          <option
            v-bind:value="currentMood.moodId"
            v-for="currentMood in mood"
            v-bind:key="currentMood.moodId"
          >
            {{ currentMood.mood }}
          </option>
        </select>
        <button v-on:click.prevent="generatePlaylistByMood">Generate</button>
      </div>
    </div>
    <!-- <div id="genre-dropdown">
        <select name="genre" class="genre">
          <option>Select Genre</option>
          <option value="python">Python</option>
          <option value="c++">C++</option>
          <option value="java">Java</option>
        </select>
        <button v-on:click.prevent="generatePlaylistByMood">Generate</button>
      </div> -->
    <!--
    <div class="or-selector">
      <p>Or</p>
    </div>
    <div id="dropdown-section-two">
      <div id="mood-dropdown">
        <select v-model="moodId" name="mood" class="mood2">
          <option>Select Mood</option>
          <option
            v-bind:value="currentMood.moodId"
            v-for="currentMood in mood"
            v-bind:key="currentMood.moodId"
          >
            {{ currentMood.mood }}
          </option>
        </select>
      </div>
      <div id="button-section-two">
        <p class="and">And</p>
        <button v-on:click.prevent="generatePlaylistByMood">Generate</button>
      </div>
      <div id="genre-dropdown">
        <select name="genre" class="genre2">
          <option>Select Genre</option>
          <option value="python">Python</option>
          <option value="c++">C++</option>
          <option value="java">Java</option>
        </select>
      </div> -->
    <!-- </div> -->
    <!-- <SongList /> -->
  </div>
</template>
<script>
import SongListService from "@/services/SongListService";
import SpeechRecognition from "@/components/SpeechRecognition.vue";
import MusicPlayer from "@/components/MusicPlayer.vue";
// import SongList from "@/components/SongList";
export default {
  data() {
    return {
      mood: [],
      moodId: "",
    };
  },
  components:{ SpeechRecognition, MusicPlayer,
  },
  created() {
    SongListService.getAllMoods()
      .then((response) => {
        this.mood = response.data;
      })
      .catch((err) => console.error(err));
  },
  methods: {
    generatePlaylistByMood() {
      const moodName = this.$route.params.mood;
      this.$router.push({
        name: "songs",
        params: {
          mood: moodName,
        },
      });
    },
    updateMood() {
      this.$store.commit("SET_MOOD_ID", this.moodId);
    },
    onMoodDetected(mood) {
      console.log("Detected mood:", mood);
    },
  },
};
</script>
<style>
</style>