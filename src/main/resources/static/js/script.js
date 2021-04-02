let sugars = document.querySelectorAll('.sugars');
let modal = document.querySelectorAll(".modules");
let btn = document.querySelectorAll(".myBtn");
let span = document.querySelectorAll(".close");

let span = document.querySelectorAll(".");
let span = document.querySelectorAll(".close");


for (let i = 0; i < btn.length; i++) {
    btn[i].onclick = function () {
        modal[i].style.display = "block";
    };
}
;

for (let i = 0; i < modal.length; i++) {
    for (let j = 0; j < sugars.length; j += 3) {
        sugars[j].checked = true;
    }
}
;


span.forEach(function (e) {
    e.onclick = function () {
        modal.forEach(function (e) {
            e.style.display = "none";
        });
    };
});


window.onclick = function (event) {
  modal.forEach(function (f) {
    if (event.target === f) {
      f.style.display = "none";
    };
  });
};