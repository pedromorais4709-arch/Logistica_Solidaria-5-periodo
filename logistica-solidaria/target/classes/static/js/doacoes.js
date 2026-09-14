const searchInput = document.getElementById("searchDonations");
const statusFilter = document.getElementById("statusFilter");
const categoryFilter = document.getElementById("categoryFilter");
const cards = document.querySelectorAll(".donation-card");
const emptyState = document.getElementById("emptyState");

function filterDonations() {
  const search = (searchInput.value || "").toLowerCase().trim();
  const status = statusFilter.value;
  const category = categoryFilter.value;
  let visible = 0;

  cards.forEach(card => {
    const text = `${card.dataset.name} ${card.dataset.category} ${card.dataset.location}`.toLowerCase();
    const matchesSearch = text.includes(search);
    const matchesStatus = !status || card.dataset.status === status;
    const matchesCategory = !category || card.dataset.category === category;
    const show = matchesSearch && matchesStatus && matchesCategory;

    card.style.display = show ? "" : "none";
    if (show) visible++;
  });

  emptyState.classList.toggle("show", visible === 0);
}

[searchInput, statusFilter, categoryFilter].forEach(el => el.addEventListener("input", filterDonations));
[statusFilter, categoryFilter].forEach(el => el.addEventListener("change", filterDonations));

const modal = document.getElementById("detailsModal");
const modalDetails = document.getElementById("modalDetails");

document.querySelectorAll(".details-btn").forEach(button => {
  button.addEventListener("click", () => {
    const card = button.closest(".donation-card");
    modalDetails.innerHTML = `
      <span class="eyebrow">${card.dataset.category}</span>
      <h2>${card.dataset.name}</h2>
      <p style="color:#68756d;margin:10px 0 20px">${card.querySelector("p").textContent}</p>
      <div class="profile-info-grid" style="padding:0;border:0;grid-template-columns:1fr 1fr">
        <div><span>Quantidade</span><strong>${card.querySelector(".donation-meta span:nth-child(1)").textContent.replace("📦 ","")}</strong></div>
        <div><span>Status</span><strong>${card.dataset.status}</strong></div>
        <div><span>Localização</span><strong>${card.dataset.location}</strong></div>
        <div><span>Data</span><strong>${card.querySelector(".donation-meta span:nth-child(3)").textContent.replace("📅 ","")}</strong></div>
      </div>
    `;
    modal.classList.add("show");
  });
});

document.querySelector("[data-close]")?.addEventListener("click", () => modal.classList.remove("show"));
