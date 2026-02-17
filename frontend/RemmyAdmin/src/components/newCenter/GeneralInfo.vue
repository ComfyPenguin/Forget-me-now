<script setup lang="ts">
defineProps({
  form: {
    type: Object,
    required: true
  }
})

const centerTypes = [
  { id: 1, name: 'Albergue Temporal' },
  { id: 2, name: 'Comedor Social' },
  { id: 3, name: 'Centro Médico' },
  { id: 4, name: 'Centro Educativo' },
  { id: 5, name: 'Centro de Atención Infantil' },
]
</script>

<template>
  <section class="form-section">
    <div class="section-header">
      <div class="section-icon">ℹ️</div>
      <h2 class="section-title">Información General</h2>
    </div>

    <div class="section-content">
      <div class="form-grid">
        <!-- Center Name -->
        <div class="form-group">
          <label for="name" class="form-label">Nombre del Centro</label>
          <input
            id="name"
            v-model.trim="form.name"
            type="text"
            required
            placeholder="Ej. Comedor Social San José"
            class="form-input"
          />
        </div>

        <!-- Center Type -->
        <div class="form-group">
          <label for="type" class="form-label">Tipo de Ayuda</label>
          <select v-model="form.type" id="type" class="form-select" required>
            <option value="">Seleccione el tipo</option>
            <option v-for="type in centerTypes" :key="type.id" :value="type.id">
              {{ type.name }}
            </option>
          </select>
        </div>

        <!-- Description (Full Width) -->
        <div class="form-group form-group--full-width">
          <label for="desc" class="form-label">Descripción</label>
          <textarea
            id="desc"
            v-model.trim="form.desc"
            required
            placeholder="Breve descripción de las actividades y servicios ofrecidos..."
            class="form-textarea"
            rows="4"
          ></textarea>
        </div>
      </div>
    </div>
  </section>
</template>

<style lang="scss" scoped>
@import '../../styles/form.css';
</style>