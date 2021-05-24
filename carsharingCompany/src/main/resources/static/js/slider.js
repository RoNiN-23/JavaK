var i=0;
var image=document.getElementById("image");
// Добавте свои картинки через запятую
var imgs=new Array('@{/images/KiaBig.jpg}','@{/images/VolkBig.jpg}', '@{/images/MerceGLABig.jpg}'
    , '@{/images/MerceCLABig.jpg}', '@{/images/RenaultBig.jpg}');
function imgsrc() {
    i++;
    image.src=imgs[i];
}