//reduce2.js
//비동기 방식 fetch() 

async function asycnFunc() {
  let memAry = [];
  let promis = await fetch('./MOCK_DATA.json'); // 패치에 결과값을 프로미스에 다 담아두고 진행(await)
  let json = await promis.json();

  memAry = json;
  console.log(memAry);

  //reduce 사용해서
  memAry.reduce((acc, mem, idx, ary) => {
    console.log(acc, mem);
    //마지막 순번에서 document.querySelector('#list').innerHTML = acc;
  }, "");

}
