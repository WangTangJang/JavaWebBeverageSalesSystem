
function goToRegisterPage() {
    window.location.href = "/BeverageSalesSystem/dynamicPage/Register.jsp";  // 修改为你的注册页面的路径
}
    const form = document.querySelector('form');
    const usernameInput = document.getElementById('username');
    const passwordInput = document.getElementById('password');


    form.addEventListener('submit', function (event) {
        event.preventDefault();

        const username = usernameInput.value;
        const password = passwordInput.value;
        if (username.trim() === '' || password.trim() === '' ) {
            alert('请填写所有必填信息。');
        } else {
            event.target.submit();
        }

    });


