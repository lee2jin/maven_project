//reduce2.js
//비동기 방식 fetch() 

async function asycnFunc(){ //동기방식
  let memAry = [];
  let promis = await fetch("./MOCK_DATA.json"); // 패치에 결과값을 프로미스에 다 담아두고 진행(await)
  let json = await promis.json();
  
  memAry = json;
 // console.log(memAry)

  memAry.reduce((acc, mem, idx, ary) => {
    if(idx == 0){
      let ul = document.createElement('ul');
      acc.append(ul);
    }
      let li = document.createElement('li');
      li.innerHTML = 'id: ' + mem.id + ', 이름: ' + mem.first_name;
      if(idx < 5)
        acc.querySelector('ul').append(li);
    
    return acc;
  },document.querySelector('#list'))

  // //reduce 사용해서
  // memAry.reduce((acc,mem,idx,ary) => {
  //   console.log(acc, mem);
  //   if(idx+1 == ary.length){
  //     document.querySelector('#list').innerHTML = acc;
  //   }
  //   let str = '';
  //   if(idx == 0){
  //     str += '<ul>';
  //   }
  //   if(idx == 5){
  //     str += '<ul>';
  //   }
  //   str += '<li> id: ' + mem.id + ', 이름: ' + mem.first_name + "</li>";
  // return idx < 5 ? acc+str : acc;
  //마지막 순번에서 document.querySelector('#list').innerHTML = acc;
  // }, "");

  memAry.reduce((acc,mem,idx, ary) =>{
    console.log(acc, mem, idx)
    if(idx == 0){
      let ul = document.createElement('ul');
      acc.append(ul);
    }
    let li = document.createElement('li');
    li.innerHTML = 'id: ' + mem.id + ', 이름: ' + mem.first_name + ', 성별: ' + mem.gender;
    if(mem.gender == 'Female'){
      li.setAttribute("style","background-color:pink");
      acc.querySelector('ul').append(li);
    }if(mem.gender == 'Male')
       li.setAttribute("style","background-color:blue");
      acc.querySelector('ul').append(li);

    return acc;
  },document.querySelector('#list'))

}
asycnFunc();