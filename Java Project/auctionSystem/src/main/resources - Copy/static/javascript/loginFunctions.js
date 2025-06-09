// For login button
var loginBtnJS = document.getElementById("loginBtn");
loginBtnJS.onclick = btnAlert;
function btnAlert() {
    var usernameJS = document.getElementById("username").value;
    var passwordJS = document.getElementById("password").value;
    alert("Button clicked!" + usernameJS + " " + passwordJS);
  };


function validateLoginForm(username, password) {
  if (!username || !password) {
    return "Username and password are required";
  }
  return null;
}


function login() {
  const username = document.getElementById("username").value;
  const password = document.getElementById("password").value;

  const error = validateLoginForm(username, password);
  if (error) {
    alert(error);
    return;
  }

  // Example: simple hardcoded check (replace with real auth)
  if (username === "user" && password === "pass") {
    localStorage.setItem("loggedInUser", username);
    alert("Login successful!");
    // Redirect to protected page
    window.location.href = "home.html";
  } else {
    alert("Invalid username or password");
  }
}

function logout() {
  localStorage.removeItem("loggedInUser");
  window.location.href = "login.html";
}
