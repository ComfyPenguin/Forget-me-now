<script setup lang="ts">
import BaseButton from '@/shared/util/baseButton.vue';
import CentersList from '@/features/Centers/components/gestionPanel/centersList.vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const goToAddCenter = () => {
    router.push('/CreateCenter');
};
</script>

<template>
  <div class="gestion-panel-scroll">
    <div class="gestion-panel-container">
      <!-- Header -->
      <header class="panel-header">
        <div class="header-titles">
          <h1 class="title">Gestión de Centros</h1>
          <p class="subtitle">Supervise y administre los recursos de la red de ayuda humanitaria.</p>
        </div>
        <BaseButton variant="primary" class="add-btn" @click="goToAddCenter">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" class="btn-icon">
            <path stroke-linecap="round" stroke-linejoin="round" d="M12 4.5v15m7.5-7.5h-15" />
          </svg>
          Añadir Centro
        </BaseButton>
      </header>

      <!-- Content Layout -->
      <div class="content-layout">
        <!-- Main Column -->
        <main class="main-column">
          <!-- Filters Area -->
          <section class="filters-card">
            <div class="filter-group block-search">
              <label>BÚSQUEDA</label>
              <div class="input-wrapper">
                <svg class="input-icon" viewBox="0 0 20 20" fill="currentColor">
                  <path fill-rule="evenodd" d="M9 3.5a5.5 5.5 0 100 11 5.5 5.5 0 000-11zM2 9a7 7 0 1112.452 4.391l3.328 3.329a.75.75 0 11-1.06 1.06l-3.329-3.328A7 7 0 012 9z" clip-rule="evenodd"/>
                </svg>
                <input type="text" placeholder="Nombre o encargado..." />
              </div>
            </div>
            
            <div class="filter-group">
              <label>CIUDAD</label>
              <div class="select-wrapper">
                <select>
                  <option>Todas las ciudades</option>
                </select>
                <svg class="select-icon" viewBox="0 0 20 20" fill="currentColor">
                  <path fill-rule="evenodd" d="M5.23 7.21a.75.75 0 011.06.02L10 11.168l3.71-3.938a.75.75 0 111.08 1.04l-4.25 4.5a.75.75 0 01-1.08 0l-4.25-4.5a.75.75 0 01.02-1.06z" clip-rule="evenodd" />
                </svg>
              </div>
            </div>

            <div class="filter-group">
              <label>TIPO DE AYUDA</label>
              <div class="select-wrapper">
                <select>
                  <option>Todos los tipos</option>
                </select>
                <svg class="select-icon" viewBox="0 0 20 20" fill="currentColor">
                  <path fill-rule="evenodd" d="M5.23 7.21a.75.75 0 011.06.02L10 11.168l3.71-3.938a.75.75 0 111.08 1.04l-4.25 4.5a.75.75 0 01-1.08 0l-4.25-4.5a.75.75 0 01.02-1.06z" clip-rule="evenodd" />
                </svg>
              </div>
            </div>

            <button class="filter-btn" aria-label="Filtros avanzados">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" class="filter-icon">
                <path d="M3 6h18v2H3V6zm3 7h12v2H6v-2zm3 7h6v2H9v-2z" />
              </svg>
            </button>
          </section>

          <!-- Centers List (Table 组件) -->
          <section class="list-section">
            <CentersList />
          </section>
        </main>

        <!-- Sidebar Column -->
        <aside class="sidebar-column">
          <div class="map-card">
            <div class="map-header">
              <div class="map-title">
                <svg class="map-icon" viewBox="0 0 24 24" fill="currentColor">
                  <path d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5s1.12-2.5 2.5-2.5 2.5 1.12 2.5 2.5-1.12 2.5-2.5 2.5z"/>
                </svg>
                <h2>Vista Geográfica</h2>
              </div>
              <button class="expand-btn">Expandir</button>
            </div>
            
            <div class="map-image-wrapper">
               <div class="map-placeholder">
                  <div class="map-marker primary-marker"></div>
                  <div class="map-marker secondary-marker m-1"></div>
                  <div class="map-marker secondary-marker m-2"></div>
               </div>
            </div>
            
            <div class="stats-card">
              <h3>Estadísticas por región</h3>
              <div class="stat-item">
                <div class="stat-header">
                  <span class="stat-name">Madrid Central</span>
                  <span class="stat-value"><strong>12</strong> centros</span>
                </div>
                <div class="progress-bar">
                  <div class="progress-fill primary-fill" style="width: 60%;"></div>
                </div>
              </div>
              
              <div class="stat-item">
                <div class="stat-header">
                  <span class="stat-name">Catalunya Sur</span>
                  <span class="stat-value"><strong>8</strong> centros</span>
                </div>
                <div class="progress-bar">
                  <div class="progress-fill primary-fill" style="width: 40%;"></div>
                </div>
              </div>
            </div>
          </div>
        </aside>
      </div>
    </div>
  </div>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap');

