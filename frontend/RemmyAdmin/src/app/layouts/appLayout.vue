<script setup lang="ts">
import Sidebar from '@/shared/sideBar/components/sideBar.vue'
</script>

<template>
  <div class="app-layout">
    <Sidebar />
    <div class="app-main">
      <router-view />
    </div>
  </div>
</template>

<style scoped>
.app-layout {
  display: flex;
  height: 100vh;
  width: 100%;
}

.app-main {
  flex: 1;
  overflow-y: auto;
  overflow-x: hidden;
  background-color: #f8fafc;
  min-width: 0;
}

/* Custom scrollbar */
.app-main::-webkit-scrollbar {
  width: 8px;
}

.app-main::-webkit-scrollbar-track {
  background: transparent;
}

.app-main::-webkit-scrollbar-thumb {
  background: #cbd5e1;
  border-radius: 4px;
}

.app-main::-webkit-scrollbar-thumb:hover {
  background: #94a3b8;
}

@media (max-width: 768px) {
  .app-layout {
    flex-direction: column;
  }

  .app-main {
    flex: 1;
  }
}
</style>