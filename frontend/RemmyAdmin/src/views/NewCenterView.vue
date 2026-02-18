<script setup lang="ts">
import { ref } from 'vue'
import BackButton from '@/components/util/backButton.vue'
import GeneralInfo from '@/components/newCenter/GeneralInfo.vue'
import Location from '@/components/newCenter/Location.vue'
import Email from '@/components/newCenter/Email.vue'
import Phone from '@/components/newCenter/Phone.vue'
import Characteristics from '@/components/newCenter/Characteristics.vue'
import Social from '@/components/newCenter/Social.vue'

const centerForm = ref({
  name: '',
  type: '',
  desc: '',
  street: '',
  postalCode: '',
  city: '',
  phone: [],
  characteristics: [],
  social: {},
  email: []
})

const handleSubmit = () => {
  console.log('Form submitted:', centerForm.value)
}

const handleCancel = () => {
  //TO-DO
  // Navigate back or reset form
  console.log('Cancelled')
}
</script>

<template>
  <div class="new-center-container">
    <!-- Header -->
    <div class="header">
      <div class="header-content">
        <BackButton label="Volver a Gestión de Centros" @click="handleCancel" />
      </div>
    </div>

    <!-- Main Content -->
    <div class="content-wrapper">
      <div class="page-header">
        <h1 class="page-title">Nuevo Centro de Ayuda</h1>
        <p class="page-subtitle">Complete el siguiente formulario para crear un nuevo punto de asistencia humanitaria.</p>
      </div>

      <form @submit.prevent="handleSubmit" class="form-sections">
        <!-- General Information Section -->
        <GeneralInfo :form="centerForm" />

        <!-- Location Section -->
        <Location :form="centerForm" />

        <!-- Email Section -->
        <Email :form="centerForm" />

        <!-- Phone Section -->
        <Phone :form="centerForm" />

        <!-- Characteristics Section -->
        <Characteristics :form="centerForm" />

        <!-- Social Media Section -->
        <Social :form="centerForm" />

        <!-- Action Buttons -->
        <div class="form-actions">
          <button type="button" class="btn btn-secondary" @click="handleCancel">
            Cancelar
          </button>
          <button type="submit" class="btn btn-primary">
            <svg width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
              <circle cx="12" cy="12" r="1"></circle>
              <path d="M12 5v14M5 12h14"></path>
            </svg>
            Guardar Centro
          </button>
        </div>
      </form>
    </div>

    <!-- Footer -->
    <div class="footer">
      <p class="footer-text">© 2024 Gestión Solidaria. Sistema de Registro Humanitario.</p>
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import '../styles/form.css';
</style>
