<template>
<div class="grid-container">
    <div class="item1" v-for="image in images" :key="image.id">
        <img :src="image.imageUrl" :alt="image.altText"/>
        <br>
        <el-button type="info" plain><router-link :to="{ name: 'StoryShow', params: { id: image.id }}" style="text-decoration: none; color: black;">大纲展示</router-link></el-button>
         <br>
         <el-button type="info" plain><router-link :to="{ name: 'storyList', params: { id: image.id }}" style="text-decoration: none; color: black;">{{ image.novelTitle }}</router-link></el-button>
    </div>
</div>


  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import axios from 'axios';
  
  const images = ref([]);
  
  onMounted(async () => {
    try {
      // 假设您的API端点返回一个包含图片信息的数组，每个对象至少包含`imageUrl`字段
      const response = await axios.get('http://localhost:8084/api/storyImage/ImageList');
      images.value = response.data;
    } catch (error) {
      console.error('获取图片列表时出错:', error);
    }
  });
  </script>
  
  <style scoped>
  .gallery {
    display: grid;
    gap: 1rem;
    justify-content: center;
  }

  .grid-container {
  display: grid;
  grid-template-columns: repeat(4, 250px); /* 例如，4列，每列250px */
  grid-gap: 10px;
  /* background-color: #2196F3; */
  padding: 10px;
  margin: 20px; /*上下左右都设置为20px*/
  /* margin: 30px 10px; //上下30px，左右10px */
  /* margin: 40px 15px 20px; //上40px，左右15px，下20px */
  /* margin: 50px 20px 30px 40px; //上50px，右20px，下30px，左40px */
  /* padding: 10px; //四边内边距都是10px */
  /* margin-top: 30px; //只调整上边外边距 */
  /* padding-right: 25px; //只调整右边内边距 */
}

.grid-container > div {
  background-color: rgba(255, 255, 255, 0.8);
  text-align: center;
  /* padding: 20px 0; */
  font-size: 30px;
}
.grid-container img {
  width: 100%; /* 确保图片宽度100%适应网格单元宽度 */
  height: auto; /* 保持图片的高度自动调整以维持宽高比 */
  object-fit: cover; /* 如果需要裁剪图片以填充网格并保持宽高比，使用cover；如果希望图片完全显示不裁剪，可以使用contain */
  object-position: center; /* 确保图片在裁剪时从中心开始 */
}


</style>