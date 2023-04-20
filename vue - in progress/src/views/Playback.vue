<template>
  <div id="ColorPlayer">
	<div id="instructions">
		<h3>Try clicking on the cover image and then on the screen that will show up</h3>
	</div>
	<img :src="cover" alt="Cover" id="cover" @click="coverClicked" :class="coverClass" />
	<div id="infoPage" :class="infoPage" @click="infoPageClicked">
		<div class="content">
			<h1>{{songName}}</h1>
			<h3>{{artistName}}</h3>
		</div>
	</div>
	<div id="player" :style="playerStyle">
		<div id="filter"></div>
		<div id="controls" :class="controls">
			<img @click="backwardButtonClicked" id="backwardButton" src="data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4KPHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB2ZXJzaW9uPSIxLjEiIHZpZXdCb3g9IjAgMCAxMjkgMTI5IiBlbmFibGUtYmFja2dyb3VuZD0ibmV3IDAgMCAxMjkgMTI5IiB3aWR0aD0iMTI4cHgiIGhlaWdodD0iMTI4cHgiPgogIDxnPgogICAgPGc+CiAgICAgIDxwYXRoIGQ9Im02NC41LDEyMi42YzMyLDAgNTguMS0yNiA1OC4xLTU4LjFzLTI2LTU4LTU4LjEtNTgtNTgsMjYtNTgsNTggMjYsNTguMSA1OCw1OC4xem0wLTEwOGMyNy41LDUuMzI5MDdlLTE1IDQ5LjksMjIuNCA0OS45LDQ5LjlzLTIyLjQsNDkuOS00OS45LDQ5LjktNDkuOS0yMi40LTQ5LjktNDkuOSAyMi40LTQ5LjkgNDkuOS00OS45eiIgZmlsbD0iIzAwMDAwMCIvPgogICAgICA8cGF0aCBkPSJtNzAsOTMuNWMwLjgsMC44IDEuOCwxLjIgMi45LDEuMiAxLDAgMi4xLTAuNCAyLjktMS4yIDEuNi0xLjYgMS42LTQuMiAwLTUuOGwtMjMuNS0yMy41IDIzLjUtMjMuNWMxLjYtMS42IDEuNi00LjIgMC01LjhzLTQuMi0xLjYtNS44LDBsLTI2LjQsMjYuNGMtMC44LDAuOC0xLjIsMS44LTEuMiwyLjlzMC40LDIuMSAxLjIsMi45bDI2LjQsMjYuNHoiIGZpbGw9IiMwMDAwMDAiLz4KICAgIDwvZz4KICA8L2c+Cjwvc3ZnPgo=" />
			<img id="playPauseButton" :src="playPauseButton" @click="playPauseClicked" :class="faded" />
			<img @click="forwardButtonClicked" id="forwardButton" src="data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTYuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjwhRE9DVFlQRSBzdmcgUFVCTElDICItLy9XM0MvL0RURCBTVkcgMS4xLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL0dyYXBoaWNzL1NWRy8xLjEvRFREL3N2ZzExLmR0ZCI+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgd2lkdGg9IjEyOHB4IiBoZWlnaHQ9IjEyOHB4IiB2aWV3Qm94PSIwIDAgNjEyIDYxMiIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNjEyIDYxMjsiIHhtbDpzcGFjZT0icHJlc2VydmUiPgo8Zz4KCTxnPgoJCTxwYXRoIGQ9Ik01ODcuNTcyLDE4Ni44ODFjLTMyLjI2Ni03NS4yMjUtODcuMDk2LTEyOS45MzQtMTYyLjk1Ni0xNjIuMjg1QzM4Ni43MTEsOC40MjcsMzQ2Ljk4NSwwLjE2OCwzMDUuNDk3LDAuMTY4ICAgIGMtNDEuNDg4LDAtODAuOTE0LDguMTgxLTExOC43ODQsMjQuNDI4QzExMS40ODgsNTYuODYxLDU2LjQxNSwxMTEuNTM1LDI0LjA5MiwxODYuODgxQzcuODk1LDIyNC42MjksMCwyNjQuMTc2LDAsMzA1LjY2NCAgICBjMCw0MS40OTYsNy44OTUsODEuMzcxLDI0LjA5MiwxMTkuMTI3YzMyLjMyMyw3NS4zNDYsODcuMzk2LDEzMC4zNDgsMTYyLjYyMSwxNjIuNjIxYzM3Ljg3LDE2LjI0Nyw3Ny4yOTUsMjQuNDIsMTE4Ljc4NCwyNC40MiAgICBjNDEuNDg5LDAsODEuMjE0LTguMjU5LDExOS4xMi0yNC40MmM3NS44Ni0zMi4zNTIsMTMwLjY5LTg3LjQwMywxNjIuOTU2LTE2Mi42MjFDNjAzLjgxOSwzODYuOTE0LDYxMiwzNDcuMTYsNjEyLDMwNS42NjQgICAgQzYxMiwyNjQuMTc2LDYwMy44MTksMjI0Ljc1Nyw1ODcuNTcyLDE4Ni44ODF6IE01MzguNzE3LDQ0MC44NTNjLTI0LjAxNCw0MS4xOTUtNTYuOTIyLDczLjg3Ni05OC4zNzUsOTguMDM5ICAgIGMtNDEuMTk2LDI0LjAyMS04Ni4zMjUsMzYuMTM1LTEzNC44NDUsMzYuMTM1Yy0zNi40NywwLTcxLjI3LTcuMDI0LTEwNC4zOTktMjEuNDE1Yy0zMy4xMjMtMTQuMzg0LTYxLjczMy0zMy4yOTQtODUuNjYyLTU3LjIxNSAgICBjLTIzLjkyMS0yMy45MjgtNDIuOTY2LTUyLjgxMS01Ny4yMTQtODUuOTk3Yy0xNC4xOTgtMzMuMDY1LTIxLjA4LTY4LjI1OC0yMS4wOC0xMDQuNzM1YzAtNDguNTIsMTEuOTIxLTkzLjQyOCwzNS43OTktMTM0LjUwOSAgICBjMjMuOTcxLTQxLjIzMSw1Ni44ODYtNzMuOTQ3LDk4LjA0LTk4LjA0YzQxLjE2LTI0LjA5Miw4NS45OTctMzYuMTQyLDEzNC41MTctMzYuMTQyczkzLjY0OSwxMi4xMjEsMTM0Ljg0NSwzNi4xNDIgICAgYzQxLjQ1MywyNC4xNjQsNzQuMjgzLDU2Ljg3OSw5OC4zNzUsOTguMDRjMjQuMDkyLDQxLjE1MywzNi4xNDIsODUuOTksMzYuMTQyLDEzNC41MDkgICAgQzU3NC44NTgsMzU0LjE4NSw1NjIuODg4LDM5OS4zOTksNTM4LjcxNyw0NDAuODUzeiIgZmlsbD0iIzAwMDAwMCIvPgoJCTxwYXRoIGQ9Ik0yNzAuMDI2LDEyOC45OTVjLTcuNjAzLTcuNzk1LTE5LjQwMi03LjM2Ny0yNi4wOTgtMC42NzFjLTcuNjk1LDcuNjk1LTcuMjc0LDE4Ljk4MS0wLjY3MSwyNS43NjNsMTQ5LjU3MSwxNTMuNTkxICAgIEwyNDMuMjU3LDQ1Ny4yNDJjLTcuMjEsNy4yMTctNi42ODksMTkuMDc0LDAsMjUuNzdjMy42ODMsMy42NzcsOC4zNjYsNS42ODksMTMuNzIsNS42ODljNS4wMTksMCw5LjM2Ni0yLjAyMSwxMy4wNDktNS42ODkgICAgbDE2Mi4yODYtMTYxLjYyMWM3LjIzLTcuMTk1LDYuNjA5LTE5LjMyNCwwLTI2LjA5OEwyNzAuMDI2LDEyOC45OTV6IiBmaWxsPSIjMDAwMDAwIi8+Cgk8L2c+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPGc+CjwvZz4KPC9zdmc+Cg==" />
		</div>
	</div>
