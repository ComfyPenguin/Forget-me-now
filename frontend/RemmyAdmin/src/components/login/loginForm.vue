<script setup lang="ts">
import { ref } from 'vue'
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
      <h2 class="login-title">Welcome back</h2>
      <p class="login-subtitle">Please enter your credentials to access the staff portal.</p>
    </div>

    <form @submit.prevent="handleSubmit" class="login-form">
      <div class="form-group">
        <label for="email" class="form-label">Email Address</label>
        <input
          id="email"
          v-model.trim="loginForm.email"
          type="email"
          autocomplete="email"
          required
          placeholder="name@organization.org"
          class="form-input"
        />
      </div>

      <div class="form-group">
        <div class="label-row">
          <label for="password" class="form-label">Password</label>
          <a href="#" class="forgot-password">Forgot Password?</a>
        </div>
        <input
          id="password"
          v-model="loginForm.password"
          type="password"
          autocomplete="current-password"
          required
          placeholder="••••••••"
          class="form-input"
        />
      </div>

      <div class="checkbox-group">
        <input
          id="remember"
          v-model="rememberDevice"
          type="checkbox"
          class="checkbox-input"
        />
        <label for="remember" class="checkbox-label">Remember this device</label>
      </div>

      <button type="submit" class="submit-button">Log In →</button>
    </form>

    <div class="footer-section">
      <p class="authorized-text">AUTHORIZED ACCESS ONLY</p>
      <p class="support-text">Need technical assistance? <a href="#" class="support-link">Contact IT Support</a></p>
      <div class="footer-icons">
        <a href="#" class="icon-link">?</a>
        <a href="#" class="icon-link">🛡️</a>
        <a href="#" class="icon-link">🌐</a>
      </div>
      <p class="copyright">Gestión Solidaria © 2024. All rights reserved.</p>
    </div>
  </div>
</template>

<style scoped>
.login-card {
  background: #ffffff;
  padding: 3rem;
  border-radius: 12px;
  box-shadow: 0 10px 25px -5px rgba(0, 0, 0, 0.1);
  width: 100%;
  max-width: 420px;
  display: flex;
  flex-direction: column;
}

.text-center {
  text-align: center;
  margin-bottom: 2rem;
}

.login-title {
  font-size: 1.875rem;
  font-weight: 700;
  color: #111827;
  margin-bottom: 0.5rem;
}

.login-subtitle {
  color: #6b7280;
  font-size: 0.875rem;
  line-height: 1.5;
}

.login-form {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
  margin-bottom: 2rem;
}

.form-group {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.label-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.form-label {
  font-size: 0.875rem;
  font-weight: 600;
  color: #374151;
}

.forgot-password {
  font-size: 0.875rem;
  color: #2563eb;
  text-decoration: none;
  font-weight: 500;
}

.forgot-password:hover {
  text-decoration: underline;
}

.form-input {
  width: 100%;
  padding: 0.75rem 1rem;
  border: 1px solid #d1d5db;
  border-radius: 6px;
  font-size: 0.875rem;
  transition: border-color 0.2s, box-shadow 0.2s;
  box-sizing: border-box;
}

.form-input:focus {
  outline: none;
  border-color: #2563eb;
  box-shadow: 0 0 0 3px rgba(37, 99, 235, 0.1);
}

.checkbox-group {
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

.checkbox-input {
  width: 18px;
  height: 18px;
  cursor: pointer;
}

.checkbox-label {
  font-size: 0.875rem;
  color: #6b7280;
  cursor: pointer;
}

.submit-button {
  width: 100%;
  padding: 0.875rem 1rem;
  background-color: #2563eb;
  color: white;
  border: none;
  border-radius: 6px;
  font-weight: 600;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.2s;
  margin-top: 0.5rem;
}

.submit-button:hover {
  background-color: #1d4ed8;
}

.submit-button:active {
  background-color: #1e40af;
}

.footer-section {
  border-top: 1px solid #e5e7eb;
  padding-top: 1.5rem;
  text-align: center;
}

.authorized-text {
  font-size: 0.75rem;
  font-weight: 600;
  color: #9ca3af;
  letter-spacing: 0.5px;
  margin-bottom: 0.5rem;
}

.support-text {
  font-size: 0.875rem;
  color: #6b7280;
  margin-bottom: 1rem;
}

.support-link {
  color: #2563eb;
  text-decoration: none;
  font-weight: 500;
}

.support-link:hover {
  text-decoration: underline;
}

.footer-icons {
  display: flex;
  gap: 1rem;
  justify-content: center;
  margin: 1rem 0;
}

.icon-link {
  width: 36px;
  height: 36px;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #e5e7eb;
  border-radius: 6px;
  text-decoration: none;
  color: #6b7280;
  font-size: 1rem;
  transition: background-color 0.2s;
}

.icon-link:hover {
  background-color: #d1d5db;
}

.copyright {
  font-size: 0.75rem;
  color: #d1d5db;
}
</style>