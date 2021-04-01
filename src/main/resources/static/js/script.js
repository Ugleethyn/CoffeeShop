let modal = document.querySelectorAll(".modules");
let btn = document.querySelectorAll(".myBtn");
let span = document.querySelectorAll(".close");
let sugars = document.querySelectorAll('.sugars');

for (let i=0; i<btn.length; i++){
    btn[i].onclick = function () {
        modal[i].style.display ="block";
    };
};



span.forEach(function (e) {
  e.onclick = function () {  
  modal.forEach(function (e){
        e.style.display = "none";
    });
    };
});

window.onclick = function (e) {
  modal.forEach(function (f) {
    if (e.target === f) {
      f.style.display = "none";
    };
  });
};
