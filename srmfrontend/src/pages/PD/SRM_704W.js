import React, { useEffect, useState, useRef } from 'react';
import CustomDateRagePicker from '../../components/CustomDateRagePicker';
import Gubun from '../../components/Gubun';
import NavBar from '../../components/NavBar';
import TuiGrid from '../../components/TuiGrid';
import '../../css/PD/SRM_704W.css';
import CustomFetch from '../../components/CustomFetch';
import DropDown from '../../components/DropDown';
import SRM704WModal from '../../components/SRM704WModal';

/**
 * 화면명 : 원단부착라벨 발행내역 (류정훈)
 * 화면번호 : SRM_704W
 * @returns
 */
const SRM_704W = (props) => {
  const { inActive } = props; 
  const gridRef = useRef();
  const [colHeader, setColHeader] = useState([]);
  const [startDate, setStartDate] = useState(new Date());
  const [drop1, setDropData1] = useState([]);
  const [drop2, setDropData2] = useState([]);
  const [endDate, setEndDate] = useState(new Date());
  const [data, setData] = useState([{}]);

  
  // 모달 관련
  const [modalOpen, setModalOpen] = useState(false);  // 모달띄우기 여부
  const [heading, setHeading] = useState("");         // 모달 헤딩 
  const [api, setApi] = useState("");                 // 띄울 데이터 api
  const [popupNumber, setPopupNumber] = useState(0);  // 띄울 팝업 번호 

   //콤보박스 데이터
   const [cmbItems, setCmbItems] = useState({
    REQ_USER_ID: [
    
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

  useEffect(() => {
    CustomFetch('localhost:8080', 'api/CmbItems/SubSubCd', {
            COL_MCD: 'MD002',
          }).then((data) => {
              console.log(data);
              setDropData1(data);
          }).catch((error) => console.log(error));

    CustomFetch('localhost:8080', 'api/CmbItems/SubSubCd', {
             COL_MCD: 'BZ001',
          }).then((data) => {
            console.log(data);
            setDropData2(data);
          }).catch((error) => console.log(error));     
  }, []);

   useEffect(() => {
    // 이걸로 닫기 눌렀을때 넓이값 조절함. 
    // document.querySelector('.content-file-wrapper').style.width = !inActive ? "820px" : "900px";
      const pageWidth  = window.innerWidth - 28;
      console.log("width: " + pageWidth);
      let width = (pageWidth - (!inActive ? 240 : 80));
      gridRef.current.getInstance().setWidth(width);
  })

  const openModal = () => {
    setModalOpen(true);
    setApi('api/Popup/SRM704Wpopup');
    setHeading("거래처팝업");
    setPopupNumber(1);
  }

  const rowCallBack = (rowData, pop) => {
    if(rowData !== null) {
       document.getElementById('pop1_input').value = rowData.ITEM_CD;
       document.getElementById('pop1_input_readonly').value = rowData.ITEM_NM; 
    }
    setModalOpen(false);
  }

  const searchCallBack = () => {
    if(startDate > endDate) {
      alert("날짜를 제대로 입력해주세요!");
      return;
    }

    let itemCdValue = document.getElementById('pop1_input').value;
    if(itemCdValue === "") {
      alert("품목코드를 선택해주세요!");
      return;
    }

    let type = document.getElementById('type');
    let typeValue = type.options[type.selectedIndex].value; 
    let division = document.getElementById('division');
    let divisionValue = type.options[division.selectedIndex].value; 

    CustomFetch('localhost:8080','api/SRM704W/list', {
      divCd:'01',
      orderDtFr:startDate,
      orderDtTo:endDate,
      itemCd:itemCdValue,
      moldType:typeValue,
      moldClass:divisionValue
    })
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


  const closeModal = (value) => {
    setModalOpen(value);
  };

  return (
    <div>
      <NavBar searchCallBack={searchCallBack} />
      <SRM704WModal 
        open={modalOpen} 
        close={closeModal} 
        header={"품목팝업"} 
        api={api} 
        rowCallBack={rowCallBack}
        popupNumber={popupNumber}
        >
      </SRM704WModal>
      <div>
        <div className="conditions-wrapper">
            <div className='grid-conditions-box-1'>
                <div className="conditions-box-child" id='right'>
                   <div>사업장 :&nbsp;</div>
                </div>
                <div className="conditions-box-child" id='left'>
                  <input id="divCd" type="text" value="거림테크" readOnly></input>
                </div>
                <div className="conditions-box-child" id='right'>
                   <div>발주처 :&nbsp;</div>
                </div>
                <div className="conditions-box-child" id='left'>
                  <div className="box-popup">
                    <input id="pop1_input" type="text" className="txt-popup"></input>
                    <button className="btn-popup" onClick={openModal}>
                      <span>...</span>
                    </button>
                  </div>
                  <span>&nbsp;</span>
                  <input id="pop1_input_readonly" type="text" className="txt-readOnly" readOnly></input>
                </div>
            </div>
            <div className='grid-conditions-box-2'>
                <div className="conditions-box-child" id='right'>
                    <div>발주일자 :&nbsp;</div>
                </div>
                <div className="conditions-box-child" id='left'>
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
                 <div className='conditions-box-child' id='right'>
                     타입 :&nbsp;
                  </div>
                  <DropDown
                    data={drop1}
                    name="type"
                    >
                  </DropDown>
            </div>
            <div className='grid-conditions-box-3'>
              <div  className='conditions-box-child' id='right'>Division :&nbsp;</div>
              <DropDown
                  data={drop2}
                  name="division">
                </DropDown>
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
        <div className='mainContainer'>
          <TuiGrid
            ref={gridRef}
            columns={colHeader.filter((col) => col.MENU_TAB_NO === '1')}
            viewName={'PD_704W'}
            bodyHeight={"fitToParent"}
            data={data}
            selectOnly={true}
            cmbItems={cmbItems}
            onClick={() => {}}
          />
        </div>
      </div>
    </div>
  );
};
export default SRM_704W;
