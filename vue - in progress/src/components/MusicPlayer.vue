/* eslint-disable no-unused-vars */
/* eslint-disable no-unused-vars */
<template>
  <div id="musicplayer" class ="bar">
    <div class="container">
    <!-- Heading/MAYBE REMOVE THIS-->
    <header class="heading">
        <h1 class="title">{{title}}</h1>
    </header>
    <!-- Heading-->

    <!-- Cover-->
    <picture class="cover">
        <img :src="cover" alt="music-cover" width="50" height="50"/>
    </picture>
    <!--Cover-->

      <!-- Info-->
      <div class="info">
        <div class="music">{{name}}</div>
        <div class="artist">{{artist}}</div>
      </div>
      <!-- Info-->

      <!-- Time -->
        <div class="time">
          <div class="count">{{currentDate}}</div>
          <div class="count">{{getTime}}</div>
        </div>
      <!--Time -->

      <!--Progress-->
      <div class="music-info">
        <div class="progress-container" @click="setProgress">
          <div class="progress" :style="{ width: progressValue + '%'}"></div>
        </div>
      </div>
      <!--Progress-->
      
      <!--Navigation-->
      <div class="navigation">
        <button class="action-btn action-btn-left" :class="reload" @click="this.isRandom = !this.isRandom">
          <i class="fas fa-random"></i>
        </button>
        <button class="action-btn" @click="prevSong">
          <i class="fas fa-backward"></i>
        </button>
        <button class="action-btn action-btn-big" @click="playSong()">
          <i class="fas fa-pause" v-if="isPlay"></i>
          <i class="fas fa-play" v-else></i>
        </button>
        <button class="action-btn" @click="nextSong">
          <i class="fas fa-forward"></i>
        </button>
        <button class="action-btn action-btn-right" :class="fav" @click="favSong">
          <i class="fas fa-heart"></i>
        </button>
      </div>
      <!--Navigation-->

      <!--Audio-->
      <audio :src="music" ref="myAudio" @ended="nextSong" @timeupdate="[updateProgress, currentTimeCalc]"></audio>
    </div>
  </div>
</template>

