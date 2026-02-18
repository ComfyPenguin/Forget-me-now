<script setup lang="ts">
import { computed, onMounted, ref } from 'vue'
import { useRouter, useRoute } from 'vue-router'

const router = useRouter()
const route = useRoute()

const isLoading = ref(true)           // ← importante para evitar flash de contenido

// Ejecutamos la verificación lo antes posible
onMounted(async () => {
  try {
    // Si tu auth necesita validar token con API (recomendado)
    //await auth.checkAuth()           // o auth.init() / auth.validateSession()
  } catch (err) {
    console.error('Error al verificar sesión', err)
  } finally {
    isLoading.value = false
  }
})
</script>

<template>
  <div class="app-container">
    <!-- Mientras verificamos auth (muy rápido, pero evita contenido parpadeante) -->
    <div v-if="isLoading" class="loading-screen">
      <div class="spinner"></div>
      <p>Cargando...</p>
    </div>

    <!-- Contenido real de la app (solo se muestra cuando ya sabemos si está logueado o no) -->
    <div v-else>
      <router-view />
    </div>
  </div>
</template>
<style scoped>
.app-container {
  min-height: 100vh;
}

.loading-screen {
  height: 100vh;
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
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
</style>