import React, { useEffect, useState, useRef } from 'react';
import Header from '../components/Header';
import TuiGrid from '../components/TuiGrid';
import '../css/SRM_501W.css';
import CustDatePicker from '../components/CustDatePicker';
import CustomFetch from '../components/CustomFetch';
import NavBar from '../components/NavBar';
import Modal from '../components/Modal';
import FileUploadForm from '../components/FileUploadForm';

/**
 * 화면명 : 품목별 성적서 파일등록 (정현락)
 * 화면번호 : SRM_501W
 * @returns
 */

const SRM_501W = () => {
  const [colHeader, setColHeader] = useState([]);
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());
  const [data, setData] = useState({
    Grid1: [],
    Grid2: [],
  });

  // 모달 띄우기. 
  const [modalOpen, setModalOpen] = useState(false);  // 모달띄우기 여부
  const [heading, setHeading] = useState("");         // 모달 헤딩 
  const [api, setApi] = useState("");                 // 띄울 데이터 api
  const [popupNumber, setPopupNumber] = useState(0);  // 띄울 팝업 번호 


  const openModal1 = () => {
    setModalOpen(true);
    setApi("api/Popup/SRM501Wpopup1");
    setHeading("거래처팝업");
    setPopupNumber(1);
  }

  const openModal2 = () => {
    setModalOpen(true);
    setApi("api/Popup/SRM501Wpopup2");
    setHeading("품목팝업");
    setPopupNumber(2);
  }

  const rowCallBack = (rowData, pop) => {
    if(rowData !== null) {
      switch(pop) {
        case 1: 
          document.getElementById('pop1_input').value = rowData.BP_CD;
          document.getElementById('pop1_input_readonly').value = rowData.BP_NM;
        break;
        case 2: 
          document.getElementById('pop2_input').value = rowData.ITEM_CD;
          document.getElementById('pop2_input_readonly').value = rowData.ITEM_NM;
        break;
        default : break;
      }
    }
    setModalOpen(false);
  }

  const closeModal = (value) => {
    setModalOpen(value);
  };

  //콤보박스 데이터
  const [cmbItems, setCmbItems] = useState({
    FILE_NO: [
      { text: 'TDS', value: '10' },
      { text: '납입사양서', value: '20' },
      { text: 'MSDS', value: '30' },
      { text: '유해물질성적서', value: '40' },
      { text: '출하성적서', value: '45' },
      { text: '원산지 포괄 확인서', value: '50' },
      { text: '원산지 소명서', value: '60' },
      { text: '제조 공정도', value: '70' },
      { text: '기타', value: '80' },
    ],
  });

  //Grid2 Data Click Event
  const useClickEventHandler = (ev) => {
    if (ev.rowKey === undefined) return;
    console.log(ev.rowKey);
    console.log('handleClick', data.Grid1[ev.rowKey].CUST_CD);

    CustomFetch('localhost:8080', 'api/SRM501W/sp2', {
      divCd: '01',
      custCd: data.Grid1[ev.rowKey].CUST_CD,
      itemCd: data.Grid1[ev.rowKey].ITEM_CD,
    })
      .then((res) => {
        console.log('결과 : ', res);
        setData({ Grid1: [...data.Grid1], Grid2: [...res.Grid2] });
      })
      .catch((error) => console.log(error));
  };

  //컬럼헤더
  useEffect(() => {
    fetch('http://localhost:8080/api/XM102W/list?divCd=01&menuId=SRM_501W')
      .then((res) => res.json())
      .then((res) => {
        setColHeader(res);
      }); // 비동기 함수
  }, []); //2번째 인자 미입력시 최초 한번 실행

  // Grid 검색 조건
  const searchFormData = {
    divCd: '01',
    custCd: '',
    itemCd: '',
    userGroup: 'S',
    userCust: '1000',
  };

  // Grid2 Dummy fild
  const grid2Dummy = [
    {
      GU: '',
      CHK: '',
      ITEM_CD: '',
      VALID_DT: '',
      FILE_SEQ: '',
      FILE_NO: '',
      FILE_NAME: '',
      FILE_EXTENSION: '',
      FILE_IMAGE: '',
      DOWN: '',
      DEL: '',
      OPEN_FILE: '',
    },
  ];

  //저장
  /////

  return (
    <div>
      {/* <Header searchFormData={searchFormData} setData={setData} searchUrl={'api/SRM501W/list'} /> */}
      <NavBar searchFormData={searchFormData} setData={setData} searchUrl={'api/SRM501W/list'} />
      <Modal 
        open={modalOpen} 
        close={closeModal} 
        header={heading} 
        api={api} 
        rowCallBack={rowCallBack}
        popupNumber={popupNumber}
        >
      </Modal>
      <div>
        <div className="conditions-wrapper">
          <div className="conditions-box">
            <span>발주처 </span>
            <div className="box-popup">
              <input id="pop1_input" type="text" className="txt-popup"></input>
              <button className="btn-popup" onClick={openModal1}>
                <span>...</span>
              </button>
            </div>
            <span>&nbsp;</span>
            <input id="pop1_input_readonly" type="text" className="txt-readOnly" readOnly></input>
          </div>
          <div className="conditions-box">
            <span>품목 </span>
            <div className="box-popup">
              <input id="pop2_input" type="text" className="txt-popup"></input>
              <button className="btn-popup" onClick={openModal2}>
                <span>...</span>
              </button>
            </div>
            <span>&nbsp;</span>
            <input id="pop2_input_readonly" type="text" className="txt-readOnly" readOnly></input>
          </div>
        </div>
      </div>
      <div className="mainContainer">
        <div className="left-container">
          <TuiGrid
            columns={colHeader.filter((col) => col.MENU_TAB_NO === '1')}
            viewName={'SRM_501W'}
            data={data.Grid1}
            cmbItems={cmbItems}
            bodyHeight={750}
            onClick={useClickEventHandler}
          />
        </div>
        <div className="right-container">
          <div className="content-wrapper">
            <div className="content-file">
              <div className='content-file-wrapper'>
                <span className='file-title'>파일종류 : </span>
                <div className="box-combo">
                  <input type="text" className="txt-combo"></input>
                  <button className="btn-combo">
                    <span>&lt;</span>
                  </button>
                </div>
              </div>
              <CustDatePicker
                dateTitle={' '}
                startDate={startDate}
                setStartDate={setStartDate}
                endDate={endDate}
                setEndDate={setEndDate}
              />
            </div>
            <FileUploadForm></FileUploadForm>
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
          <div className="content-box-grid">
            <TuiGrid
              columns={colHeader.filter((col) => col.MENU_TAB_NO === '2')}
              viewName={'SRM_501W'}
              data={data.Grid2.length === 0 ? grid2Dummy : data.Grid2}
              cmbItems={cmbItems}
              bodyHeight={667}
              onClick={() => {}}
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default SRM_501W;
