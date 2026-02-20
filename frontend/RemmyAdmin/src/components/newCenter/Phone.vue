<script setup lang="ts">
import { ref } from 'vue'

const props = defineProps({
  form: {
    type: Object,
    required: true
  }
})

const newPhone = ref('')
const phoneError = ref('')

// Initialize phone array if doesn't exist
if (!Array.isArray(props.form.phone)) {
  props.form.phone = []
}

const validatePhone = (phone: string): boolean => {
  // Accept various phone formats: +34 600 000 000, 600000000, +34600000000, etc.
  const phoneRegex = /^(\+\d{1,3})?\s?(\d{1,4}[\s\-]?)*\d{1,4}$/
  return phoneRegex.test(phone.replace(/\s/g, '')) && phone.replace(/\D/g, '').length >= 9
}

const formatPhone = (phone: string): string => {
  // Keep the format the user entered
  return phone.trim()
}

const addPhone = () => {
  const phone = newPhone.value.trim()
  
  if (!phone) {
    phoneError.value = 'Por favor ingresa un número de teléfono'
    return
  }

  if (!validatePhone(phone)) {
    phoneError.value = 'Por favor ingresa un teléfono válido (mínimo 9 dígitos)'
    return
  }

  if (props.form.phone.includes(phone)) {
    phoneError.value = 'Este teléfono ya ha sido añadido'
    return
  }

  props.form.phone.push(formatPhone(phone))
  newPhone.value = ''
  phoneError.value = ''
}

const removePhone = (index: number) => {
  props.form.phone.splice(index, 1)
}

const handleKeyPress = (event: KeyboardEvent) => {
  if (event.key === 'Enter') {
    event.preventDefault()
    addPhone()
  }
}
</script>

<template>
  <section class="form-section">
    <div class="section-header">
      <div class="section-icon">📱</div>
      <h2 class="section-title">Números de Teléfono</h2>
    </div>

    <div class="section-content">
      <p class="phone-description">Añade todos los números de teléfono de contacto de tu centro</p>
      
      <!-- Phone Input Section -->
      <div class="phone-input-section">
        <div class="phone-input-group">
          <input
            v-model.trim="newPhone"
            type="tel"
            placeholder="+34 600 000 000"
            class="form-input phone-input"
            @keypress="handleKeyPress"
          />
          <button
            type="button"
            class="btn-add-phone"
            @click="addPhone"
          >
            <span class="btn-plus">+</span>
            Añadir
          </button>
        </div>
        <div v-if="phoneError" class="phone-error">{{ phoneError }}</div>
      </div>

      <!-- Phone List -->
      <div v-if="form.phone.length > 0" class="phone-list">
        <div class="phone-list-header">
          <span class="phone-count">{{ form.phone.length }} teléfono{{ form.phone.length !== 1 ? 's' : '' }}</span>
        </div>
        <div class="phone-items">
          <div
            v-for="(phone, index) in form.phone"
            :key="index"
            class="phone-item"
          >
            <div class="phone-item-content">
              <span class="phone-icon">☎️</span>
              <span class="phone-text">{{ phone }}</span>
            </div>
            <button
              type="button"
              class="remove-phone-btn"
              @click="removePhone(index)"
              title="Eliminar"
            >
              ✕
            </button>
          </div>
        </div>
      </div>

      <!-- Empty State -->
      <div v-else class="phone-empty">
        <p>Aún no has añadido ningún número de teléfono</p>
      </div>
    </div>
  </section>
</template>

<style lang="scss" scoped>
@import '../../presentation/styles/form.css';
</style>