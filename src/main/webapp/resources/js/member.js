const frm = document.getElementById("frm");
const btn = document.getElementById("btn");
const id1 = document.getElementById("id1");
const pw1 = document.getElementById("pw1");
const val_id = document.getElementById("val_id");
const val_pw = document.getElementById("val_pw");


btn.addEventListener("click", function(){

    // if(pw1.value.length != 0 && id1.value.length != 0){
       
    //     frm.submit();
    // }else{
    //     frm.reset();
    //     alert("id/pw는 필수입니다.");
    // }

    // if(id1.value == ""){
    //     alert("id는 필수입니다.");
    //     return;
    // }

    // if(pw1.value ==""){
    //     alert("pw는 필수입니다.");
    //     return;
    // }

    // frm.submit();

    if(id1.value==""){
        val_id.innerText = "id는 필수입니다.";
        val_pw.innerText = "pw는 필수입니다."
        return;
    }


    if(id1.value==""){
        val_id.innerText = "id는 필수입니다.";
        return;
    }

    if(pw1.value==""){
        val_pw.innerText= "pw는 필수입니다.";
        return;
    }

    frm.submit();

});

