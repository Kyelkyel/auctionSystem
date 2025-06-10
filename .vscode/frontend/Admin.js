const auctionForm = document.getElementById('auction-form');
  const auctionList = document.getElementById('auction-list');
  const totalAuctions = document.getElementById('total-auctions');

  auctionForm.addEventListener('submit', function(e) {
    e.preventDefault();
    const title = document.getElementById('title').value;
    const price = document.getElementById('price').value;
    const status = document.getElementById('status').value;

    const row = document.createElement('tr');
    row.innerHTML = `
      <td>${title}</td>
      <td>₱${price}</td>
      <td>${status}</td>
      <td><button onclick="deleteAuction(this)">Delete</button></td>
    `;
    auctionList.appendChild(row);

    // Clear form
    auctionForm.reset();

    // Update dashboard count
    totalAuctions.textContent = auctionList.children.length;
  });

  function deleteAuction(button) {
    const row = button.closest('tr');
    row.remove();
    totalAuctions.textContent = auctionList.children.length;
  }

  function approveItem(button) {
  const row = button.closest('tr');
  const title = row.children[0].textContent;
  const price = row.children[1].textContent;

  // Move to active auctions
  const approvedRow = document.createElement('tr');
  approvedRow.innerHTML = `
    <td>${title}</td>
    <td>${price}</td>
    <td>Pending</td>
    <td><button onclick="deleteAuction(this)">Delete</button></td>
  `;
  auctionList.appendChild(approvedRow);

  // Remove from pending
  row.remove();
  totalAuctions.textContent = auctionList.children.length;
}

function rejectItem(button) {
  const row = button.closest('tr');
  row.remove();
}