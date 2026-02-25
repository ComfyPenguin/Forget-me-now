<script setup lang="ts">
import { onMounted, ref } from 'vue'

const isLoading = ref(true)

onMounted(async () => {
  try {
    // Simular carga inicial
    await new Promise(resolve => setTimeout(resolve, 500))
  } catch (err) {
    console.error('Error al verificar sesión', err)
  } finally {
    isLoading.value = false
  }
})
</script>

<template>
  <!-- Loading Screen -->
  <div v-if="isLoading" class="loading-screen">
    <div class="spinner"></div>
    <p>Cargando...</p>
  </div>

  <!-- App Content -->
  <div v-else>
    <router-view />
  </div>
</template>

<style scoped>
html, body, #app {
  height: 100%;
  width: 100%;
  margin: 0;
  padding: 0;
}

.loading-screen {
  height: 100vh;
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  background: #f8f9fa;
}

.spinner {
  width: 50px;
  height: 50px;
  border: 5px solid #f3f3f3;
  border-top: 5px solid #3498db;
  border-radius: 50%;
  animation: spin 1s linear infinite;
  margin-bottom: 1rem;
}

@keyframes spin {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}
</style>