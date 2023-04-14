import axios from 'axios';

export default {
    getAllSongs() {
        return axios.get('/songs');
    },
    getAllMoods() {
        return axios.get('/songs/moods');
    },
    getSongsByMood(id) {
        return axios.get(`/songs/moods/${id}`);


    }




}