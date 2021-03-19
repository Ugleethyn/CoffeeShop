let modal = document.getElementById("myModal");

<<<<<<< HEAD
=======
let modal = document.getElementById("myModal");

>>>>>>> e75024120ed980e7adfedeee9f2fa85161619987

let btn = document.querySelectorAll(".myBtn");

let span = document.getElementsByClassName("close")[0];

btn.forEach(function (e) {
    e.onclick = function () {
        modal.style.display = "block";
    };
});


span.onclick = function () {
<<<<<<< HEAD
    modal.style.display = "none";
=======
  modal.style.display = "none";
>>>>>>> e75024120ed980e7adfedeee9f2fa85161619987
};


window.onclick = function (event) {
<<<<<<< HEAD
    if (event.target === modal) {
        modal.style.display = "none";
    }
    ;
=======
  if (event.target === modal) {
    modal.style.display = "none";
  };
>>>>>>> e75024120ed980e7adfedeee9f2fa85161619987
};

let form = document.querySelector('.demo');
let sizeradios = form.elements.size;
let defaultsize = sizeradios[0];
defaultsize.checked = true;

let sugarradios = form.elements.sugar;
let defaultsugar = sugarradios[0];
<<<<<<< HEAD
defaultsugar.checked = true;
=======
defaultsugar.checked = true;
>>>>>>> e75024120ed980e7adfedeee9f2fa85161619987
