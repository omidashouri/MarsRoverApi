/*
document.getElementById('curiosity').addEventListener('click', curiosityFunction);

function curiosityFunction() {
    alert('salam');
}*/

let marsApiButtons = document.querySelectorAll("button[id*='marsApi']");
marsApiButtons.forEach(button => button.addEventListener('click', buttonFunction));

function buttonFunction() {
    const buttonId = this.id;
    const roverId = buttonId.split('Api')[1];
    let apiData = document.getElementById('marsApiRoverData');
    apiData.value = roverId;
    document.getElementById('frmRoverType').submit();
}
