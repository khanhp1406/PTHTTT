let isShow = false;

let btnInfo = document.querySelector(".info__btn");
let infoDoc = document.querySelector(".info__doc");
let btnClose = document.querySelector(".info__close");

btnInfo.addEventListener("click", () => {
  infoDoc.classList.toggle("info__doc-show");
  isShow = !isShow;
  isShow && btnClose.classList.add("info__close-show");
});
btnClose.addEventListener("click", () => {
  isShow = !isShow;
  infoDoc.classList.toggle("info__doc-show");
  btnClose.classList.remove("info__close-show");
});
