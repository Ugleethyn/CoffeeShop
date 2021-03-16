
const form = document.getElementById('demo');
const sizeradios = form.elements.sizes;
const defaultsize = sizeradios[0];
defaultsize.checked = true;

const sugarradios = form.elements.sugar;
const defaultsugar = sugarradios[0];
defaultsugar.checked = true;

// Get the modal
let modal = document.getElementById("myModal");

// Get the button that opens the modal
let btn = document.querySelectorAll(".myBtn");

// Get the <span> element that closes the modal
let span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.forEach(function (e) {
  e.onclick = function () {
      alert("Hello");
    modal.style.display = "block";
  };
});

// When the user clicks on <span> (x), close the modal
span.onclick = function () {
  modal.style.display = "none";
};

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
  if (event.target == modal) {
    modal.style.display = "none";
  };
};
