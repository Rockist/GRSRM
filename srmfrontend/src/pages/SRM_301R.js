import React, { useEffect, useState } from 'react';
import Header from '../components/Header';
import Gubun from '../components/Gubun';
import TuiGrid from '../components/TuiGrid';
import CustomDateRagePicker from '../components/CustomDateRagePicker';
import NavBar from '../components/NavBar';
import CustomFetch from '../components/CustomFetch';


/**
 * 화면명 : 납품현황조회 (정현락)
 * 화면번호 : SRM_301R
 * @returns
 */

const SRM_301R = () => {
  const [columns, setColumns] = useState([]);
  const [dtGbn, setDtGbn] = useState('D');
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());
  const [data, setData] = useState([{}]);

  //콤보박스 데이터
  const [cmbItems, setCmbItems] = useState({
    PUR_USER_ID: [
      { text: '자재팀', value: '100' },
      { text: '이대선', value: '200' },
      { text: '박건민', value: '300' },
      { text: '정미옥', value: '400' },
      { text: '노동욱', value: '500' },
    ],
    SL_CD: [
      { text: '제품창고', value: 'AA11' },
      { text: '자재창고', value: 'AA21' },
      { text: '호림창고', value: 'AA31' },
      { text: '생산창고', value: 'AA41' },
      { text: '아산창고', value: 'AA51' },
      { text: '비앤에프창고', value: 'AA61' },
      { text: '두이산업창고', value: 'AB01' },
      { text: '제이엘프로텍창고', value: 'AB02' },
      { text: '성하하이텍창고', value: 'AB03' },
      { text: '지에스테크창고', value: 'AB04' },
      { text: '세기컨버텍창고', value: 'AB05' },
      { text: '지현창고', value: 'AB06' },
      { text: '지앤지텍창고', value: 'AB08' },
      { text: '태인창고', value: 'AB09' },
      { text: '한국필림재단', value: 'AB10' },
      { text: '디노창고', value: 'AB11' },
      { text: '베트남', value: 'AB17' },
      { text: '남경', value: 'AB18' },
      { text: 'B&F창고', value: 'AB19' },
      { text: 'LSK창고', value: 'AB20' },
      { text: '씨테크창고', value: 'AB21' },
      { text: '세진산업창고', value: 'AB22' },
      { text: '영진아스텍창고', value: 'AB23' },
      { text: '제이앤제이창고', value: 'AB24' },
      { text: '한석인터내셔날창고', value: 'AB25' },
      { text: '창성시트창고', value: 'AB26' },
      { text: 'SP테크', value: 'AB27' },
      { text: '티앤티코리아', value: 'AB28' },
      { text: 'SCRAP / 폐기 ', value: 'AC02' },
    ],
  });

  //컬럼헤더
  useEffect(() => {
    fetch('http://localhost:8080/api/XM102W/list?divCd=01&menuId=SRM_301R')
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
    CustomFetch('localhost:8080','api/SRM301R/list', searchFormData)
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

  // 검색

  return (
    <div>
      {/* <Header searchFormData={searchFormData} setData={setData} searchUrl={'api/SRM301R/list'} data={data} /> */}
      <NavBar searchCallBack={searchCallBack} data={data} />
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
            gbnValue1={'입고일자'}
            gbnValue2={'발주일자'}
            contact1={'D'}
            contact2={'P'}
            value1={'D'}
            value2={'P'}
          />
        </div>
      </div>
      <TuiGrid
        columns={columns}
        viewName={'SRM_301R'}
        data={data}
        cmbItems={cmbItems}
        bodyHeight={750}
        onClick={() => {}}
      />
    </div>
  );
};

export default SRM_301R;
