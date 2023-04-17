<template>
  <div class="speech-recognition">
    <div class="speech-box">
      <button @click="startRecognition" :disabled="listening" class="speech-btn">Start Listening</button>
      <button @click="stopRecognition" :disabled="!listening" class="speech-btn">Stop Listening</button>
      <p v-if="listening" class="listening-indicator">Listening...</p>
      <p v-if="speechResult" class="mood-result">Mood detected: {{ speechResult }}</p>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      listening: false,
      speechResult: "",
      recognition: null,
      moods: ["happy", "sad", "angry", "romantic", "silly", "unhinged", "motivated", "chill", "workout"],
    };
  },
  methods: {
       startRecognition() {
            if (!("webkitSpeechRecognition" in window)) {
                alert("Speech recognition is not supported in your browser.");
                return;
            }
            // eslint-disable-next-line no-undef
            this.recognition = new webkitSpeechRecognition();
            this.recognition.continuous = true;
            this.recognition.interimResults = true;
            this.recognition.lang = "en-US";
            this.recognition.onstart = () => {
                this.listening = true;
            };
            this.recognition.onresult = (event) => {
                const latestResult = event.results[event.results.length - 1];
                const transcript = latestResult[0].transcript.trim();
                if (latestResult.isFinal) {
                    this.speechResult = transcript;
                    this.stopRecognition();
                    this.$emit("mood-detected", transcript);
                }
            };
            this.recognition.onerror = (error) => {
                console.error("Error in speech recognition:", error);
                this.stopRecognition();
            };
            this.recognition.start();
        },
        stopRecognition() {
            if (this.recognition) {
                this.recognition.stop();
                this.listening = false;
            }
        },
         isMood(transcript) {
      const lowercaseTranscript = transcript.toLowerCase();
      return this.moods.some((mood) => lowercaseTranscript.includes(mood));
        },
    },
     created() {
    // eslint-disable-next-line no-undef
    this.recognition = new webkitSpeechRecognition();
    this.recognition.continuous = true;
    this.recognition.interimResults = true;
    this.recognition.lang = "en-US";
    this.recognition.onstart = () => {
      this.listening = true;
        };
    this.recognition.onresult = (event) => {
      const latestResult = event.results[event.results.length - 1];
      const transcript = latestResult[0].transcript.trim();
      if (latestResult.isFinal && this.isMood(transcript)) {
        this.speechResult = transcript;
        this.stopRecognition();
        this.$emit("mood-detected", transcript);
            }
        };
    this.recognition.onerror = (error) => {
      console.error("Error in speech recognition:", error);
      this.stopRecognition();
        };
     },
    beforeDestroy() {
        this.stopRecognition();
    },
};
//--------FUNCTIONALITY AND LOGIC STRUCTURE--------
//component uses the Web Speech API to recognize user speech.
//It has two buttons, "Start Listening" and "Stop Listening," to control the speech recognition.
//When the component detects a final result, it stops the recognition and emits a "mood-detected" event with the detected mood.
//use component import it into main parent component location tbd and add an event listener for the "mood-detected" event
//see scratch for mockup.
//When this event is emitted use to generate a playlist based on the detected mood.
// update: new moods data property containing the list of keywords to recognize.
// added a new isMood method to check if a given transcript matches any of the keywords.
// The onresult event handler now checks if the recognized speech matches any of the keywords by calling the isMood method.
// If the recognized speech matches a keyword and the result is final, it emits the "mood-detected" event with the detected mood.
// Now, the speech recognition feature will only recognize and respond to the specified keywords.
//THIS IS THE SAME AS RECOGNITION2. NO UPDATE HERE.
//-----------STYLE NOTES ARE AS FOLLOWS----------
//a minimalistic box appearance with a light gray background, a slight box shadow, and a fixed width.
//the buttons are styled with a blue background and white text same as back and navigation buttons, with hover and disabled states.
//the listening indicator and mood result texts are centered and styled with a smaller font size.
//the component will be displayed as a small box within the page.
//in time, I believe we could do a different version for each mood result that affects the VFX of the whole page as previously discussed.
</script>
<style scoped>
.speech-recognition {
  display: flex;
  justify-content: center;
  margin-bottom: 2rem;
}
.speech-box {
  background-color: #F0F0F0;
  border-radius: 5px;
  padding: 1rem;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  width: 250px;
}
.speech-btn {
  background-color: #4A69BD;
  border: none;
  border-radius: 3px;
  color: #fff;
  cursor: pointer;
  display: block;
  font-size: 14px;
  margin-bottom: 1rem;
  padding: 0.5rem 1rem;
  text-align: center;
  width: 100%;
}
.speech-btn:hover {
  background-color: #3C528D;
}
.speech-btn:disabled {
  background-color: #A6B1E1;
  cursor: not-allowed;
}
.listening-indicator {
  color: #333;
  font-size: 14px;
  margin-bottom: 0.5rem;
  text-align: center;
}
.mood-result {
  color: #333;
  font-size: 14px;
  font-weight: bold;
  text-align: center;
}
</style>