import React, { useEffect, useState, useRef } from 'react';
import CustomDateRagePicker from '../../components/CustomDateRagePicker';
import Gubun from '../../components/Gubun';
import NavBar from '../../components/NavBar';
import TuiGrid from '../../components/TuiGrid';
import '../../css/PD/SRM_704W.css';

/**
 * 화면명 : 원단부착라벨 발행내역 (류정훈)
 * 화면번호 : SRM_704W
 * @returns
 */
const SRM_704W = (inActive) => { 
  const gridRef = useRef();
  const [colHeader, setColHeader] = useState([]);
  const [pageType, setpageType] = useState('D');
  const [pageSize, setPageSize] = useState('D');
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());
  const [data, setData] = useState([{}]);
  const [isOpen, setOpen] = useState(false);

  const useClickEventHandler = (ev) => {
    if (ev.rowKey === undefined) return;
    console.log(ev.rowKey);

    // data[ev.rowKey].CHK = !data[ev.rowKey].CHK;
    // setData([...data]);
  };

   //콤보박스 데이터
   const [cmbItems, setCmbItems] = useState({
    REQ_USER_ID: [
      { text: '자재팀', value: '100' },
    ],
    REQ_TYPE:[{ text: '자재팀', value: '100' },],
    PROC_CD:[{ text: '자재팀', value: '100' }],
    MOLD_CLASS:[{ text: '자재팀', value: '100' },],
    DRAW_NO:[{ text: '자재팀', value: '100' },],
    MOLD_TYPE:[{ text: '자재팀', value: '100' },],
    MAKER:[{ text: '자재팀', value: '100' },],
    PUR_USER_ID:[{ text: '자재팀', value: '100' },],
  });

  //컬럼헤더
  useEffect(() => {
    fetch('http://localhost:8080/api/XM102W/list?divCd=01&menuId=PD_703W')
      .then((res) => res.json())
      .then((res) => {
        console.log(res);
        setColHeader(res);
      }); // 비동기 함수
  }, []); //2번째 인자 미입력시 최초 한번 실행

  const handleResize = () => {
    console.log("resize");
    let height = document.querySelector('.nav-container').clientHeight - 100;
    gridRef.current.getInstance().setBodyHeight(height);
  }

  useEffect(() => {
    // 이걸로 닫기 눌렀을때 넓이값 조절함. 
     window.addEventListener('resize', handleResize);
      let height = document.querySelector('.side-menu').clientHeight - 100;
      gridRef.current.getInstance().setBodyHeight(height);
      return () => {
        window.removeEventListener('resize', handleResize);
      }
  })

  const searchFormData = {
    divCd: '01',
    dtFrom: startDate,
    dtTo: endDate,
    purCustCd: '1000',
    userGroup: 'S',
  };

  return (
    <div>
      {/* <Header searchFormData={searchFormData} setData={setData} searchUrl={'api/SRM202W/list'} /> */}
      <NavBar searchFormData={searchFormData} setData={setData} searchUrl={'api/SRM202W/list'} />
      <div>
        <div className="conditions-wrapper">
            <div className='grid-conditions-box-1'>
                <div className="conditions-box-child" id='right'>
                   <div>사업장 :</div>
                </div>
                <div className='conditions-box-child'>
                    <div className='left'>&nbsp;<input value="거림테크" readOnly></input></div>
                </div>
                <div className="conditions-box-child" id='right'>
                    <div>발주일자 :</div>
                </div>
                <div className="conditions-box-child">
                    <div className='left'>
                        <CustomDateRagePicker
                        dateTitle={""}
                        startDate={startDate}
                        setStartDate={setStartDate}
                        endDate={endDate}
                        setEndDate={setEndDate}
                        />
                    </div>
                 </div>
            </div>
            <div className='grid-conditions-box-1'>
                <div className="conditions-box-child" id='right'>
                   <div>사업장 :</div>
                </div>
                <div className='conditions-box-child'>
                    <div className='left'>&nbsp;<input value="거림테크" readOnly></input></div>
                </div>
                <div className="conditions-box-child" id='right'>
                    <div>발주일자 :</div>
                </div>
                <div className="conditions-box-child">
                    <div className='left'>
                        <CustomDateRagePicker
                        dateTitle={""}
                        startDate={startDate}
                        setStartDate={setStartDate}
                        endDate={endDate}
                        setEndDate={setEndDate}
                        />
                    </div>
                 </div>
            </div>
            <div className='grid-conditions-box-1'>
                <div className="conditions-box-child" id='right'>
                   <div>사업장 :</div>
                </div>
                <div className='conditions-box-child'>
                    <div className='left'>&nbsp;<input value="거림테크" readOnly></input></div>
                </div>
                <div className="conditions-box-child" id='right'>
                    <div>발주일자 :</div>
                </div>
                <div className="conditions-box-child">
                    <div className='left'>
                        <CustomDateRagePicker
                        dateTitle={""}
                        startDate={startDate}
                        setStartDate={setStartDate}
                        endDate={endDate}
                        setEndDate={setEndDate}
                        />
                    </div>
                 </div>
            </div>
          {/* <div className="conditions-box">
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
          </div> */}
        </div>
        <TuiGrid
          ref={gridRef}
          columns={colHeader.filter((col) => col.MENU_TAB_NO === '1' && col.COL_TYPE === '0')}
          viewName={'PD_703W'}
          data={data}
          cmbItems={cmbItems}
          width={"fitToParent"}
          onClick={useClickEventHandler}
        />
      </div>
    </div>
  );
};
export default SRM_704W;
