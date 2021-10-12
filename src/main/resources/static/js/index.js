/*
document.getElementById('curiosity').addEventListener('click', curiosityFunction);

function curiosityFunction() {
    alert('salam');
}*/

// let userId = localStorage.getItem('userId');
let userId = getUrlParameter('userId');
if(userId == null || userId.length == ''){
    userId = localStorage.getItem('userId');
}
if(userId != null && userId != '' && userId != 'null'){
    localStorage.setItem('userId', userId);
    document.getElementById('userId').value = userId;
}

let marsApiButtons = document.querySelectorAll("button[id*='marsApi']");
marsApiButtons.forEach(button => button.addEventListener('click', buttonFunction));

function buttonFunction() {
    const buttonId = this.id;
    const roverId = buttonId.split('Api')[1];
    let apiData = document.getElementById('marsApiRoverData');
    apiData.value = roverId;
    document.getElementById('frmRoverType').submit();
}

function getUrlParameter(name) {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    var results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
};

let marsSol = document.getElementById('marsSol').value;
if(marsSol != null &&  marsSol != ''  && marsSol >= 0){
    document.getElementById('marsSol').value = marsSol;
}

let marsRoverType = document.getElementById('marsApiRoverData').value;
highLightButtonByRoverType(marsRoverType);

function highLightButtonByRoverType(roverType) {
    if (roverType == '')
        roverType = 'Opportunity';
    document.getElementById('marsApi' + roverType).classList.remove('btn-primary');
    document.getElementById('marsApi' + roverType).classList.add('btn-secondary');
}

/*if(marsRoverType == 'Opportunity'){
    document.getElementById('marsApiOpportunity').classList.remove('btn-primary');
    document.getElementById('marsApiOpportunity').classList.add('btn-secondary');
} else if (marsRoverType == 'Curiosity') {
    document.getElementById('marsApiCuriosity').classList.remove('btn-primary');
    document.getElementById('marsApiCuriosity').classList.add('btn-secondary');

}else if (marsRoverType == 'Spirit'){
    document.getElementById('marsApiSpirit').classList.remove('btn-primary');
    document.getElementById('marsApiSpirit').classList.add('btn-secondary');
} else{
    document.getElementById('marsApiOpportunity').classList.remove('btn-primary');
    document.getElementById('marsApiOpportunity').classList.add('btn-secondary');
}*/


