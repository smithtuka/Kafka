"use strict";

var size = 12;
// hello world part
function helloWorld(){
	alert("Hello, World!");			
}
// enlarge text - part1
function enlarged(){
    let texta = document.getElementById("texta");
    texta.style.fontSize = "24pt";
}

function enlargeByTwo(){
    var texta = document.getElementById("texta");
    // texta.value = parseInt(texta.style.fontSize) + "?"; // looks like computed value not coming directly
    texta.style.fontSize = size+=2 + "pt";
    // texta.style.backgroundColor ="grey";
    
}

function growBigger(){
    var texta = document.getElementById("texta"); 
    texta.style.fontSize = (parseInt(texta.style.fontSize)+30) + "pt"; //why no tparsing value?
    // texta.style.backgroundColor ="grey";   
}

function blower2(){
    var textb = document.getElementById("texta");
    // textb.style.fontSize = 6 +"px"; // testing just
    var id = setInterval(sizer, 5000);
    function sizer(){
        if(size<=80){
            textb.style.fontSize = size + "pt";
            size+=2;
        }
        else{
            clearInterval(id);
        }
    }

}