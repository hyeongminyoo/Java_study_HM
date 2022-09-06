//bankbookComment.js
const commentAdd = document.querySelector("#commentAdd");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const commentList = document.querySelector("#commentList");

getCommentList();

commentAdd.addEventListener("click", function(){

    // console.log(commentAdd.data-bookNum);

    let bookNum = commentAdd.getAttribute("data-bookNum");
    let wv = writer.value;
    let cv = contents.value;
    //------------------ajax---------------------------
    //1. XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. URL 준비 xhttp.open("메서드명", "URL주소");
    xhttp.open("POST","./commentAdd");

    //3. Enctype , POST 방식일 경우
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //4. 요청 발생(post일 경우 파라미터 추가)
    xhttp.send("bookNum="+bookNum+"&writer="+wv+"&contents="+cv);

    //5. 응답 처리
    xhttp.onreadystatechange = function(){
        if(this.readyState==4 && this.status==200){
           let result = xhttp.responseText.trim();
           console.log(result);
           result = JSON.parse(result);
           writer.value = "";
           contents.value = "";
           if(result.result == '1'){
                alert("댓글 작성 완료");
                getCommentList();
           }else{
                alert("댓글 작성 실패");
           }
        }

    }


});//click Event 끝

function getCommentList(){
    //1. xmlhtppRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. Method, URL 준비
    xhttp.open("GET", "./commentList?page=1&bookNum=1661998816684");

    //3. 요청 발생(파라미터)
    xhttp.send();

    //4. 응답 처리
    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState == 4 && this.status == 200){
            console.log(xhttp.responseText.trim());
            //1. jsp 사용한 결과물
            //commentList.innerHTML = tab;

    
            //2. JSON 결과물
            let ar = JSON.parse(xhttp.responseText.trim());
            const tab = document.createElement("table");
            let tab_atr = document.createAttribute("class");
            tab_atr.value = "table";
            tab.setAttributeNode(tab_atr);
            for(let i = 0; i<ar.length; i++){
                const tab_tr = document.createElement("tr");
                
                let tab_td = document.createElement("td");
                let tab_text = document.createTextNode(ar[i].writer);
                tab_td.appendChild(tab_text);
                tab_tr.appendChild(tab_td);

                tab_td = document.createElement("td");
                tab_td.innerText = ar[i].contents;
                tab_tr.appendChild(tab_td);

                tab_td = document.createElement("td");
                tab_td.innerText = ar[i].regDate;
                tab_tr.appendChild(tab_td);

                tab.appendChild(tab_tr);
            }
            
            commentList.appendChild(tab);   
            }
        })
}
