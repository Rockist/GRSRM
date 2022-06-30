import React, { useEffect, useState, useRef } from 'react';
import Header from '../components/Header';
import TuiGrid from '../components/TuiGrid';
import '../css/SRM_501W.css';

import CustomFetch from '../components/CustomFetch';
import NavBar from '../components/NavBar';
import Modal from '../components/Modal';
import FileUploadForm from '../components/FileUploadForm';

/**
 * 화면명 : 품목별 성적서 파일등록 (정현락)
 * 화면번호 : SRM_501W
 * @returns
 */

const SRM_501W = (props) => {
  const {inActive} = props;
  const gridRef1 = useRef();
  const gridRef2 = useRef();

  const [colHeader, setColHeader] = useState([]);
  const [data, setData] = useState({
    Grid1: [],
    Grid2: [],
  });

  // 모달 관련
  const [modalOpen, setModalOpen] = useState(false);  // 모달띄우기 여부
  const [heading, setHeading] = useState("");         // 모달 헤딩 
  const [api, setApi] = useState("");                 // 띄울 데이터 api
  const [popupNumber, setPopupNumber] = useState(0);  // 띄울 팝업 번호 

  // 추후에 모달함수 한개로 변경 필요. 
  const openModal1 = () => {
    setModalOpen(true);
    setApi("api/Popup/SRM501Wpopup1");
    setHeading("거래처팝업");
    setPopupNumber(1);
  }

  const openModal2 = () => {
    // 리엑트에서는 어차피 state 변경을 한번에 하기때문에 이렇게 해도됨. 
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
  
  // file 관련
  const [custCd, setCustCd] = useState("");
  const [itemCd, setItemCd] = useState("");

  const download = (rowKey) => {
    console.log("rowKey : " + rowKey);
    var a = document.createElement("a");
    a.href = "http://localhost:8080/api/SRM501W/file_download?" + new URLSearchParams({
      divCd : "01",
      fileNo : data.Grid2[rowKey].FILE_NO,
      fileName : data.Grid2[rowKey].FILE_NAME,
      fileSeq : Number(data.Grid2[rowKey].FILE_SEQ)
    })
    a.setAttribute("download", data.Grid2[rowKey].FILE_NAME);
    a.click();
  }

  const allDownClick = () => {
    for(var i=0; i<data.Grid2.length; i++) {
      if(!data.Grid2[i].CHK) continue;
      console.log(data.Grid2[i]);
    }
  }

  const allDeleteClick = () => {

  }

  const buttonClick = (rowKey, text) => {
    switch(text) {
      case "다운로드" : download(rowKey); break;
      case "삭제" : 
      CustomFetch('localhost:8080', 'api/SRM501W/file_delete', {
        divCd: '01',
        custCd: custCd,
        itemCd: itemCd,
        fileSeq : Number(data.Grid2[rowKey].FILE_SEQ)
      }).then((res) => {
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
          } else {
            alert('파일 삭제 실패!');
          }
        })
        .catch((error) => console.log(error));
      break;
      case "열기" : 
        console.log(3);
      break;
      default: break;
    }
  }

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
    CustomFetch('localhost:8080', 'api/SRM501W/sp2', {
      divCd: '01',
      custCd: data.Grid1[ev.rowKey].CUST_CD,
      itemCd: data.Grid1[ev.rowKey].ITEM_CD,
    })
      .then((res) => {
        console.log('결과 : ', res);
        setCustCd(data.Grid1[ev.rowKey].CUST_CD);
        setItemCd(data.Grid1[ev.rowKey].ITEM_CD);
        setData({ Grid1: [...data.Grid1], Grid2: [...res.Grid2] });
      })
      .catch((error) => console.log(error));
  };

  const searchCallBack = () => {
    CustomFetch('localhost:8080','api/SRM501W/list', searchFormData)
      .then((res) => {
        console.log('결과 : ', res);
        if (res.length === 0) {
          alert('데이터가 존재하지 않습니다.');
          setData([{}]);
        } else {
          setData(res);
          console.log('결과 : ', res);
        }
      })
      .catch((error) => console.log(error));
  }

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

  useEffect(() => {
    // 이걸로 닫기 눌렀을때 넓이값 조절함. 
    // document.querySelector('.content-file-wrapper').style.width = !inActive ? "820px" : "900px";
      const pageWidth  = window.innerWidth - 30;
      console.log("width: " + pageWidth);
      let width = (pageWidth - (!inActive ? 240 : 80)) / 2;
      gridRef1.current.getInstance().setWidth(width);
      gridRef2.current.getInstance().setWidth(width);
  })
  //저장
  /////
  return (
    <div>
      {/* <Header searchFormData={searchFormData} setData={setData} searchUrl={'api/SRM501W/list'} /> */}
      <NavBar searchCallBack={searchCallBack} />
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
            ref={gridRef1}
            columns={colHeader.filter((col) => col.MENU_TAB_NO === '1')}
            viewName={'SRM_501W'}
            data={data.Grid1}
            cmbItems={cmbItems}
            bodyHeight={"fitToParent"}
            onClick={useClickEventHandler}
          />
        </div>
        <div className="right-container">
          <div className="content-wrapper">
            <FileUploadForm
              allDoClick={allDownClick}
              allDeClick={allDeleteClick}
              itemCd={itemCd}
              custCd={custCd}
              setData={setData}
              data={data}
            />
          </div>
          <div className='content-grid'>
           <TuiGrid
              ref={gridRef2}
              columns={colHeader.filter((col) => col.MENU_TAB_NO === '2')}
              viewName={'SRM_501W'}
              data={data.Grid2.length === 0 ? grid2Dummy : data.Grid2}
              cmbItems={cmbItems}
              bodyHeight={"fitToParent"}
              onClick={() => {}}
              buttonClick={buttonClick}
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default SRM_501W;
