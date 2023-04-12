<template>
  <div id="main">
    <div id="header-section">
      <img v-bind:src="require('../assets/holder-logo.jpg')" />
      <h1>Decibel</h1>
      <p>How would you like to generate your playlist?</p>
    </div>

    <div id="dropdown-section-one">
      <div id="mood-dropdown">
        <select
          v-on:change="updateMood"
          v-model="moodId"
          name="mood"
          class="mood"
        >
          <option>Select Mood</option>
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

      <p class="or">Or</p>

      <div id="genre-dropdown">
        <select name="genre" class="genre">
          <option>Select Genre</option>
          <option value="python">Python</option>
          <option value="c++">C++</option>
          <option value="java">Java</option>
        </select>
        <button v-on:click.prevent="generatePlaylistByMood">Generate</button>
      </div>
    </div>
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

    <song-list />
  </div>
</template>

<script>
import SongListService from "@/services/SongListService";
import SongList from "@/components/SongList";
export default {
  data() {
    return {
      mood: [],
      moodId: "",
    };
    
  },
  component: SongList,

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
  },
};
</script>

<style>
body {
  margin-top: 0px;
  margin-right: 0px;
  margin-bottom: 0px;
  margin-left: 0px;
  font-family: Arial, Helvetica, sans-serif;
}

img {
  width: 8rlh;
  margin-top: 2rlh;
}

button {
  font-size: 12px;
  height: 20px;
  width: 80px;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  top: 0;
}

li {
  font-size: 2vw;
  font-family: monospace;
  text-decoration-thickness: 25%;
  text-transform: capitalize;
  text-emphasis-style: bold;
}

#playlist {
  display: flex;
  align-content: center;
  margin-bottom: 20px;
}

#song-table {
  display: flex;
  align-content: center;
  justify-content: center;
}

#try-again-button {
  display: flex;
  justify-content: center;
}

#header-section {
  background-color: #1c37383a;
  background-size: cover;
  display: flex;
  flex-direction: column;
  align-items: center;
  align-content: space-around;
  height: 15rlh;
}

#dropdown-section-one {
  background-color: #4d484749;
  display: flex;
  flex-direction: flex-start;
  justify-content: center;
  align-items: center;
  height: 8rlh;
}

#genre-dropdown {
  display: flex;
  flex-direction: column;
  align-items: center;
}

#mood-dropdown {
  display: flex;
  flex-direction: column;
  align-items: center;
}

#spacer {
  width: 10vw;
}

#button-section-one {
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  height: 5vw;
}

#dropdown-section-two {
  background-color: #8baaad;
  display: flex;
  flex-direction: flex-start;
  justify-content: center;
  align-items: center;
  height: 8rlh;
}

#button-section-two {
  flex-direction: column;
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  height: 5vw;
  margin-top: 4vh;
}

.mood,
.genre {
  width: 25vw;
  height: 20px;
  text-align: center;
  margin-bottom: 4vh;
}

.mood2,
.genre2 {
  width: 25vw;
  height: 20px;
  text-align: center;
}

.or {
  /* flex-grow: 3; */
  text-align: center;
  margin-left: 11vw;
  margin-right: 11vw;
}

.and {
  /* flex-grow: 3; */
  text-align: center;
  margin-left: 11vw;
  margin-right: 11vw;
  margin-bottom: vh;
}

.or-selector {
  background-color: #8bad919c;
  display: flex;
  justify-content: center;
  height: 2rlh;
  align-items: center;
}
</style>