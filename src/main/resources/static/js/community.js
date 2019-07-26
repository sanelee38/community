function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    
    if (!content){
        alert("回复内容不能为空");
        return;
    }
    $.ajax({
        type:"post",
        contentType:'application/json',
        url:"/comment",
        data:JSON.stringify({
            "parentId":questionId,
            "content":content,
            "type":1
        }),
        success:function (response) {
            if (response.code == 200) {
                window.location.reload();
            }else {
                if (response.code == 2003) {
                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=930c2be4fd3db31f2f22&redirect_uri=http://localhost:9090/callback&scope=user&state=1");
                        window.localStorage.setItem("closable",true);
                    }

                }else {
                    alert(response.message);
                }
            }
        },
        dataType:"json"
    })
}