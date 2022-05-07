const buttons = document.querySelectorAll('li.button')
const myheader = document.querySelector('header')

function handleScroll() {
    if (window.scrollY > 50) {
        myheader.classList.add('stick')
        buttons.forEach(function(button) {
            button.classList.add('stick')
        })
    } else {
        myheader.classList.remove('stick')
        buttons.forEach(function(button) {
            button.classList.remove('stick')
        })
    }

}


init()