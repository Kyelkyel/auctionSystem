  document.querySelectorAll(".auction-card").forEach(card => {
    card.addEventListener("click", (e) => {
      // Prevent the button from triggering the redirect separately
      if (e.target.classList.contains("bid-button")) return;

      const title = card.querySelector(".auction-title").innerText;
      const price = card.querySelector(".auction-price").innerText;
      const time = card.querySelector(".auction-time").innerText;
      const img = card.querySelector("img").getAttribute("src");

      // Redirect to detail page with data as query string
      window.location.href = `auction-detail.html?title=${encodeURIComponent(title)}&price=${encodeURIComponent(price)}&time=${encodeURIComponent(time)}&img=${encodeURIComponent(img)}`;
    });
  });

const params = new URLSearchParams(window.location.search);
document.getElementById("product-title").innerText = params.get("title") || "Apple MacBook";
document.getElementById("price").innerText = params.get("price") || "$0.00";
document.getElementById("buy-price").innerText = params.get("price") || "$0.00";
document.getElementById("product-img").src = params.get("img") || "../../images/default.jpg";
document.getElementById("timer").innerText = params.get("time") || "Coming Soon";