</div>
</template>

<script>
export default {

	data: function() {
return {
		playerStyle: {//REPLACE COVERS, SONGNAMES, ARTISTS IN METHODS WITH DATA DERIVED FROM API CALLS
			backgroundColor: "#000000".replace(/0/g,() => {return (~~(Math.random()*16)).toString(16)})
		},
		cover: 'https://i1.sndcdn.com/artworks-000217001504-gzt4ul-t500x500.jpg',
		coverClass: '',
		playPauseButton: 'data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTkuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgdmlld0JveD0iMCAwIDI5NC44NDMgMjk0Ljg0MyIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgMjk0Ljg0MyAyOTQuODQzOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSIgd2lkdGg9IjEyOHB4IiBoZWlnaHQ9IjEyOHB4Ij4KPGc+Cgk8cGF0aCBkPSJNMjc4LjUyNyw3OS45NDZjLTEwLjMyNC0yMC4wMjMtMjUuMzgtMzcuNzA0LTQzLjUzOC01MS4xMzJjLTIuNjY1LTEuOTctNi40MjEtMS40MDctOC4zOTIsMS4yNTdzLTEuNDA3LDYuNDIxLDEuMjU3LDguMzkyICAgYzE2LjY4NywxMi4zNCwzMC41MjEsMjguNTg2LDQwLjAwOCw0Ni45ODNjOS45NCwxOS4yNzcsMTQuOTgsNDAuMTI4LDE0Ljk4LDYxLjk3NmMwLDc0LjY3MS02MC43NSwxMzUuNDIxLTEzNS40MjEsMTM1LjQyMSAgIFMxMiwyMjIuMDkzLDEyLDE0Ny40MjFTNzIuNzUsMTIsMTQ3LjQyMSwxMmMzLjMxMywwLDYtMi42ODcsNi02cy0yLjY4Ny02LTYtNkM2Ni4xMzMsMCwwLDY2LjEzMywwLDE0Ny40MjEgICBzNjYuMTMzLDE0Ny40MjEsMTQ3LjQyMSwxNDcuNDIxczE0Ny40MjEtNjYuMTMzLDE0Ny40MjEtMTQ3LjQyMUMyOTQuODQyLDEyMy45NzcsMjg5LjIwMSwxMDAuNjQ1LDI3OC41MjcsNzkuOTQ2eiIgZmlsbD0iIzAwMDAwMCIvPgoJPHBhdGggZD0iTTEwOS42OTksNzguOTY5Yy0xLjg3NiwxLjA2Ny0zLjAzNSwzLjA1OS0zLjAzNSw1LjIxNnYxMzEuNjc0YzAsMy4zMTQsMi42ODcsNiw2LDZzNi0yLjY4Niw2LTZWOTQuNzRsODguODMzLDUyLjg4MyAgIGwtNjUuMzI0LDQyLjA4N2MtMi43ODUsMS43OTUtMy41ODksNS41MDgtMS43OTQsOC4yOTNjMS43OTYsMi43ODYsNS41MDgsMy41OSw4LjI5NCwxLjc5NGw3My40NjUtNDcuMzMzICAgYzEuNzQ2LTEuMTI1LDIuNzg2LTMuMDczLDIuNzQ5LTUuMTVjLTAuMDM3LTIuMDc3LTEuMTQ1LTMuOTg3LTIuOTMtNS4wNUwxMTUuNzMzLDc5LjAyOSAgIEMxMTMuODc3LDc3LjkyNiwxMTEuNTc1LDc3LjkwMiwxMDkuNjk5LDc4Ljk2OXoiIGZpbGw9IiMwMDAwMDAiLz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8L3N2Zz4K',
		play: true,
		pause: false,
		faded: '',
		controls: '',
		infoPage: '',
		songName: 'Insane',
		artistName: 'Flume (Jey Vazz Remix)',
	};
},
	methods: { //REPLACE COVERS, SONGNAMES, ARTISTS IN METHODS WITH DATA DERIVED FROM API CALLS
		backwardButtonClicked: function() {
			if(this.cover == 'https://i1.sndcdn.com/artworks-000202678628-gdpmft-t500x500.jpg') {
				this.coverClass = 'faded'
				setTimeout(()=>{
					this.coverClass = ''
					this.cover = 'https://i1.sndcdn.com/artworks-000217001504-gzt4ul-t500x500.jpg'
					this.songName = 'Insane'
					this.artistName = 'Flume (Jey Vazz Remix)'
				},200)	
			}
			else {
				this.coverClass = 'faded'
				setTimeout(()=>{
					this.coverClass = ''
					this.cover = 'https://i1.sndcdn.com/artworks-000202678628-gdpmft-t500x500.jpg'
					this.songName = 'All You Ever Talk About'
					this.artistName = 'Whethan VS Oliver Tree'
				},200)
			}
		},
		forwardButtonClicked: function() {//REPLACE COVERS, SONGNAMES, ARTISTS IN METHODS WITH DATA DERIVED FROM API CALLS
			if(this.cover == 'https://i1.sndcdn.com/artworks-000217001504-gzt4ul-t500x500.jpg') {
				this.coverClass = 'faded'
				setTimeout(()=>{
					this.coverClass = ''
					this.cover = 'https://i1.sndcdn.com/artworks-000202678628-gdpmft-t500x500.jpg'
					this.songName = 'All You Ever Talk About'
					this.artistName = 'Whethan VS Oliver Tree'
				},200)	
			}
			else {
				this.coverClass = 'faded'
				setTimeout(()=>{
					this.coverClass = ''
					this.cover = 'https://i1.sndcdn.com/artworks-000217001504-gzt4ul-t500x500.jpg'
					this.songName = 'Insane'
					this.artistName = 'Flume (Jey Vazz Remix)'
				},200)
			}
		},
		coverClicked: function() {
			this.controls = 'active'
			setTimeout(()=>{
				this.coverClass = 'active'
				setTimeout(()=>{
					this.infoPage = 'active'
				},500)
			},500)
		},
		infoPageClicked: function() {
			this.infoPage = ''
			setTimeout(()=>{
				this.coverClass = ''
				setTimeout(()=>{
					this.controls = ''
				},500)
			},500)
		},
		playPauseClicked: function() {
			if(this.play == true) {
				this.faded = 'faded'
				setTimeout(()=>{
					this.faded = ''
					this.play = false
					this.pause = true
					this.playPauseButton = 'data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTkuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iTGF5ZXJfMSIgeD0iMHB4IiB5PSIwcHgiIHZpZXdCb3g9IjAgMCA1MTIgNTEyIiBzdHlsZT0iZW5hYmxlLWJhY2tncm91bmQ6bmV3IDAgMCA1MTIgNTEyOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSIgd2lkdGg9IjEyOHB4IiBoZWlnaHQ9IjEyOHB4Ij4KPGc+Cgk8Zz4KCQk8cGF0aCBkPSJNNDc3LjYwNywxMjguMDU1QzQ0My40MzIsNjguODYxLDM4OC4yNSwyNi41MiwzMjIuMjI5LDguODNDMjU2LjIwNy04Ljg2MiwxODcuMjQ5LDAuMjE4LDEyOC4wNTUsMzQuMzkzICAgIEM2OC44NjIsNjguNTcsMjYuNTIsMTIzLjc1LDguODMsMTg5Ljc3MWMtMTcuNjksNjYuMDIyLTguNjExLDEzNC45ODEsMjUuNTY0LDE5NC4xNzQgICAgYzM0LjE3NSw1OS4xOTQsODkuMzU1LDEwMS41MzUsMTU1LjM3NywxMTkuMjI1YzIyLjA0Niw1LjkwOCw0NC40MTcsOC44Myw2Ni42NDQsOC44M2M0NC4zMzktMC4wMDEsODguMTAxLTExLjYyOSwxMjcuNTI5LTM0LjM5NSAgICBjNTkuMTkzLTM0LjE3NSwxMDEuNTM1LTg5LjM1NSwxMTkuMjI1LTE1NS4zNzdDNTIwLjg2MSwyNTYuMjA3LDUxMS43ODIsMTg3LjI0OCw0NzcuNjA3LDEyOC4wNTV6IE00NzcuNDMxLDMxNS4zMzMgICAgYy0xNS44NDksNTkuMTQ2LTUzLjc4LDEwOC41NzktMTA2LjgxLDEzOS4xOTdjLTUzLjAyOCwzMC42MTYtMTE0LjgwNiwzOC43NDgtMTczLjk1MiwyMi45MDEgICAgYy01OS4xNDctMTUuODQ5LTEwOC41ODEtNTMuNzgtMTM5LjE5Ny0xMDYuODFjLTMwLjYxNi01My4wMjgtMzguNzUtMTE0LjgwNy0yMi45MDEtMTczLjk1NCAgICBjMTUuODQ5LTU5LjE0Niw1My43OC0xMDguNTc5LDEwNi44MS0xMzkuMTk3YzM1LjMyNS0yMC4zOTUsNzQuNTIzLTMwLjgxMiwxMTQuMjQ5LTMwLjgxMmMxOS45MSwwLDM5Ljk1OCwyLjYyLDU5LjcwNSw3LjkxICAgIGM1OS4xNDcsMTUuODQ5LDEwOC41ODEsNTMuNzgsMTM5LjE5NywxMDYuODFDNDg1LjE0NiwxOTQuNDA3LDQ5My4yNzksMjU2LjE4Niw0NzcuNDMxLDMxNS4zMzN6IiBmaWxsPSIjMDAwMDAwIi8+Cgk8L2c+CjwvZz4KPGc+Cgk8Zz4KCQk8cGF0aCBkPSJNMjEwLjcwNiwxMzMuMTE4aC0zMy4xMmMtMTQuNjk0LDAtMjYuNjQ4LDExLjk1NC0yNi42NDgsMjYuNjQ4djE5Mi40NjhjMCwxNC42OTQsMTEuOTU0LDI2LjY0OCwyNi42NDgsMjYuNjQ4aDMzLjEyICAgIGMxNC42OTQsMCwyNi42NDgtMTEuOTU0LDI2LjY0OC0yNi42NDhWMTU5Ljc2NkMyMzcuMzU0LDE0NS4wNzIsMjI1LjQsMTMzLjExOCwyMTAuNzA2LDEzMy4xMTh6IE0yMTAuNzA2LDM1Mi4yMzRoLTMzLjEyVjE1OS43NjYgICAgaDMzLjEybDAuMDE3LDE5Mi40NjZDMjEwLjcyMywzNTIuMjMyLDIxMC43MTgsMzUyLjIzNCwyMTAuNzA2LDM1Mi4yMzR6IiBmaWxsPSIjMDAwMDAwIi8+Cgk8L2c+CjwvZz4KPGc+Cgk8Zz4KCQk8cGF0aCBkPSJNMzM0LjQxNiwxMzMuMTE4aC0zMy4xMmMtMTQuNjk0LDAtMjYuNjQ4LDExLjk1NC0yNi42NDgsMjYuNjQ4djE5Mi40NjhjMCwxNC42OTQsMTEuOTU0LDI2LjY0OCwyNi42NDgsMjYuNjQ4aDMzLjEyICAgIGMxNC42OTQsMCwyNi42NDgtMTEuOTU0LDI2LjY0OC0yNi42NDhWMTU5Ljc2NkMzNjEuMDY0LDE0NS4wNzIsMzQ5LjEwOSwxMzMuMTE4LDMzNC40MTYsMTMzLjExOHogTTMzNC40MTQsMzUyLjIzNGgtMzMuMTIgICAgVjE1OS43NjZoMzMuMTJsMC4wMTcsMTkyLjQ2NkMzMzQuNDMyLDM1Mi4yMzIsMzM0LjQyNiwzNTIuMjM0LDMzNC40MTQsMzUyLjIzNHoiIGZpbGw9IiMwMDAwMDAiLz4KCTwvZz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8L3N2Zz4K'
				},200)
			}
			else if(this.pause == true) {
				this.faded = 'faded'
				setTimeout(()=>{
					this.faded = ''
					this.pause = false
					this.play = true
					this.playPauseButton = 'data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTkuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgdmlld0JveD0iMCAwIDI5NC44NDMgMjk0Ljg0MyIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgMjk0Ljg0MyAyOTQuODQzOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSIgd2lkdGg9IjEyOHB4IiBoZWlnaHQ9IjEyOHB4Ij4KPGc+Cgk8cGF0aCBkPSJNMjc4LjUyNyw3OS45NDZjLTEwLjMyNC0yMC4wMjMtMjUuMzgtMzcuNzA0LTQzLjUzOC01MS4xMzJjLTIuNjY1LTEuOTctNi40MjEtMS40MDctOC4zOTIsMS4yNTdzLTEuNDA3LDYuNDIxLDEuMjU3LDguMzkyICAgYzE2LjY4NywxMi4zNCwzMC41MjEsMjguNTg2LDQwLjAwOCw0Ni45ODNjOS45NCwxOS4yNzcsMTQuOTgsNDAuMTI4LDE0Ljk4LDYxLjk3NmMwLDc0LjY3MS02MC43NSwxMzUuNDIxLTEzNS40MjEsMTM1LjQyMSAgIFMxMiwyMjIuMDkzLDEyLDE0Ny40MjFTNzIuNzUsMTIsMTQ3LjQyMSwxMmMzLjMxMywwLDYtMi42ODcsNi02cy0yLjY4Ny02LTYtNkM2Ni4xMzMsMCwwLDY2LjEzMywwLDE0Ny40MjEgICBzNjYuMTMzLDE0Ny40MjEsMTQ3LjQyMSwxNDcuNDIxczE0Ny40MjEtNjYuMTMzLDE0Ny40MjEtMTQ3LjQyMUMyOTQuODQyLDEyMy45NzcsMjg5LjIwMSwxMDAuNjQ1LDI3OC41MjcsNzkuOTQ2eiIgZmlsbD0iIzAwMDAwMCIvPgoJPHBhdGggZD0iTTEwOS42OTksNzguOTY5Yy0xLjg3NiwxLjA2Ny0zLjAzNSwzLjA1OS0zLjAzNSw1LjIxNnYxMzEuNjc0YzAsMy4zMTQsMi42ODcsNiw2LDZzNi0yLjY4Niw2LTZWOTQuNzRsODguODMzLDUyLjg4MyAgIGwtNjUuMzI0LDQyLjA4N2MtMi43ODUsMS43OTUtMy41ODksNS41MDgtMS43OTQsOC4yOTNjMS43OTYsMi43ODYsNS41MDgsMy41OSw4LjI5NCwxLjc5NGw3My40NjUtNDcuMzMzICAgYzEuNzQ2LTEuMTI1LDIuNzg2LTMuMDczLDIuNzQ5LTUuMTVjLTAuMDM3LTIuMDc3LTEuMTQ1LTMuOTg3LTIuOTMtNS4wNUwxMTUuNzMzLDc5LjAyOSAgIEMxMTMuODc3LDc3LjkyNiwxMTEuNTc1LDc3LjkwMiwxMDkuNjk5LDc4Ljk2OXoiIGZpbGw9IiMwMDAwMDAiLz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8L3N2Zz4K'
				},200)
			}
		}
	},
	mounted: function(){
		setInterval(()=>{
			this.playerStyle.backgroundColor = "#000000".replace(/0/g,() => {return (~~(Math.random()*16)).toString(16)})
		},500)
	}
}

