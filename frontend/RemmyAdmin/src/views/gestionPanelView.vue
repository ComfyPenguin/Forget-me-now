<script setup lang="ts">
import BaseButton from '@/components/util/baseButton.vue';

const handleClick = () => {
    console.log('Button clicked!');
};
</script>

<template>
    <div class="gestion-panel">
        <h1>Gestion Panel</h1>
        <BaseButton variant="primary" @click="handleClick">
            Click Me
        </BaseButton>
    </div>
</template>

<style scoped>
.gestion-panel {
    padding: 20px;
}

.gestion-panel h1 {
    margin-bottom: 20px;
}
</style>