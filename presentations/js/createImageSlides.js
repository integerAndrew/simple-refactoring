var fs = require('fs')

window.onload = () => {
    location = "resources/badNames"
    turnImagesIntoSlides(location)
}

const turnImagesIntoSlides = ( location ) => {
    fs.readdirSync(location).forEach( file => {
        console.log(file)
        }
    )
}