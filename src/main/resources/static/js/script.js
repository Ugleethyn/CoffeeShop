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
    }
    ;
};

let form = document.querySelector('.demo');
let sizeradios = form.elements.size;
let defaultsize = sizeradios[0];
defaultsize.checked = true;

let sugarradios = form.elements.sugar;
let defaultsugar = sugarradios[0];
defaultsugar.checked = true;