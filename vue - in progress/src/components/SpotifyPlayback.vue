<template>
  <div>
       <h1>Spotify Web Playback SDK Quick Start</h1>
    <button id="togglePlay">Toggle Play</button>
  </div>
</template>

<script>

export default {

    mounted(){
         const script = document.createElement("script");
    script.src = "https://sdk.scdn.co/spotify-player.js";
    script.async = true;

    document.body.appendChild(script);
        window.onSpotifyWebPlaybackSDKReady = () => {
            const token = 'BQAmRVFhVpKWqEOoWeK0iylAYfDHTslH0ZMdpNz9XQNtIT2Wqo2y27UvqIA1LbM3z1BOiW3fxcqFAFDh6Ucn6YueS-gtk8bqhug4jgioxYGXg_pTmy1QDFcQfe9mRHC7OkjNkLMqZh8dFaEn1y3HfvZVWnvMVTiZMwChVc9_6u-3R5rdC9yYssRjVh7M4hMA9EziGUr7nc5kfs7PRvaOGraqBcWwVmWgxs4Gn59kanJFwwCXRQehUHIoPUOqDjSb0OBWV4HzjkOCZOrVlDobfjUWBKeEYjXxc8ame3c3QrdQnvn30RgbSB0xu_20ypHhT7ZvcLmnekDkobfCTUQIXh29fYIqSEbCT1gTbimn6Uhk1ys';
           // eslint-disable-next-line
           const player = new Spotify.Player({
                name: 'Web Playback SDK Quick Start Player',
                getOAuthToken: cb => { cb(token); },
                volume: 0.5
            });

            // Ready
            player.addListener('ready', ({ device_id }) => {
                console.log('Ready with Device ID', device_id);
            });

            // Not Ready
            player.addListener('not_ready', ({ device_id }) => {
                console.log('Device ID has gone offline', device_id);
            });

            player.addListener('initialization_error', ({ message }) => {
                console.error(message);
            });

            player.addListener('authentication_error', ({ message }) => {
                console.error(message);
            });

            player.addListener('account_error', ({ message }) => {
                console.error(message);
            });

            document.getElementById('togglePlay').onclick = function() {
              player.togglePlay();
            };

            player.connect();
        }

    }

}
</script>

<style>

</style>