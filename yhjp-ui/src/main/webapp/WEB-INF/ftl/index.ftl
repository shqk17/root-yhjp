<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主页测试11</title>
</head>
<script src="http://localhost:8082/static/js/jquery-3.3.1.min.js"></script>
<body style="font-family: SimSun; font-size:small;">
测试11 fsdifh发低速合法IP速度回复U盾发哈皮U盾挂号费皮u刮大风呲牙的出发点从部分阿大V重复as大V发
as给对方擦US大V发阿深V大幅阿斯钢大V发阿萨德股份via啥都有分割按地方是爱上对方
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
            url: "http://localhost:8082/test/savePdfV2/",
            type: "POST",
            contentType: "application/json;charset=utf-8",
            data: html,
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
</html>