
App = {
	adoptedAry: [], //adapted.json의 정보를 일차적으로 저장하고 초기값으로 쓰고 입양버튼을 누르면 아이디를 저장
	
	init: function() {
		// pets.json 파일의 정보를 읽어서 애완견의 정보를 활용해서 페이지 생성.
		fetch('./json/pets.json')
			.then((resolve) => {
				return resolve.json()
			})
			.then(result => App.info(result));
			},
				// end of init;
		info:function(data){
		  //	console.log(data);
		  data.forEach((pet,idx)=>{
		  let page = document.querySelector('div.col-sm-6').cloneNode(true);
		  
		  page.querySelector('.panel-title').innerText = pet.name;
		  page.querySelector('.pet-breed').innerText = pet.breed;
		  page.querySelector('.pet-age').innerText = pet.age;
		  page.querySelector('.pet-location').innerText = pet.location;
		  page.querySelector('img').src=pet.picture;
		  page.querySelector('button.btn').setAttribute('data-id',pet.id)
		  page.querySelector('button.btn').addEventListener('click', App.initContract);
		  document.querySelector('#petsRow').append(page);
		  })
	}, // end of info;

	initContract: function() {
		//console.log("확인!!!!");
		// bindEvents 호출.
		App.bindEvents();
		// initMarkData 호출.
		App.initMarkData();

	}, // end of initContract;

	bindEvents: function() {
		console.log("확인!!!!");
		
		// 입양버튼에 이벤트 등록. > markAdopted를 활용
	},

	initMarkData: function() {
		console.log("확인~~");
		// adopted.json 정보를 활용해서 입양처리하기.
		fetch('./json/adopted.json')
			.then((resolve) => {
				return resolve.json()
			})
			.then(result => {
				console.log(result);
				
			result.forEach((id,idx)=>{	
				
			});
			})
		//adoptedAry.push()
	},

	markAdopted: function() {
		// 입양처리. adoptedAry에 추가.
		

	}, // end of markAdopted;

	handleAdopt: function(event) {
		// 사용자화면에서 입양버튼 클릭 시 처리. 버튼 비활성화 작업

	} // end of handleAdopt;

}; // end of App;


$(function() {
	App.init();
});
