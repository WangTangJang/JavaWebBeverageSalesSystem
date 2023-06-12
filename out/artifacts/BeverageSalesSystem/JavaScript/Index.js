
    const sidebarItems = document.querySelectorAll('.sidebar li');

    sidebarItems.forEach(item => {
    item.addEventListener('click', function () {
        const subMenu = this.querySelector('ul');
        if (subMenu) {
            if (subMenu.style.display === 'block') {
                subMenu.style.display = 'none';
            } else {
                subMenu.style.display = 'block';
            }
        }
    });
});

    const sidebarLinks = document.querySelectorAll('.sidebar a');

    sidebarLinks.forEach(link => {
    link.addEventListener('mouseenter', function () {
        const dot = this.querySelector('::before');
        dot.style.opacity = '1';
    });

    link.addEventListener('mouseleave', function () {
    const dot = this.querySelector('::before');
    dot.style.opacity = '0';
});
});

    // 显示公告栏
    const announcement = document.querySelector('.announcement');
    announcement.classList.add('visible');
