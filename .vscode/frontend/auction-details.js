// Main page — bind data and redirect
if (document.querySelectorAll(".auction-card").length) {
  document.querySelectorAll(".auction-card").forEach(card => {
    card.addEventListener("click", (e) => {
      if (e.target.classList.contains("bid-button")) return;

      const title = card.querySelector(".auction-title")?.innerText || "";
      const price = card.querySelector(".auction-price")?.innerText || "";
      const time = card.querySelector(".auction-time")?.innerText || "";
      const img = card.querySelector("img")?.getAttribute("src") || "";

      const query = new URLSearchParams({
        title,
        price,
        time,
        img
      }).toString();

      window.location.href = `auction-detail.html?${query}`;
    });
  });
}

// Detail page — display data
if (window.location.pathname.includes("auction-detail.html")) {
  const params = new URLSearchParams(window.location.search);

  const title = params.get("title");
  const price = params.get("price");
  const time = params.get("time");
  const img = params.get("img");

  // Set elements dynamically, if they exist
  const titleEl = document.getElementById("product-title");
  const priceEl = document.getElementById("price");
  const buyEl = document.getElementById("buy-price");
  const imgEl = document.getElementById("product-img");
  const timerEl = document.getElementById("timer");

  if (titleEl) titleEl.innerText = title || "Product Title";
  if (priceEl) priceEl.innerText = price || "$0.00";
  if (buyEl) buyEl.innerText = price || "$0.00";
  if (imgEl) imgEl.src = img || "../../images/default.jpg";
  if (timerEl) timerEl.innerText = time || "Coming Soon";
}
