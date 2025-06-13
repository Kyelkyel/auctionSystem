function saveProfile() {
  const usernameInput = document.getElementById('username');
  alert('Username updated to: ' + usernameInput.value);
}

// Preview uploaded image
document.getElementById('uploadImage').addEventListener('change', function () {
  const file = this.files[0];
  if (file) {
    const reader = new FileReader();
    reader.onload = function (e) {
      document.getElementById('profileImage').src = e.target.result;
    };
    reader.readAsDataURL(file);
  }
});
