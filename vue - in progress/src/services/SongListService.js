import axios from  'axios';

export default {
    getAllSongs(){
        return axios.get('/songs');
    },
    getSongsByMood(mood){
        return axios.get(`/songs/${mood}`);
    }

   
}