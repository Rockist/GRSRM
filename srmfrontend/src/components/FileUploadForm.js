import React, { useEffect, useState } from 'react';
import '../css/FileUploadForm.css';
import FileUploadFetch from '../components/FileUploadFetch';
import CustDatePicker from '../components/CustDatePicker';
import CustomFetch from '../components/CustomFetch';

const FileUploadForm = (props) => {
    const { itemCd, custCd, setData, data } = props;
    const [file, setFile] = useState(null);
    const [fileName, setFileName] = useState("");
    const [startDate, setStartDate] = useState(new Date());
    const [endDate, setEndDate] = useState(new Date());

    const onFileChange = (event) => { 
        // Update the state 
        let file = event.target.files[0];
        console.log(file);
        setFile(file); 
        setFileName(file.name);
    }; 

    const onFileUpload = (ev) => {
        ev.preventDefault() // 새로고침 안하게 막음. 
        if(file === null)  {
            alert('파일을 선택해주세요');
            return;
        }

        if(itemCd === "" || custCd === "") {
            alert('품목코드가 설정되지 않았습니다.');
            return;
        }

        let select = document.getElementById('file_type');
        let fileNo = select.options[select.selectedIndex].value; 
       
        console.log(itemCd);
        console.log(custCd);
        FileUploadFetch('localhost:8080', 'api/SRM501W/file_upload', file, itemCd, custCd, fileNo, startDate)
            .then((res) => {
               if(res === 0) {
                CustomFetch('localhost:8080', 'api/SRM501W/sp2', {
                    divCd: '01',
                    custCd: custCd,
                    itemCd: itemCd,
                  })
                    .then((res) => {
                      console.log('결과 : ', res);
                      setData({ Grid1: [...data.Grid1], Grid2: [...res.Grid2] });
                    })
                    .catch((error) => console.log(error));
               } 
        })
        .catch((error) => console.log(error));
    }

    return (
        <div className='content-file-wrapper'>
            <div className="content-file">
                <div className='.content-file-box'>
                    <span className='file-title'>파일종류 : </span>
                    <select name="file_type" id="file_type">
                        <option value="10">TDS</option>
                        <option value="20">납입사양서</option>
                        <option value="30">MSDS</option>
                        <option value="40">유해물질성적서</option>
                        <option value="45">출하성적서</option>
                        <option value="50">원산지 포괄 확인서</option>
                        <option value="60">원산지 소명서</option>
                        <option value="70">제조 공정도</option>
                        <option value="80">기타</option>
                    </select>
                </div>
                <CustDatePicker
                    dateTitle={' '}
                    startDate={startDate}
                    setStartDate={setStartDate}
                    endDate={endDate}
                    setEndDate={setEndDate}
                />
            </div>
            <div className="fileupload-form"> 
                <form className='form' onSubmit={onFileUpload} >
                    <button className="btn-upload" type='submit'>
                        Upload
                    </button>
                    <input className="txt-upload" type="text" value={fileName} readOnly></input>
                    <input type="file" name="uploadfile" onChange={onFileChange} id="file" style={{display:'none'}}/>
                    <label htmlFor="file" className="btn-upload" id='btn-file-choose'>
                        파일선택
                    </label>
                </form>
            </div>
            <div className="content-box-download">
              <button className="btn-upload">
                <span className="txt-btn-upload">일괄 다운</span>
              </button>
              <button
                className="btn-upload"
                onClick={() => {
                  window.print();
                }}
              >
                <span className="txt-btn-upload">일괄 삭제</span>
              </button>
            </div>
      </div>
    );
}

export default FileUploadForm;