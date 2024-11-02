import { createRouter,createWebHistory,createWebHashHistory } from 'vue-router'
//import LoginPage from '../components/common/LoginPage.vue';
import Register from '../components/common/Register.vue';
import login from '../components/common/Login.vue';
import main from '../components/common/main.vue';
import addStory from '../components/storyList/addStory.vue';
import storyList from '../components/storyList/storyList.vue';
import StoryShow from '../components/storyList/StoryShow.vue';
import generateRole from '../components/generate/generateRole.vue';
import RoleList from '../components/generate/RoleList.vue';
import RoleAdd from '../components/generate/RoleAdd.vue';
import english from '../components/common/english.vue';
import practice from '../components/english/practice.vue';
import StoryImage from '../components/storyList/storyImage.vue';
import StoryListMain from '../components/storyList/storyListMain.vue'

const routes = [

    {
        path:'/Register',
        components: {
            default: Register,
          },
    },
    {
        path:'/login',
        components: {
            default: login,
          },
    },
    {
        path:'/english',
        components: {
            default: english,
          },

           //二级路由
        children:[
            {
                path: '/english/practice',
                component:practice
            }
        ]
    },
    // {
    //     path:'/generateRole',
    //     components: {
    //         default: generateRole,
    //       },
    // },
    //优先显示组件<review>,这里是让访问的用户优先进行登入才能进行后续操作
    {
        path: '',
        redirect:'/login'
    },
    {
        path: '/main',
        component:main,
       
        //二级路由
        children:[
            {
                path: '/main/storyList/:id', // 注意这里的:id表示动态参数
                name: 'storyList',
                component:storyList// 引入实际的组件路径
              },
            // {
            //     path: '/main/storyList',
            //     component:storyList
            // },
            {
                path: '/main/addStory',
                component:addStory
            },
            {
                path: '/main/addStory/:id', // 注意这里的:id表示动态参数
                name: 'addStory',
                component:addStory// 引入实际的组件路径
              },
            // {
            //     path: '/main/StoryShow',
            //     component:StoryShow
            // },
            {
                path: '/main/StoryShow/:id', // 注意这里的:id表示动态参数
                name: 'StoryShow',
                component:StoryShow// 引入实际的组件路径
              },
            {
                path: '/main/generateRole',
                component:generateRole
            },
            {
                path: '/main/RoleList',
                component:RoleList
            },
            {
                path: '/main/RoleAdd',
                component:RoleAdd
            },
            {
                path: '/main/StoryImage',
                component:StoryImage
            },{
                path: '/main/StoryListMain',
                component:StoryListMain
            }
        ]
    },
    

]

const router = createRouter({
    // history: createWebHistory(),
    history:createWebHashHistory(),
    routes,
})

export default router;

