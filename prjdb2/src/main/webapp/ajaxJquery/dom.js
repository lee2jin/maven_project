/**
 * dom.js 
 */

		let ul = document.createElement('ul'); //DOM
		let li = document.createElement('li');
		
		li.setAttribute('class','second');		
		let txt = document.createTextNode('Apple');
		li.appendChild(txt); //txt가 li의 자식요소
		ul.appendChild(li);
		
		li = document.createElement('li');
		li.setAttribute('class','second');
		txt = document.createTextNode('Banana');
		li.appendChild(txt); 
		ul.appendChild(li);
		
		console.log(ul);
		
		document.getElementById('clone').appendChild(ul);
		
		
		
		