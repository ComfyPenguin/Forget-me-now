<script setup lang="ts">
import { ref } from 'vue'

const props = defineProps({
  form: {
    type: Object,
    required: true
  }
})

const newEmail = ref('')
const emailError = ref('')

// Initialize email array if doesn't exist
if (!Array.isArray(props.form.email)) {
  props.form.email = []
}

const validateEmail = (email: string): boolean => {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
  return emailRegex.test(email)
}

const addEmail = () => {
  const email = newEmail.value.trim()
  
  if (!email) {
    emailError.value = 'Por favor ingresa un correo electrónico'
    return
  }

  if (!validateEmail(email)) {
    emailError.value = 'Por favor ingresa un correo válido'
    return
  }

  if (props.form.email.includes(email)) {
    emailError.value = 'Este correo ya ha sido añadido'
    return
  }

  props.form.email.push(email)
  newEmail.value = ''
  emailError.value = ''
}

const removeEmail = (index: number) => {
  props.form.email.splice(index, 1)
}

const handleKeyPress = (event: KeyboardEvent) => {
  if (event.key === 'Enter') {
    event.preventDefault()
    addEmail()
  }
}
</script>

<template>
  <section class="form-section">
    <div class="section-header">
      <div class="section-icon">✉️</div>
      <h2 class="section-title">Correos Electrónicos</h2>
    </div>

    <div class="section-content">
      <p class="email-description">Añade todos los correos electrónicos de contacto de tu centro</p>
      
      <!-- Email Input Section -->
      <div class="email-input-section">
        <div class="email-input-group">
          <input
            v-model.trim="newEmail"
            type="email"
            placeholder="ejemplo@correo.com"
            class="form-input email-input"
            @keypress="handleKeyPress"
          />
          <button
            type="button"
            class="btn-add-email"
            @click="addEmail"
          >
            <span class="btn-plus">+</span>
            Añadir
          </button>
        </div>
        <div v-if="emailError" class="email-error">{{ emailError }}</div>
      </div>

      <!-- Email List -->
      <div v-if="form.email.length > 0" class="email-list">
        <div class="email-list-header">
          <span class="email-count">{{ form.email.length }} correo{{ form.email.length !== 1 ? 's' : '' }}</span>
        </div>
        <div class="email-items">
          <div
            v-for="(email, index) in form.email"
            :key="index"
            class="email-item"
          >
            <div class="email-item-content">
              <span class="email-icon">📧</span>
              <span class="email-text">{{ email }}</span>
            </div>
            <button
              type="button"
              class="remove-email-btn"
              @click="removeEmail(index)"
              title="Eliminar"
            >
              ✕
            </button>
          </div>
        </div>
      </div>

      <!-- Empty State -->
      <div v-else class="email-empty">
        <p>Aún no has añadido ningún correo electrónico</p>
      </div>
    </div>
  </section>
</template>

<style lang="scss" scoped>
@import '../../styles/form.css';
</style>