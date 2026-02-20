<script setup lang="ts">
import { ref } from 'vue'
import BackButton from '@/shared/util/backButton.vue'
import GeneralInfo from '@/features/Centers/components/createCenter/GeneralInfo.vue'
import Location from '@/features/Centers/components/createCenter/Location.vue'
import Email from '@/features/Centers/components/createCenter/Email.vue'
import Phone from '@/features/Centers/components/createCenter/Phone.vue'
import Characteristics from '@/features/Centers/components/createCenter/Characteristics.vue'
import Social from '@/features/Centers/components/createCenter/Social.vue'

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
  <div class="new-center-outer-wrapper">
    <div class="new-center-container">
      <!-- Header -->
      <div class="header">
        <div class="header-content">
          <button class="back-button" @click="handleCancel">
            <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
              <path d="M19 12H5M12 19l-7-7 7-7"/>
            </svg>
            Volver a Gestión de Centros
          </button>
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
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/form.css';

.new-center-outer-wrapper {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  width: 100vw;
  height: 100vh;
  overflow: auto;
  z-index: 100;
}
</style>