/* Color Variables */
.gestion-panel-scroll {
  --bg-color: #f8fafc;
  --card-bg: #ffffff;
  --text-dark: #0f172a;
  --text-muted: #64748b;
  --text-light: #94a3b8;
  --border-color: #e2e8f0;
  --primary-blue: #1d4ed8;
  --primary-blue-hover: #1e40af;
  --input-bg: #f1f5f9;
  
  font-family: 'Inter', sans-serif;
  background-color: var(--bg-color);
  min-height: 100vh;
  margin: 0;
  padding: 0;
}

/* Global container styling */
.gestion-panel-container {
  max-width: 1400px;
  margin: 0 auto;
  padding: 2rem 2.5rem;
  color: var(--text-dark);
}

/* Header */
.panel-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 2rem;
}

.header-titles .title {
  font-size: 2.25rem;
  font-weight: 800;
  margin: 0;
  color: var(--text-dark);
  line-height: 1.2;
}

.header-titles .subtitle {
  font-size: 1.05rem;
  color: var(--text-muted);
  margin: 0.5rem 0 0 0;
  font-weight: 400;
}

.add-btn {
  display: flex !important;
  align-items: center;
  gap: 0.5rem;
  font-family: inherit;
  font-weight: 600;
  padding: 0.75rem 1.25rem;
  border-radius: 8px;
  background-color: var(--primary-blue) !important;
  color: white !important;
  border: none !important;
  box-shadow: 0 4px 6px -1px rgba(29, 78, 216, 0.2), 0 2px 4px -1px rgba(29, 78, 216, 0.1);
  transition: all 0.2s ease;
  cursor: pointer;
}

.add-btn:hover {
  background-color: var(--primary-blue-hover) !important;
  transform: translateY(-1px);
}

.btn-icon {
  width: 1.25rem;
  height: 1.25rem;
}

/* Layout Grid */
.content-layout {
  display: grid;
  grid-template-columns: 1fr 320px;
  gap: 1.5rem;
  align-items: start;
}

@media (max-width: 1024px) {
  .content-layout {
    grid-template-columns: 1fr;
  }
}

/* Filters Card */
.filters-card {
  background-color: var(--card-bg);
  border-radius: 12px;
  padding: 1.25rem;
  display: flex;
  align-items: flex-end;
  gap: 1.25rem;
  box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.05), 0 1px 2px 0 rgba(0, 0, 0, 0.03);
  margin-bottom: 1.5rem;
  border: 1px solid var(--border-color);
}

