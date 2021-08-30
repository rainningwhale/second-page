// 获取元素和点击操作
const signInBtn = document.getElementById("signIn");
const signUpBtn = document.getElementById("signUp");
const fistForm = document.getElementById("form1");
const secondForm = document.getElementById("form2");
const container = document.querySelector(".container");

signInBtn.addEventListener("click", () => {
	container.classList.remove("right-panel-active");
});

signUpBtn.addEventListener("click", () => {
	container.classList.add("right-panel-active");
});

// fistForm.addEventListener("submit", (e) => e.preventDefault());
// secondForm.addEventListener("submit", (e) => e.preventDefault());
// window.onload = function(){
// 	var change = document.getElementById("change");
// 	change.onclick = function () {
//
// 		var date = new Date().getTime();
// 		change.href = "/day15/CheckCodeServlet?"+date;
//
// 	}
// }

window.onload = function () {
	//1,获取图片对象
	var img = document.getElementById("checkcode");

	//2.绑定单机事件
	img.onclick = function () {
		//加时间戳
		var date = new Date().getTime();

		img.src = "/day15/CheckCodeServlet?"+date;

	}

}