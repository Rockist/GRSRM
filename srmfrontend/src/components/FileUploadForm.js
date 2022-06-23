import React, { useEffect, useState } from 'react';
import '../css/FileUploadForm.css';
import FileUploadFetch from '../components/FileUploadFetch';

const FileUploadForm = (props) => {

    const [file, setFile] = useState(null);

    const onFileChange = (event) => { 
        // Update the state 
        setFile(event.target.files[0]); 
    }; 

    const onFileUpload = (ev) => {
        if(file === null) return
        ev.preventDefault()
        FileUploadFetch('localhost:8080', '', file)
            .then((res) => {
              console.log('결과 : ', res);
            })
            .catch((error) => console.log(error));
    }

    return (
    <div className="fileupload-form"> 
        <form className='form' onSubmit={onFileUpload}>
            <button className="btn-upload" type='submit'>
                  Upload
             </button>
            <input className="txt-upload" type="text" readOnly></input>
            <input type="file" name="uploadfile" onChange={onFileChange} id="file" style={{display:'none'}}/>
            <label htmlFor="file" className="btn-upload" id='btn-file-choose'>
                파일선택
            </label>
        </form>
    </div>);
}

export default FileUploadForm;