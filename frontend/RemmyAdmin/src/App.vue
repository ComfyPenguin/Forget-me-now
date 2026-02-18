<script setup lang="ts">
import {onMounted, ref } from 'vue'

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
    <!-- Mientras verificamos auth (muy rápido, pero evita contenido parpadeante) -->
    <div v-if="isLoading" class="loading-screen">
      <div class="spinner"></div>
      <p>Cargando...</p>
    </div>

    <!-- Contenido real de la app (solo se muestra cuando ya sabemos si está logueado o no) -->
    <div v-else class="app-wrapper">
  <router-view />
</div>
</template>
<style scoped>
/* Asegura que TODO el viewport esté disponible (muy importante) */
html, body, #app {
  height: 100%;
  margin: 0;
  padding: 0;
  width: 100%;
}

.app-wrapper {
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
}

/* Contenedor que envuelve router-view (crece automáticamente) */
.main-content {
  flex: 1 1 auto;              /* ← esto hace que crezca y ocupe todo el espacio sobrante */
  width: 100%;
  min-height: 100%;            /* opcional pero útil en algunos navegadores */
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

/* Loading (lo que ya tenías, sin cambios) */
.loading-screen {
  height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  background: #f8f9fa;
  width: 100%;                 /* ← asegúrate también aquí */
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