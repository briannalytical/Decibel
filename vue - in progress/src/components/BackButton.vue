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
.back-button {
    background-color: #f8f9fa;
    border: none;
    color: #077bff;
    padding: 8px 16px;
    font-size: 16px;
    cursor: pointer;
    text-decoration: none;
    border-radius: 4px;
    transition: background-color 0.3s, color 0.3s;
}

.back-button:hover {
    background-color: #077bff;
    color: #ffffff;
}
</style>