<template>
  <div id="main">
    <button class="save-playlist-button" @click="dropIt">Pet Options</button>
    <transition name="slide">
      <ul class="list" v-if="isDropped">
        <li>Dog</li>
        <li>Cat</li>
        <li>Bunny</li>
        <li>Parrot</li>
        <li>Fish</li>
      </ul>
    </transition>
  </div>
</template>

<script>
export default {
    data: () => ({
    isDropped: false
  }),
  methods: {
    dropIt() {
      this.isDropped = !this.isDropped
    }
  }
};
</script>

<style>

button {
  padding: 20px 60px;
  border: solid thin darken(#b50064, 10%);
  background: #b50064;
  color: #eee;
  
}
.list {
  position: absolute;
  width: 204px;
  margin: 0;
  padding: 0;
  list-style-type: none;
  transform-origin: top;
  transition: transform 0.4s ease-in-out;
  overflow: hidden;
}
  li {
    padding: 10px;
    background: white;
    border-bottom: solid thin #eee;
    border-left: solid medium #cbc;
  }

.slide-enter,
.slide-leave-to {
  transform: scaleY(0);
}
</style>