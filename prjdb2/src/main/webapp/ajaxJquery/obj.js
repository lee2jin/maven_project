/*
*obj.js
*/

let name = "Hong"; //String
let age = 20; //number
let obj = {                             //자바스크립트의 객체 표현
	name: name,                         //속성 : 값
	age,                                // 속성, 값 이름이 같으면 이렇게도 표현해도 됨
	phone: '010-1111',
	showInfo: function() {
		return this.name + ", " + this.age;
	}
}

console.log(obj.name);
console.log(obj.age);
console.log(obj['phone']);
console.log(obj.showInfo());
/*for (let prop in obj){
	console.log(prop);
}*/ //이거는 속성값 출력
for (let prop in obj) {
	console.log(`속성: ${prop}, 값: ${obj[prop]}`);
}

obj.hobbies = ['reading', 'eating', 'sleeping']
console.log(obj.hobbies[0]);

let yourHobbies = ['운동하기', '영화보기', '자전거타기']


function makeHobbies(hobbies=[]) {
	for (let i = 0; i < hobbies.length; i++) {
		li = document.createElement('li');             //<li></li>
		txt = document.createTextNode(hobbies[i]); //reading
		li.appendChild(txt);                           //<li>reading</li>
		document.getElementById('myHobby').appendChild(li);
	}
}
makeHobbies(yourHobbies);

/*
//code here. 내가쓴거
ul = document.createElement('ul');
li = document.createElement('li');
txt = document.createTextNode('reading');
li.appendChild(txt);
ul.appendChild(li);

li = document.createElement('li');
txt = document.createTextNode('eating');
li.appendChild(txt);
ul.appendChild(li);

li = document.createElement('li');
txt = document.createTextNode('sleeping');
li.appendChild(txt);
ul.appendChild(li);

console.log(ul);

for(let ele in obj.hobbies){
	console.log(`${obj[ele]}`);
}
*/




