<template>
  <button class="save-button" @click="savePlaylist">
     &#8592; Save Playlist  
  </button>
</template>

<script>
export default {
    methods: {
    savePlaylist() {
        this.$router.push({
            name:"savelist"
        })
    }
    }
}
</script>

<style scoped>
.save-button {
    background-color: #f8f9fa;
    border: none;
    color: #077bff;
    /* padding: 8px 16px; */
    font-size: 16px;
    cursor: pointer;
    /* text-decoration: none; */
    border-radius: 4px;
    transition: background-color 0.3s, color 0.3s;
}

.save-button:hover {
    background-color: #077bff;
    color: #ffffff;
}
</style>