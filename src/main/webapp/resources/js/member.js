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
    });
    
    for(let i = 0; i<cb.length; i++){
        cb[i].addEventListener("click",function(){
            let result = true;
            for(let i=0; i<cb.length; i++){
                if(!cb[i].checked){
                    result=false;
                    break;
                }else{
                    for(let j=0; i<req.length;i++){
                        if(!req[j].checked){
                            result=false;
                            break;
                        }else{
                            continue;
                        }
                    }
                }
            }

            all.checked = result;
        });
    
    }
    
    btn2.addEventListener("click", function(){
        let result = false;
        for(let i=0; i<req.length; i++){
            if(req[i].checked){
                result = true;
                continue;
            }else{
                break;
            }
        }
        
        console.log(result);

        if(result){
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
