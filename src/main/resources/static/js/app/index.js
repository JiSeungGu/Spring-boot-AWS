var main = {
    init : function() {
        var _this = this;

        $('#btn-save').on('click', function() {
            _this.save();
        });

        $('#btn-update').on('click',function() {
           _this.update();
        });

        $('#btn-delete').on('click',function(){
           _this.delete();
        });
        $('#comment-btn-save').on('click',function(){
            _this.commentSave();
        })
    },
    save : function() {
        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val()
        };
        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType : 'json',
            contentType:'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
        //   글이 등록되면 메인 페이지 / 로 이동 한다
            window.location.href= '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function() {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.')
            window.location.href= '/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },
    delete : function() {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType:'json',
            contentType:'application/json; charset=utf-8',
        }).done(function(){
            alert('글이 삭제되었습니다. ');
            window.location.href = '/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },
    commentSave : function() {
        var data = {
            com_writer: $('#writer').val(),
            com_content: $('#comment_msg').val(),
            com_post_id : $('#id').val()
        };
        console.log("아이디야~ : "+data.com_post_id)
    $.ajax({
        type : 'POST',
        url: '/api/v1/commentSave',
        dataType : 'json',
        contentType :'application/json; charset=utf-8',
        data : JSON.stringify(data)
    }).done(function() {
        alert('댓글이 등록되었습니다.')
        // 댓글이 등록되면 메인 페이지로 이동
        window.location.href='/';
    }).fail(function (error) {
        alert(JSON.stringify(error));
    })
}
};
main.init();
