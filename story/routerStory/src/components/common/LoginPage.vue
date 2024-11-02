<template>
    
  <div class="Register">
    <h1>Register</h1>
    <form @submit.prevent="handleSubmit">
      <label for="userName">Username:</label>
      <input type="text" id="userName" v-model="userName" required>
      <br>
      <label for="password">Password:</label>
      <input type="password" id="password" v-model="password" required>
      <br>
      <button type="submit">Register</button>
    </form>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import router from '../../router/router';
import { RouterLink } from 'vue-router';

export default {
  name: 'App',
  setup() {
    const info = ref([]);
    const data = ref({
      userName: '',
      password: ''
    })
    ;


    const findAll = () => {
  axios.get('http://localhost:8084/registerAndLogin/FindUser')
  .then(response => {
    if(response.data.code==='200'){
                  alert('登录成功');
                  sessionStorage.setItem("uerId",response.data.data);
              }else{
                  alert("登录失败")
              }
  })
  .catch(error => {
    console.log(error);
  });
};

  const AddUser = () => {
      axios.post('http://localhost:8084/registerAndLogin/AddUser', data.value)
        .then(response => {
          data.value = {
            userName: '',
            password:''
          };
          alert('注册成功');
          router.push({path:'/main'});
        }
        )
        .catch(error => {
          console.log(error);
        });
    };




const handleSubmit = () => {
  AddUser();
};


    return {
      info,
      data,
      findAll,
      AddUser,
      handleSubmit
    };
  }
};
</script>

<style scoped>
.Register {
  max-width: 300px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 4px;
}
</style>
