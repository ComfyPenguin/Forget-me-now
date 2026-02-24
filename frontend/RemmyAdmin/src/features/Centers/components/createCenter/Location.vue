<script setup lang="ts">
import { faLocationDot } from '@fortawesome/free-solid-svg-icons/faLocationDot';



defineProps({
  form: {
    type: Object,
    required: true
  }
})

</script>

<template>
  <section class="form-section">
    <div class="section-header">
      <div class="section-icon"><font-awesome-icon :icon="faLocationDot" /></div>
      <h2 class="section-title">Ubicación</h2>
    </div>

    <div class="section-content">
      <div class="form-grid">
        <!-- Street Address -->
        <div class="form-group form-group--full-width">
          <label for="street" class="form-label">Dirección Exacta</label>
          <input
            id="street"
            v-model.trim="form.address"
            type="text"
            required
            placeholder="Calle, número, piso/puerta"
            class="form-input"
          />
        </div>

        <!-- Postal Code -->
        <div class="form-group">
          <label for="postal-code" class="form-label">Código Postal</label>
          <input
            id="postal-code"
            v-model.trim="form.postalCode"
            type="text"
            required
            placeholder="Ej. 28001"
            class="form-input"
          />
        </div>
      </div>
    </div>
  </section>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/form.css';
</style>