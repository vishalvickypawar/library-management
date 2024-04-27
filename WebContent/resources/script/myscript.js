$(window).scroll(function() {
$var1 = $(window).scrollTop();
$var2 = $("#heading").height();
if($var1>$var2+25){
	$("#menu").addClass("w3-top");
	$("#extra-bar").show();
	$(".small-buttons").show();
}
else{
	$("#menu").removeClass("w3-top");
	$("#extra-bar").hide();
	$(".small-buttons").hide();
}
});

$(document).ready(function() {
    $("#menu-icon").click(function() {
		$("#down-menu").slideToggle("slow");
});
});

$(document).ready(function() {
    $("#drop-head-1").click(function() {
		$("#drop-content-1").slideDown("slow");
	});
    $("#drop-head-1").mouseleave(function() {
		$("#drop-content-1").slideUp("slow");
	});
});


$(document).ready(function(e) {
	$("#staff").hide();
	$("#student-tab-div").addClass("w3-border-teal");
});

$(document).ready(function() {
	$("#student-tab").click(function() {
		$("#student").show();
		$("#staff").hide();
		$("#student-tab-div").addClass("w3-border-teal");
		$("#staff-tab-div").removeClass("w3-border-teal");
});
});

$(document).ready(function() {
	$("#staff-tab").click(function() {
		$("#staff").show();
		$("#student").hide();
		$("#staff-tab-div").addClass("w3-border-teal");
		$("#student-tab-div").removeClass("w3-border-teal");
});
});

$(document).ready(function() {
    var myIndex1 = 1;
	setTimeout(carousel1, 1000);

	function carousel1() {
		
		var i;
		var x = document.getElementsByClassName("mySlides1");
		for (i = 0; i < x.length; i++) {
		   $(x[i]).hide();  
		}
			$(x[myIndex1]).show();
		myIndex1=myIndex1+2;
		if (myIndex1 == x.length) {myIndex1 = 0;}
		else if (myIndex1 == x.length+1) {myIndex1 = 1;}    
		setTimeout(carousel1, 4000);
	}
});


$(document).ready(function() {
	var k=0;
    var myIndex2 = 2;
	setInterval(carousel3, 2000);
	setTimeout(carousel2, 3000);

	function carousel2() {
		
		var i;
		var x = document.getElementsByClassName("mySlides2");
		for (i = 0; i < x.length; i++) {
		   $(x[i]).hide();  
		}  
			$(x[myIndex2]).show();
		myIndex2=myIndex2+2; 
		if (myIndex2 == x.length) {myIndex2 = 0;}
		else if (myIndex2 == x.length+1) {myIndex2 = 1;}			
		setTimeout(carousel2, 4000);
	}
	
	function carousel3() {
		
		$("#slides2").fadeToggle(500);
		k++;
		$(".indicator").removeClass("w3-white");
		$(".middle-text").hide();
		var x = document.getElementsByClassName("indicator");
		var y = document.getElementsByClassName("middle-text");
		$(x[k]).addClass("w3-white");
		$(y[k]).show();
		if (k == x.length-1) {k = -1;}
	}
});

$(document).ready(function(e) {
	$("#video").hide();
	$("#pdf-tab-div").addClass("w3-border-teal");
});

$(document).ready(function() {
	$("#pdf-tab").click(function() {
		$("#pdf").show();
		$("#video").hide();
		$("#pdf-tab-div").addClass("w3-border-teal");
		$("#video-tab-div").removeClass("w3-border-teal");
});
});

$(document).ready(function() {
	$("#video-tab").click(function() {
		$("#video").show();
		$("#pdf").hide();
		$("#video-tab-div").addClass("w3-border-teal");
		$("#pdf-tab-div").removeClass("w3-border-teal");
});
});

function showAns(i){
	$("#"+i).slideToggle("slow");
	$("#"+i).removeClass("answerslist");
	$(".answerslist").slideUp("slow");
	$("#"+i).addClass("answerslist");
}

function showQue(i){
	$("#"+i).show();
}
function rpy(r,n){
	document.getElementById(r).innerHTML=n;
}


function initial() {
	var d = new Date();
	var n = d.getTime();
	$("#t").val(n);
}
function initial1() {
	var d = new Date();
	var n = d.getTime();
	$("#t1").val(n);
}