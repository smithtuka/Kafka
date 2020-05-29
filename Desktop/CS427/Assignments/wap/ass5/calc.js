
function calc(){
  const amount = document.getElementById("amount");
  const tip = document.getElementById("tip");
  const total = document.getElementById("total"); //study this and see how to destructure it if use by Name
  
if(parseInt(amount.value) && parseInt(tip.value)){
  total.innerHTML = "$"+(parseFloat(amount.value)*(1+parseFloat(tip.value)/100)).toFixed(2);
  total.style.fontWeight ="normal";
}
else alert("incorrect input, try again!");
}
