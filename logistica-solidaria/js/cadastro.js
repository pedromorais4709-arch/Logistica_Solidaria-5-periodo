const cadastroForm = document.getElementById("cadastroForm");
if (cadastroForm) {
  cadastroForm.addEventListener("submit", e => {
    e.preventDefault();

    const fields = {
      nome: document.getElementById("nome"),
      telefone: document.getElementById("telefone"),
      email: document.getElementById("cadEmail"),
      tipo: document.getElementById("tipo"),
      senha: document.getElementById("cadSenha"),
      confirmar: document.getElementById("confirmarSenha")
    };

    Object.keys(fields).forEach(key => {
      const error = document.getElementById(key === "email" ? "cadEmailError" :
        key === "confirmar" ? "confirmarSenhaError" : key + "Error");
      if (error) error.textContent = "";
    });

    let valid = true;
    const show = (id, text) => { document.getElementById(id).textContent = text; valid = false; };

    if (fields.nome.value.trim().length < 3) show("nomeError", "Informe seu nome completo.");
    if (fields.telefone.value.trim().length < 8) show("telefoneError", "Informe um telefone válido.");
    if (!fields.email.value.includes("@")) show("cadEmailError", "Digite um e-mail válido.");
    if (!fields.tipo.value) show("tipoError", "Selecione o tipo de usuário.");
    if (fields.senha.value.length < 6) show("cadSenhaError", "Use pelo menos 6 caracteres.");
    if (fields.senha.value !== fields.confirmar.value) show("confirmarSenhaError", "As senhas não são iguais.");

    const termos = document.getElementById("termos");
    if (!termos.checked) {
      alert("Aceite os termos de uso para continuar.");
      valid = false;
    }

    const message = document.getElementById("cadastroMessage");
    if (!valid) {
      message.classList.remove("show");
      return;
    }

    message.textContent = "Cadastro validado com sucesso! Em um sistema real, os dados seriam enviados ao servidor.";
    message.classList.add("show");
    cadastroForm.reset();
  });
}