<script>
export default {
    name: "MusicPlayer",
  data() {
    return {
      musics:[
        {
          name: "The Lonely Shepherd",
          artist: "Gheorge Zamfir",
          cover: "https://i.scdn.co/image/ab67616d0000b273fecfac11994325a39cd03dec",
          source: "https://github.com/ramazanyamac/vue-music-player/blob/master/music/The-Lonely-Shepherd.mp3?raw=true",
          fav: false,
        },
        {
          name: "Once Upon a Time in the West",
          artist: "Ennio Morricone",
          cover: "https://i.scdn.co/image/ab67616d0000b2732b23062e3b70cc2725b4f960",
          source: "https://github.com/ramazanyamac/vue-music-player/blob/master/music/Once-Upon-a-Time-in-the-West.mp3?raw=true",
          fav: false,
        },
        {
          name: "So Was Red",
          artist: "Thomas Newman",
          cover: "https://i.scdn.co/image/ab67616d0000b273e710c1f5b228046932790031",
          source: "https://github.com/ramazanyamac/vue-music-player/blob/master/music/So-Was-Red.mp3?raw=true",
          fav: false,
        },
        {
          name: "Leaving Wallbrook/On The Road",
          artist: "Hans Zimmer",
          cover: "https://i.scdn.co/image/ab67616d0000b273bf5889f82cc38018de92724a",
          source: "https://github.com/ramazanyamac/vue-music-player/blob/master/music/On-The-Road.mp3?raw=true",
          fav: false,
        },
        {
          name: "Cast Away",
          artist: "Geek Music",
          cover: "https://i.scdn.co/image/ab67616d0000b2733eff8e9536d0f0db4260e03a",
          source: "https://github.com/ramazanyamac/vue-music-player/blob/master/music/Cast-Away.mp3?raw=true",
          fav: false,
        },
      ],
      songIndex: 0,
      music: null,
      cover: null,
      name: null,
      artist: null,
      isPlay: false,
      progressValue: null,
      currentDate: null,
      duration: null,
      isRandom: false,
    }
  },
  methods: {
    loadSong() {
      this.music = this.musics[this.songIndex].source;
      this.cover = this.musics[this.songIndex].cover;
      this.name = this.musics[this.songIndex].name;
      this.artist = this.musics[this.songIndex].artist;
      const audio = new Audio(this.musics[this.songIndex].source); 

      audio.onloadedmetadata = () => {
          this.duration = audio.duration;
      }

      this.$refs.myAudio.load()
    },
    playSong() {
      this.isPlay = !this.isPlay;
      
      if(this.isPlay) {
        this.$refs.myAudio.play()
      } else {
        this.$refs.myAudio.pause()
      }
      
    },
    refreshSong(){
      this.isPlay = true;

      if(this.isPlay) {
        var playPromise =  this.$refs.myAudio.play();
        if(playPromise !== undefined){
          // eslint-disable-next-line no-unused-vars
          playPromise.then(_ => {
            this.$refs.myAudio.pause();
          })
          // eslint-disable-next-line no-unused-vars
          .catch(error => {
            this.$refs.myAudio.play();
          });
        }
      }
    },
    randomNumber(min, max){
      return Math.floor(Math.random() * (max - min + 1) ) + min;
    },
    prevSong() {
      if(this.random){
        this.songIndex = this.songIndex - this.randomNumber(1,this.musics.length);
      } else {
        this.songIndex--;
      }

      if (this.songIndex < 0) {
        this.songIndex = this.musics.length - 1;
      }

      this.loadSong();
      this.refreshSong();
    },
    nextSong() {
      if(this.random){
        this.songIndex = this.songIndex + this.randomNumber(1,this.musics.length);
      } else {
        this.songIndex++;
      }

      if (this.songIndex > this.musics.length - 1) {
        this.songIndex = 0;
      }
      
      this.loadSong();
      this.refreshSong();
    },
    updateProgress(e) {
      const { duration, currentTime } = e.srcElement;
      const progressPercent = (currentTime / duration) * 100;
      this.progressValue = progressPercent;
    },
    setProgress(e) {
      const width = e.target.parentElement.clientWidth;
      const clickX = e.offsetX;
      const duration = this.$refs.myAudio.duration;
      this.$refs.myAudio.currentTime = (clickX / width) * duration;
    },
    timeCalculate(time){
      // eslint-disable-next-line no-unused-vars
      var current_hour = parseInt(time / 3600) % 24,
      current_minute = parseInt(time / 60) % 60,
      current_seconds_long = time % 60,
      current_seconds = current_seconds_long.toFixed(),
      current_time = (current_minute < 10 ? "0" + current_minute : current_minute) + ":" + (current_seconds < 10 ? "0" + current_seconds : current_seconds);
  
      return current_time;
    },
    currentTimeCalc(){
      this.currentDate = this.timeCalculate(this.$refs.myAudio.currentTime)
    },
    favSong() {
      this.musics = this.musics.map((music, index) => index === this.songIndex ? {...music, fav: !music.fav} : music)
    }
  },
  computed: {
    getTime: function(){
      return this.timeCalculate(this.duration)
    },
    title: function(){
      return this.isPlay ? 'Now Playing' : 'Pause'
    },
    reload: function(){
      return this.isRandom && 'action-btn-active';
    },
    fav: function(){
      return this.musics[this.songIndex].fav && 'action-btn-fav';
    },
  },
  watch: {
    
  },
  mounted(){
    this.loadSong();
  },


}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css?family=Lato&display=swap');

.bar {
    position: fixed;
    bottom: 0;
    width: 100%;
    background-color: #fff;
    box-shadow: 0 -2px 4px rgba(0, 0, 0, 0.1);
    padding: 5px 0;
  }

  .container {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 20px;
    max-width: 100%;
    margin: auto;
  }

  .cover img {
    border-radius: 50%;
    box-shadow: none;
  }

  .info {
    display: flex;
    flex-direction: column;
    justify-content: center;
    padding: 0;
    font-size: 14px;
  }

  .info .music {
    font-weight: bold;
    margin-bottom: 2px;
  }

  .info .artist {
    font-weight: normal;
  }

  .music-info {
    width: 40%;
  }

  .navigation {
    display: flex;
    align-items: center;
    justify-content: space-between;
    width: 30%;
    z-index: 1;
  }

  .action-btn {
      
  border: 0;
  color: #8a017e;
  font-size: 20px;
  cursor: pointer;
    padding: 6px;
  }

  .action-btn.action-btn-big {
    font-size: normal;
  }

</style>