// Interações gerais do site
document.addEventListener("DOMContentLoaded", () => {
  // Menu mobile
  const menuToggle = document.getElementById("menuToggle");
  const navLinks = document.getElementById("navLinks");
  if (menuToggle && navLinks) {
    menuToggle.addEventListener("click", () => navLinks.classList.toggle("open"));
    navLinks.querySelectorAll("a").forEach(link => link.addEventListener("click", () => navLinks.classList.remove("open")));
  }

  // Menu lateral do dashboard
  const sidebarToggle = document.getElementById("sidebarToggle");
  const sidebar = document.getElementById("sidebar");
  if (sidebarToggle && sidebar) {
    sidebarToggle.addEventListener("click", () => sidebar.classList.toggle("open"));
  }

  // Mostrar/ocultar senha
  document.querySelectorAll(".password-toggle").forEach(button => {
    button.addEventListener("click", () => {
      const input = document.getElementById(button.dataset.target);
      if (!input) return;
      input.type = input.type === "password" ? "text" : "password";
      button.textContent = input.type === "password" ? "👁" : "🙈";
    });
  });

  // Contadores das estatísticas
  const counters = document.querySelectorAll(".counter");
  if (counters.length) {
    const animateCounter = counter => {
      const target = Number(counter.dataset.target);
      let current = 0;
      const step = Math.max(1, Math.ceil(target / 60));
      const timer = setInterval(() => {
        current += step;
        if (current >= target) {
          current = target;
          clearInterval(timer);
        }
        counter.textContent = current + "+";
      }, 25);
    };
    const observer = new IntersectionObserver(entries => {
      entries.forEach(entry => {
        if (entry.isIntersecting && !entry.target.dataset.started) {
          entry.target.dataset.started = "true";
          animateCounter(entry.target);
        }
      });
    }, {threshold:.5});
    counters.forEach(c => observer.observe(c));
  }

  // Confirmação de saída
  const logout = document.getElementById("logoutBtn");
  if (logout) {
    logout.addEventListener("click", e => {
      if (!confirm("Deseja realmente sair da sua conta?")) e.preventDefault();
    });
  }

  // Fechar modais clicando no fundo ou no botão
  document.querySelectorAll("[data-close]").forEach(button => {
    button.addEventListener("click", () => {
      const modal = button.closest(".modal");
      if (modal) modal.classList.remove("show");
    });
  });
  document.querySelectorAll(".modal").forEach(modal => {
    modal.addEventListener("click", e => {
      if (e.target === modal) modal.classList.remove("show");
    });
  });
});
