<template>
  <div class="container mt-3">
    <h2>小说大纲</h2>
    <!-- <p><strong>注意：</strong> 使用 <strong>data-parent</strong> 属性来确保所有的折叠元素在指定的父元素下，这样就能实现在一个折叠选项显示时其他选项就隐藏。</p> -->
    
    <div id="accordion">
      <div v-for="(value, index) in paginatedInfo" :key="value.id" class="card">
        <div class="card-header">
          <a class="btn" data-bs-toggle="collapse" :href="'#collapse' + index">
            {{ value.storyName }}
          </a>
        </div>
        
        <div :id="'collapse' + index" class="collapse" data-bs-parent="#accordion">
          <div class="card-body">
            <p> {{ value.story }}</p>
          </div>
          <div class="card-body">
            <!-- <p> {{ value.story }}</p> -->
            <p> 登场人物：{{ value.names }}</p>
            <!-- 添加角色按钮 -->
            <button @click="addCharacter(value.id)">添加角色</button>
            <button @click="queryAllIdNameStoryId">取消角色</button>
            <button @click="queryAllIdNameStoryId">选择角色绑定本章节</button>
            <!-- 删除角色按钮应该有不同的逻辑，例如下面这样 -->
            <!-- <button @click="deleteCharacter(value.id)">删除角色</button> -->
                    <!-- 添加角色对话框 -->
                        <el-dialog
                        v-model="dialogAddVisibleRef"
                        title="添加角色"
                        width="30%">
                        <el-form ref="addCharacterFormRef" :model="newCharacterRef" label-width="80px">
                        <el-form-item label="角色名称">
                          <el-input v-model="newCharacterRef.name"></el-input>
                        </el-form-item>
                        <el-form-item label="角色身高">
                          <el-input v-model="newCharacterRef.roleHigh"></el-input>
                        </el-form-item>
                        <el-form-item label="身体描述">
                          <el-input v-model="newCharacterRef.bodyDetail"></el-input>
                        </el-form-item>
                        <el-form-item label="角色衣服">
                          <el-input v-model="newCharacterRef.clothes"></el-input>
                        </el-form-item>
                        <el-form-item label="角色腰带">
                          <el-input v-model="newCharacterRef.belt"></el-input>
                        </el-form-item>
                        <el-form-item label="头部描述">
                          <el-input v-model="newCharacterRef.face"></el-input>
                        </el-form-item>
                        <el-form-item label="人物性格">
                          <el-input v-model="newCharacterRef.character"></el-input>
                        </el-form-item>
                        <!-- 更多角色属性... -->
                      </el-form>
                      <template #footer>
                        <span class="dialog-footer">
                          <el-button @click="dialogAddVisibleRef = false">取消</el-button>
                          <el-button type="primary" @click="submitRole">确定添加</el-button>
                        </span>
                      </template>
                    </el-dialog>

                    <!-- 角色remove and choice -->
                    <el-dialog
                        v-model="dialogAddOrRemoceCharacterVisibleRef"
                        title="角色选择和移除"
                        width="30%">
                        <el-form ref="addCharacterFormRef" :model="addOrRemoceCharacter" label-width="80px">
                        <el-form-item label="选择角色">
                        <el-select v-model="addOrRemoceCharacter.id" placeholder="请选择角色" style="width: 400px">
                          <el-option
                            v-for="item in queryCharacter"
                            :key="item.id"
                            :label="item.name"
                            :value="item.id">
                          </el-option>
                        </el-select>
                      </el-form-item>
                      <el-form-item label="角色名称">
                          <el-input v-model="addOrRemoceCharacter.name" style="width: 400px"></el-input>
                      </el-form-item>
                      <el-form-item label="绑定章节">
                        <el-select v-model="addOrRemoceCharacter.storyId" placeholder="请选择章节" style="width: 400px">
                           <!-- 新增的"取消角色"选项 -->
                          <el-option label="取消角色" value="0"></el-option>
                          <el-option
                            v-for="item in paginatedInfo"
                            :key="item.id"
                            :label="item.storyName"
                            :value="item.id">
                          </el-option>
                        </el-select>
                      </el-form-item>
                        <!-- 更多角色属性... -->
                      </el-form>
                      <template #footer>
                        <span class="dialog-footer">
                          <el-button @click="dialogAddOrRemoceCharacterVisibleRef = false">取消</el-button>
                          <el-button type="primary" @click="updateCharacter">确定修改</el-button>
                        </span>
                      </template>
                    </el-dialog>
          </div>
        </div>
      </div>
    </div>
    <div class="pagination">
      <button :disabled="currentPage === 1" @click="prevPage">上一页</button>
      <span>{{ currentPage }} / {{ totalPages }}</span>
      <button :disabled="currentPage === totalPages" @click="nextPage">下一页</button>
      <el-button><router-link :to="{ name: 'addStory', params: { id: imageId.id }}" style="text-decoration: none; color: gray;">添加章节</router-link></el-button>
      <el-button><router-link :to="{ name: 'storyList', params: { id: imageId.id }}" style="text-decoration: none; color: gray;">修改章节</router-link></el-button>
      <el-button @click="findMainRoleByNovelId">查看主角</el-button>
      <el-button @click="gainCurrentNovelId">添加主角</el-button>
      <el-button @click="findNovelDecribeByNovelId">查看小说世界观</el-button>
      <el-button @click="NovelDescribeGainCurrentNovelId">添加小说世界观</el-button>
      
            <!--查看和添加主角对话框组件 -->
            <el-dialog
              v-model="dialogVisible"
              title="主角信息"
              width="30%"
            >
            <!-- 表单，仅当selectedRole有值时显示 -->
            <el-form
              ref="roleFormRef"
              :model="selectedRole"
              label-width="80px"
              v-if="selectedRole && Object.keys(selectedRole).length > 0"
            >
              <!-- 角色名称 -->
              <el-form-item label="角色名称">
                <el-input v-model="selectedRole.roleName" />
              </el-form-item>

              <!-- 角色技能 -->
              <el-form-item label="角色技能">
                <el-input 
                v-model="selectedRole.roleSkill" 
                class="custom-textarea-style" 
                type="textarea"
                :rows="5" 
                :autosize="{ minRows: 5, maxRows: 10 }"
              />
              </el-form-item>
              
              <!-- 角色信息 -->
              <el-form-item label="角色信息">
                <el-input 
                v-model="selectedRole.roleText" 
                class="custom-textarea-style" 
                type="textarea"
                :rows="5" 
                :autosize="{ minRows: 5, maxRows: 10 }"
              />
              </el-form-item>
              <!-- 操作按钮 -->
              <el-form-item>
                <el-button type="primary" @click="saveRole">保存更改</el-button>
                <el-button type="primary" @click="addMainRole">保存添加</el-button>
                <el-button @click="dialogVisible = false">取消</el-button>
              </el-form-item>
              </el-form>
            </el-dialog>

             <!--查看和添加世界观对话框组件 -->
             <el-dialog
              v-model="dialogAddVisibleWorldView"
              title="小说信息"
              width="30%"
            >
            <!-- 表单，仅当WorldView有值时显示 -->
            <el-form
              ref="addWorldViewFormRef"
              :model="WorldView"
              label-width="80px"
              v-if="WorldView && Object.keys(WorldView).length > 0"
            >
              <!-- 小说世界观 -->
              <el-form-item label="世界观">
                <el-input 
                v-model="WorldView.novelDescribe" 
                class="custom-textarea-style" 
                type="textarea"
                :rows="10" 
                :autosize="{ minRows: 10, maxRows: 20 }"
              />
              </el-form-item>

              <!-- 操作按钮 -->
              <el-form-item>
                <el-button type="primary" @click="saveNovelDecribe">保存更改</el-button>
                <el-button type="primary" @click="addNovelDescribe">保存添加</el-button>
                <el-button @click="dialogAddVisibleWorldView = false">取消</el-button>
              </el-form-item>
              </el-form>
            </el-dialog>
    </div>
  </div>
