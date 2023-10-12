//reduce1.js

let memberAry = [];
    fetch('./MOCK_DATA.json')
    .then(resolve => resolve.json()) // then은 함수를 매개값으로 받음
    .then(result => {
      memberAry = result;
      //console.log(memberAry);
      let str = ""
      memberAry.forEach((member, idx) => {
        if(idx == 0){
          str += '<ul>';
        }
        if(idx < 5){
          str += '<li>id: ' + member.id + ', 이름: ' + member.first_name + '</li>';
        }
        if(idx + 1 == memberAry.length){
          str += '</ul>';
        }
      }); //end of memberAry
      //document.querySelector('#list').innerHTML = str;

      let ary5 = memberAry.filter((member, idx, ary)=>{
        //console.log("확인");
        //console.log(member, idx, ary);
        return idx < 5;
      })
      //console.log(ary5);

      ary5.reduce((acc, member, idx, ary)=>{
        //console.log(acc, member, idx, ary);
        return member;
      });// },0) > 이렇게 초기값이 지정되어있으면 첫번째 누산값(acc)이 0   
      
      //쉬운예시
        result = [3,2,6,9,5].reduce((acc, num, idx, ary)=>{  //
        console.log(acc, num, idx); //누산값, 배열에 있는 요소, 인덱스값
       // return acc + num; //리턴되는 값이 그다음 매개값으로 사용(그다움 순서의 초기값) / 배열안에 있는 전체값이 합할때
       // return acc > num ? acc : num; //배열안 최대값을 구할때
       if(ary.length == idx+1){
        return (acc + num)/ ary.length
        } 
        return acc + num //배열안 평균값을 구할때
      },0) // > 초기값 넣어주기
      console.log(result);

    })