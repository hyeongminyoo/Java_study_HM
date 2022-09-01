//<button type="button" class="del">삭제</button>


const fileAdd = document.getElementById("fileAdd");
const addFiles = document.getElementById("addFiles");



let idx = 0;
let i = 0;
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