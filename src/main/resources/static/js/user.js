let index = {
    init: function(){
        $("#btn-save").on("click", ()=>{ // function(){} -> ()=>{} : this 를 바인딩하기 위해 사용
            this.save();
        });
        $("#btn-update").on("click", ()=>{
            this.update()
        })
    },

    save: function(){
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };

        $.ajax({
            type: "post",
            url: "/auth/joinProc",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            if(resp.status === 500){
                alert("회원가입에 실패하였습니다.");
            }else{
                alert("회원가입이 완료되었습니다.");
                location.href = "/";
            }
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

    update: function (){
        let data = {
            id: $("#id").val(),
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };

        $.ajax({
            type: "put",
            url: "/user",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp){
            alert("회원 수정 완료");
            location.href = "/";
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },
}

index.init();