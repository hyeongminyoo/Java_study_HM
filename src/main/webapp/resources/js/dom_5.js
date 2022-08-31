const d2 = document.getElementById("d2");
const d1 = document.getElementById("d1");
const d3 = document.getElementById("d3");
const d5 = document.getElementById("d5");
const d4 = document.getElementById("d4");
const s1 = document.getElementById("s1");

d2.addEventListener("focus",function(){
    console.log("입력준비");
})

d2.addEventListener("blur",function(){
    console.log("blur 실행");
})

//d1 입력하고 나왔을때 글자의 길이가 3글자 이하라면 d1에 강제 입력 대기상태

    d1.addEventListener("blur",function(){
        if(d1.value.length <= 3){
        d1.focus();
        }
    })

    d3.addEventListener("change",function(){
        console.log("change Event발생");
    })

    d5.addEventListener("change",function(){
        console.log("change 이벤트 발생");
    })

    let p = 0;
    d4.addEventListener("keyup",function(){
        console.log("key 업");
        p = p+1000;
        s1.innerText = ""+p+"";
    })