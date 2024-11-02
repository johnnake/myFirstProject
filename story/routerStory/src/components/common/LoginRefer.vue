<template>
  <div class="login-container">
    <h1>用户登录</h1>
    <form @submit.prevent="submitForm">
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

      <button type="submit">登录</button>
    </form>

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
    const password = ref('');
    const error = ref('');
    const success = ref('');

    async function submitForm() {
      try {
        const response = await axios.post('/api/login', {
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
          // router.push('/');
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
.login-container {
  /* 添加适当的样式 */
}

.error, .success {
  color: red; /* 或绿色 */
  margin-top: 1rem;
}
</style>