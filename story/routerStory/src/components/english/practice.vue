<template>
    <div>
        <ul v-for="(subArray, outerIndex) in info" :key="outerIndex">
            <li v-for="(value, innerIndex) in subArray" :key="innerIndex">
            {{ value }}
            </li>  
        </ul>
    </div>

</template>

<script>
import { ref } from 'vue';


export default {
  setup() {   
    const info = ref([
        ['are you like play video games?', 'yes,I like.','I am a docter!,who are you?'],
        ['我是一名医生！', '你是谁？']
    ]);

    return {
        info,
    };
  },
};

</script>

<style scoped>

</style>