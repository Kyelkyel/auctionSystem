function searchProducts() {
  const input = document.getElementById("searchInput").value.toLowerCase();
  const cards = document.querySelectorAll('.auction-card');
  let visibleCount = 0;

  cards.forEach(card => {
    const textContent = card.textContent.toLowerCase();
    if (textContent.includes(input)) {
      card.style.display = "block";
      visibleCount++;
    } else {
      card.style.display = "none";
    }
  });

  const noResultsMessage = document.getElementById("noResultsMessage");
  if (visibleCount === 0) {
    noResultsMessage.style.display = "block";
  } else {
    noResultsMessage.style.display = "none";
  }
}

const searchInput = document.getElementById("searchInput");
searchInput.addEventListener("focus", (event) => {
  const x = window.scrollX;
  const y = window.scrollY;
  setTimeout(() => {
    window.scrollTo(x, y);
  }, 0);
});