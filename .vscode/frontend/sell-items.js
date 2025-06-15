
  const loggedInUser = {
    name: "USER 01",
    email: "user01@example.com",
    phone: "09171234567",
    location: "Manila, Philippines"
  };

  window.addEventListener("DOMContentLoaded", () => {
    document.getElementById("sellerName").value = loggedInUser.name;
    document.getElementById("sellerEmail").value = loggedInUser.email;
    document.getElementById("sellerPhone").value = loggedInUser.phone;
    document.getElementById("sellerLocation").value = loggedInUser.location;
  });
