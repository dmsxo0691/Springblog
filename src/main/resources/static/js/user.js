let index = {
    init: function(){
        $("#btn-save").on("click", ()=>{ // function(){} -> ()=>{} : this 를 바인딩하기 위해 사용
            this.save();
        });
    },

    save: function(){
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };

        // ajax default = 비동기 호출
        // ajax 통신을 통해 3개의 값을 json 으로 변경하여 insert 요청
        $.ajax({
            type: "post",
            url: "/api/user",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            alert("회원가입 완료");
            location.href = "/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },

    login: function(){
            let data = {
                username: $("#username").val(),
                password: $("#password").val()
            };

            $.ajax({
                type: "post",
                url: "/api/user/login",
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                dataType: "json"
            }).done(function(resp){
                alert("로그인 완료");
                location.href = "/";
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
        }
}

index.init();