<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'

const route = useRoute()
const router = useRouter()

// Center data structure (will come from API or props)
const centerData = ref({
  id: 1,
  name: 'Comedor Social San José',
  type: 'Comedor',
  description: 'Centro de atención para personas en situación de vulnerabilidad. Ofrecemos comidas diarias y apoyo integral.',
  street: 'Calle Mayor, 123',
  postalCode: '28001',
  city: 'Madrid',
  phones: ['+34 600 000 000', '+34 912 345 678'],
  emails: ['contacto@sjose.com', 'info@sjose.com'],
  characteristics: ['comida', 'duchase', 'camas', 'medico', 'psicologia'],
  social: {
    instagram: '@comedorsanjose',
    facebook: 'facebook.com/comedorsanjose',
    whatsapp: '+34 600 000 000'
  },
  createdAt: '2024-01-15',
  updatedAt: '2024-02-19'
})

const isLoading = ref(false)

const characteristicIcons: Record<string, string> = {
  accesibilidad: '♿',
  wifi: '📶',
  comida: '🍽️',
  duchase: '🚿',
  camas: '🛏️',
  medico: '⚕️',
  psicologia: '💭',
  legal: '⚖️',
  educacion: '📚',
  cuidado_ninos: '👶',
  actividades: '🎯',
  transporte: '🚌'
}

const characteristicNames: Record<string, string> = {
  accesibilidad: 'Accesibilidad',
  wifi: 'Wi-Fi Gratis',
  comida: 'Comida',
  duchase: 'Duchas',
  camas: 'Camas',
  medico: 'Asistencia Médica',
  psicologia: 'Apoyo Psicológico',
  legal: 'Asesoría Legal',
  educacion: 'Educación',
  cuidado_ninos: 'Cuidado de Niños',
  actividades: 'Actividades',
  transporte: 'Transporte'
}

const socialIcons: Record<string, string> = {
  instagram: '📷',
  x: '𝕏',
  facebook: '👍',
  tiktok: '♪',
  linkedin: '💼',
  youtube: '▶️',
  whatsapp: '💬',
  telegram: '✈️'
}

const socialNames: Record<string, string> = {
  instagram: 'Instagram',
  x: 'X (Twitter)',
  facebook: 'Facebook',
  tiktok: 'TikTok',
  linkedin: 'LinkedIn',
  youtube: 'YouTube',
  whatsapp: 'WhatsApp',
  telegram: 'Telegram'
}

const handleBackClick = () => {
  router.push('/GestionPanel')
}

const getCharacteristicIcon = (id: string) => characteristicIcons[id] || '⭐'
const getCharacteristicName = (id: string) => characteristicNames[id] || id
const getSocialIcon = (id: string) => socialIcons[id] || '🔗'
const getSocialName = (id: string) => socialNames[id] || id

onMounted(async () => {
  isLoading.value = true
  try {
    // TODO: Fetch center data from API using route.params.id
    // const { data } = await fetch(`/api/centers/${route.params.id}`)
    // centerData.value = data
  } catch (error) {
    console.error('Error loading center data:', error)
  } finally {
    isLoading.value = false
  }
})
</script>

