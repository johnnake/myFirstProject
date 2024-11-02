<template>
  <a-layout class="logincontent">
    <div class="loginform">
      <h1 class="login-title">用户登录</h1>
      <form @submit.prevent="submitForm" class="form-and-register">
        <label>
          ID：
          <input v-model="loginId" type="text" required>
        </label>
        <br>
        <label>
          密码：
          <input v-model="password" type="password" required>
        </label>
        <br>
        <button type="submit">登录</button>
      </form>
   <Router-Link to="/Register" class="register-link">注册用户</Router-Link>
      <div v-if="error" class="error">{{ error }}</div>
      <div v-if="success" class="success">{{ success }}</div>
    </div>
  </a-layout>
  </template>
  
  <script>
  import { ref } from 'vue';
  import axios from 'axios';
  import router from '../../router/router';

  export default {
    setup() {
      const loginId = ref('');
      const password = ref('');
      const error = ref('');
      const success = ref('');
  
      async function submitForm() {
        try {
          const response = await axios.post('http://localhost:8084/token/login', {
            loginId: loginId.value,
            password: password.value,
          });
  
          if (response.data.code === '200') {
            success.value = '登录成功';
            // 这里可以处理返回的用户信息和token，如保存到本地存储或更新状态管理器等
            // const userInfo = response.data.data;
            // localStorage.setItem('user', JSON.stringify(userInfo));
            // ...
            // 跳转到主页或其他指定页面
            router.push('/main');
          } else {
            error.value = response.data.data || '登录失败';
          }
        } catch (err) {
          error.value = '网络请求异常，请稍后重试';
          console.error(err);
        }
      }
  
      return {
        loginId,
        password,
        error,
        success,
        submitForm,
      };
    },
  };
  </script>
  
<style scoped>


.login-title {
  margin-bottom: 2rem; /* 为标题与表单之间添加间距 */
}

.form-and-register {
  display: flex;
  flex-direction: column;
  gap: 1rem; /* 在表单与注册链接之间添加间距 */
}

.register-link {
  text-align: center;
}

/* ...其他样式 */ 
  .error, .success {
    color: red; /* 或绿色 */
    margin-top: 1rem;
  }

  .logincontent {
  display: flex;
  flex-direction: column;
  /* background-image: url("/src/assets/planet.jpg"); */
  background-size: 100% 100%;
  background-attachment: fixed;
  
 
  width: 100%;
  height: 100%;
  min-width: 900px;
  min-height: 1000px;
 
  justify-content: center;
  align-items: center;
}

.loginform {
  background-color: #fdf8f8;
  min-width: 400px;
  box-shadow: rgba(0, 0, 0, 0.1) 0px 15px 30px;
  padding: 30px 30px;
  text-align: center;
}

  </style>