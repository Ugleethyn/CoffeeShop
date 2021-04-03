let modal = document.querySelectorAll(".modules");
let btn = document.querySelectorAll(".myBtn");
let span = document.querySelectorAll(".close");
let sugars = document.querySelectorAll('.sugars');

for (let i = 0; i < btn.length; i++) {
    btn[i].onclick = function () {
        modal[i].style.display = "block";
    };
};

span.forEach(function (e) {
    e.onclick = function () {
        modal.forEach(function (e) {
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

function coffeeFilter() {
    document.getElementById("coffees").style.display = "block";
    document.getElementById("snacks").style.display = "none";
    document.getElementById("drinks").style.display = "none";
};

function allProducts() {
    document.getElementById("coffees").style.display = "block";
    document.getElementById("snacks").style.display = "block";
    document.getElementById("drinks").style.display = "block";
};

function snackFilter() {
    document.getElementById("coffees").style.display = "none";
    document.getElementById("snacks").style.display = "block";
    document.getElementById("drinks").style.display = "none";
};

function drinkFilter() {
    document.getElementById("coffees").style.display = "none";
    document.getElementById("snacks").style.display = "none";
    document.getElementById("drinks").style.display = "block";
};