<template>
  <div class="info-center-outer-wrapper">
    <div class="info-center-container">
      <!-- Header -->
      <div class="header">
        <div class="header-content">
          <button class="back-button" @click="handleBackClick">
            <svg width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
              <path d="M19 12H5M12 19l-7-7 7-7"/>
            </svg>
            Volver a Gestión de Centros
          </button>
        </div>
      </div>

      <!-- Main Content -->
      <div class="content-wrapper">
        <div v-if="!isLoading" class="center-details">
          <!-- Header Section -->
          <section class="info-section header-section">
            <div class="center-header">
              <h1 class="center-title">{{ centerData.name }}</h1>
              <span class="center-type">{{ centerData.type }}</span>
            </div>
            <p class="center-description">{{ centerData.description }}</p>
          </section>

          <!-- Location Section -->
          <section class="info-section">
            <div class="section-header">
              <h2 class="section-title">📍 Ubicación</h2>
            </div>
            <div class="section-content">
              <div class="info-item">
                <span class="info-label">Dirección</span>
                <span class="info-value">{{ centerData.street }}</span>
              </div>
              <div class="info-row">
                <div class="info-item">
                  <span class="info-label">Código Postal</span>
                  <span class="info-value">{{ centerData.postalCode }}</span>
                </div>
                <div class="info-item">
                  <span class="info-label">Ciudad</span>
                  <span class="info-value">{{ centerData.city }}</span>
                </div>
              </div>
            </div>
          </section>

          <!-- Contact Section -->
          <section class="info-section">
            <div class="section-header">
              <h2 class="section-title">📞 Contacto</h2>
            </div>
            <div class="section-content">
              <!-- Phones -->
              <div v-if="centerData.phones.length > 0" class="contact-group">
                <span class="contact-label">Teléfonos</span>
                <div class="contact-list">
                  <a
                    v-for="(phone, index) in centerData.phones"
                    :key="index"
                    :href="`tel:${phone}`"
                    class="contact-item phone-item"
                  >
                    <span class="contact-icon">☎️</span>
                    <span>{{ phone }}</span>
                  </a>
                </div>
              </div>

              <!-- Emails -->
              <div v-if="centerData.emails.length > 0" class="contact-group">
                <span class="contact-label">Correos Electrónicos</span>
                <div class="contact-list">
                  <a
                    v-for="(email, index) in centerData.emails"
                    :key="index"
                    :href="`mailto:${email}`"
                    class="contact-item email-item"
                  >
                    <span class="contact-icon">📧</span>
                    <span>{{ email }}</span>
                  </a>
                </div>
              </div>
            </div>
          </section>

          <!-- Characteristics Section -->
          <section v-if="centerData.characteristics.length > 0" class="info-section">
            <div class="section-header">
              <h2 class="section-title">⭐ Características</h2>
            </div>
            <div class="section-content">
              <div class="characteristics-display">
                <div
                  v-for="charId in centerData.characteristics"
                  :key="charId"
                  class="characteristic-badge"
                >
                  <span class="badge-icon">{{ getCharacteristicIcon(charId) }}</span>
                  <span class="badge-name">{{ getCharacteristicName(charId) }}</span>
                </div>
              </div>
            </div>
          </section>

          <!-- Social Media Section -->
          <section v-if="Object.keys(centerData.social).length > 0" class="info-section">
            <div class="section-header">
              <h2 class="section-title">🌐 Redes Sociales</h2>
            </div>
            <div class="section-content">
              <div class="social-display">
                <a
                  v-for="(handle, platform) in centerData.social"
                  :key="platform"
                  :href="buildSocialUrl(platform, handle)"
                  target="_blank"
                  rel="noopener noreferrer"
                  class="social-link"
                  :title="getSocialName(platform)"
                >
                  <span class="social-icon">{{ getSocialIcon(platform) }}</span>
                  <span class="social-platform">{{ getSocialName(platform) }}</span>
                </a>
              </div>
            </div>
          </section>

          <!-- Metadata Section -->
          <section class="info-section metadata-section">
            <div class="metadata-items">
              <div class="metadata-item">
                <span class="metadata-label">Creado</span>
                <span class="metadata-value">{{ formatDate(centerData.createdAt) }}</span>
              </div>
              <div class="metadata-item">
                <span class="metadata-label">Actualizado</span>
                <span class="metadata-value">{{ formatDate(centerData.updatedAt) }}</span>
              </div>
            </div>
          </section>

          <!-- Action Buttons -->
          <div class="action-buttons">
            <button class="btn btn-secondary" @click="handleBackClick">
              Volver
            </button>
            <button class="btn btn-primary">
              Editar Centro
            </button>
          </div>
        </div>

        <!-- Loading State -->
        <div v-else class="loading-state">
          <div class="spinner"></div>
          <p>Cargando información del centro...</p>
        </div>
      </div>

      <!-- Footer -->
      <div class="footer">
        <p class="footer-text">© 2024 Gestión Solidaria. Sistema de Registro Humanitario.</p>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
function buildSocialUrl(platform: string, handle: string): string {
  const urls: Record<string, (h: string) => string> = {
    instagram: (h) => `https://instagram.com/${h.replace('@', '')}`,
    facebook: (h) => `https://facebook.com/${h}`,
    x: (h) => `https://x.com/${h.replace('@', '')}`,
    tiktok: (h) => `https://tiktok.com/@${h.replace('@', '')}`,
    linkedin: (h) => h.startsWith('http') ? h : `https://linkedin.com/in/${h}`,
    youtube: (h) => h.startsWith('http') ? h : `https://youtube.com/@${h}`,
    whatsapp: (h) => `https://wa.me/${h.replace(/\D/g, '')}`,
    telegram: (h) => `https://t.me/${h.replace('@', '')}`
  }
  
  return urls[platform] ? urls[platform](handle) : handle
}

function formatDate(dateString: string): string {
  const date = new Date(dateString)
  return date.toLocaleDateString('es-ES', {
    year: 'numeric',
    month: 'long',
    day: 'numeric'
  })
}
</script>

<style lang="scss" scoped>
@import '@/assets/styles/global.css';

