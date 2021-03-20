let modal = document.getElementById("myModal");


let btn = document.querySelectorAll(".myBtn");

let span = document.getElementsByClassName("close")[0];

btn.forEach(function (e) {
  e.onclick = function () {
    modal.style.display = "block";
  };
});


span.onclick = function () {
  modal.style.display = "none";
};


window.onclick = function (event) {
  if (event.target === modal) {
    modal.style.display = "none";
  };
};

let sizes = document.querySelectorAll('.sizes');
let defaultsize = sizes[0];
defaultsize.checked = true;

let sugars = document.querySelectorAll('.sugars');
let defaultsugar = sugars[0];
defaultsugar.checked = true;

$(document).ready(function() {
  $(".dropdown-toggle").dropdown();
});