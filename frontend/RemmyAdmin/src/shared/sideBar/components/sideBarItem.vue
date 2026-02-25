<script setup lang="ts">
import { computed } from 'vue'
import { useRoute } from 'vue-router'
import { ref } from 'vue'

interface Props {
  label: string
  icon?: string
  to?: string
  onClick?: () => void
  action?: 'link' | 'button'
}

const props = withDefaults(defineProps<Props>(), {
  action: 'link'
})

const route = useRoute()
const isActive = computed(() => {
  if (!props.to) return false
  return route.path === props.to || route.path.startsWith(props.to + '/')
})

const showTooltip = ref(false)

const toggleTooltip = () => {
  showTooltip.value = !showTooltip.value
}

const hideTooltip = () => {
  showTooltip.value = false
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
      @mouseenter="showTooltip = true"
      @mouseleave="showTooltip = false"
      :title="label"
    >
      <span v-if="icon" class="sidebar-item-icon">{{ icon }}</span>
      <span v-if="showTooltip" class="tooltip">{{ label }}</span>
    </router-link>

    <!-- Button Item -->
    <button
      v-else-if="action === 'button'"
      class="sidebar-item"
      @click="onClick"
      @mouseenter="showTooltip = true"
      @mouseleave="showTooltip = false"
      :title="label"
    >
      <span v-if="icon" class="sidebar-item-icon">{{ icon }}</span>
      <span v-if="showTooltip" class="tooltip">{{ label }}</span>
    </button>
  </div>
</template>

<style lang="scss" scoped>
.sidebar-item-wrapper {
  width: 100%;
}

.sidebar-item {
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 48px;
  background: none;
  border: none;
  color: #cbd5e1;
  font-size: 1.5rem;
  cursor: pointer;
  text-decoration: none;
  transition: all 0.2s;
  border-radius: 8px;
  padding: 0;
  margin: 0;

  &:hover {
    background-color: #334155;
    color: #f1f5f9;
  }

  &--active {
    background-color: #3b82f6;
    color: #ffffff;
    font-weight: 600;
  }
}

.sidebar-item-icon {
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 1.25rem;
}

.tooltip {
  position: absolute;
  left: 100%;
  top: 50%;
  transform: translateY(-50%);
  margin-left: 0.5rem;
  background-color: #0f172a;
  color: #f1f5f9;
  padding: 0.5rem 0.75rem;
  border-radius: 6px;
  white-space: nowrap;
  font-size: 0.85rem;
  font-weight: 500;
  pointer-events: none;
  z-index: 1000;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.3);
  
  &::before {
    content: '';
    position: absolute;
    right: 100%;
    top: 50%;
    transform: translateY(-50%);
    border: 6px solid transparent;
    border-right-color: #0f172a;
  }
}
</style>