.filter-group {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.block-search {
  flex-grow: 1;
}

.filter-group label {
  font-size: 0.75rem;
  font-weight: 700;
  color: var(--text-muted);
  letter-spacing: 0.5px;
}

.input-wrapper, .select-wrapper {
  position: relative;
  width: 100%;
}

.input-wrapper input, .select-wrapper select {
  width: 100%;
  padding: 0.625rem 1rem;
  background-color: var(--input-bg);
  border: 1px solid transparent;
  border-radius: 8px;
  font-size: 0.875rem;
  color: var(--text-dark);
  font-family: inherit;
  font-weight: 500;
  transition: all 0.2s ease;
  outline: none;
  box-sizing: border-box;
}

.input-wrapper input {
  padding-left: 2.5rem;
}

.select-wrapper select {
  padding-right: 2.5rem;
  appearance: none;
  cursor: pointer;
}

.input-wrapper input:focus, .select-wrapper select:focus {
  border-color: var(--primary-blue);
  background-color: white;
  box-shadow: 0 0 0 3px rgba(29, 78, 216, 0.1);
}

.input-icon {
  position: absolute;
  left: 0.75rem;
  top: 50%;
  transform: translateY(-50%);
  width: 1.25rem;
  height: 1.25rem;
  color: var(--text-light);
}

.select-icon {
  position: absolute;
  right: 0.75rem;
  top: 50%;
  transform: translateY(-50%);
  width: 1.25rem;
  height: 1.25rem;
  color: var(--text-light);
  pointer-events: none;
}

.filter-btn {
  background-color: var(--input-bg);
  border: 1px solid transparent;
  border-radius: 8px;
  padding: 0.625rem;
  height: 38px;
  width: 38px;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  color: var(--text-muted);
  transition: all 0.2s;
}

.filter-btn:hover {
  background-color: #e2e8f0;
  color: var(--text-dark);
}

.filter-icon {
  width: 1.25rem;
  height: 1.25rem;
}

/* Sidebar styling */
.map-card {
  background-color: var(--card-bg);
  border-radius: 12px;
  box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.05), 0 1px 2px 0 rgba(0, 0, 0, 0.03);
  border: 1px solid var(--border-color);
  overflow: hidden;
  display: flex;
  flex-direction: column;
}

.map-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1rem 1.25rem;
  border-bottom: 1px solid var(--border-color);
}

.map-title {
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

.map-title h2 {
  font-size: 1rem;
  font-weight: 700;
  margin: 0;
  color: var(--text-dark);
}

.map-icon {
  width: 1.25rem;
  height: 1.25rem;
  color: var(--primary-blue);
}

.expand-btn {
  font-size: 0.875rem;
  color: var(--primary-blue);
  background: none;
  border: none;
  font-family: inherit;
  font-weight: 600;
  cursor: pointer;
}

.expand-btn:hover {
  text-decoration: underline;
}

.map-image-wrapper {
  height: 250px;
  background-color: #e2e8f0;
  position: relative;
}

.map-placeholder {
  width: 100%;
  height: 100%;
  background-image: url('https://w7.pngwing.com/pngs/354/298/png-transparent-map-world-map-globe-simple-world-map-business-thumbnail.png');
  background-size: cover;
  background-position: center;
  position: relative;
  opacity: 0.8;
  filter: sepia(0.2) hue-rotate(180deg) saturate(0.6) brightness(1.1);
  border-bottom: 1px solid var(--border-color);
}

/* Map markers dots */
.map-marker {
  position: absolute;
  width: 14px;
  height: 14px;
  border-radius: 50%;
  border: 2px solid white;
  box-shadow: 0 0 0 2px rgba(29, 78, 216, 0.2);
}

.primary-marker {
  background-color: #ef4444; /* Red indicator on mockup */
  top: 40%;
  right: 35%;
  width: 18px;
  height: 18px;
}

.secondary-marker {
  background-color: var(--primary-blue);
}

.m-1 { top: 30%; left: 40%; }
.m-2 { top: 60%; left: 45%; }


.stats-card {
  padding: 1.25rem;
}

.stats-card h3 {
  font-size: 0.875rem;
  color: var(--text-muted);
  margin: 0 0 1.25rem 0;
  font-weight: 500;
}

.stat-item {
  margin-bottom: 1rem;
}

.stat-item:last-child {
  margin-bottom: 0;
}

.stat-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 0.5rem;
}

.stat-name {
  font-size: 0.875rem;
  font-weight: 600;
  color: var(--text-dark);
}

.stat-value {
  font-size: 0.875rem;
  color: var(--text-dark);
}

.progress-bar {
  width: 100%;
  height: 6px;
  background-color: #f1f5f9;
  border-radius: 4px;
  overflow: hidden;
}

.progress-fill {
  height: 100%;
  border-radius: 4px;
}

.primary-fill {
  background-color: var(--primary-blue);
}

</style>
