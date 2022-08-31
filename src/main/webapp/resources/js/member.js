//member.js

function loginCheck(){
    const frm = document.getElementById("frm");
    const btn = document.getElementById("btn");
    const id1 = document.getElementById("id1");
    const pw1 = document.getElementById("pw1");
    const val_id = document.getElementById("val_id");
    const val_pw = document.getElementById("val_pw");    



    btn.addEventListener("click", function(){
    if(id1.value==""&&pw1.value==""){
        val_id.innerText = "id 필수";
        val_pw.innerText = "pw 필수";
        return;
    }

    if(id1.value==""&&pw1.value!=""){
        val_id.innerText = "id필수";
        val_pw.innerText = "";
        return;
    }

    if(id1.value!=""&&pw1.value==""){
        val_id.innerText = "";
        val_pw.innerText = "pw필수";
        return;
    }
    
    
    frm.submit();
    });
}


function agreeCheck(){
    const all = document.getElementById("all");
    const cb = document.getElementsByClassName("cb");
    const btn2 = document.getElementById("btn2");
    const frm2 = document.getElementById("frm2");
    const req = document.getElementsByClassName("req");

    all.addEventListener("click",function(){
        for(let i = 0; i<cb.length ; i++){
            cb[i].checked = all.checked;
            req[i].checked = all.checked;
        }
    })
    
    for(let i = 0; i<cb.length; i++){
        let result = true;
        cb[i].addEventListener("click", function(){
        if(cb[i].checked == false){
            result = false;
            break;
        }
        
    })
    }

    for(let j=0; j<req.length; j++){
        let result = true;
        if(req[j].checked == false){
            result = false;
            break;
        }
    }
    
    btn2.addEventListener("click", function(){
        let result = false;
        for(let i=0; i<req.length; i++){
            if(req[i].checked){
                result = true;
                continue;
            }else{
                result = false;
                break;
            }
        }
        

        if(!result){
            frm2.action = "./agree.iu";
            alert("동의가 필요합니다.");
        }else{
            frm2.submit();
        }

        
        // if(all.checked){
        //     frm2.submit();
        // }else{
        //     alert("동의가 필요합니다.");
        // }
    })

}


function joinCheck(){
    //생성자
    const name = document.getElementById("name");
    const userName = window.document.getElementById("userName");
    const password1 = document.getElementById("password1");
    const password2 = document.getElementById("password2");
    const email = document.getElementById("email");
    const phone = document.getElementById("phone");
    const h_name = document.getElementById("h_name");
    const h_userName = document.getElementById("h_userName");
    const h_password1 = document.getElementById("h_password1");
    const h_password2 = document.getElementById("h_password2");
    const h_email = document.getElementById("h_email");
    const h_phone = document.getElementById("h_phone");
    const frm3 = document.getElementById("frm3");
    const join = document.getElementById("join");
    
    //Check 결과
    let idCheck = false;
    let passwordCheck = false;
    let pwequalCheck = false;
    let nameCheck = false;
    let emailCheck = false;
    let phoneCheck = false;

    //정규표현식
    const regex_phone = /\d{3}-\d{4}-\d{4}/;
    const regex_email = /[\w\-\.]+\@[\w]/;
    const regex_userName1 = /[A-Za-z0-9]/;



    userName.addEventListener("blur",function(){
        if(userName.value.length < 2){
            h_userName.innerText = "2글자 이상";
            idCheck = false;
            userName.focus();
        }else{
            idCheck = true;
            h_userName.innerText= "";
            return;
        }
    })
    name.addEventListener("change",function(){
        if(name.value.length < 1){
            h_name.innerText = "1글자 이상";
            name.focus();
        }else{
            h_name.innerText= "";
            return;
        }
    });




    password1.addEventListener("keyup",function(){
        if(password1.value.length < 6){
            h_password1.innerText="6글자 이상"
            password1.focus();
        }else{
            h_password1.innerText="";
            return;
        }
    })

    password2.addEventListener("blur", function(){
        if(password2.value.length < 6 ){
            h_password2.innerText="6글자 이상"
            password2.focus();
        }else if(password2.value != password1.value){
            h_password2.innerText="불일치";
            password2.focus();
        }else if(password2.value == password2.value){
            h_password2.innerText = "일치";
            return;
        }
    })

    email.addEventListener("change", function(){
        if(email.value.length<1){
            h_email.innerText = "1글자 이상";
            email.focus();
        }else{
            h_email.innerText = "";
            return;
        }
    })

    phone.addEventListener("change",function(){
        if(phone.value.length<1){
            h_phone.innerText="1글자 이상";
            phone.focus();
        }else{
            h_phone.innerText="";
            return;
        }
    })

    join.addEventListener("click",function(){
        if(h_userName.innerText ==""
        && h_name.innerText== "" 
        && h_password1.innerText==""
        && h_password2.innerText == "일치" 
        && h_email.innerText==""
        && h_phone.innerText==""){
            frm3.submit();
        }else{
            frm3.method = "get";
            alert("입력이 필요합니다.");
            return;
        }
    })

    
}