<script setup lang="ts">
import { ref } from 'vue'

const props = defineProps({
  form: {
    type: Object,
    required: true
  }
})

const characteristics = [
  { id: 'accesibilidad', name: 'Accesibilidad', icon: '♿' },
  { id: 'wifi', name: 'Wi-Fi Gratis', icon: '📶' },
  { id: 'comida', name: 'Comida', icon: '🍽️' },
  { id: 'duchase', name: 'Duchas', icon: '🚿' },
  { id: 'camas', name: 'Camas', icon: '🛏️' },
  { id: 'medico', name: 'Asistencia Médica', icon: '⚕️' },
  { id: 'psicologia', name: 'Apoyo Psicológico', icon: '💭' },
  { id: 'legal', name: 'Asesoría Legal', icon: '⚖️' },
  { id: 'educacion', name: 'Educación', icon: '📚' },
  { id: 'cuidado_ninos', name: 'Cuidado de Niños', icon: '👶' },
  { id: 'actividades', name: 'Actividades', icon: '🎯' },
  { id: 'transporte', name: 'Transporte', icon: '🚌' },
]

// Initialize characteristics array if doesn't exist
if (!Array.isArray(props.form.characteristics)) {
  props.form.characteristics = []
}

const toggleCharacteristic = (characteristicId: string) => {
  const index = props.form.characteristics.indexOf(characteristicId)
  if (index > -1) {
    props.form.characteristics.splice(index, 1)
  } else {
    props.form.characteristics.push(characteristicId)
  }
}

const isSelected = (characteristicId: string) => {
  return props.form.characteristics.includes(characteristicId)
}

const getCharacteristicName = (id: string) => {
  return characteristics.find(c => c.id === id)?.name || id
}
</script>

<template>
  <section class="form-section">
    <div class="section-header">
      <div class="section-icon">⭐</div>
      <h2 class="section-title">Características del Centro</h2>
    </div>

    <div class="section-content">
      <p class="characteristics-description">Selecciona las características y servicios que ofrece tu centro</p>
      
      <!-- Characteristics Grid -->
      <div class="characteristics-grid">
        <button
          v-for="char in characteristics"
          :key="char.id"
          type="button"
          class="characteristic-button"
          :class="{ 'characteristic-button--selected': isSelected(char.id) }"
          @click="toggleCharacteristic(char.id)"
        >
          <span class="characteristic-icon">{{ char.icon }}</span>
          <span class="characteristic-name">{{ char.name }}</span>
        </button>
      </div>

      <!-- Selected Characteristics Summary -->
      <div v-if="form.characteristics.length > 0" class="characteristics-summary">
        <div class="characteristics-summary-header">
          <span class="characteristics-count">{{ form.characteristics.length }} característica{{ form.characteristics.length !== 1 ? 's' : '' }} seleccionada{{ form.characteristics.length !== 1 ? 's' : '' }}</span>
        </div>
        <div class="characteristics-tags">
          <div
            v-for="charId in form.characteristics"
            :key="charId"
            class="characteristic-tag"
          >
            <span class="tag-icon">{{ characteristics.find(c => c.id === charId)?.icon }}</span>
            <span class="tag-name">{{ getCharacteristicName(charId) }}</span>
          </div>
        </div>
      </div>

      <!-- Empty State -->
      <div v-else class="characteristics-empty">
        <p>Selecciona las características que ofrece tu centro</p>
      </div>
    </div>
  </section>
</template>

<style lang="scss" scoped>
@import '../../styles/form.css';
</style>