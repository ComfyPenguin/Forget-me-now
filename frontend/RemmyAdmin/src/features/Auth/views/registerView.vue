<script setup lang="ts">
import RegisterForm from "@/features/Auth/components/registerForm.vue";
</script>
<template>
<div class="loginContainer">
  <div class="left">
    <div class="left-content">
      <div class="logo-section">
        <div class="logo-icon">XD</div>
        <h1 class="logo-text">BlosteSoftware</h1>
      </div>
      <h2 class="tagline"> Robusto como un poste </h2>
    </div>
  </div>
  <div class="right">
    <RegisterForm/>
  </div>
</div>
</template>
<style>

.loginContainer {
  display: flex;
  height: calc(100vh - 64px);
  width: 100vw;                    
  background-color: #f3f4f6;
  margin-left: calc(-50vw + 50%);  
}


.left {
  flex: 1;
  background: linear-gradient(135deg, #4a9b8e 0%, #2d7a6e 50%, #1e5a54 100%);
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 2rem;
  color: white;
}

.left-content {
  max-width: 450px;
}

.logo-section {
  display: flex;
  align-items: center;
  gap: 1rem;
  margin-bottom: 2rem;
}

.logo-icon {
  font-size: 2.5rem;
  width: 50px;
  height: 50px;
  display: flex;
  align-items: center;
  justify-content: center;
  background: rgba(255, 255, 255, 0.2);
  border-radius: 8px;
}

.logo-text {
  font-size: 1.5rem;
  font-weight: 700;
  letter-spacing: 0.5px;
}

.tagline {
  font-size: 2rem;
  font-weight: 700;
  line-height: 1.3;
  margin-bottom: 1.5rem;
}

.description {
  font-size: 0.95rem;
  line-height: 1.6;
  opacity: 0.9;
}

.right {
  flex: 1;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 2rem;
  background-color: #ffffff;
}

@media (max-width: 768px) {
  .loginContainer {
    flex-direction: column;
  }
  
  .left {
    height: 40%;
    border-radius: 0 0 16px 16px;
  }
  
  .right {
    height: 60%;
  }
  
  .tagline {
    font-size: 1.5rem;
  }
}
</style>