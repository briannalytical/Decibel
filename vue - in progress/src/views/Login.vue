<template>
  <div id="main">
    <div id="record-collection-prime">
      <div id="record-collection1">
        <div id="albums1">
          <img src="../assets/Cash.jpg" /><img src="../assets/Bad.jpg" /><img
            src="../assets/Beauty.png"
          /><img src="../assets/Gran.jpg" />
        </div>
        <div id="albums2">
          <img src="../assets/Guy.jpg" /><img src="../assets/Bey.jpg" /><img
            src="../assets/RTJ4.jpg"
          />
        </div>
        <div id="albums3">
          <img src="../assets/Nyan.jpg" /><img src="../assets/Jimmy.jpg" />
        </div>
      </div>

      <img id="purp-logo" src="../assets/DBLogo-purple.png" />

      <div id="record-collection2">
        <div id="albums4">
          <img src="../assets/Roots.jpg" /><img src="../assets/Snake.jpg" />
        </div>
        <div id="albums5">
          <img src="../assets/Whitehorse.jpg" /><img
            src="../assets/Panic.jpg"
          /><img src="../assets/IMG_0984.jpg" />
        </div>
        <div id="albums6">
          <img src="../assets/IMG_0994.jpg" /><img
            src="../assets/ODB.jpg"
          /><img src="../assets/Swift.jpg" /><img src="../assets/Snoop.jpg" />
        </div>
      </div>
    </div>

    <div id="login">
      <form @submit.prevent="login">
        <div role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div role="alert" v-if="this.$route.query.registration">
          Thank you for registering, please sign in.
        </div>
        <div class="form-input-group">
          <label for="username">Username</label>
          <input
            type="text"
            id="username"
            v-model="user.username"
            required
            autofocus
          />
        </div>
        <div class="form-input-group">
          <label for="password">Password</label>
          <input
            type="password"
            id="password"
            v-model="user.password"
            required
          />
        </div>
        <div id="bottom-part">
          <button type="submit">Sign in</button>
          <p>
            <router-link :to="{ name: 'register' }"
              >Need an account? Sign up.</router-link
            >
          </p>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>
#main {
  height: 100vh;
}

#purp-logo {
  display:flex;
  width: 255px;
  height: 255px;
}

#bottom-part {
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  align-items: center;
  background-color: #52525270;
  border: solid 2px#525252;
  width: 25vw;
  height: 88px;
}
.form-input-group {
  color: #ffefd5;
  display: flex;
  flex-direction: column;
  align-content: center;
  justify-content: center;
  align-items: center;
  background-color: #52525270;
  border: solid 2px#525252;
  width: 25vw;
  height: 88px;
  margin-bottom: 12px;
}

h1 {
  color: #ffefd5;
  font-family: serif;
  font-size: 5em;
  letter-spacing: 2px;
  text-align: center;
  width: 25vw;
  margin-bottom: 12px;
}

label {
  margin-right: 0.5rem;
}

form {
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  align-items: center;
  position: fixed;
  bottom: 0;
  width: 100%;
}
#record-collection-prime {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 150px;
  height: 100vh;
  background-color: rgb(0, 0, 0);
}
#record-collection1 {
  display: flex;
  gap: 18px;
  align-items: center;
  align-content: center;
  justify-content: center;
}

#record-collection2 {
  display: flex;
  gap: 18px;
  align-items: center;
  align-content: center;
  justify-content: center;
}

#albums1 {
  display: inline-flex;
  flex-direction: column;
  justify-content: flex-end;
  width: 150px;
  gap: 18px;
  /* align-self: flex-start; */
}
#albums2 {
  display: inline-flex;
  flex-direction: column;
  width: 150px;
  gap: 18px;
  /* padding-bottom: 50px; */
}
#albums3 {
  display: inline-flex;
  flex-direction: column;
  width: 150px;
  gap: 18px;
  /* align-self: flex-start; */
}
#albums4 {
  display: inline-flex;
  flex-direction: column;
  width: 150px;
  gap: 18px;
  /* padding-bottom: 315px; */
}
#albums5 {
  display: inline-flex;
  flex-direction: column;
  width: 150px;
  gap: 18px;
  /* align-self: flex-start; */
}
#albums6 {
  display: inline-flex;
  flex-direction: column;
  width: 150px;
  gap: 18px;
  /* padding-top: 194px;
  align-self: center; */
}
</style>