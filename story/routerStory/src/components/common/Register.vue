<template>
  <div class="register-container">
    <h1>用户注册</h1>
    <form @submit.prevent="submitForm">
      <label>
        用户名称：
        <input v-model="username" type="text" required>
      </label>
      <label>
        登录ID：
        <input v-model="loginId" type="text" required>
      </label>
      <br>
      <label>
        密码：
        <input v-model="password" type="password" required>
      </label>
      <br>
      <!-- 其他字段... -->

      <button type="submit">注册</button>
    </form>
    <Router-Link to="/login">返回登入页面</Router-Link>
    <div v-if="error" class="error">{{ error }}</div>
    <div v-if="success" class="success">{{ success }}</div>
  </div>
</template>

<script>
import { ref } from 'vue';
import axios from 'axios';

export default {
  setup() {
    
    const loginId = ref('');
    const username = ref('');
    const password = ref('');
    // 其他字段...

    const error = ref('');
    const success = ref('');

    async function submitForm() {
      try {
        const response = await axios.post('http://localhost:8084/user/register', {
          loginId: loginId.value,
          username: username.value,
          password: password.value,  
          // 其他字段...
        });

        if (response.data.code === '200') {
          success.value = '注册成功';
          // 清空表单
          loginId.value = '';
          password.value = '';
          username.value = '';
          // 其他字段...
        } else {
          error.value = response.data.message || '注册失败';
        }
      } catch (err) {
        error.value = '网络请求异常，请稍后重试';
        console.error(err);
      }
    }

    return {
      loginId,
      username,
      password,
      // 其他字段...
      error,
      success,
      submitForm,
    };
  },
};
</script>

<style scoped>
.register-container {
  /* 添加适当的样式 */
}

.error, .success {
  color: red; /* 或绿色 */
  margin-top: 1rem;
}
</style>