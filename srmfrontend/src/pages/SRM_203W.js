import React, { useEffect, useState } from 'react';
import { createPortal } from "react-dom";
import CustomDateRagePicker from '../components/CustomDateRagePicker';
import Gubun from '../components/Gubun';
import NavBar from '../components/NavBar';
import PreviewPopup from '../components/PreviewPopup';
import TuiGrid from '../components/TuiGrid';

/**
 * 화면명 : 원단부착라벨 발행내역 (정현락)
 * 화면번호 : SRM_203W
 * @returns
 */

 const modal = document.querySelector('#modal');
 const root = document.querySelector('#root');

function showEmptyMessage() {
  alert("미리보기 데이터가 없습니다.");
}

const SRM_203W = () => {
  const [colHeader, setColHeader] = useState([]);
  const [pageType, setpageType] = useState('D');
  const [pageSize, setPageSize] = useState('D');
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());
  const [data, setData] = useState([{
  }]);
  const [isOpen, setOpen] = useState(false);
  const [previewData, setPreviewData] = useState([{}]);

  const previewCallBack = (value) => {
    if(value) {
      const fillterData = data.filter(data => data.CHK);
      if(fillterData.length > 0) {
        setPreviewData(fillterData);
        setOpen(!isOpen);
      } else {
        showEmptyMessage()
      }
    }
  }

  // 콤보박스용
  // const [cmbEmp, setCmbEmp] = useState([
  //   { text: '자재팀', value: '100' },
  //   { text: '이대선', value: '200' },
  //   { text: '박건민', value: '300' },
  //   { text: '정미옥', value: '400' },
  //   { text: '노동욱', value: '500' },
  // ]);
  // const [printYn, setPrintYn] = useState([
  //   {
  //     text: '거래처명',
  //     value: 'N',
  //   },
  //   { text: '거래처2', value: 'Y' },
  // ]);

  // // 거래처 콤보박스
  // useEffect(() => {
  //   CustomFetch('192.168.0.148:8080', 'api/cmbItems/UserQuery', { query: 'select p from BA_BIZ_PARTNER p' })
  //     .then((items) => {
  //       console.log(items);
  //       if (items.length === 0) {
  //         setPrintYn([{}]);
  //       } else {
  //         setPrintYn(items);
  //       }
  //     })
  //     .catch((error) => console.log(error));
  // }, []);

  const useClickEventHandler = (ev) => {
    if (ev.rowKey === undefined) return;
    console.log(ev.rowKey);

    data[ev.rowKey].CHK = !data[ev.rowKey].CHK;
    setData([...data]);
  };

  //컬럼헤더
  useEffect(() => {
    fetch('http://localhost:8080/api/XM102W/list?divCd=01&menuId=SRM_203W')
      .then((res) => res.json())
      .then((res) => {
        setColHeader(res);
      }); // 비동기 함수
  }, []); //2번째 인자 미입력시 최초 한번 실행

  const searchFormData = {
    divCd: '01',
    dtFrom: startDate,
    dtTo: endDate,
    purCustCd: '1000',
    userGroup: 'S',
  };

  //저장
  // const handleSaveList = (e) => {
  //   e.preventDefault();
  //   fetch('http://192.168.0.148:8080/api/SRM_202W/save', {
  //     method: 'POST',
  //     headers: { 'Content-Type': 'application/json' },
  //     body: JSON.stringify({
  //       // SRM302RDto: data1,
  //       // SRM100RVO: searchFormData,
  //     }),
  //   })
  //     .then((res) => res)
  //     .then((res) => {
  //       //console.log(res.status);
  //     });
  // };

  useEffect(() => {
    root.style.display = isOpen ? "none" : "block";
    modal.style.display = isOpen ? "block": "none";
  })

  return (
    <div>
      {/* <Header searchFormData={searchFormData} setData={setData} searchUrl={'api/SRM202W/list'} /> */}
      <NavBar searchFormData={searchFormData} setData={setData} searchUrl={'api/SRM202W/list'} previewCallBack={previewCallBack}/>
      { isOpen? (
        <div className='preview-box'>{
          previewData.map((data, index) => (
            <PreviewPopup
              key={index}
              pdata={data} 
              />
          ))
          }</div>
        ) : null
      }
      <div>
        <div className="conditions-wrapper">
          <div className="conditions-box">
            <CustomDateRagePicker
              dateTitle={'납품일자 '}
              startDate={startDate}
              setStartDate={setStartDate}
              endDate={endDate}
              setEndDate={setEndDate}
            />
          </div>
          <div className="conditions-box"></div>
          <div className="conditions-box">
            <Gubun
              dtGbn={pageType}
              setDtGbn={setpageType}
              gbnTitle={'용지종류 : '}
              gbnValue1={'라벨'}
              gbnValue2={'A4'}
              contact1={'c1'}
              contact2={'c2'}
              value1={'D'}
              value2={'P'}
            />
          </div>
          <div className="conditions-box">
            <Gubun
              dtGbn={pageSize}
              setDtGbn={setPageSize}
              gbnTitle={'용지크기 : '}
              gbnValue1={'4*5'}
              gbnValue2={'8*10'}
              contact1={'d1'}
              contact2={'d2'}
              value1={'D'}
              value2={'P'}
            />
          </div>
        </div>
        <TuiGrid
          columns={colHeader.filter((col) => col.MENU_TAB_NO === '1')}
          viewName={'SRM_203W'}
          data={data}
          //cmbItems={cmbEmp}
          bodyHeight={800}
          onClick={useClickEventHandler}
        />
      </div>
    </div>
  );
};
export default SRM_203W;
