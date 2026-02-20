<script setup lang="ts">
defineProps<{
  label?: string // Prop para cambiar la etiqueta, por defecto es volver.
}>()

const emit = defineEmits<{
  click: []
}>()

const handleClick = () => {
  emit('click')
}
</script>

<template>
  <button class="back-button" @click="handleClick">
    <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
      <path d="M19 12H5M12 19l-7-7 7-7"/>
    </svg>
    {{ label || 'Volver' }}
  </button>
</template>

<style scoped>
.back-button {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  padding: 0.5rem 1rem;
  background: transparent;
  border: none;
  color: inherit;
  cursor: pointer;
  font-size: 0.95rem;
  transition: opacity 0.2s;
}

.back-button:hover {
  opacity: 0.7;
}
</style>