</script>

<style>
body {
	background-color: rgb(233, 233, 233)
}
#instructions {
	color: rgb(126, 126, 126);
	text-align: center;
	font-family: Josefin Sans;
}
#infoPage {
	height: 0px;
	width: 500px;
	border-radius: 5px;
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-250px,-250px);
	transition: 1s;
	overflow: hidden;
	background-color: rgb(185, 185, 185);
	z-index: 1000;
	display: flex;
	align-items: center;
	justify-content: center;
	text-align: center;
	font-family: Josefin Sans;
}

#infoPage.active{
	height: 500px;
    }
#player {
	height: 500px;
	width: 500px;
	border-radius: 5px;
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-250px,-250px);
	transition: .2s;
	overflow: hidden;
    }

	#filter {
		height: 100%;
		width: 100%;
		border-radius: 5px;
		position: absolute;
		left: 0;
		top: 0;
		background: url(https://fdrfreebies.s3-us-west-1.amazonaws.com/wp-content/uploads/01_free-soft-blurry-background.jpg) center center no-repeat;
		background-size: cover;
		opacity: .7;
    }
	#controls.active {
		bottom: -100px
    }
	#controls {
		height: 120px;
		width: 500px;
		background-color: rgba(#fff,0.8);
		position: absolute;
		bottom: 0px;
		border-radius: 5px;
		box-shadow: 0px -10px 20px 0px rgba(0,0,0,0.4);
		display: flex;
		align-items: center;
		justify-content: center;
		transition: .5s;
    }
		#playPauseButton {
			width: 70px;
        }
		#forwardButton {
			width: 50px;
			margin: 0 15px;
        }
		#backwardButton {
			width: 50px;
			margin: 0 15px;
        }
#cover {
	position: absolute;
	z-index: 999;
	width: 420px;
	left: 50%;
	top: 50%;
	transform: translate(-210px,-300px);
	border-radius: 5px;
	box-shadow: 3px 3px 20px 0px rgba(0,0,0,0.4);
	transition: .5s;
}
#cover.active {
	transform: translate(-210px,-210px)
}
	
.faded {
	opacity: 0;
	transition: .2s
}
</style>