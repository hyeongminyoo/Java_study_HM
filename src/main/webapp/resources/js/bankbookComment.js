//bankbookComment.js
const commentAdd = document.querySelector("#commentAdd");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const commentList = document.querySelector("#commentList");
const more = document.querySelector("#more");
const updateButton = document.querySelector("#updateButton");


// 페이지 번호 담는 변수
let page = 1;
// bookNum을 담을 변수
const bookNum = commentAdd.getAttribute("data-bookNum");
getCommentList(page, bookNum);



commentAdd.addEventListener("click", function(){

    // console.log(commentAdd.data-bookNum);

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
           if(result.result == '1' && (writer.value !="" || contents.value !="")){
               writer.value = "";
               contents.value = "";
                alert("댓글 작성 완료");

                if(commentList.children.length != 0 ){
                    for(let i = 0; i<commentList.children.length;){
                        commentList.children[0].remove();
                    }
                }
                
                page = 1;
                getCommentList(page, bookNum);
           }else{
                alert("댓글 작성 실패");
           }
        }

    }


});//click Event 끝

function getCommentList(p, bn){
    //1. xmlhtppRequest 생성
    const xhttp = new XMLHttpRequest();

    //2. Method, URL 준비
    xhttp.open("GET", "./commentList?page="+page+"&bookNum="+bookNum);

    //3. 요청 발생(파라미터)
    xhttp.send();

    //4. 응답 처리
    xhttp.addEventListener("readystatechange", function(){
        if(this.readyState == 4 && this.status == 200){
            console.log(xhttp.responseText.trim());
            //1. jsp 사용한 결과물
            //commentList.innerHTML = tab;

    
            //2. JSON 결과물
            let result = JSON.parse(xhttp.responseText.trim());
            // const tab = document.createElement("table");
            // let tab_atr = document.createAttribute("class");
            // tab_atr.value = "table";
            // tab.setAttributeNode(tab_atr);

            let pager = result.pager; //commentPager
            let ar = result.list; //댓글리스트
            let tab_tbody= document.createElement("tbody");

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
                //날짜 format 변경
                // const d = new Date(ar[i].regDate);
                // const month = d.getMonth()+1;
                // tab_text = document.createTextNode(d.getFullYear()+"-"+month+"-"+d.getDate());
                tab_text = document.createTextNode(ar[i].regDate);
                tab_td.appendChild(tab_text);
                tab_tr.appendChild(tab_td);

                tab_td = document.createElement("td");
                tab_text = document.createTextNode("수정");
                let tdAttr = document.createAttribute("class");
                tdAttr.value = "update";
                tab_td.setAttributeNode(tdAttr);
                tdAttr = document.createAttribute("data-comment-num");
                tdAttr.value = ar[i].num;
                tab_td.setAttributeNode(tdAttr);
                tab_td.appendChild(tab_text);
                tab_tr.appendChild(tab_td);

            
                
                tab_td = document.createElement("td");
                tab_text = document.createTextNode("삭제");
                tdAttr = document.createAttribute("class");
                tdAttr.value = "delete";
                tab_td.setAttributeNode(tdAttr);
                tdAttr = document.createAttribute("data-comment-num");
                tdAttr.value = ar[i].num;
                tab_td.setAttributeNode(tdAttr);
                tab_td.appendChild(tab_text);
                tab_tr.appendChild(tab_td);
                
                tab_tbody.appendChild(tab_tr)
            }
            commentList.appendChild(tab_tbody);    
            
            if(page >= pager.totalPage){
                more.classList.add("disabled");
            }else{
                more.classList.remove("disabled");
            }
            
            
            
            // let t = commentList.children;

            // if(t.length !=0){
            //     commentList.children[0].remove();
            // }

            // try {
            //     console.log(commentList.children);
            //     commentList.children.remove();
            //     throw new Error("에러 메세지");
            // } catch (exception) {
                
            // } finally{

            // }
            // commentList.appendChild(tab);
               
            }
        })
}


//더보기--

more.addEventListener("click", function(){
    page++; 

    console.log(bookNum);
    console.log(page);

    getCommentList(page, bookNum);

})


// ------ Delete(이벤트 위임)-------------- 
commentList.addEventListener("click", function(event){
    
    if(event.target.className == "delete"){

        let check = window.confirm("삭제?");
        if(check == true){
            let num = event.target.getAttribute("data-comment-num");
            console.log("num :", num);

            //1. XMLHttpRequest 객체 생성
            const xhttp = new XMLHttpRequest();

            //2. Method, URL 준비
            xhttp.open("POST","./commentDelete");

            //3. Enctype , POST 방식일 경우
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

            //4. 요청 발생(post일 경우 파라미터 추가)
            xhttp.send("num="+num);

            //5. 응답처리
            xhttp.onreadystatechange = function(){
                if(this.readyState == 4 && this.status == 200){
                    let result = xhttp.responseText.trim();
                    result = JSON.parse(result);
   
                    if(result == '1'){
                        
                        alert("삭제 완료");
                        if(commentList.children.length != 0 ){
                            for(let i = 0; i<commentList.children.length;){
                                commentList.children[0].remove();
                            }
                        }
                        
                        page = 1;
                        getCommentList(page, bookNum);
                    }else{
                        alert("삭제실패");
                    }
                }
            }
        }
    }

    if(event.target.className == "update"){
        let check = window.confirm("수정?");
        if(check == true){
            let contents = event.target.previousSibling.previousSibling.innerHTML;
            let writer = event.target.previousSibling.previousSibling.previousSibling.innerHTML;
            let num = event.target.getAttribute("data-comment-num");
            console.log(contents);
            console.log(writer);
            document.querySelector("#updateContents").value= contents;
            document.querySelector("#updateWriter").value = writer;
            document.querySelector("#num").value = num;
            document.getElementById("up").click();
            
            

            
            // let num = event.target.getAttribute("data-comment-num");
            // let contents = event.target.previousSibling.previousSibling;
            // console.log("num:",num);
            // console.log(contents);
            // contents.innerHTML = "<textarea>"+contents.innerText+"</textarea>";
            



        }
    }


})

//--------------modal 업데이트 버튼---------------------
updateButton.addEventListener("click", function(){
    console.log("버튼");

    let modal_contents = document.querySelector("#updateContents").value;
    let modal_num = document.querySelector("#num").value;

    //1. xmlhtpprequest 객체 생성
    const xhttp = new XMLHttpRequest();

    //2. method, url 준비
    xhttp.open("POST", "commentUpdate");

    //3. Enctype, post 방식 일 경우, 헤더 
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //4. 요청 발생(보내기) 파라미터 추가
    xhttp.send("num="+modal_num+"&contents="+modal_contents);

    //5. 응답처리
    xhttp.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            let result = xhttp.responseText.trim();
            if(result == '1'){
                alert("수정 성공");
                // document.getElementById("close").click();

                if(commentList.children.length != 0){
                    for(let i = 0; i<commentList.children.length;){
                        commentList.children[0].remove();
                    }
                }

                page = 1;
                getCommentList(page, bookNum);

            }else{
                alert("수정 실패");
            }


        }
    }
})