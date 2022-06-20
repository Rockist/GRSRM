import React, { useEffect, useRef, useState } from 'react';
import Gubun3 from '../../components/Gubun3';
import NavBar from '../../components/NavBar';
import TuiGrid from '../../components/TuiGrid';

/**
 * 화면명 : 프로그램메뉴등록 (정현락)
 * 화면번호 : XM_101W
 * @returns
 */

const XM_101W = () => {
  const [columns, setColumns] = useState([]);
  const [dtGbn, setDtGbn] = useState('Y');
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());
  const [data, setData] = useState([{}]);
  const [pMenuText, setPMenuText] = useState('');
  const gridRef = useRef();

  //콤보박스 데이터
  const [cmbItems, setCmbItems] = useState({
    P_MENU_TYPE: [
      { text: '*', value: '*' },
      { text: '모듈', value: 'B' },
      { text: '메뉴', value: 'M' },
      { text: '프로그램', value: 'P' },
    ],
    C_MENU_TYPE: [
      { text: '*', value: '*' },
      { text: '모듈', value: 'B' },
      { text: '메뉴', value: 'M' },
      { text: '프로그램', value: 'P' },
    ],
    // B9102: [
    //   { text: '아니오', value: 'N' },
    //   { text: '예', value: 'Y' },
    // ],
  });

  //컬럼헤더
  useEffect(() => {
    fetch('http://localhost:8080/api/XM102W/list?divCd=01&menuId=XM_101W')
      .then((res) => res.json())
      .then((res) => {
        console.log('XM101W', res);
        setColumns(res);
      }); // 비동기 함수
  }, []); //2번째 인자 미입력시 최초 한번 실행

  // 조회조건 데이터
  const searchFormData = {
    divCd: '01',
    pMenuId: pMenuText,
    useYN: dtGbn,
  };

  //조회조건 이벤트
  const usepMenuTextOnChangeEvent = (e) => {
    console.log('pMenuText', e.target.value);
    setPMenuText(e.target.value);
  };

  // 추가
  const useAddRowHandler = () => {
    console.log(gridRef.current);
    console.log(gridRef.current.getInstance().store.focus.rowKey);

    if (gridRef === undefined) return;

    let idx = gridRef.current.getInstance().store.focus.rowKey;
    if (idx === null) {
      gridRef.current.getInstance().appendRow({});
    } else {
      gridRef.current.getInstance().appendRow({ CU: 'C' }, { at: idx + 1 });
    }
  };

  //저장
  const useSaveRowHandler = (e) => {
    e.preventDefault();
    fetch('http://localhost:8080/api/XM101W/save', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        XM101WDto: data,
        XM101WVo: searchFormData,
      }),
    })
      .then((res) => res)
      .then((res) => {
        //console.log(res);
      });
  };

  return (
    <div>
      {/* <Header searchFormData={searchFormData} setData={setData} searchUrl={'api/SRM100R/list'} /> */}
      <NavBar
        searchFormData={searchFormData}
        setData={setData}
        searchUrl={'api/XM101W/list'}
        useAddRowHandler={useAddRowHandler}
        useSaveRowHandler={useSaveRowHandler}
      />

      <div>
        <div className="conditions-wrapper">
          <div className="conditions-box">
            <span>상위메뉴ID </span>
            <div className="box-popup">
              <input type="text" className="txt-popup" value={pMenuText} onChange={usepMenuTextOnChangeEvent}></input>
              <button className="btn-popup">
                <span>...</span>
              </button>
            </div>
            <span>&nbsp;</span>
          </div>
          <div className="conditions-box">
            <Gubun3
              dtGbn={dtGbn}
              setDtGbn={setDtGbn}
              gbnTitle={'사용여부'}
              gbnValue1={'전체'}
              gbnValue2={'예'}
              gbnValue3={'아니요'}
              contact1={'A'}
              contact2={'Y'}
              contact3={'N'}
              value1={'A'}
              value2={'Y'}
              value3={'N'}
            />
          </div>
        </div>
        <TuiGrid
          ref={gridRef}
          columns={columns}
          viewName={'XM_101W'}
          data={data}
          cmbItems={cmbItems}
          bodyHeight={750}
          onClick={() => {}}
        />
      </div>
    </div>
  );
};

export default XM_101W;
