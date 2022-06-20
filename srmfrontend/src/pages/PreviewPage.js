import React, { useEffect, useState } from 'react';
import CustomFetch from '../components/CustomFetch';
import PreviewPopup from '../components/PreviewPopup';

const PreviewPage = () => {
  const [previewData, setPreviewData] = useState([[{}]]);   // 미리보기 데이터 setup
  const [isOpen, setIsOpen] = useState(false);   // 미리보기 데이터 setup

  useEffect(() => {
    document.querySelector('.side-menu').style.display = "none";
    document.querySelector('.myContainer').style.marginLeft = '0px';
  })

  useEffect(() => {
    var dilvy_no = localStorage.getItem('preview');
    if(dilvy_no != null) {
        CustomFetch('localhost:8080', 'api/SRM204W/prv_sp', dilvy_no)
        .then((res) => {
          if (res.length === 0) {
            setIsOpen(false);
          } else {
            setIsOpen(true);
            setPreviewData(res.receiveList);
            console.log('결과 : ', res);  
            console.log('아이디 : ', res.receiveList[0].id);
          }
        })
        .catch((error) => {
          alert('미리보기 데이터를 가져오는데 실패했습니다.');
          console.log(error)
        })
        .finally(() => {
          localStorage.removeItem('preview');
        });
    }
  })

  return (
    <div>
        {isOpen ? (<div className='preview-box'>{
          previewData.map((data) =>  (
            <PreviewPopup
              key={data.id}
              pdata={data} 
              />
          ))
      }</div>) : null}
    </div>      
  );
};

export default PreviewPage;
