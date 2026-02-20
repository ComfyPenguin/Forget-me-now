<script setup lang="ts">
import { ref } from 'vue'

const props = defineProps({
  form: {
    type: Object,
    required: true
  }
})

const socialPlatforms = [
  { id: 'instagram', name: 'Instagram', icon: '📷', placeholder: '@username' },
  { id: 'x', name: 'X', icon: '𝕏', placeholder: '@username' },
  { id: 'facebook', name: 'Facebook', icon: '👍', placeholder: 'facebook.com/...' }
]

const activeSocial = ref<string | null>(null)

// Initialize social object if doesn't exist
if (!props.form.social) {
  props.form.social = {}
}

const toggleSocial = (platformId: string) => {
  activeSocial.value = activeSocial.value === platformId ? null : platformId
  if (!props.form.social[platformId]) {
    props.form.social[platformId] = ''
  }
}

const removeSocial = (platformId: string) => {
  delete props.form.social[platformId]
  if (activeSocial.value === platformId) {
    activeSocial.value = null
  }
}

const isActive = (platformId: string) => {
  return props.form.social[platformId]
}
</script>

<template>
  <section class="form-section">
    <div class="section-header">
      <div class="section-icon">🌐</div>
      <h2 class="section-title">Redes Sociales</h2>
    </div>

    <div class="section-content">
      <p class="social-description">Selecciona y añade los perfiles de redes sociales de tu centro</p>
      
      <!-- Social Platforms Grid -->
      <div class="social-grid">
        <button
          v-for="platform in socialPlatforms"
          :key="platform.id"
          type="button"
          class="social-button"
          :class="{ 'social-button--active': isActive(platform.id) }"
          @click="toggleSocial(platform.id)"
        >
          <span class="social-icon">{{ platform.icon }}</span>
          <span class="social-name">{{ platform.name }}</span>
        </button>
      </div>

      <!-- Active Social Inputs -->
      <div v-if="Object.keys(form.social).length > 0" class="social-inputs">
        <div
          v-for="(value, platformId) in form.social"
          :key="platformId"
          class="social-input-group"
        >
          <div class="social-input-header">
            <label :for="`social-${platformId}`" class="form-label">
              {{ socialPlatforms.find(p => p.id === platformId)?.name }}
            </label>
            <button
              type="button"
              class="remove-social-btn"
              @click="removeSocial(platformId.toString())"
              title="Eliminar"
            >
              ✕
            </button>
          </div>
          <input
            :id="`social-${platformId}`"
            v-model.trim="form.social[platformId]"
            type="text"
            :placeholder="socialPlatforms.find(p => p.id === platformId)?.placeholder"
            class="form-input"
          />
        </div>
      </div>

      <!-- Empty State -->
      <div v-else class="social-empty">
        <p>Aún no has añadido ninguna red social</p>
      </div>
    </div>
  </section>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/form.css';
</style>