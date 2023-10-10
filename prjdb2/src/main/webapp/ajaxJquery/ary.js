/*
ary.js
*/

const myNumbers = [20, 30, 45, 66, 88, 22];
let sum = 0;
for (let i = 0; i < myNumbers.length; i++) {
	console.log(myNumbers[i]);
	sum += myNumbers[i];
}
sum = 0;

for (let num of myNumbers) {
	sum += num;
}
sum = 0;
myNumbers.forEach(function(elem, idx){
	console.log(`index: ${idx}, value: ${elem}`);
	sum += elem;
});
console.log(`배열의 누적합: ${sum}`);




let fruits = ['Appel', 'Banana', 'Cherry'];

document.querySelector('.fruits').innerHTML ='';
	fruits.forEach(function(elem,idx){
	
		li = document.createElement('li');      //리스트 만들기	           
		txt = document.createTextNode(elem);
		li.appendChild(txt); 
	 
		let btn = document.createElement('button');    //취소 버튼만들기
		btn.onclick = function(){                      //클릭시 이벤트 발생
			console.log(btn);
			btn.parentElement.remove();                //btn.parentElement 버튼의 상위
		}		
		btn.innerText='삭제';
		li.appendChild(btn);
	
		document.querySelector('.fruits').appendChild(li);
	});