import FileUploadFetch from '../components/FileUploadFetch';

class FileUploadButton {
    constructor(props) {
      const { text } = props.columnInfo.renderer.options;
      const newForm = document.createElement('form');
      newForm.name = 'newForm';
      newForm.method = 'post';
      // newForm.action = 'https://ifuwanna.tistory.com/196';

      const onFileUpload = (ev) => {
        ev.preventDefault(); // 새로고침 안하게 막음. 
        // if(file === null)  {
        //     alert('파일을 선택해주세요');
        //     return;
        // }

        // if(itemCd === "" || custCd === "") {
        //     alert('품목코드가 설정되지 않았습니다.');
        //     return;
        // }

        // let select = document.getElementById('file_type');
        // let fileNo = select.options[select.selectedIndex].value; 
       
        // console.log(itemCd);
        // console.log(custCd);
        
        // const map = new Map();
        // map.set('file', file);
        // map.set('itemCd', itemCd);
        // map.set('custCd', custCd);
        // map.set('fileNo', fileNo);
        // map.set('startDate', startDate);

        // FileUploadFetch('localhost:8080', 'api/SRM501W/file_upload', map)
        //     .then((res) => {
        //        if(res === 0) {
        //         CustomFetch('localhost:8080', 'api/SRM501W/sp2', {
        //             divCd: '01',
        //             custCd: custCd,
        //             itemCd: itemCd,
        //           })
        //             .then((res) => {
        //               console.log('결과 : ', res);
        //               setData({ Grid1: [...data.Grid1], Grid2: [...res.Grid2] });
        //             })
        //             .catch((error) => console.log(error));
        //        } 
        // })
        // .catch((error) => console.log(error));
    }

      var input = document.createElement('input');
      input.setAttribute("type", "file");
      input.setAttribute("id", "file");
      input.setAttribute("name", "file");
      input.style.display = "none";

      var label = document.createElement('label');
      label.setAttribute('htmlFor', "file");

      input.onChange = function() {
        console.log("dfdf");
      }
      newForm.appendChild(input);
      newForm.appendChild(label);
      // button.innerText = text;
      // button.style.backgroundColor = "#42aaf5";
      // button.style.padding = "2px";
      // button.style.border = "";
      // button.style.color = "white";
      // button.style.fontSize = "11px";
      // button.style.fontWeight = "bold"

      // button.addEventListener('mousedown', (ev) => {
      //   ev.preventDefault();
      //   button.style.backgroundColor = "#0484e0";
      //   // 다운로드, 삭제, 열기 콜백 
      //   clickEvent(rowKey, text);
      // });

      // button.addEventListener('mouseup', (ev)=> {
      //   ev.preventDefault();
      //   button.style.backgroundColor = "#42aaf5";
      // });
      // this.el = button;
    }
    
    getElement() {
      return this.el;
    }
  }
  
  export default FileUploadButton;
  