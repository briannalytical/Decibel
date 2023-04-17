<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'songs' }">Songs</router-link
      >&nbsp;|&nbsp;
       <!-- <router-link v-bind:to="{ name: 'savelist' }">Saved Lists</router-link
      >&nbsp;|&nbsp; -->
      <router-link v-bind:to="{ name: 'welcome' }">Welcome</router-link
      >&nbsp;|&nbsp;
       <router-link v-bind:to="{ name: 'user'}">User</router-link
      >&nbsp;|&nbsp;
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
    <router-view />
  </div>
</template>
