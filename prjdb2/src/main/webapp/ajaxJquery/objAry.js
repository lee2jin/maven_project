/*
objAry.js
*/

const mem1 = {
	name: "홍길동",
	age: 20,
	phone: '010-1111'
}
const mem2 = {
	name: "김길동",
	age: 22,
	phone: '010-2222'
}

const mem3 = {
	name: "박길동",
	age: 30,
	phone: '010-3333'
}

const members = [mem1, mem2, mem3];
let target = document.querySelector('#memberList>tbody')
members.forEach(addMemberFnc); //배열요소, 인덱스, array

document.querySelector('#memberList>tbody button').onclick = function(e){
	e.target.parentElement.parentElement.remove();
}

document.querySelector('#memberList>tbody button').setAttribute('style', 'color: red');
document.querySelectorAll('#memberList>tbody>tr').forEach(function(tr) {
	tr.addEventListener('mouseover', function() {
		tr.setAttribute('style', 'background: yellow');
	})
	tr.addEventListener('mouseout', function() {
		tr.setAttribute('style', 'background: null');
	})
})

document.querySelector(".add").addEventListener('click', function() {
	const member = {
	name: document.querySelector('input[name=name]').value,
	age: document.querySelector('input[name=age]').value,
	phone: document.querySelector('input[name=phone]').value,
	
	}

	addMemberFnc(member);
});

function addMemberFnc(member = {}) {
	let tr = document.createElement('tr');
	for (let prop in member) {
		let td = document.createElement('td');
		td.innerHTML = member[prop];
		tr.appendChild(td);
	}
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.addEventListener('click', function(e) {
		console.log(e);                      //this
		this.parentElement.parentElement.remove();
	});
	btn.innerText = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);
	target.appendChild(tr);
}

document.querySelector('#memberList>tbody button').onclick = function(e) {
	e.target.parentElement.parentElement.remove();
}



