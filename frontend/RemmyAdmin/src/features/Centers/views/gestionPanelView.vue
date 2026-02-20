<script setup lang="ts">
import BaseButton from '@/components/util/baseButton.vue';
import CentersList from '@/components/gestion/centersList.vue';
import backButton from '@/components/util/backButton.vue';

const handleClick = () => {
    console.log('Button clicked!');
};
</script>

<template>
    <div>
        <h1>Gestion Panel</h1>
        <BaseButton variant="primary" :animation-enabled=true @click="handleClick, $router.push('/CreateCenter')" >
            Nuevo Centro
        </BaseButton>
    </div>
    <div>
        <CentersList />
    </div>
    <backButton></backButton>
</template>

<style scoped>
.gestion-panel-container {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  width: 100vw;
  height: 100vh;
  overflow: auto;
  z-index: 100;
}
</style>
