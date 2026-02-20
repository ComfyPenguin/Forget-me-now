<script setup lang="ts">
import { ref } from 'vue'
import BaseButton from '@/shared/util/baseButton.vue'
const registerForm = ref({
  username: '',
  email: '',
  password: '',
  passwordConfirm: '',
})

const errors = ref({
  username: '',
  email: '',
  password: '',
  passwordConfirm: '',
})

const showPassword = ref(false)
const showPasswordConfirm = ref(false)
const isLoading = ref(false)

const validateEmail = (email: string) => {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
  return emailRegex.test(email)
}

const validateForm = () => {
  let isValid = true
  errors.value = { username: '', email: '', password: '', passwordConfirm: '' }

  // Username validation
  if (!registerForm.value.username.trim()) {
    errors.value.username = 'El nombre de usuario es obligatorio'
    isValid = false
  } else if (registerForm.value.username.length < 3) {
    errors.value.username = 'El nombre debe tener al menos 3 caracteres'
    isValid = false
  }

  // Email validation
  if (!registerForm.value.email.trim()) {
    errors.value.email = 'El correo es obligatorio'
    isValid = false
  } else if (!validateEmail(registerForm.value.email)) {
    errors.value.email = 'El correo no es válido'
    isValid = false
  }

  // Password validation
  if (!registerForm.value.password) {
    errors.value.password = 'La contraseña es obligatoria'
    isValid = false
  } else if (registerForm.value.password.length < 8) {
    errors.value.password = 'La contraseña debe tener al menos 8 caracteres'
    isValid = false
  }

  // Password confirmation
  if (!registerForm.value.passwordConfirm) {
    errors.value.passwordConfirm = 'Debes confirmar la contraseña'
    isValid = false
  } else if (registerForm.value.password !== registerForm.value.passwordConfirm) {
    errors.value.passwordConfirm = 'Las contraseñas no coinciden'
    isValid = false
  }

  return isValid
}

const handleSubmit = async () => {
  
}

const handleInputChange = (field: keyof typeof registerForm.value) => {
  errors.value[field] = ''
}
</script>

<template>
  <div class="login-card">
    <div class="text-center">
      <h2 class="login-title">Crear Cuenta</h2>
      <p class="login-subtitle">Únete a nuestra comunidad hoy</p>
    </div>

    <form @submit.prevent="handleSubmit" class="login-form">
      <!-- Username Field -->
      <div class="form-group">
        <label for="username" class="form-label">Nombre de Usuario</label>
        <input
          id="username"
          v-model.trim="registerForm.username"
          type="text"
          placeholder="tu_nombre_usuario"
          class="form-input"
          @input="handleInputChange('username')"
        />
        <p v-if="errors.username" class="error-text">{{ errors.username }}</p>
      </div>

      <!-- Email Field -->
      <div class="form-group">
        <label for="email" class="form-label">Correo Electrónico</label>
        <input
          id="email"
          v-model.trim="registerForm.email"
          type="email"
          placeholder="tu@correo.com"
          class="form-input"
          @input="handleInputChange('email')"
        />
        <p v-if="errors.email" class="error-text">{{ errors.email }}</p>
      </div>

      <!-- Password Field -->
      <div class="form-group">
        <div class="label-row">
          <label for="password" class="form-label">Contraseña</label>
          <button
            type="button"
            class="forgot-password"
            @click="showPassword = !showPassword"
          >
            {{ showPassword ? 'Ocultar' : 'Mostrar' }}
          </button>
        </div>
        <input
          id="password"
          v-model="registerForm.password"
          :type="showPassword ? 'text' : 'password'"
          placeholder="••••••••"
          class="form-input"
          @input="handleInputChange('password')"
        />
        <p v-if="errors.password" class="error-text">{{ errors.password }}</p>
      </div>

      <!-- Password Confirmation Field -->
      <div class="form-group">
        <div class="label-row">
          <label for="passwordConfirm" class="form-label">Confirmar Contraseña</label>
          <button
            type="button"
            class="forgot-password"
            @click="showPasswordConfirm = !showPasswordConfirm"
          >
            {{ showPasswordConfirm ? 'Ocultar' : 'Mostrar' }}
          </button>
        </div>
        <input
          id="passwordConfirm"
          v-model="registerForm.passwordConfirm"
          :type="showPasswordConfirm ? 'text' : 'password'"
          placeholder="••••••••"
          class="form-input"
          @input="handleInputChange('passwordConfirm')"
        />
        <div v-if="registerForm.passwordConfirm" class="password-match-status">
          <span v-if="registerForm.password === registerForm.passwordConfirm" class="match-success">
            ✓ Las contraseñas coinciden
          </span>
          <span v-else class="match-error">
            ✗ Las contraseñas no coinciden
          </span>
        </div>
        <p v-if="errors.passwordConfirm" class="error-text">{{ errors.passwordConfirm }}</p>
        </div>

        <BaseButton variant="primary" label="Register" :animationEnabled="false" @click="$router.push('/login')" />

    </form>

    <div class="footer-section">
      <p class="copyright">¿Ya tienes cuenta? <a href="/login" class="support-link">Inicia sesión aquí</a></p>
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import '@/assets/styles/form.css';


.text-center {
  text-align: center;
  margin-bottom: 2rem;
}

.error-text {
  font-size: 0.875rem;
  color: #ef4444;
  margin: 0.5rem 0 0 0;
}

.password-match-status {
  margin-top: 0.5rem;
  font-size: 0.875rem;
  font-weight: 500;
}

.match-success {
  color: #22c55e;
}

.match-error {
  color: #ef4444;
}



.forgot-password {
  font-size: 0.875rem;
  color: var(--primary);
  text-decoration: none;
  font-weight: 500;
  background: none;
  border: none;
  cursor: pointer;
  padding: 0;
}

.forgot-password:hover {
  text-decoration: underline;
}

.footer-section {
  border-top: 1px solid #e5e7eb;
  padding-top: 1.5rem;
  text-align: center;
}
</style>