.center-details {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.header-section {
  background: linear-gradient(135deg, var(--primary-lightest) 0%, #dbeafe 100%);
  border: 2px solid var(--primary-light);
}

.center-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 1rem;
  flex-wrap: wrap;
  gap: 1rem;
}

.center-title {
  font-size: 2rem;
  font-weight: 700;
  color: var(--neutral-darkest);
  margin: 0;
}

.center-type {
  background: var(--primary);
  color: white;
  padding: 0.5rem 1rem;
  border-radius: 20px;
  font-size: 0.875rem;
  font-weight: 600;
}

.center-description {
  color: var(--neutral);
  font-size: 0.95rem;
  line-height: 1.6;
  margin: 0;
}

.info-section {
  background: white;
  border-radius: 12px;
  border: 1px solid #e5e7eb;
  overflow: hidden;
}

.section-header {
  background: linear-gradient(135deg, #f8fafc 0%, #f1f5f9 100%);
  padding: 1.25rem 1.5rem;
  border-bottom: 2px solid #f1f5f9;
}

.section-title {
  font-size: 1.125rem;
  font-weight: 700;
  color: var(--neutral-darkest);
  margin: 0;
}

.section-content {
  padding: 1.5rem;
}

.info-item {
  display: flex;
  flex-direction: column;
  gap: 0.25rem;
}

.info-label {
  font-size: 0.75rem;
  font-weight: 600;
  color: var(--neutral-dark);
  text-transform: uppercase;
  letter-spacing: 0.5px;
}

.info-value {
  font-size: 0.95rem;
  color: var(--neutral-darkest);
  font-weight: 500;
}

.info-row {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 1.5rem;
  margin-top: 1rem;
}

.contact-group {
  margin-bottom: 1.5rem;

  &:last-child {
    margin-bottom: 0;
  }
}

.contact-label {
  font-size: 0.75rem;
  font-weight: 600;
  color: var(--neutral-dark);
  text-transform: uppercase;
  letter-spacing: 0.5px;
  display: block;
  margin-bottom: 0.75rem;
}

.contact-list {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.contact-item {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  padding: 0.75rem 1rem;
  background-color: #f8fafc;
  border-radius: 6px;
  text-decoration: none;
  color: var(--neutral-darkest);
  transition: all 0.2s;
  font-size: 0.9rem;
}

.contact-item:hover {
  background-color: #f1f5f9;
  transform: translateX(4px);
}

.contact-item.phone-item:hover {
  color: var(--primary);
}

.contact-item.email-item:hover {
  color: var(--secondary);
}

.contact-icon {
  font-size: 1.125rem;
  flex-shrink: 0;
}

.characteristics-display {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(150px, 1fr));
  gap: 1rem;
}

.characteristic-badge {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 0.5rem;
  padding: 1rem;
  background: linear-gradient(135deg, var(--primary-lightest) 0%, #eff6ff 100%);
  border: 2px solid var(--primary-light);
  border-radius: 8px;
  text-align: center;
  transition: all 0.2s;
}

.characteristic-badge:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(59, 130, 246, 0.15);
}

.badge-icon {
  font-size: 1.75rem;
}

.badge-name {
  font-size: 0.875rem;
  font-weight: 600;
  color: var(--neutral-darkest);
}

.social-display {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(140px, 1fr));
  gap: 1rem;
}

.social-link {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 0.75rem;
  padding: 1.25rem 1rem;
  background-color: #f8fafc;
  border: 2px solid #e5e7eb;
  border-radius: 8px;
  text-decoration: none;
  color: var(--neutral-darkest);
  transition: all 0.2s;
}

.social-link:hover {
  border-color: var(--primary);
  background-color: var(--primary-lightest);
  transform: translateY(-2px);
}

.social-icon {
  font-size: 1.75rem;
}

.social-platform {
  font-size: 0.875rem;
  font-weight: 600;
  text-align: center;
}

.metadata-section {
  background: linear-gradient(135deg, #f8fafc 0%, #f1f5f9 100%);
  border: 1px solid #e5e7eb;
}

.metadata-items {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 1.5rem;
}

.metadata-item {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.metadata-label {
  font-size: 0.75rem;
  font-weight: 600;
  color: var(--neutral-dark);
  text-transform: uppercase;
  letter-spacing: 0.5px;
}

.metadata-value {
  font-size: 0.9rem;
  color: var(--neutral-darkest);
}

.action-buttons {
  display: flex;
  gap: 1rem;
  justify-content: flex-end;
  margin-top: 1rem;
  padding-top: 1.5rem;
  border-top: 1px solid #e5e7eb;
}

.loading-state {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 3rem;
  text-align: center;
  color: var(--neutral);
}

.spinner {
  width: 40px;
  height: 40px;
  border: 4px solid #e5e7eb;
  border-top-color: var(--primary);
  border-radius: 50%;
  animation: spin 1s linear infinite;
  margin-bottom: 1rem;
}

@keyframes spin {
  to {
    transform: rotate(360deg);
  }
}

@media (max-width: 768px) {
  .center-title {
    font-size: 1.5rem;
  }

  .center-header {
    flex-direction: column;
    align-items: flex-start;
  }

  .info-row {
    grid-template-columns: 1fr;
  }

  .characteristics-display {
    grid-template-columns: repeat(auto-fill, minmax(120px, 1fr));
  }

  .social-display {
    grid-template-columns: repeat(auto-fill, minmax(120px, 1fr));
  }

  .action-buttons {
    flex-direction: column;
  }

  .btn {
    width: 100%;
  }
}
</style>