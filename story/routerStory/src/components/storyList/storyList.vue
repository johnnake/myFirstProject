<template>
    <div>
      <el-table :data="info" style="width: 100%">
        <el-table-column prop="id" label="id"></el-table-column>
        <el-table-column prop="storyName" label="故事名称"></el-table-column>
        <el-table-column prop="story" label="故事内容"></el-table-column>
        <el-table-column label="操作">
          <template #default="scope">
            <div class="operation-buttons">
              <el-button type="danger" size="small" @click="deleteStory(scope.row.id)">删除</el-button>
              <el-button type="warning" size="small" @click="updateStory(scope.row.id)">修改</el-button>
              <el-button type="primary" size="small" @click="backNovelOutline">返回当前小说大纲</el-button>
            </div>
          </template>
      </el-table-column>
      </el-table>
    </div>
    <!-- 添加编辑故事模态框 -->
    <el-dialog v-model="dialogEditVisible" title="编辑内容" width="500">
    <el-form :model="editForm">
      <el-form-item label="故事名称" :label-width="formLabelWidth">
        <el-input v-model="editForm.storyName" autocomplete="off" />
      </el-form-item>
      <el-form-item label="故事内容" :label-width="formLabelWidth">
        <el-input v-model="editForm.story" autocomplete="off" />
      </el-form-item>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogEditVisible = false;resetEditForm()">取消</el-button>
        <el-button type="primary" @click="handleSave(editForm.id)">
          保存
        </el-button>
      </div>
    </template>
  </el-dialog>


</template>>
  
  <script>
  import axios from 'axios';
  import { id } from 'element-plus/es/locale/index.mjs';
  import { ref, reactive, onMounted } from 'vue';
  import { ElMessage, ElMessageBox } from 'element-plus';
  import { useRoute, useRouter } from 'vue-router';//获取路由信息和使用路由跳转
  
  export default {
    name: 'App',
    setup() {
      const info = ref([]);
      const newStory = ref({
        StoryName: '',
        Story:''
      });
      // 获取路由器和当前路由信息，用于跳转和获取路由内信息
      const router = useRouter();
      const route = useRoute();

    // 添加编辑模态框显示状态
    const dialogEditVisible = ref(false);

    
    // 根据id返回指定小说大纲方法
    const backNovelOutline = () => {
      const id = route.params.id; // 获取路由参数中的id
      // 直接使用route.params.id而不需要传参
      router.push({ name: 'StoryShow', params: { id } });
    };

    const editForm = reactive({
        id: '',
        storyName: '',
        story: ''
    });

    // 清空表单
    const resetEditForm = () => {
      editForm.value = {
        storyName: '',
        story: ''
      };
    };

    // 更新操作（修改以显示模态框）
    const updateStory = async (id) => {
    try {
        const response = await axios.get(`http://localhost:8084/story/findById/${id}`); // 修改这里，移除查询参数格式，使用路径参数
        Object.assign(editForm, response.data);
        dialogEditVisible.value = true; // 显示编辑模态框
    } catch (error) {
        console.error('获取故事详情失败:', error);
    }
};

        const handleSave = async () => {
          try {
            await axios.put(`http://localhost:8084/story/update/${editForm.id}`, editForm); // 注意URL路径中添加${editForm.id}
            ElMessage.success('故事更新成功');
            // findAll(); // 刷新列表
            refreshCurrentStory(); // 刷新列表
            resetEditForm(); // 重置表单
          } catch (error) {
            console.error('更新故事失败:', error);
            ElMessage.error('更新失败，请稍后再试');
          }
        };


      
      // const findAll = () => {
      //   axios.get('http://localhost:8084/story/findAll')
      //     .then(response => {
      //       info.value = response.data;
      //     })
      //     .catch(error => {
      //       console.log(error);
      //     });
      // };

      onMounted(async () => {
      try {
        // 直接在这里根据路由参数获取特定故事，不再调用外部的findAll函数
        const storyId = route.params.id; // 从route中获取id
        if(storyId) { // 确保有id才发起请求
          const response = await axios.get(`http://localhost:8084/story/findAllById/${storyId}`);
          info.value = response.data;
        } else {
          console.warn('No storyId found in the route parameters.');
        }
      } catch (error) {
        console.error('获取故事列表时出错:', error);
      }
    });
  

      // 新增 refreshCurrentStory 函数
      const refreshCurrentStory = async () => {
        try {
          const storyId = route.params.id;
          if(storyId) {
            const response = await axios.get(`http://localhost:8084/story/findAllById/${storyId}`);
            info.value = response.data;
          } else {
            console.warn('No storyId found in the route parameters.');
          }
        } catch (error) {
          console.error('刷新故事列表时出错:', error);
        }
      };

      const addStory = () => {
        axios.post('http://localhost:8084/story/insert', newStory.value)
          .then(response => {
            newStory.value = {
              StoryName: '',
              Story:''
            };
            // findAll();
            refreshCurrentStory(); // 刷新列表
          })
          .catch(error => {
            console.log(error);
          });
      };


      const deleteStory = (id) => { // 修改参数为id
      axios.get('http://localhost:8084/story/delete?id='+id) // 传入正确的参数
      .then(response=>{
        // findAll();
        refreshCurrentStory(); // 刷新列表
      })
        .catch(error => {
          console.log(error);
        });
    };
  
          
      // onMounted(() => {
      //   findAll();
      // });
  
      return {
        info,
        dialogEditVisible,
        editForm,
        resetEditForm,
        newStory,
        // findAll,
        refreshCurrentStory,
        addStory,
        dialogEditVisible,
        updateStory,
        handleSave,
        deleteStory,
        backNovelOutline,
        id
      };
    }
  };
  </script>
  
  <style scoped>
  .pagination {
  display: flex;
  justify-content: center;
  gap: 10px;
}
  </style>