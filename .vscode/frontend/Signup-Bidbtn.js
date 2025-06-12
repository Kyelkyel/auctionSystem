 function openModal() {
    document.getElementById("login-modal").style.display = "block";
  }

  function closeModal() {
    document.getElementById("login-modal").style.display = "none";
  }

  function redirectToSignup() {
    window.location.href = "Sign-up.html";
  }

  function redirectToLogin() {
    window.location.href = "Log-in.html";
  }

  document.addEventListener("DOMContentLoaded", function () {
    const bidButtons = document.querySelectorAll(".bid-button");
    bidButtons.forEach(button => {
      button.addEventListener("click", openModal);
    });
  });