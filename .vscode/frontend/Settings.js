function previewImage(event) {
      const preview = document.getElementById("preview");
      const file = event.target.files[0];
      if (file) {
        preview.src = URL.createObjectURL(file);
        preview.style.display = "block";
      }
    }