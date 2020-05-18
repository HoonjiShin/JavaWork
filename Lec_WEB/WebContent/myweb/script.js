$(function(){
	createSticky($(".main-main-wrapper"));
});
function createSticky(sticky) {
	if (typeof sticky !== "undefined") {
		var	pos = sticky.offset().top,
				win = $(window);

		win.on("scroll", function() {
    		win.scrollTop() >= pos ? sticky.addClass("fixed-header") : sticky.removeClass("fixed-header");
		});
	}
}

$('ul.list-group li.dropdown').hover(function(){
    $(this).find('.dropdown-menu').stop(true,true).delay(200).fadeIn(500);
	}
	,
    function(){
        $(this).find('.dropdown-menu').stop(true,true).delay(200).fadeOut(500);
	}
	);
	function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
  document.getElementById("navbar_side").style.transform="none";
  document.getElementById("navbar_side").style.left="0%";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("navbar_side").style.transform ="translateX(-50%)";
  document.getElementById("navbar_side").style.left="50%";
}

$(document).on('ready', function() {
	$(".regular").slick({
		dots: true,
		infinite: true,
		slidesToShow: 4,
		slidesToScroll: 4,
		responsive: [
			{
			breakpoint: 1024,

				settings: {
				slidesToShow: 3,
				slidesToScroll: 3,
				infinite: true,
				dots: true
				}
			},

			{
			breakpoint: 600,
				settings: {
				slidesToShow: 2,
				slidesToScroll: 2
				}
			},

			{
			breakpoint: 480,
				settings: {
				slidesToShow: 1,
				slidesToScroll: 1
				}
			}
		]
	});
});

function showData(url){
    var result = "Your Infomation <br>";

    var frm = document.forms["sign-up"];

    var userid = frm["finputEmail"].value;
    var userpw = frm["finputPassword"].value;
    var useraddr1 = frm["finputAddress"].value;
    var useraddr2 = frm["finputAddress2"].value;
    var usercity = frm["finputCity"].value;
    var userstate = frm["finputState"].value;
	var userzip = frm["finputZip"].value;

	if((userid == "")||(userid == null)){
		alert("Insert Your ID");
		return;
	}else if((userpw == "")||(userpw == null)){
		alert("Insert Your Password");
		return;
	}

	alert( "EMAIL:  " + userid + "\n" + "PW:  " + userpw + "\n" +
							"ADDRESS:  " + useraddr1 + " " + useraddr2 + "\n" +
							"CITY:  " + userstate + " " + usercity + "\n"
	);

}


function up(max) {
    document.getElementById("myNumber").value = parseInt(document.getElementById("myNumber").value) + 1;
    if (document.getElementById("myNumber").value >= parseInt(max)) {
        document.getElementById("myNumber").value = max;
    }
}

function down(min) {
    document.getElementById("myNumber").value = parseInt(document.getElementById("myNumber").value) - 1;
    if (document.getElementById("myNumber").value <= parseInt(min)) {
        document.getElementById("myNumber").value = min;
    }
}

function success(){
	var result = "";
	var email = document.getElementById("exampleInputEmail1").value;
	var passwd = document.getElementById("exampleInputPassword1").value;
	var login_chk = document.getElementById("exampleCheck1");

	if(email == ""||email == null){
		alert("이메일을 입력하세요");
		return;
	}else if(passwd == "" || passwd == null){
		alert("비밀번호를 입력하세요");
		return;
	}else if(login_chk.checked ==false){
		alert("Are you a robot??");
		return;
	}
	alert("Hello! " + email +"\nWelcome to Our Webpage!!");

	result += "I'm " + email;

	document.getElementById("result").innerHTML = result;
}

function addtocart(){
	var count = document.getElementById("myNumber").value;
	alert("제품이 "+ count +"개 추가 되었습니다.");
}
