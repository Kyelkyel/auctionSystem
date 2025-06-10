// Dropdown toggle for mobile or hamburger menu
function toggleDropdown() {
  const dropdown = document.getElementById("dropdownContent");
  dropdown.classList.toggle("show");
}

// Hide dropdown when clicking outside
window.onclick = function (event) {
  if (!event.target.matches('.dropbtn')) {
    const dropdowns = document.getElementsByClassName("dropdown-content");
    for (let i = 0; i < dropdowns.length; i++) {
      dropdowns[i].classList.remove('show');
    }
  }
}

// Filter cards by category and toggle <h2> headings
function filterCategory(category, event) {
  if (event) event.preventDefault(); // Prevent page from jumping

  const cards = document.querySelectorAll('.auction-card');
  const headings = document.querySelectorAll('.h2');

  cards.forEach(card => {
    const cardCategory = card.getAttribute('data-category');
    if (category === 'all' || cardCategory === category) {
      card.style.display = 'block';
    } else {
      card.style.display = 'none';
    }
  });

  // Show headings only for 'all' category
  headings.forEach(h2 => {
    h2.style.display = category === 'all' ? 'block' : 'none';
  });
}
