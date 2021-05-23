var i=0;
var image=document.getElementById("image");
// Добавте свои картинки через запятую
var imgs=new Array('@{/images/KiaRioXLineBig.jpg}','@{/images/VolkswagenPoloBig.jpg}', '@{/images/MercedesBenzGLABig.jpg}'
    , '@{/images/MercedesBenzCLABig.jpg}', '@{/images/RenaultArkanaBig.jpg}');
function imgsrc() {
    i++;
    image.src=imgs[i];
}