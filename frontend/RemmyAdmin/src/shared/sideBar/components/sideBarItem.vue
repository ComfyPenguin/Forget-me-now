<script setup lang="ts">
import { computed } from 'vue'
import { useRoute } from 'vue-router'

interface Props {
  label: string
  icon?: string
  to?: string
  children?: Array<{
    label: string
    icon?: string
    to: string
  }>
  onClick?: () => void
  badge?: number | string
  action?: 'link' | 'button' | 'dropdown'
}

const props = withDefaults(defineProps<Props>(), {
  action: 'link'
})

const route = useRoute()
const isActive = computed(() => {
  if (!props.to) return false
  return route.path === props.to || route.path.startsWith(props.to + '/')
})

const isDropdownOpen = ref(false)

import { ref } from 'vue'

const toggleDropdown = () => {
  if (props.action === 'dropdown') {
    isDropdownOpen.value = !isDropdownOpen.value
  }
}
</script>

<template>
  <div class="sidebar-item-wrapper">
    <!-- Link Item -->
    <router-link
      v-if="action === 'link'"
      :to="to || '#'"
      class="sidebar-item"
      :class="{ 'sidebar-item--active': isActive }"
    >
      <span v-if="icon" class="sidebar-item-icon">{{ icon }}</span>
      <span class="sidebar-item-label">{{ label }}</span>
      <span v-if="badge" class="sidebar-item-badge">{{ badge }}</span>
    </router-link>

    <!-- Button Item -->
    <button
      v-else-if="action === 'button'"
      class="sidebar-item"
      @click="onClick"
    >
      <span v-if="icon" class="sidebar-item-icon">{{ icon }}</span>
      <span class="sidebar-item-label">{{ label }}</span>
      <span v-if="badge" class="sidebar-item-badge">{{ badge }}</span>
    </button>

    <!-- Dropdown Item -->
    <div v-else-if="action === 'dropdown'" class="sidebar-dropdown">
      <button
        class="sidebar-item"
        @click="toggleDropdown"
      >
        <span v-if="icon" class="sidebar-item-icon">{{ icon }}</span>
        <span class="sidebar-item-label">{{ label }}</span>
        <span class="dropdown-arrow" :class="{ 'dropdown-arrow--open': isDropdownOpen }">
          ▼
        </span>
      </button>

      <!-- Dropdown Children -->
      <transition name="dropdown">
        <div v-if="isDropdownOpen" class="sidebar-dropdown-content">
          <router-link
            v-for="child in children"
            :key="child.to"
            :to="child.to"
            class="sidebar-dropdown-item"
            :class="{ 'sidebar-dropdown-item--active': route.path === child.to }"
          >
            <span v-if="child.icon" class="sidebar-item-icon">{{ child.icon }}</span>
            <span class="sidebar-item-label">{{ child.label }}</span>
          </router-link>
        </div>
      </transition>
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/form.css';

.sidebar-item-wrapper {
  width: 100%;
}

.sidebar-item {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  width: 100%;
  padding: 0.875rem 1rem;
  background: none;
  border: none;
  color: var(--neutral);
  font-size: 0.9rem;
  font-weight: 500;
  cursor: pointer;
  text-decoration: none;
  transition: all 0.2s;
  text-align: left;
  font-family: inherit;
  border-left: 3px solid transparent;

  &:hover {
    background-color: #f1f5f9;
    color: var(--neutral-darkest);
    padding-left: 1.25rem;
  }

  &--active {
    background-color: var(--primary-lightest);
    color: var(--primary);
    border-left-color: var(--primary);
    font-weight: 600;
    padding-left: 1.25rem;
  }
}

.sidebar-item-icon {
  font-size: 1.25rem;
  flex-shrink: 0;
  display: flex;
  align-items: center;
  justify-content: center;
}

.sidebar-item-label {
  flex: 1;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.sidebar-item-badge {
  background: var(--primary);
  color: white;
  border-radius: 12px;
  padding: 0.25rem 0.5rem;
  font-size: 0.75rem;
  font-weight: 700;
  flex-shrink: 0;
}

.sidebar-dropdown {
  width: 100%;
}

.dropdown-arrow {
  font-size: 0.7rem;
  transition: transform 0.2s;
  flex-shrink: 0;

  &--open {
    transform: rotate(180deg);
  }
}

.sidebar-dropdown-content {
  background-color: #f8fafc;
  border-left: 3px solid var(--primary-light);
}

.sidebar-dropdown-item {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  width: 100%;
  padding: 0.75rem 1rem 0.75rem 2.5rem;
  background: none;
  border: none;
  color: var(--neutral);
  font-size: 0.85rem;
  font-weight: 400;
  cursor: pointer;
  text-decoration: none;
  transition: all 0.2s;
  text-align: left;
  font-family: inherit;
  border-left: 3px solid transparent;

  &:hover {
    background-color: white;
    color: var(--neutral-darkest);
    padding-left: 2.75rem;
  }

  &--active {
    background-color: white;
    color: var(--primary);
    border-left-color: var(--primary);
    font-weight: 600;
    padding-left: 2.75rem;
  }
}

.dropdown-enter-active,
.dropdown-leave-active {
  transition: all 0.2s;
  max-height: 500px;
  overflow: hidden;
}

.dropdown-enter-from,
.dropdown-leave-to {
  max-height: 0;
  opacity: 0;
}
</style>