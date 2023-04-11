import axios from  'axios';

export default {
    getAllSongs(){
        return axios.get('/songs');
    },
    getSongsById(songId){
        return axios.get(`/songs/${songId}`);
    }

   
}