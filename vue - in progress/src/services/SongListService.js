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
    },

    getPlaylist(){
        return axios.get(`/playlist`)
    },
    savePlaylist(playlist){
        return axios.post(`/playlist`,playlist)
    },

    updateNameOfPlaylist(playlist){
        return axios.put(`/playlist`,playlist)
    },

    updateUserProfile(imageUrl){
        return axios.put(`/users`, {"userProfilePicture": imageUrl})
    },

    getUserProfile() {
        return axios.get('/users')
    }
}