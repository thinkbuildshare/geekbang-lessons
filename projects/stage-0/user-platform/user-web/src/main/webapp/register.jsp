<head>
    <jsp:directive.include file="/WEB-INF/jsp/prelude/include-head-meta.jspf"/>
    <title>注册页</title>
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        .form-signin {
            width: 50%;
            margin: 20% auto auto 20%;
        }
    </style>
</head>
<body>
<div class="container">
    <form class="form-signin">
        <h1 class="h3 mb-3 font-weight-normal">注册</h1>
        <label for="username" class="sr-only">请输入用户名
        </label>
        <input type="input" id="username" class="form-control"
               placeholder="请输入用户名" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control"
               placeholder="请输入密码" required>
        <label for="inputEmail" class="sr-only">请输入电子邮件
        </label>
        <input type="email" id="inputEmail" class="form-control"
               placeholder="请输入电子邮件" required autofocus>
        <label for="phoneNumber" class="sr-only">请输入电话号码</label>
        <input type="input" id="phoneNumber" class="form-control"
               placeholder="请输入电话号码" required>
        <button class="btn btn-lg btn-primary btn-block"  id="registerBtn">注册</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2017-2021</p>
    </form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/prelude/include-js.jspf"/>
<script type="text/javascript">
    $(document).ready(function () {
        $("#registerBtn").click(function () {
            var userName = $('#username').val()
            var inputPassword = $('#inputPassword').val()
            var email = $('#inputEmail').val()
            var phoneNumber = $('#phoneNumber').val()
            if (userName === '' || inputPassword === '' || email === '' || phoneNumber === '') {
                return
            }

            $.ajax({
                type: "POST",
                url: "/register",
                data: {name: userName, password: inputPassword, email: email, phoneNumber: phoneNumber},
                dataType: "html",
                success: function (data) {
                    window.location.href = "/welcome";
                },
                error: function (data,s,e) {
                    console.log(e)
                }
            });

        });
    });
</script>
</body>
