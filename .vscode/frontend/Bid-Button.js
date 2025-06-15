document.addEventListener("DOMContentLoaded", () => {
  const modal = document.getElementById('bid-modal');
  const closeBidBtn = document.getElementById('close-bid-modal');
  const submitBtn = document.getElementById('submit-bid');

  // Simulated logged-in user
  const loggedInUser = {
    name: "USER 01",
    email: "user01@example.com",
    phone: "09171234567",
    location: "Manila, Philippines"
  };

  if (modal && closeBidBtn && submitBtn) {
    document.querySelectorAll('.bid-button').forEach(button => {
      button.addEventListener('click', () => {
        modal.style.display = 'flex';
        // Autofill username when opening modal
        document.getElementById('bid-username').value = loggedInUser.name;
      });
    });

    closeBidBtn.onclick = () => {
      modal.style.display = 'none';
    };

    window.onclick = (event) => {
      if (event.target === modal) {
        modal.style.display = 'none';
      }
    };

    submitBtn.onclick = () => {
      const username = document.getElementById('bid-username').value.trim();
      const amount = parseFloat(document.getElementById('bid-amount').value);
      const comments = document.getElementById('bid-comments').value.trim();

      if (!username) {
        alert('Please enter your username.');
        return;
      }

      if (isNaN(amount) || amount <= 0) {
        alert('Please enter a valid bid amount.');
        return;
      }

      addBid(username, amount);
      modal.style.display = 'none';

      document.getElementById('bid-username').value = '';
      document.getElementById('bid-amount').value = '';
      document.getElementById('bid-comments').value = '';
    };
  }

  function addBid(username, amount) {
    const table = document.getElementById('bids-table');
    if (!table) return;

    for (let i = 1; i < table.rows.length; i++) {
      const row = table.rows[i];
      const statusCell = row.cells[3];
      statusCell.textContent = '';
      statusCell.style.fontWeight = '';
      statusCell.style.color = '';
    }

    const newRow = table.insertRow(1);
    newRow.insertCell(0).textContent = username;
    newRow.insertCell(1).textContent = '$' + amount.toFixed(2);

    const now = new Date();
    newRow.insertCell(2).textContent = now.getHours() + ":" + now.getMinutes();

    const statusCell = newRow.insertCell(3);
    statusCell.textContent = 'Highest Bid';
    statusCell.style.fontWeight = 'bold';
    statusCell.style.color = 'green';
  }
});
