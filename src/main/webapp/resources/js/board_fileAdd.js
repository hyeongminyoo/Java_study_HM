//<button type="button" class="del">삭제</button>


const fileAdd = document.getElementById("fileAdd");
const addFiles = document.getElementById("addFiles");
const fileDelete = document.querySelectorAll(".fileDelete"); //forEach 가능
// const fileDelete = document.getElementsByClassName("fileDelete"); //forEach 불가능


// -----------------------------Update 시 fileDelete----------------------------------------

try{
fileDelete.forEach(function(f){
    f.addEventListener("click", function(){
        
        let check = window.confirm("삭제?");

        if(!check){
            return;
        }

        let fileNum = f.getAttribute("data-file-num");
        

        // 1. 전송할 객체 생성
        const xhttp = new XMLHttpRequest();
        
        //2. Method , URL 준비
        xhttp.open("POST", "./fileDelete");

        //3. Enctype , Post 방식 일 경우
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        //4. 요청 발생 
        xhttp.send("fileNum="+fileNum);

        //5. 응답처리
        xhttp.onreadystatechange = function(){
            if(xhttp.readyState == 4 && xhttp.status == 200){
                let result = xhttp.responseText.trim();
                if(result == 1){
                    console.log(result);
                    f.parentNode.remove();
                    i--;
                }else{
                    console.log(result);
                }
            }

        }
    
    })
});

}catch(e){
    console.log(e);
}

// for(fi of fileDelete){
//     console.log(fi);
// }


//------------------------------- Add 시 file_Add----------------------------------------------------------------------


let idx = 0;
let i = 0;

function setCount(c){
    if(c >= 0){
        i = c;
    }
}

try{
fileAdd.addEventListener("click",function(){
    
 
    if(i>4){
        alert("파일 첨부는 최대 5개 입니다.");
        return;
    }
    const file_div = document.createElement("div");
    const file_label = document.createElement("label");
    const file_input = document.createElement("input");
    const file_delete = document.createElement("button");
    let text = document.createTextNode("파일첨부");
    let text_delete = document.createTextNode("삭제");

    const file_delete_class = document.createAttribute("class");
    const file_delete_type = document.createAttribute("type");
    const file_delete_title = document.createAttribute("title");
    file_delete_class.value = "del";
    file_delete_type.value = "button";
    file_delete_title.value = idx;
    file_delete.appendChild(text_delete);
    file_delete.setAttributeNode(file_delete_class);
    file_delete.setAttributeNode(file_delete_type);
    file_delete.setAttributeNode(file_delete_title);

    file_div.setAttribute("class","mb-3");
    file_div.setAttribute("id","file"+idx);
    file_label.setAttribute("for","files");
    file_label.setAttribute("class","form-label");
    file_label.appendChild(text);
    file_input.setAttribute("type", "file");
    file_input.setAttribute("class","form-control");
    file_input.setAttribute("name","files");

    file_label.appendChild(file_input);
    file_div.appendChild(file_label);
    file_div.appendChild(file_delete);


    addFiles.append(file_div);

    i = i+1;
    idx = idx+1;
})



addFiles.addEventListener("click", function(event){
    if(event.target.classList[0] == "del"){
        // for(let i =0; i<idx ; i++){
        //     if(event.target.title == i){
        //        let ddd = document.getElementById("file"+i);
        //        ddd.remove();
        //     }
        // }

        let dddd = document.getElementById("file"+event.target.title);
        dddd.remove();
            
        // alert("삭제");
        i--;
    }
    
})
}catch(e){

}