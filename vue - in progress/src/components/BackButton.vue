<template>
  <button class="back-button" @click="goBack">
     &#8592; Back 
  </button>
</template>

<script>
export default {
    methods: {
        goBack() {
            this.$router.go(-1);
        },
    },
};
</script>

<style scoped>

</style>