<template>
  <div>
    <el-form :model="newStory" label-width="80px" style="margin-top: 20px;">
      <el-form-item label="故事名称">
        <el-input style="width: 400px" v-model="newStory.storyName"></el-input>
      </el-form-item>
      <el-form-item label="选择大纲">
        <el-select v-model="newStory.imageId" placeholder="请选择大纲" style="width: 400px">
          <el-option
            v-for="item in outlineOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="故事内容">
        <el-input v-model="newStory.story" style="width: 1680px" :rows="20" type="textarea" placeholder="Please input">
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="addStory">添加</el-button>
        <el-button><router-link :to="{ name: 'StoryShow', params: { id: imageId.id }}" style="text-decoration: none; color: gray;">返回上一次的小说大纲</router-link></el-button>
      </el-form-item>
    </el-form>
  </div>

  <!-- <div class="demo-radius">
      <el-text class="w-150px mb-2" v-for="value in info">
        <div>{{ value.id}}<br/></div>
        <div>
          <h1>{{ value.storyName }}</h1><br/>
        </div>
        <div class="radius">
          {{ value.story }}
        </div>
      </el-text>
</div> -->

</template>

<script>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRoute, useRouter } from 'vue-router';//获取路由信息和使用路由跳转
export default {
  name: 'App',
  setup() {
    const info = ref([]);
    const newStory = ref({
      storyName: '',
      story:'',
      imageId:''
    });
    // 获取路由器和当前路由信息，用于跳转和获取路由内信息
    const route = useRoute();
    const imageId=route.params.id;
    const findAll = () => {
      axios.get('http://localhost:8084/story/findAll')
        .then(response => {
          info.value = response.data;
        })
        .catch(error => {
          console.log(error);
        });
    };

    const addStory = () => {
      axios.post('http://localhost:8084/story/insert', newStory.value)
        .then(response => {
          newStory.value = {
            storyName: '',
            story:'',
            imageId:''
          };
        })
        .catch(error => {
          console.log(error);
        });
    };

        // 新增：大纲选项数据源
        const outlineOptions = ref([
          { value: '1', label: 'novelOne' },
          { value: '2', label: 'novelTwo' },
          { value: '3', label: 'novelThree' },
          { value: '3', label: 'novelFour' },
          // 可以根据实际情况添加更多选项
        ]);

    const deleteStory = (id) => {
      axios.delete('http://localhost:8084/story/delete?id=' + id)
        .then(response => {
          info.value = info.value.filter((item) => item.id !== id);
        })
        .catch(error => {
          console.log(error);
        });
    };

    onMounted(() => {
      findAll();
    });

    return {
      info,
      newStory,
      outlineOptions,
      findAll,
      addStory,
      deleteStory,
      imageId,
      route
    };
  }
};
</script>

<style scoped>

div{text-align: center}

div{font-size:20px;}

.demo-radius .title {
  color: var(--el-text-color-regular);
  font-size: 18px;
  margin: 10px 0;
}
.demo-radius .value {
  
  color: var(--el-text-color-primary);
  font-size: 16px;
  margin: 10px 0;
}
.demo-radius .radius {
  height: auto;
  width: auto;
  border: 0px solid var(--el-border-color);
  border-radius: 0;
  margin-top: 20px;
}





</style>