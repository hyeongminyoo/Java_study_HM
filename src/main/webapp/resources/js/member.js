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

//-------------------------------------------------
//-------------------------------------------------
//약관동의
function agreeCheck(){
    const all = document.getElementById("all");
    // const cb = document.getElementsByClassName("cb");
    const cb = document.querySelectorAll(".cb");
    const btn2 = document.getElementById("btn2");
    const frm2 = document.getElementById("frm2");
    const req = document.getElementsByClassName("req");

    console.log("forEach");
    cb.forEach(function(v,i,ar){
        console.log(v);
    })


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

//-------------------------------------------------
//-------------------------------------------------
//회원가입 체크

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
    const regex_phone = /\d{3}-\d{4}-\d{4}$/;
    const regex_email = /[\w\-\.]+\@[\w]/;
    const regex_userName = /^[A-za-z0-9]{5,15}/g;
    const regex_password =/^[a-zA-z0-9]{10,15}/;
    const regex_name = /^[가-힣]{2,4}$/;



    userNameInput.addEventListener("change",function(){
        if(!regex_userName.test(userNameInput.value)){
            userNameInputResult.innerHTML="5-15자 사이 영문 대소문자 및 숫자 입력";
            idCheck = false;

        }else{
            idCheck = true;
            userNameInputResult.innerHTML= "";
            return;
        }
    })

    nameInput.addEventListener("change",function(){
        if(regex_name.test(nameInput.value)){
            nameCheck = true;
            nameInputResult.innerHTML="";
        }else{
            nameCheck=false;
            nameInputResult.innerHTML="2-4자사이 한글로 입력해주세요.";
        }
    })

    passwordInput.addEventListener("keyup", function(){
        if(regex_password.test(passwordInput.value)){
            passwordCheck = true;
            passwordInputResult.innerHTML="";
        }else {
            passwordCheck= false;
            passwordInputResult.innerHTML="pw는 숫자와 영문자조합으로 10-15자리 입력";

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


    emailInput.addEventListener("change",function(){
        if(regex_email.test(emailInput.value)){
            emailCheck = true;
            emailInputResult.innerHTML="";
        }else{
            emailCheck=false;
            emailInputResult.innerHTML="E-mail 형식이 적합하지 않습니다."
        }
    })


    phoneInput.addEventListener("change",function(){
        if(regex_phone.test(phoneInput.value)){
            phoneCheck = true;
            phoneInputResult.innerHTML="";
        }else{
            phoneCheck=false;
            phoneInputResult.innerHTML="전화번호 형식이 적합하지 않습니다."
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