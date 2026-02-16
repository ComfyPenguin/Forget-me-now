/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{vue,js,ts,jsx,tsx}",
    // "./stories/**/*.{js,ts,jsx,tsx,vue}", // uncomment for Storybook
  ],
  darkMode: 'class',          // or 'media' — 'class' is better for manual toggles
  theme: {
    extend: {
      colors: {
        // Semantic surface / background
        bg: {
          DEFAULT: 'var(--bg)',       // main background
          dark:  'var(--bg-dark)',
          light: 'var(--bg-light)',
        },

        // Text
        text: {
          DEFAULT: 'var(--text)',
          muted:   'var(--text-muted)',
        },

        // UI elements
        highlight: 'var(--highlight)',
        border: {
          DEFAULT: 'var(--border)',
          muted:   'var(--border-muted)',
        },

        // Status / brand colors
        primary:   'var(--primary)',
        secondary: 'var(--secondary)',
        danger:    'var(--danger)',
        warning:   'var(--warning)',
        success:   'var(--success)',
        info:      'var(--info)',
      },
    },
  },
  plugins: [],
}