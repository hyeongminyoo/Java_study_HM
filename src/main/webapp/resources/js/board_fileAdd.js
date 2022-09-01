const fileAdd = document.getElementById("fileAdd");
const addFiles = document.getElementById("addFiles");


let i = 0;
fileAdd.addEventListener("click",function(){
    
    i = i+1;

    if(i>5){
        alert("파일 첨부는 최대 5개 입니다.");
        return;
    }
    const file_div = document.createElement("div");
    const file_label = document.createElement("label");
    const file_input = document.createElement("input");
    let text = document.createTextNode("파일첨부");
    

    file_div.setAttribute("class","mb-3");
    file_label.setAttribute("for","files");
    file_label.setAttribute("class","form-label");
    file_label.appendChild(text);
    file_input.setAttribute("type", "file");
    file_input.setAttribute("class","form-control");
    file_input.setAttribute("name","files");

    file_label.appendChild(file_input);
    file_div.appendChild(file_label);

    addFiles.before(file_div);


})