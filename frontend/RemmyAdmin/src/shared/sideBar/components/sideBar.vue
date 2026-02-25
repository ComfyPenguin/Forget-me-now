<script lang="ts" setup>
import SidebarItem from './sideBarItem.vue'
</script>

<template>
  <nav class="sidebar">
    <div class="sidebar-logo">
      <router-link to="/" class="logo-link">
        <span class="logo-icon">📊</span>
      </router-link>
    </div>

    <div class="sidebar-menu">
      <SidebarItem 
        label="Dashboard"
        icon="📊" 
        to="/Dashboard" 
        action="link"
      />
      <SidebarItem 
        label="Gestión de Centros"
        icon="🏢" 
        to="/GestionPanel" 
        action="link"
      />
      <SidebarItem 
        label="Reportes"
        icon="📈" 
        to="/Reportes" 
        action="link"
      />
      <SidebarItem 
        label="Usuarios"
        icon="👥" 
        to="/Usuarios" 
        action="link"
      />
      <SidebarItem 
        label="Configuración"
        icon="⚙️" 
        to="/Configuracion" 
        action="link"
      />
    </div>

    <div class="sidebar-footer">
      <SidebarItem 
        label="Ayuda"
        icon="❓" 
        action="button"
        @click="handleHelp"
      />
    </div>
  </nav>
</template>

<script lang="ts">
function handleHelp() {
  console.log('Help clicked');
}
</script>

<style scoped>
.sidebar {
  display: flex;
  flex-direction: column;
  width: 70px;
  height: 100vh;
  background-color: #1e293b;
  border-right: 1px solid #334155;
  padding: 0.5rem 0;
  overflow-y: auto;
}

.sidebar-logo {
  display: flex;
  justify-content: center;
  padding: 1rem 0;
  border-bottom: 1px solid #334155;
  margin-bottom: 0.5rem;
}

.logo-link {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 48px;
  height: 48px;
  border-radius: 8px;
  background-color: #3b82f6;
  text-decoration: none;
  transition: background-color 0.2s;
}

.logo-link:hover {
  background-color: #2563eb;
}

.logo-icon {
  font-size: 1.5rem;
}

.sidebar-menu {
  flex: 1;
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
  padding: 0.5rem;
}

.sidebar-footer {
  padding-top: 1rem;
  border-top: 1px solid #334155;
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
  padding: 0.5rem;
}

/* Custom scrollbar */
.sidebar::-webkit-scrollbar {
  width: 6px;
}

.sidebar::-webkit-scrollbar-track {
  background: transparent;
}

.sidebar::-webkit-scrollbar-thumb {
  background: #475569;
  border-radius: 3px;
}

.sidebar::-webkit-scrollbar-thumb:hover {
  background: #64748b;
}

@media (max-width: 768px) {
  .sidebar {
    width: 60px;
  }
}
</style>