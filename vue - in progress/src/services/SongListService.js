import axios from  'axios';

export default {
    getAllSongs(){
        return axios.get('/songs');
    },
    getAllMoodsById(){
        return axios.get('/moods');
    }
  

   
}