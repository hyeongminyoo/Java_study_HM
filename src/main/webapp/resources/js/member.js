//member.js
///로그인
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

//약관동의
function agreeCheck(){
    const all = document.getElementById("all");
    const cb = document.getElementsByClassName("cb");
    const btn2 = document.getElementById("btn2");
    const frm2 = document.getElementById("frm2");
    const req = document.getElementsByClassName("req");


    //전체동의
    all.addEventListener("click",function(){
        for(let i = 0; i<cb.length ; i++){
            cb[i].checked = all.checked;
            for(let j=0; j<req.length; j++){
                req[j].checked = all.checked;
            }
        }
    })

    //일부 동의
    for(let i = 0; i<cb.length; i++){
        // 매개변수가  있을 때
        // cb[i].addEventListener("click", function(){
        //     check();
        // })
        
        
        cb[i].addEventListener("click",check)
    }
    
    for(let i=0; i<req.length; i++){
        req[i].addEventListener("click", check)
    }


    function check(){
        let result1 = true;
        let result2 = true;
        for(let i=0; i<cb.length; i++){
            if(!cb[i].checked){
                result1 = false;
                break;
            }
        }
        for(let i=0; i<req.length; i++){
            if(!req[i].checked){
                result2 = false;
                break;
            }
        }
        
        if(result1 && result2){
            all.checked = true;
        }else{
            all.checked = false;
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
            alert("동의가 필요합니다.");
        }else{
            frm2.submit();
        }

    })

}


function joinCheck(){
    //생성자
    const membersJoinForm = document.getElementById("membersJoinForm");
    const userNameInput = document.getElementById("userNameInput");
    const userNameInputResult = document.getElementById("userNameInputResult");
    const nameInput = document.getElementById("nameInput");
    const nameInputResult = document.getElementById("nameInputResult");
    const passwordInput = document.getElementById("passwordInput");
    const passwordInputResult = document.getElementById("passwordInputResult");
    const passwordCheckInput = document.getElementById("passwordCheckInput");
    const passwordCheckInputResult = document.getElementById("passwordCheckInputResult");
    const emailInput = document.getElementById("emailInput");
    const emailInputResult = document.getElementById("emailInputResult");
    const phoneInput = document.getElementById("phoneInput");
    const phoneInputResult = document.getElementById("phoneInputResult");
    const membersJoinSubmit = document.getElementById("membersJoinSubmit");
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



    userNameInput.addEventListener("blur",function(){
        if(userNameInput.value.length < 2){
            userNameInputResult.innerHTML="id는 2글자 이상 입력해주세요.";
            idCheck = false;

        }else{
            idCheck = true;
            userNameInputResult.innerHTML= "";
            return;
        }
    })

    nameInput.addEventListener("blur",function(){
        if(nameInput.value.length >= 1){
            nameCheck = true;
            nameInputResult.innerHTML="";
        }else{
            nameCheck=false;
            nameInputResult.innerHTML="이름은 1글자 이상 입력해주세요."
        }
    })

    passwordInput.addEventListener("keyup", function(){
        if(passwordInput.value.length >= 6){
            passwordCheck = true;
            passwordInputResult.innerHTML="";
        }else if(passwordInput.value.length <6 ){
            passwordCheck= false;
            passwordInputResult.innerHTML="pw는 6글자 이상 입력해주세요.";

        }

        if(passwordInput.value != passwordCheckInput.value){
            passwordCheckInputResult.innerHTML="일치하지 않습니다."
            passwordCheckInput.value="";
            pwequalCheck=false;
        }


    })

    passwordCheckInput.addEventListener("blur",function(){
       if(passwordCheckInput.value==passwordInput.value){
        passwordCheckInputResult.innerHTML="";
        pwequalCheck = true;
       }else{
        passwordCheckInputResult.innerHTML="일치하지 않습니다."
        passwordCheckInput.value="";
        pwequalCheck=false;
       }
    
    })


    emailInput.addEventListener("blur",function(){
        if(emailInput.value.length >= 1){
            emailCheck = true;
            emailInputResult.innerHTML="";
        }else{
            emailCheck=false;
            emailInputResult.innerHTML="email은 1글자 이상 입력해주세요."
        }
    })


    phoneInput.addEventListener("blur",function(){
        if(phoneInput.value.length >= 1){
            phoneCheck = true;
            phoneInputResult.innerHTML="";
        }else{
            phoneCheck=false;
            phoneInputResult.innerHTML="email은 1글자 이상 입력해주세요."
        }
    })



    membersJoinSubmit.addEventListener("click",function(){
        if(idCheck&&nameCheck&&passwordCheck&&pwequalCheck&&emailCheck&&phoneCheck){
            membersJoinForm.submit();
        }else{
            alert("입력이 필요합니다.");
        }
    })

    
}