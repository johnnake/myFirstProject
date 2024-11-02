<template>
    <form @submit.prevent="uploadImage">
      <input type="file" ref="fileInput" accept="image/*" @change="handleFileChange" />
      <input type="text" v-model="novelTitle" placeholder="请输入小说标题" />
      <button type="submit" :disabled="!selectedFile">上传图片</button>
      <p v-if="uploadMessage">{{ uploadMessage }}</p>
    </form>
  </template>
  
  <script setup>
  import axios from 'axios';
  import { ref, onMounted } from 'vue';
  
  const fileInput = ref(null);
  const selectedFile = ref(null);
  const uploadMessage = ref('');
  const novelTitle = ref('');
  
  const handleFileChange = () => {
    selectedFile.value = fileInput.value.files[0];
  };
  
  const uploadImage = async () => {
    if (!selectedFile.value) return;
  
    const formData = new FormData();
    formData.append('file', selectedFile.value);
    formData.append('novelTitle', novelTitle.value);
  
    try {
      const response = await axios.post('http://localhost:8084/api/storyImage/uploads', formData, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      });
      uploadMessage.value = '图片上传成功！';
      console.log(response.data); // 打印后端返回的图片信息
      // 可能需要清空表单或做其他后续处理
    } catch (error) {
      uploadMessage.value = '图片上传失败，请重试。';
      console.error(error);
    }
  };
  
  onMounted(() => {
    // 初始化时聚焦文件输入框（可选）
    fileInput.value.focus();
  });
  </script>
  
  <style scoped>
  button {
    margin-top: 10px;
  }
  </style>