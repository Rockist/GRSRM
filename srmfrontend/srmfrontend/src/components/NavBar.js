import '../css/NavBar.css';
import CustomFetch from './CustomFetch';
import React, { useEffect } from 'react';
import PreviewPopup from '../components/PreviewPopup';

const modal = document.querySelector('#modal');
const root = document.querySelector('#root');

const NavBar = (props) => {
  const { searchFormData, setData, searchUrl, useAddRowHandler, previewCallBack } = props;

  // 조회버튼 옵션
  const searchList = (e) => {
    e.preventDefault();
    console.log('searchUrl', searchUrl);
    console.log('searchFromData', searchFormData);
    CustomFetch('localhost:8080', searchUrl, searchFormData)
      .then((res) => {
        console.log('결과 : ', res);
        if (res.length === 0) {
          setData([{}]);
        } else {
          setData(res);
          console.log('결과 : ', res);
        }
      })
      .catch((error) => console.log(error));
  };

  // 신규버튼
  const activeNewForm = (e) => {
    console.log('신규 버튼 클릭');
  };

  useEffect(() => {
    modal.style.display = "none";
    root.style.display = "block";
  })

  // 추가
  // const useAddRow = (e) => {
  //   // null 체크
  //   if (gridRef === undefined) return;

  //   let idx = gridRef.current.getInstance().store.focus.rowKey;
  //   if (idx === null) {
  //     gridRef.current.getInstance().appendRow({});
  //   } else {
  //     gridRef.current.getInstance().appendRow({ CU: 'C' }, { at: idx + 1 });
  //   }
  //   //console.log(gridRef.current.getInstance().appendRow({}, { at: idx + 1 }));
  //   //console.log(gridRef.current.getInstance().store.focus.rowKey);
  // };

  return (
    <div>
      <div className="nav-container">
        <div className="nav-menu">
          <div className="btn-nav" onClick={activeNewForm}>
            <i className="btn-icon bi-arrow-clockwise"></i>신규
          </div>
          <div className="btn-nav" onClick={searchList}>
            <i className="btn-icon bi-search"></i>
            조회
          </div>
          <div className="btn-nav" onClick={useAddRowHandler}>
            <i className="btn-icon bi-file-earmark-plus"></i>추가
          </div>
          <div className="btn-nav">
            <i className="btn-icon bi-save"></i>저장
          </div>
          <div className="btn-nav">
            <i className="btn-icon bi-trash"></i>삭제
          </div>
          <div className="btn-nav">
            <i className="btn-icon bi-x-circle"></i>취소
          </div>
          <div className="btn-nav">닫기</div>
          <div className="btn-nav">엑셀</div>
          <div className="btn-nav" onClick={() => previewCallBack(true)}>
            미리보기
          </div>
          <div className="btn-nav">인쇄</div>
        </div>
      </div>
    </div>
  );
};

export default NavBar;
