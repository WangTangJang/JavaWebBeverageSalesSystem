
function goToRegisterPage() {
    window.location.href = "/BeverageSalesSystem/dynamicPage/Register.jsp";  // 修改为你的注册页面的路径
}
    const form = document.querySelector('form');
    const usernameInput = document.getElementById('username');
    const passwordInput = document.getElementById('password');
    const canvas = document.getElementById('stars');
    const ctx = canvas.getContext('2d');

    let stars = [];
    const numStars = 100;

    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;

    form.addEventListener('submit', function (event) {
        event.preventDefault();

        const username = usernameInput.value;
        const password = passwordInput.value;


        if (username === 'admin' && password === 'password') {
            alert('Login successful!');
        } else {
            alert('Invalid username or password. Please try again.');
        }
    });
    function Star(x, y, size, speedX, speedY) {
    this.x = x;
    this.y = y;
    this.size = size;
    this.speedX = speedX;
    this.speedY = speedY;

    this.draw = function () {
    ctx.beginPath();
    ctx.arc(this.x, this.y, this.size, 0, Math.PI * 2);
    ctx.fillStyle = '#fff';
    ctx.fill();
    ctx.closePath();
};

    this.update = function () {
    this.x += this.speedX;
    this.y += this.speedY;

    if (this.x <= 0 || this.x >= canvas.width) {
    this.speedX *= -1;
}
    if (this.y <= 0 || this.y >= canvas.height) {
    this.speedY *= -1;
}
};
}

    function connectStars(stars) {
    for (let i = 0; i < stars.length; i++) {
    for (let j = i + 1; j < stars.length; j++) {
    const dx = stars[i].x - stars[j].x;
    const dy = stars[i].y - stars[j].y;
    const distance = Math.sqrt(dx * dx + dy * dy);

    if (distance < 100) {
    ctx.beginPath();
    ctx.moveTo(stars[i].x, stars[i].y);
    ctx.lineTo(stars[j].x, stars[j].y);
    ctx.strokeStyle = 'rgba(255, 255, 255, 0.2)';
    ctx.stroke();
    ctx.closePath();
}
}
}
}

    function createStars() {
    for (let i = 0; i < numStars; i++) {
    const x = Math.random() * canvas.width;
    const y = Math.random() * canvas.height;
    const size = Math.random() * 3;
    const speedX = (Math.random() - 0.5) * 2;
    const speedY = (Math.random() - 0.5) * 2;

    stars.push(new Star(x, y, size, speedX, speedY));
}
}

    function animate() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    for (let i = 0; i < stars.length; i++) {
    stars[i].draw();
    stars[i].update();
}

    connectStars(stars);

    requestAnimationFrame(animate);
}

    createStars();
    animate();

