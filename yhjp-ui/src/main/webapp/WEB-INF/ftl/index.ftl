<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页测试11</title>
</head>
<script src="http://localhost:8080/static/js/jquery-3.3.1.min.js"></script>
<body>
测试11

<pre class="java" name="code"><html>
<body>
    <h1>holle world ${name}</h1><br/>

    1 + 1 = 3? ${(1 != 1)?string("yes", "no")}
</body>
    
</html>
</pre>
<br>
<input type="button" onclick="getAllHtml()" value="保存">
</body>
<script>
    function getAllHtml() {
        var html = document.getElementsByTagName('html')[0].innerHTML;

        $.ajax({
            url: "http://localhost:8080/test/savePdf/",
            type: "POST",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify({'allHtml': html}),
            dataType: "text",
            success: function (result) {
                if (result == "success") {
                    obj.parents('form').submit();
                } else {
                }
            },
            error: function (msg) {
                $(".notice").html('Error:' + msg);
            }
        })
        return false;
    }
</script>
    }
    
    
</script>
</html>