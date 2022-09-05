//ajax1_1.js
const d1 = document.getElementById("d1");
let num = document.getElementById("i1");
const i2 = document.querySelector("#i2");

d1.addEventListener("click", function(){
    console.log("a");

    //1.ajax로 요청하는 객체 생성
    let xhttp = new XMLHttpRequest();

    //2. 요청 정보
    xhttp.open("GET", "https://jsonplaceholder.typicode.com/posts/"+num.value);

    //3. 요청 발생 ()안에 파라미터 넣는것은 post방식 일때만
    xhttp.send();
    
    //4. 응답 결과 처리
    xhttp.onreadystatechange = function(){
        //this는 xhttp 객체
        // console.log(this.status);
        // console.log(this.readyState);
        // console.log("=====================================");
        if(this.readyState==4 && this.status == 200){
            //console.log(this.responseText);

            let response = this.responseText.trim();
            response = JSON.parse(response);

            console.log(response.userId);
            console.log(response.id);
            console.log(response.title);
            console.log(response.body);

            let ddd = document.createElement("h3");
            let ddd2 = document.createElement("h3");
            let ddd3 = document.createElement("h3");
            let ddd4 = document.createElement("h3");
            ddd.innerHTML = "userId:" + response.userId;
            i2.append(ddd);
            ddd2.innerHTML = "id:" + response.id;
            i2.append(ddd2);
            ddd3.innerHTML = "title:" + response.title;
            i2.append(ddd3);
            ddd4.innerHTML = "body:" + response.body;
            i2.append(ddd4);


        }


    }

    console.log("Ajax 발생");
    
})