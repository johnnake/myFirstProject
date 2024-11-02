
<template>
  <div>
    <el-table :data="info" style="width: 100%">
      <el-table-column prop="name" label="角色名"></el-table-column>
      <el-table-column prop="roleHigh" label="角色身高"></el-table-column>
      <el-table-column prop="bodyDetail" label="身材描述"></el-table-column>
      <el-table-column prop="clothes" label="衣服"></el-table-column>
      <el-table-column prop="belt" label="腰带"></el-table-column>
      <el-table-column prop="face" label="面相"></el-table-column>
      <el-table-column prop="character" label="品格"></el-table-column>
      <!-- <el-table-column prop="planet" label="属于什么宗门"></el-table-column> -->
      <el-table-column label="操作">
        <template #default="scope">
          <el-button type="primary" @click="addRole(scope.row)">保存到角色列表</el-button>
          <!-- <el-button type="danger" @click="addRole(scope.row.id)">删除</el-button> -->
        </template>
      </el-table-column>
    </el-table>
  </div>
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
    character: ''
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
  //selectedRole是addRole的参数，这个接收了scope.row表单数据值
  //这里的scope对象是由el-table的default插槽提供的作用域插槽参数，它包含了当前行（scope.row）的所有数据。
  //当您在@click事件处理器中传入scope.row作为参数时，实际上是将当前行的数据传递给了addRole方法。
  const addRole = (selectedRole) => {
    axios.post('http://localhost:8084/api/addRole',selectedRole)
      .then(response => {
        // queryAllRole();
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
    findAll();
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
  div{text-align: center}
  
  </style>