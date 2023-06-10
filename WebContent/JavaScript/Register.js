function goToRegisterPage() {
    window.location.href = "LoginServlet";  // 修改为你的注册页面的路径asd
}
const form = document.querySelector('form');
const nicknameInput = document.getElementById('username');
const passwordInput = document.getElementById('password');
const confirmPasswordInput = document.getElementById('confirm-password');
const emailInput = document.getElementById('email');

form.addEventListener('submit', function (event) {
    event.preventDefault();
    const nickname = nicknameInput.value;
    const password = passwordInput.value;
    const confirmPassword = confirmPasswordInput.value;
    const email = emailInput.value;
    // Perform registration validation and logic here
    // Example: You can display a success message or show an error notification
    // based on the registration result.
    if (nickname.trim() === '' || password.trim() === '' || confirmPassword.trim() === '' || email.trim() === '') {
        alert('请填写所有必填信息。');
    } else if (password !== confirmPassword) {
        alert('确认密码不匹配。请重新输入。');
    } else {
        event.target.submit();
    }
});