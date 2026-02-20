<script setup lang="ts">
import { ref } from 'vue'
import BaseButton from '@/components/util/baseButton.vue'
const loginForm = ref({
  email: '',
  password: ''
})
const rememberDevice = ref(false)
const handleSubmit = () => {
  console.log('Login attempt:', loginForm.value)
}
</script>
<template>
  <div class="login-card">
    <div class="text-center">
      <h2 class="login-title">Welcome</h2>
      <p class="login-subtitle">Please enter your credentials to access the staff portal.</p>
    </div>

    <form @submit.prevent="handleSubmit" class="login-form">
      <div class="form-group">
        <label for="email" class="form-label">Email Address</label>
        <input id="email" v-model.trim="loginForm.email" type="email" autocomplete="email" required
          placeholder="name@organization.org" class="form-input" />
      </div>

      <div class="form-group">
        <div class="label-row">
          <label for="password" class="form-label">Password</label>
          <a href="#" class="forgot-password">Forgot Password?</a>
        </div>
        <input id="password" v-model="loginForm.password" type="password" autocomplete="current-password" required
          placeholder="••••••••" class="form-input" />
      </div>

      <div class="checkbox-group">
        <input id="remember" type="checkbox" v-model="rememberDevice" class="checkbox-input" />
        <label for="remember" class="checkbox-label">Remember this device</label>
      </div>

      <BaseButton variant="primary" label="Log In →" :animationEnabled="false" @click="$router.push('/GestionPanel')" />

      <button class="createAccount" @click="$router.push('/Register')">Create Account</button>

    </form>

    <div class="footer-section">
      <p class="authorized-text">AUTHORIZED ACCESS ONLY</p>
      <div class="footer-icons">
        <a href="#" class="icon-link">?</a>
        <a href="#" class="icon-link">🛡️</a>
        <a href="#" class="icon-link">🌐</a>
      </div>
      <p class="copyright">Gestión Solidaria © 2024. All rights reserved.</p>
    </div>
  </div>
</template>

<style lang="scss">
@import '../../presentation/styles/form.css';

.createAccount {
  display: inline-block; /* O simplemente bórralo si es un <button>, ya que suelen serlo por defecto */
  color: var(--primary);
  cursor: pointer;
}

.createAccount:hover{
  color: var(--primary-darkest)
}

.text-center {
  text-align: center;
  margin-bottom: 2rem;
}

.forgot-password {
  font-size: 0.875rem;
  color: var(--primary);
  text-decoration: none;
  font-weight: 500;
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