</template>



<script>
import { ref, onMounted } from 'vue';
// import {  nextTick } from 'vue';
import axios from 'axios';
import { useRoute } from 'vue-router';
import { ElMessage } from 'element-plus';
import { id } from 'element-plus/es/locale/index.mjs';
import { watch} from 'vue';

export default {
  name: 'App',
  setup() {
    const route = useRoute(); // 使用useRoute获取当前路由信息
    const totalPages = ref(1); // 默认设为1，表示初始状态或没有数据时的页数
    const info = ref([]);
    const paginatedInfo = ref([]);
    const newStory = ref({
      StoryName: '',
      Story: ''
    });
    const currentPage = ref(1);
    const itemsPerPage = ref(10); // 每页显示多少条数据
    //主角参数
    const dialogVisible = ref(false);
    const selectedRole = ref({            
            RoleName: '',
            RoleSkill: '',
            RoleText: '',
            novelId: ''});
    const roleFormRef = ref(null);

    const imageId = route.params.id; // 从route中获取id

    //角色参数
    const queryCharacter = ref([]);
    const addOrRemoceCharacter = ref({
      id:'',
      name: '',
      storyId:''
    });
    const dialogAddOrRemoceCharacterVisibleRef = ref(false);
    //角色参数
    const dialogAddVisibleRef = ref(false);
    const newCharacterRef = ref({   
      name: '',
      roleHigh:'',
      bodyDetail: '',
      clothes: '',
      belt: '',
      face: '',
      character: '',
      storyId:'' }); // 初始化角色信息对象
    const addCharacterFormRef = ref(null); // 表单引用
    //世界观参数
    const dialogAddVisibleWorldView = ref(false);
    //遇到错误 "Cannot set properties of undefined (setting 'novelId')" 通常意味着你尝试在一个未定义的对象上设置属性,我们给WorldView设置属性novelDescribe，novelId
    const WorldView=ref({
      novelDescribe:'',
      novelId:''
    });
    const addWorldViewFormRef=ref(null);




    
    // 角色方法
    const addCharacter = (storyId) => {
      newCharacterRef.value.storyId = storyId; // 假设新角色需要知道关联的故事ID
      dialogAddVisibleRef.value = true; // 显示添加角色对话框
    };
    const submitRole = async () => {
      try {
        // 假设简单的表单验证，实际项目中可能需要更复杂的验证逻辑|| !newCharacterRef.value.character
        if (!newCharacterRef.value.name ) {
          ElMessage.error('角色名称是必填项');
          return;
        }
        // 发起添加角色请求
        await axios.post('http://localhost:8084/api/addRole', newCharacterRef.value);
        ElMessage.success('角色添加成功');
        dialogAddVisibleRef.value = false; // 关闭对话框
        // 这里可以添加刷新列表的逻辑
        findAllWithPagination();
      } catch (error) {
        console.error('添加角色失败:', error);
        ElMessage.error('添加角色失败，请重试！');
      }
    };
    //分页功能
    const findAllWithPagination = (page = 1) => {
        const imageId = route.params.id; // 从route中获取id
        axios.get(`http://localhost:8084/story/findStoriesByImageIdWithPagination/${imageId}?&currentPage=${page}&pageSize=${itemsPerPage.value}`)
          .then(response => {
            paginatedInfo.value = response.data.dataList;
            totalPages.value = Math.ceil(response.data.totalCount / itemsPerPage.value);
          })
          .catch(error => {
            console.log(error);
          });
      };
    
    const prevPage = () => {
        if (currentPage.value > 1) {
          currentPage.value--;
          findAllWithPagination(currentPage.value); // 修改这里
        }
      };

      const nextPage = () => {
        if (currentPage.value < totalPages.value) {
          currentPage.value++;
          findAllWithPagination(currentPage.value); // 修改这里
        }
      };

    // 获取主角信息
    /*确保数据格式：你现在的findMainRoleByNovelId方法直接将响应的data赋值给selectedRole，根据你的日志，这应该是一个对象数组。\
    但你的模板期待的是一个对象，而不是数组。确保后端API设计正确或在前端处理数据时进行调整，比如直接赋值selectedRole.value = response.data[0];如果数组确实只包含一个对象。*/
    const findMainRoleByNovelId = async () => {
      try {
        const novelId = route.params.id;
        const response = await axios.get(`http://localhost:8084/MainRole/findByNovelId/${novelId}`);
        selectedRole.value = response.data[0];
        // console.log(selectedRole.value)
        // await nextTick(); // 等待Vue更新DOM
        dialogVisible.value = true;
      } catch (error) {
        ElMessage.error('获取主角信息失败，请稍后重试！');
        console.error('获取主角信息失败:', error);
      }
    };
    const saveRole = async () => {
      try {
        // 确保selectedRole.value包含角色的ID，这是更新操作所必需的
        if (!selectedRole.value.id) {
          ElMessage.error('角色ID缺失，无法进行更新');
          return;
        }

    // 准备要发送给后端的数据，确保包含角色ID以便识别要更新的记录
    const postData = {
          id: selectedRole.value.id, // 添加角色ID
          roleName: selectedRole.value.roleName,
          roleSkill: selectedRole.value.roleSkill,
          roleText: selectedRole.value.roleText,
          // 其他角色属性...
        };

        // 注意：更新操作通常使用PUT或PATCH方法，而非POST。这里假设后端API支持PUT方法用于更新。
        // 同时，URL中需要包含动态的角色ID。这里使用模板字符串插值方式来插入ID。
        const response = await axios.put(`http://localhost:8084/MainRole/update/${selectedRole.value.id}`, postData);

        // 检查响应状态，确保更新成功
        if (response.status === 200) {
          ElMessage.success('角色信息保存成功');
          dialogVisible.value = false;
        } else {
          ElMessage.error('服务器返回异常状态，更新失败');
        }
      } catch (error) {
        console.error('保存角色信息失败:', error);
        ElMessage.error('保存角色信息失败，请重试！');
      }
    };

    // 添加主角方法
    const gainCurrentNovelId= () => {
      selectedRole.value.novelId = route.params.id; // 假设新主角需要知道关联的NovelID
      dialogVisible.value = true; // 显示添加主角对话框
    };
    const addMainRole = () => {
      axios.post('http://localhost:8084/MainRole/insert', selectedRole.value)
        .then(response => {
          selectedRole.value = {
            RoleName: '',
            RoleSkill: '',
            RoleText: '',
            novelId: ''
          };
          // 检查响应状态，确保更新成功
        if (response.status === 200) {
          ElMessage.success('角色信息保存成功');
          dialogVisible.value = false;
        } else {
          ElMessage.error('服务器返回异常状态，更新失败');
        }
        })
        .catch(error => {
          console.error('保存角色信息失败:', error);
          ElMessage.error('保存角色信息失败，请重试！');
        });
    };


    //添加世界观的NovelDecribe部分
    const findNovelDecribeByNovelId = async () => {
      try {
        const novelId = route.params.id;
        const response = await axios.get(`http://localhost:8084/NovelDescribe/findByNovelId/${novelId}`);
        WorldView.value = response.data[0];
        // console.log(WorldView.value)
        // await nextTick(); // 等待Vue更新DOM
        dialogAddVisibleWorldView.value = true;
      } catch (error) {
        ElMessage.error('获取小说信息失败，请稍后重试！');
        console.error('获取小说信息失败:', error);
      }
    };
    const saveNovelDecribe = async () => {
      try {
        // 确保WorldView.value包含小说信息的ID，这是更新操作所必需的
        if (!WorldView.value.id) {
          ElMessage.error('小说信息ID缺失，无法进行更新');
          return;
        }

    // 准备要发送给后端的数据，确保包含小说信息ID以便识别要更新的记录
    const postData = {
          id: WorldView.value.id, // 添加小说ID
          novelDescribe:WorldView.value.novelDescribe,
          // 其他属性...
        };

        // 注意：更新操作通常使用PUT或PATCH方法，而非POST。这里假设后端API支持PUT方法用于更新。
        // 同时，URL中需要包含动态的小说ID。这里使用模板字符串插值方式来插入ID。
        const response = await axios.put(`http://localhost:8084/NovelDescribe/update/${WorldView.value.id}`, postData);

        // 检查响应状态，确保更新成功
        if (response.status === 200) {
          ElMessage.success('小说信息保存成功');
          dialogAddVisibleWorldView.value = false;
        } else {
          ElMessage.error('服务器返回异常状态，更新失败');
        }
      } catch (error) {
        console.error('保存小说信息失败:', error);
        ElMessage.error('保存小说信息失败，请重试！');
      }
    };

    const removeRestwords= () => {
      dialogAddVisibleWorldView.value = true; // 显示添加主角对话框
    };
    // 添加小说信息novelDecribe方法
    const NovelDescribeGainCurrentNovelId= () => {
      dialogAddVisibleWorldView.value = true; // 显示添加主角对话框
    };
    const addNovelDescribe = () => {
      WorldView.value.novelId = route.params.id; // 假设新主角需要知道关联的NovelID
      axios.post('http://localhost:8084/NovelDescribe/insert', WorldView.value)
        .then(response => {
          WorldView.value = {
            novelDescribe:'',
            novelId:''
          };
          // 检查响应状态，确保更新成功
        if (response.status === 200) {
          ElMessage.success('小说信息保存成功');
          dialogAddVisibleWorldView.value = false;
        } else {
          ElMessage.error('服务器返回异常状态，更新失败');
        }
        })
        .catch(error => {
          console.error('保存小说信息失败:', error);
          ElMessage.error('保存小说信息失败，请重试！');
        });
    };

      const queryAllIdNameStoryId = () => {
        dialogAddOrRemoceCharacterVisibleRef.value=true;
        axios.get('http://localhost:8084/api/queryAllIdNameStoryId')
          .then(response => {
            queryCharacter.value = response.data;
          })
          .catch(error => {
            console.log(error);
          });
      };

      const updateCharacter = async () => {
          try {
            // 确保addOrRemoceCharacter.value包含ID，这是更新操作所必需的
            if (!addOrRemoceCharacter.value.id) {
              ElMessage.error('ID缺失，无法进行更新');
              return;
            }

          // 准备要发送给后端的数据，确保包含角色ID以便识别要更新的记录
          const postData = {
              id: addOrRemoceCharacter.value.id, // 添加小说ID
              name:addOrRemoceCharacter.value.name,
              storyId:addOrRemoceCharacter.value.storyId,
              // 其他属性...
            };
            // 注意：更新操作通常使用PUT或PATCH方法，而非POST。这里假设后端API支持PUT方法用于更新。
            // 同时，URL中需要包含动态的小说ID。这里使用模板字符串插值方式来插入ID。
            const response = await axios.put(`http://localhost:8084/api/updateCharacterResponseStoryId/${addOrRemoceCharacter.value.id}`, postData);

            // 检查响应状态，确保更新成功
            if (response.status === 200) {
              ElMessage.success('角色保存成功');
              dialogAddOrRemoceCharacterVisibleRef.value = false;
              findAllWithPagination();
            } else {
              ElMessage.error('服务器返回异常状态，更新失败');
            }
          } catch (error) {
            console.error('保存角色失败:', error);
            ElMessage.error('保存角色失败，请重试！');
          }
    };
    //这段代码会监视addOrRemoceCharacter.id的变化，一旦ID变化，就会执行提供的回调函数，查找对应的角色并更新名称。记得在合适的生命周期位置（如组件的setup函数中）调用此watch函数。
    //这样，即使没有直接绑定@change事件，每当el-select中选择的角色ID变化时，也会触发逻辑自动填充角色名称到相应的输入框中。
    watch(() => addOrRemoceCharacter.value.id, (newId) => {
      const selectedItem = queryCharacter.value.find(item => item.id === newId);
      if(selectedItem) {
        addOrRemoceCharacter.value.name = selectedItem.name; // 当id变化时，自动填充名称
      } else {
        console.warn("No item selected with the provided ID."); // 如果找不到匹配的ID
      }
    });
  
// const findAll = () => {
    //     axios.get('http://localhost:8084/story/findAll')
    //       .then(response => {
    //         info.value = response.data;
    //       })
    //       .catch(error => {
    //         console.log(error);
    //       });
    //   };

const addStory = () => {
  axios.post('http://localhost:8084/story/insert', newStory.value)
    .then(response => {
      newStory.value = {
        StoryName: '',
        Story:''
      };
      findAll();
    })
    .catch(error => {
      console.log(error);
    });
};

const deleteStory = (id) => { // 修改参数为id
axios.get('http://localhost:8084/story/delete?id='+id) // 传入正确的参数
.then(response=>{
  findAll();
})
  .catch(error => {
    console.log(error);
  });
};

    
onMounted(() => {
  findAllWithPagination();
});

return {
      route,
      totalPages,
      info,
      paginatedInfo,
      findMainRoleByNovelId,
      newStory,
      findAllWithPagination,
      addStory,
      deleteStory,
      currentPage,
      prevPage,
      nextPage,
      roleFormRef,
      selectedRole,
      dialogVisible,
      saveRole,
      dialogAddVisibleRef,
      newCharacterRef,
      addCharacterFormRef,
      addCharacter,
      submitRole,
      addMainRole,
      gainCurrentNovelId,
      dialogAddVisibleWorldView,
      WorldView,
      addWorldViewFormRef,
      findNovelDecribeByNovelId,
      saveNovelDecribe,
      NovelDescribeGainCurrentNovelId,
      addNovelDescribe,
      imageId,
      queryAllIdNameStoryId,
      queryCharacter,
      addOrRemoceCharacter,
      dialogAddOrRemoceCharacterVisibleRef,
      updateCharacter
    };
}
};
</script>

<style scoped>
div{text-align: center}

.custom-textarea-style .el-textarea__inner {
  /* 字体大小 */
  font-size: 18px; /* 按需调整字体大小 */

  /* 文字靠左对齐 */
  text-align: left;

  /* 自动换行，保持文本的自然换行 */
  white-space: pre-wrap;

  /* 顶部对齐，可能需要根据实际字体大小调整行高 */
  line-height: 1.5; 

  /* 如果需要调整内外边距，可以根据实际情况调整 */
  padding: 10px; /* 示例值，按需调整 */
}

/* 如果有单行输入框的需求，需要单独处理 */
.custom-textarea-style:not(.is-disabled) .el-input__inner {
  /* 类似于上面的调整，但针对单行输入框 */
}

.grid-container {
  display: grid;
  grid-template-columns: auto auto auto;
  background-color: #2196F3;
  padding: 10px;
}
.grid-item {
  background-color: rgba(255, 255, 255, 0.8);
  border: 1px solid rgba(0, 0, 0, 0.8);
  padding: 30px;
  font-size: 30px;
  text-align: center;
}


</style>