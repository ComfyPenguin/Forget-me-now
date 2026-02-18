<script setup lang="ts">
import BaseButton from '@/components/util/baseButton.vue';
import CentersList from '@/components/gestion/centersList.vue';
import backButton from '@/components/util/backButton.vue';

const handleClick = () => {
    console.log('Button clicked!');
};
</script>

<template>
    <div class="gestion-panel">
        <h1>Gestion Panel</h1>
        <BaseButton variant="primary" @click="handleClick, $router.push('/CreateCenter')" >
            Nuevo Centro
        </BaseButton>
    </div>
    <div>
        <CentersList />
    </div>
    <backButton></backButton>
</template>

<style scoped>
.gestion-panel {
    padding: 20px;
}

.gestion-panel h1 {
    margin-bottom: 20px;
}
</style>
