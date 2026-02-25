<script setup lang="ts">
import { ref, computed } from 'vue'
import { useRouter } from 'vue-router'
import SideBarItem from '@/shared/sideBar/components/sideBarItem.vue'

interface NavItem {
  label: string
  icon: string
  to?: string
  action?: 'link' | 'button' | 'dropdown'
  badge?: number | string
  onClick?: () => void
  children?: Array<{
    label: string
    icon?: string
    to: string
  }>
}

const router = useRouter()
const isSidebarOpen = ref(true)
const isCollapsed = ref(false)

const navItems: NavItem[] = [
  {
    label: 'Dashboard',
    icon: '📊',
    to: '/dashboard',
    action: 'link'
  },
  {
    label: 'Gestión de Centros',
    icon: '🏢',
    to: '/GestionPanel',
    action: 'link'
  },
  {
    label: 'Reportes',
    icon: '📈',
    action: 'dropdown',
    children: [
      {
        label: 'Actividad',
        icon: '📋',
        to: '/reports/activity'
      },
      {
        label: 'Estadísticas',
        icon: '📊',
        to: '/reports/statistics'
      },
      {
        label: 'Exportar',
        icon: '⬇️',
        to: '/reports/export'
      }
    ]
  },
  {
    label: 'Usuarios',
    icon: '👥',
    action: 'dropdown',
    children: [
      {
        label: 'Listar Usuarios',
        icon: '📋',
        to: '/users/list'
      },
      {
        label: 'Crear Usuario',
        icon: '➕',
        to: '/users/create'
      },
      {
        label: 'Roles y Permisos',
        icon: '🔐',
        to: '/users/roles'
      }
    ]
  },
  {
    label: 'Configuración',
    icon: '⚙️',
    to: '/settings',
    action: 'link'
  },
  {
    label: 'Ayuda',
    icon: '❓',
    action: 'button',
    onClick: () => {
      alert('Abre formulario de soporte')
    }
  }
]

const handleLogout = () => {
  if (confirm('¿Estás seguro de que deseas cerrar sesión?')) {
    router.push('/login')
  }
}

const toggleSidebar = () => {
  isCollapsed.value = !isCollapsed.value
}
</script>

<template>
  <div class="sidebar-wrapper" :class="{ 'sidebar-wrapper--collapsed': isCollapsed }">
    <!-- Sidebar Header -->
    <div class="sidebar-header">
      <div class="sidebar-logo">
        <span class="logo-icon">🏛️</span>
        <span v-if="!isCollapsed" class="logo-text">Gestión Solidaria</span>
      </div>
      <button class="sidebar-toggle-btn" @click="toggleSidebar" :title="isCollapsed ? 'Expandir' : 'Contraer'">
        {{ isCollapsed ? '→' : '←' }}
      </button>
    </div>

    <!-- Sidebar Navigation -->
    <nav class="sidebar-nav">
      <SideBarItem
        v-for="item in navItems"
        :key="item.label"
        :label="item.label"
        :icon="item.icon"
        :to="item.to"
        :action="item.action"
        :badge="item.badge"
        :children="item.children"
        :onClick="item.onClick"
      />
    </nav>

    <!-- Sidebar Footer -->
    <div class="sidebar-footer">
      <button class="sidebar-footer-btn logout-btn" @click="handleLogout">
        <span class="footer-icon">🚪</span>
        <span v-if="!isCollapsed" class="footer-label">Cerrar Sesión</span>
      </button>
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/form.css';

.sidebar-wrapper {
  width: 280px;
  height: 100vh;
  background: white;
  border-right: 1px solid #e5e7eb;
  display: flex;
  flex-direction: column;
  position: fixed;
  left: 0;
  top: 0;
  z-index: 50;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
  transition: width 0.3s ease;

  &--collapsed {
    width: 80px;

    .logo-text {
      display: none;
    }

    .sidebar-nav .sidebar-item-label,
    .footer-label {
      display: none;
    }

    .sidebar-item {
      justify-content: center;
    }

    .sidebar-item-icon {
      margin: 0;
    }
  }
}

.sidebar-header {
  padding: 1.5rem 1rem;
  border-bottom: 2px solid #f1f5f9;
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 0.75rem;
}

.sidebar-logo {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  flex: 1;
  min-width: 0;
}

.logo-icon {
  font-size: 1.5rem;
  flex-shrink: 0;
}

.logo-text {
  font-size: 0.95rem;
  font-weight: 700;
  color: var(--neutral-darkest);
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.sidebar-toggle-btn {
  background: none;
  border: none;
  color: var(--neutral);
  font-size: 1rem;
  cursor: pointer;
  padding: 0.25rem;
  transition: color 0.2s;
  flex-shrink: 0;
}

.sidebar-toggle-btn:hover {
  color: var(--neutral-darkest);
}

.sidebar-nav {
  flex: 1;
  overflow-y: auto;
  padding: 0.75rem 0;

  &::-webkit-scrollbar {
    width: 6px;
  }

  &::-webkit-scrollbar-track {
    background: transparent;
  }

  &::-webkit-scrollbar-thumb {
    background: #cbd5e1;
    border-radius: 3px;

    &:hover {
      background: #94a3b8;
    }
  }
}

.sidebar-footer {
  padding: 1rem;
  border-top: 1px solid #e5e7eb;
  background-color: #f8fafc;
}

.sidebar-footer-btn {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  width: 100%;
  padding: 0.875rem 1rem;
  background: none;
  border: none;
  color: #ef4444;
  font-size: 0.9rem;
  font-weight: 500;
  cursor: pointer;
  text-decoration: none;
  transition: all 0.2s;
  text-align: left;
  font-family: inherit;
  border-radius: 6px;

  &:hover {
    background-color: rgba(239, 68, 68, 0.1);
    color: #dc2626;
  }

  &.logout-btn {
    color: #ef4444;

    &:hover {
      background-color: rgba(239, 68, 68, 0.1);
    }
  }
}

.footer-icon {
  font-size: 1.125rem;
  flex-shrink: 0;
}

.footer-label {
  flex: 1;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

/* Responsive */
@media (max-width: 768px) {
  .sidebar-wrapper {
    width: 80px;
    position: fixed;
    left: 0;
    top: 0;
  }

  .sidebar-wrapper--collapsed {
    width: 80px;
  }

  .logo-text {
    display: none;
  }

  .sidebar-nav .sidebar-item-label,
  .footer-label {
    display: none;
  }

  .sidebar-item {
    justify-content: center;
  }

  .sidebar-item-icon {
    margin: 0;
  }

  .sidebar-header {
    flex-direction: column;
    justify-content: center;
    padding: 1rem 0.5rem;
  }

  .sidebar-toggle-btn {
    display: none;
  }

  .sidebar-nav {
    padding: 0.5rem 0;
  }

  .sidebar-footer-btn {
    padding: 0.75rem 0.5rem;
    justify-content: center;
  }
}
</style>