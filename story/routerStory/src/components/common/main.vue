<script setup lang="ts">
</script>

<template>

    <el-container class="layout-container-demo" style="height: 848px;">
      <el-header>
        <div class="mb-4" style="display: flex; justify-content: center; align-items: center; height: auto; padding: 0;">
        
        <el-button type="primary" plain><router-link to="/main"><span>首页</span></router-link></el-button>
        <el-button type="success" plain><router-link to="/english"><span>英语</span></router-link></el-button>
        <el-button type="info" plain><span>数学</span></el-button>
        <el-button plain><span>小说</span></el-button>
        <!-- <el-button type="warning" plain>Warning</el-button>
        <el-button type="danger" plain>Danger</el-button> -->
      </div>
        <el-divider />
      </el-header>
      <el-container>
        <el-aside width="200px">
          <el-scrollbar>
            <el-menu>
              <template #title>
                  用户
              </template>
              <el-menu-item-group>
                <!--菜单标题title-->
                <!-- <template #title>用户</template> -->
                <el-menu-item index="1-1">
                    <button>
                      <span><router-link to="/main/StoryListMain" style="text-decoration: none; color: yellowg;">故事列表</router-link></span>
                    </button>
                </el-menu-item><br>
                <!-- <el-menu-item index="1-2"><button><router-link to="/main/addStory" style="text-decoration: none; color: yellowg;">故事添加</router-link></button></el-menu-item><br> -->
                <el-menu-item index="1-2-2"><button><router-link to="/main/StoryImage" style="text-decoration: none; color: yellowg;">故事图片</router-link></button></el-menu-item><br>
              </el-menu-item-group>
              <el-menu-item-group title="">
                <el-menu-item index="1-3"><button><router-link to="/main/generateRole" style="text-decoration: none; color: yellowg;">生成角色</router-link></button></el-menu-item><br>
                <el-menu-item index="1-4"><button><router-link to="/main/RoleList" style="text-decoration: none; color: yellowg;">角色列表</router-link></button></el-menu-item><br>
                <el-menu-item index="1-4"><button><router-link to="/main/RoleAdd" style="text-decoration: none; color: yellowg;">角色添加</router-link></button></el-menu-item><br>
              </el-menu-item-group>
              <!--菜单中的菜单-->
              <!-- <el-sub-menu index="1-4">
                <template #title>其他</template>
                <el-menu-item index="1-4-1"></el-menu-item>
                <el-menu-item index="1-4-2"></el-menu-item>
              </el-sub-menu>
              
              <el-sub-menu index="2">
                <template #title>
                  其他
                </template>
                <el-menu-item-group>
                  <template #title>Group 1</template>
                  <el-menu-item index="2-1">Option 1</el-menu-item>
                  <el-menu-item index="2-2">Option 2</el-menu-item>
                </el-menu-item-group>
                <el-menu-item-group title="Group 2">
                  <el-menu-item index="2-3">Option 3</el-menu-item>
                </el-menu-item-group>
                <el-sub-menu index="2-4">
                  <template #title>Option 4</template>
                  <el-menu-item index="2-4-1">Option 4-1</el-menu-item>
                </el-sub-menu>
              </el-sub-menu>-->
            </el-menu> 
          </el-scrollbar>
        </el-aside>
        <el-container>
          <el-main>
            <el-scrollbar>
            <router-view/>
            </el-scrollbar>
          </el-main>
          <!-- <el-footer>Footer</el-footer> -->
        </el-container>
      </el-container>
    </el-container>


    
   
</template>

<style scoped>
.layout-container-demo .el-header {
  margin-top: 20px; /* 添加顶部外边距 */
  position: relative;
  background-color: white(--el-color-primary-light-7);
  color: var(--el-text-color-primary);
}


.left-shift {
  padding-left: 1570px; /* 或者使用margin-left */
}
.right-shift {
  padding-right: 30px; /* 或者使用margin-right 和 float:right; 但需注意清除浮动的影响 */
}

.layout-container-demo .el-aside {
  color: var(--el-text-color-primary);
  background: white(--el-color-primary-light-8);
  margin-top: 20px; /* 添加顶部外边距 */
}
.layout-container-demo .el-menu {
  border-right: none;
}
.layout-container-demo .el-main {
  padding: 0;
  margin-top: 5px; /* 添加顶部外边距 */
}
/* .layout-container-demo .toolbar {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  right: 20px;
} */

/* 。。导航栏 */
ul.breadcrumb {
    padding: 8px 16px;
    list-style: none;
    /* background-color: #eeeeee; */
}
ul.breadcrumb li {display: inline;}
ul.breadcrumb li+li:before {
    padding: 8px;
    color: black;
    content: "/\00a0";
}
ul.breadcrumb li a {color: green;}



/*特效button*/
button {
  background: #fff;
  border: none;
  padding: 10px 20px;
  display: inline-block;
  font-size: 15px;
  font-weight: 600;
  width: 120px;
  text-transform: uppercase;
  cursor: pointer;
  transform: skew(-21deg);
  /* padding: 10px 0px; 第一个值控制上下内边距，第二个值控制左右内边距，可以根据需要调整 */
}
/*在你提供的CSS代码中，导致按钮内文字倾斜的原因是button选择器下的transform: skew(-21deg);这一行代码。
这行代码应用了一个斜切变换（skew transformation）给按钮，使得按钮及其内容（包括里面的文字）沿X轴倾斜了21度。

为了让按钮背景产生倾斜效果而内部文字保持水平，你已经正确地在span选择器内使用了transform: skew(21deg);来抵消按钮的倾斜效果。
这意味着如果你将文本包裹在<span>标签中，文本应当会呈现为水平状态，不受按钮倾斜的影响*/
span {
  display: inline-block;
  transform: skew(21deg);
}

button::before {
  content: '';
  position: absolute;
  top: 0;
  bottom: 0;
  right: 100%;
  left: 0;
  background: rgb(20, 20, 20);
  opacity: 0;
  z-index: -1;
  transition: all 0.5s;
}

button:hover {
  color: #fff;
}

button:hover::before {
  left: 0;
  right: 0;
  opacity: 1;
}

/*el—header-bottun*/




</style>

