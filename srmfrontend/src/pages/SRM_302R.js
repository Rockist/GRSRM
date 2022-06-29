import React, { memo, useEffect, useState } from 'react';
import Header from '../components/Header';
import Gubun from '../components/Gubun';
import TuiGrid from '../components/TuiGrid';
import CustomDateRagePicker from '../components/CustomDateRagePicker';
import NavBar from '../components/NavBar';
import CustomFetch from '../components/CustomFetch';


/**
 * 화면명 : 매출마감조회 (정현락)
 * 화면번호 : SRM_302R
 * @returns
 */

const SRM_302R = () => {
  const [columns, setColumns] = useState([]);
  const [dtGbn, setDtGbn] = useState('D');
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());
  const [data, setData] = useState([{}]);

  //콤보박스 데이터
  const [cmbItems, setCmbItems] = useState({
    CFM_YN: [
      { text: '아니요', value: 'N' },
      { text: '예', value: 'Y' },
    ],
  });

  //컬럼헤더
  useEffect(() => {
    fetch('http://localhost:8080/api/XM102W/list?divCd=01&menuId=SRM_302R')
      .then((res) => res.json())
      .then((res) => {
        setColumns(res);
      }); // 비동기 함수
  }, []); //2번째 인자 미입력시 최초 한번 실행

  const searchFormData = {
    divCd: '01',
    purCustCd: '1000',
    dtFrom: startDate,
    dtTo: endDate,
    dtGbn: dtGbn,
    userGroup: 'S',
  };

  const searchCallBack = () => {
    CustomFetch('localhost:8080','api/SRM302R/list', searchFormData)
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
  }

  //저장버튼
  const handleSaveList = memo((e) => {
    e.preventDefault();
    fetch('http://localhost:8080/api/SRM302R/save', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        SRM302RDto: data,
        SRM100RVO: searchFormData,
      }),
    })
      .then((res) => res)
      .then((res) => {
        console.log(res.status);
      });
  });

  return (
    <div>
      {/* <Header searchFormData={searchFormData} setData={setData} searchUrl={'api/SRM302R/list'} /> */}
      <NavBar searchCallBack={searchCallBack} setData={setData} />
      <div className="conditions-wrapper">
        <div className="conditions-box">
          <CustomDateRagePicker
            dateTitle={'기간 '}
            startDate={startDate}
            setStartDate={setStartDate}
            endDate={endDate}
            setEndDate={setEndDate}
          />
        </div>
        <div className="conditions-box">
          <Gubun
            dtGbn={dtGbn}
            setDtGbn={setDtGbn}
            gbnTitle={'기간'}
            gbnValue1={'입고일자'}
            gbnValue2={'발주일자'}
            contact1={'D'}
            contact2={'P'}
            value1={'D'}
            value2={'P'}
          />
        </div>
        <div className="conditions-box">
          <span>확인자 : </span>
          <input type="text" style={{ height: '25px' }}></input>
        </div>
        <div className="conditions-box">
          <button className="btn-conditions" style={{ height: '25px' }} onClick={() => handleSaveList}>
            전체확인/취소
          </button>
        </div>
      </div>
      <TuiGrid
        columns={columns}
        viewName={'SRM_302R'}
        data={data}
        cmbItems={cmbItems}
        bodyHeight={750}
        onClick={() => {}}
      />
    </div>
  );
};

export default SRM_302R;
