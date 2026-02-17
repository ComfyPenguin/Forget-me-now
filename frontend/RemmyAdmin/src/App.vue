<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <!-- Navigation always stays at the top -->
  <nav class="navbar">
    <div class="nav-container">
      <RouterLink to="/login" class="nav-link">Login</RouterLink>
      <RouterLink to="/GestionPanel" class="nav-link">Gestion Panel</RouterLink>
    </div>
  </nav>
  <RouterView />
</template>

<style scoped>
.navbar {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  height: 64px;           /* ← you can change this value */
  background-color: white;
  border-bottom: 1px solid #e5e7eb;
  box-shadow: 0 1px 3px rgba(0,0,0,0.1);
  z-index: 1000;
}

.nav-container {
  margin: 0 auto;
  height: 100%;
  padding: 0 1.5rem;

  display: flex;
  align-items: center;
  gap: 2.5rem;
}

.nav-link {
  text-decoration: none;
  color: #374151;
  font-weight: 500;
  font-size: 1.05rem;
  padding: 0.5rem 0;
  transition: all 0.2s;
}

.nav-link:hover {
  color: #2563eb;
}

.nav-link.router-link-exact-active {
  color: #2563eb;
  border-bottom: 2px solid #2563eb;
}


</style>