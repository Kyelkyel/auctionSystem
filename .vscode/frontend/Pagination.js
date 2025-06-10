const cards = document.querySelectorAll('.auction-card');
const cardsPerPage = 6;
let currentPage = 1;

// Show only the items for the current page
function showPage(page) {
  const start = (page - 1) * cardsPerPage;
  const end = start + cardsPerPage;

  cards.forEach((card, index) => {
    card.style.display = index >= start && index < end ? 'block' : 'none';
  });

  // Update active page button
  document.querySelectorAll('.page-btn').forEach(btn => {
    btn.classList.toggle('active', parseInt(btn.dataset.page) === page);
  });

  // Update disabled state for Previous/Next
  document.getElementById('prev-page').disabled = page === 1;
  document.getElementById('next-page').disabled = end >= cards.length;
}

// Event listeners for numbered buttons
document.querySelectorAll('.page-btn').forEach(button => {
  button.addEventListener('click', () => {
    currentPage = parseInt(button.dataset.page);
    history.pushState(null, '', `?page=${currentPage}`);

    showPage(currentPage);
  });
});

// Previous and Next buttons
document.getElementById('prev-page').addEventListener('click', () => {
  if (currentPage > 1) {
    currentPage--;
    history.pushState(null, '', `?page=${currentPage}`);
    showPage(currentPage);
  }
});

document.getElementById('next-page').addEventListener('click', () => {
  const totalPages = Math.ceil(cards.length / cardsPerPage);
  if (currentPage < totalPages) {
    currentPage++;
    history.pushState(null, '', `?page=${currentPage}`);
    showPage(currentPage);
  }
});

// Initialize on first load
showPage(currentPage);

