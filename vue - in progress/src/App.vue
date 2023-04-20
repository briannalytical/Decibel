<template>
  <div id="app">
    <div id="nav">
      <nav class="navigationWrapper">
          <a href="http://localhost:8080/welcome"><img id="header-logo" v-bind:src="require('./assets/DBLogo-gold.png')" /><img id="header-logo2" v-bind:src="require('./assets/DBLogo-txt-only.png')" /></a>
        <ul class="navigation">
          <router-link v-bind:to="{ name: 'home' }">Home</router-link
          >&nbsp;|&nbsp;
          <router-link v-bind:to="{ name: 'songs' }">Songs</router-link
          >&nbsp;|&nbsp;
       
        <router-link v-bind:to="{ name: 'welcome' }">Welcome</router-link
          >&nbsp;|&nbsp;
          <router-link v-bind:to="{ name: 'user-profile' }">User</router-link
          >&nbsp;|&nbsp;
          <router-link
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
            >Logout</router-link
          >
        </ul>
      </nav>
    </div>
    <router-view />
  </div>
</template>
