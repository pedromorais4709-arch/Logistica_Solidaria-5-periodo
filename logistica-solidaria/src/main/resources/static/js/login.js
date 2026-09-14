const loginForm = document.getElementById("loginForm");
if (loginForm) {
  loginForm.addEventListener("submit", e => {
    e.preventDefault();
    const email = document.getElementById("email");
    const senha = document.getElementById("senha");
    const emailError = document.getElementById("emailError");
    const senhaError = document.getElementById("senhaError");
    const message = document.getElementById("loginMessage");

    emailError.textContent = "";
    senhaError.textContent = "";
    message.classList.remove("show");

    let valid = true;
    if (!email.value.trim() || !email.value.includes("@")) {
      emailError.textContent = "Digite um e-mail válido.";
      valid = false;
    }
    if (senha.value.length < 6) {
      senhaError.textContent = "A senha deve ter pelo menos 6 caracteres.";
      valid = false;
    }

    if (!valid) return;

    message.textContent = "Login validado com sucesso! Em um sistema real, o usuário seria autenticado pelo back-end.";
    message.classList.add("show");
  });
}

const forgotPassword = document.getElementById("forgotPassword");
if (forgotPassword) {
  forgotPassword.addEventListener("click", e => {
    e.preventDefault();
    alert("Demonstração acadêmica: a recuperação de senha seria enviada por e-mail.");
  });
}
