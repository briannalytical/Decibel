const SONGS = [
    // replace and insert api calls - need to get data from the backend here
];

export async function getAllSongs() {
    return SONGS;
}

export async function generateSongsByMoodAndGenre(mood, genre) {
    // replace with an api call to the backend to generate a playlist
    return SONGS.filter(song => song.mood === mood && song.genre === genre).slice(0,10)
}

/* 
Travis notes 4-10:
functions to get songs and generate a playlist. the dataset SONGS is a mock set.
getAllSongs returns all songs that match the selection
generateSongsByMoodAndGenre filters the list and returns the top 10 
*/