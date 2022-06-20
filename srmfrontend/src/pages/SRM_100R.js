import React, { useEffect, useRef, useState } from 'react';
import Header from '../components/Header';

import TuiGrid from '../components/TuiGrid';
import CustomDateRagePicker from '../components/CustomDateRagePicker';
import Gubun from '../components/Gubun';
import NavBar from '../components/NavBar';

/**
 * 화면명 : 발주현황조회 (정현락)
 * 화면번호 : SRM_100R
 * @returns
 */

const SRM_100R = () => {
  const [columns, setColumns] = useState([]);
  const [dtGbn, setDtGbn] = useState('D');
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());
  const [data, setData] = useState([{}]);
  const gridRef = useRef();

  //콤보박스 데이터
  const [cmbItems, setCmbItems] = useState({
    PUR_USER_ID: [
      { text: '자재팀', value: '100' },
      { text: '이대선', value: '200' },
      { text: '박건민', value: '300' },
      { text: '정미옥', value: '400' },
      { text: '노동욱', value: '500' },
    ],
    // B9102: [
    //   { text: '아니오', value: 'N' },
    //   { text: '예', value: 'Y' },
    // ],
  });

  //컬럼헤더
  useEffect(() => {
    fetch('http://localhost:8080/api/XM102W/list?divCd=01&menuId=SRM_100R')
      .then((res) => res.json())
      .then((res) => {
        setColumns(res);
      }); // 비동기 함수
  }, []); //2번째 인자 미입력시 최초 한번 실행

  // 조회조건 데이터
  const searchFormData = {
    divCd: '01',
    purCustCd: '1000',
    dtFrom: startDate,
    dtTo: endDate,
    dtGbn: dtGbn,
    userGroup: 'S',
  };

  // 검색

  return (
    <div>
      {/* <Header searchFormData={searchFormData} setData={setData} searchUrl={'api/SRM100R/list'} /> */}
      <NavBar searchFormData={searchFormData} setData={setData} searchUrl={'api/SRM100R/list'} />

      <div>
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
              gbnTitle={'기간구분'}
              gbnValue1={'납기일자'}
              gbnValue2={'발주일자'}
              contact1={'D'}
              contact2={'P'}
              value1={'D'}
              value2={'P'}
            />
          </div>
        </div>
        <TuiGrid
          ref={gridRef}
          columns={columns}
          viewName={'SRM_100R'}
          data={data}
          cmbItems={cmbItems}
          bodyHeight={750}
          onClick={() => {}}
        />
      </div>
    </div>
  );
};

export default SRM_100R;
