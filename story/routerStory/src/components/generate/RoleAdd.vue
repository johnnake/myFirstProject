<template>
    <div>
      <el-form :model="newpeople" label-width="80px" style="margin-top: 20px;">
        <el-form-item label="名字">
          <el-input style="width: 800px" v-model="newpeople.name"></el-input>
        </el-form-item>
        <el-form-item label="身高">
          <el-input v-model="newpeople.roleHigh" style="width: 800px"></el-input>
        </el-form-item>
        <el-form-item label="身体">
          <el-input style="width: 800px" v-model="newpeople.bodyDetail"></el-input>
        </el-form-item>
        <el-form-item label="衣服">
          <el-input style="width: 800px" v-model="newpeople.clothes"></el-input>
        </el-form-item>
        <el-form-item label="腰带">
          <el-input style="width: 800px" v-model="newpeople.belt"></el-input>
        </el-form-item>
        <el-form-item label="脸">
          <el-input style="width: 800px" v-model="newpeople.face"></el-input>
        </el-form-item>
        <el-form-item label="性格">
          <el-input style="width: 800px" v-model="newpeople.character"></el-input>
        </el-form-item>
        <el-form-item label="选择章节">
          <el-input style="width: 800px" v-model="newpeople.storyId"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="addRole">添加</el-button>
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

export default {
name: 'App',
setup() {
const info = ref([]);
const newpeople = ref({
  name: '',
  roleHigh:'',
  bodyDetail: '',
  clothes: '',
  belt: '',
  face: '',
  character: '',
  storyId:''
});

const findAll = () => {
  axios.get('http://localhost:8084/api/characters')
    .then(response => {
      info.value = response.data;
    })
    .catch(error => {
      console.log(error);
    });
};

const queryAllRole = () => {
  axios.get('http://localhost:8084/api/queryAllRole')
    .then(response => {
      info.value = response.data;
    })
    .catch(error => {
      console.log(error);
    });
};

const addRole = (selectedRole) => {
  axios.post('http://localhost:8084/api/addRole',newpeople.value)
    .then(response => {
      // queryAllRole();
      newpeople.value={
        name: '',
        roleHigh:'',
        bodyDetail: '',
        clothes: '',
        belt: '',
        face: '',
        character : '',
        storyId:''
      };
      alert('保存成功');
    })
    .catch(error => {
      console.log(error);
    });
};

const deleteRole = (id) => { // 修改参数为id
axios.get('http://localhost:8084/story/deleteRole?id='+id) // 传入正确的参数
.then(response=>{
  queryAllRole();
})
  .catch(error => {
    console.log(error);
  });
};

    
onMounted(() => {
  queryAllRole();
});

return {
  info,
  newpeople,
  findAll,
  queryAllRole,
  addRole,
  deleteRole
};
}
};
</script>

<style scoped>

</style>