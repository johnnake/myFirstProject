<script setup lang="ts">



</script>

<template>
  <el-container  class="layout-container-demo" style="height: 400px;">
    <el-aside width="200px">
      <el-scrollbar>
        <el-menu>
          <template #title>
              用户
          </template>
          <el-menu-item-group>
            <!--菜单标题title-->
            <template #title>用户</template>
            <el-menu-item index="1-1"><router-link to="/english/practice"><button class="button">单词列表</button></router-link></el-menu-item>
            <el-menu-item index="1-2"><router-link to="/main/addStory"><button class="button">单词添加</button></router-link></el-menu-item>
            <el-menu-item index="1-2-1"><router-link to="/main/StoryShow"><button class="button">单词显示</button></router-link></el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="角色生成和星球和城市">
            <!-- <el-menu-item index="1-3"><router-link to="/main/generateRole"><button class="button">生成角色</button></router-link></el-menu-item>
            <el-menu-item index="1-4"><router-link to="/main/RoleList"><button class="button">角色列表</button></router-link></el-menu-item>
            <el-menu-item index="1-4"><router-link to="/main/RoleAdd"><button class="button">角色添加</button></router-link></el-menu-item> -->
          </el-menu-item-group>
          <!--菜单中的菜单-->
          <el-sub-menu index="1-4">
            <template #title>其他</template>
            <el-menu-item index="1-4-1">添加权限</el-menu-item>
            <el-menu-item index="1-4-2">权限列表</el-menu-item>
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
          </el-sub-menu>
        </el-menu>


      </el-scrollbar>
    </el-aside>
    <el-container>
      <el-header>
        <ul class="breadcrumb">
          <li><router-link to="/main">首页</router-link></li>
          <li><a href="#">英语</a></li>
          <li><a href="#">数学</a></li>
          <li><a href="#">文学</a></li>
        </ul>

      </el-header>
      <el-main>
        <el-scrollbar>
        <router-view/>
        </el-scrollbar>
      </el-main>
    </el-container>
  </el-container>
    
   
</template>

<style scoped>
.layout-container-demo .el-header {
  position: relative;
  background-color: var(--el-color-primary-light-7);
  color: var(--el-text-color-primary);
}
.layout-container-demo .el-aside {
  color: var(--el-text-color-primary);
  background: var(--el-color-primary-light-8);
}
.layout-container-demo .el-menu {
  border-right: none;
}
.layout-container-demo .el-main {
  padding: 0;
}
/* .layout-container-demo .toolbar {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  right: 20px;
} */
/* 按钮 */
.button {
    background-color: #4CAF50; /* 绿色 */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
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


</style>

