import React, { useEffect, useState, useRef } from 'react';
import CustomDateRagePicker from '../../components/CustomDateRagePicker';
import Gubun from '../../components/Gubun';
import NavBar from '../../components/NavBar';
import TuiGrid from '../../components/TuiGrid';
import '../../css/PD/SRM_705W.css';
import CustomFetch from '../../components/CustomFetch';
import FileUploadFetch from '../../components/FileUploadFetch';
import DropDown from '../../components/DropDown';
import SRM704WModal from '../../components/SRM704WModal';

/**
 * 화면명 : 금형발주등록 (류정훈)
 * 화면번호 : SRM_705W
 * @returns
 */
const SRM_705W = (props) => {
  const { inActive } = props; 
  const gridRef = useRef();
  const [colHeader, setColHeader] = useState([]);
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());
  const [data, setData] = useState([{}]);

  // const [cmbItems, setCmbItems] = useState({
  //   MAKER: [
  //     { text: 'TDS', value: '10' },
  //   ],
  //   PUR_USER_ID: [
  //     { text: 'TDS', value: '10' },
  //   ],
  //   REQ_TYPE: [
  //     { text: 'TDS', value: '10' },
  //   ],
  //   MOLD_CLASS: [
  //     { text: 'TDS', value: '10' },
  //   ],
  //   MOLD_TYPE: [
  //     { text: 'TDS', value: '10' },
  //   ],
  // });

  //컬럼헤더
  useEffect(() => {
    fetch('http://localhost:8080/api/XM102W/list?divCd=01&menuId=SRM_705W')
      .then((res) => res.json())
      .then((res) => {
        console.log(res);
        setColHeader(res);
      }); // 비동기 함수
  }, []); //2번째 인자 미입력시 최초 한번 실행

   useEffect(() => {
    // 이걸로 닫기 눌렀을때 넓이값 조절함. 
      const pageWidth  = window.innerWidth - 28;
      console.log("width: " + pageWidth);
      let width = (pageWidth - (!inActive ? 240 : 80));
      gridRef.current.getInstance().setWidth(width);
  })


  const buttonClick = (rowKey, text) => {
    // var form = document.createElement("form");
    // form.setAttribute("charset", "UTF-8");
    // form.setAttribute("method", "Post");  //Post 방식
    // form.setAttribute("action", "/user/signup"); //요청 보낼 주소

    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("type", "file");
    hiddenField.setAttribute("name", "mName");
    hiddenField.setAttribute("value", "몰라");
    hiddenField.style.display = "none";
    hiddenField.click();

    hiddenField.onchange = (ev) => {
      alert("rdfdf : " + ev);
    }

    // const map = new Map();
    // map.set('file', file);
    // map.set('itemCd', itemCd);
    // map.set('custCd', custCd);
    // map.set('fileNo', fileNo);
    // map.set('startDate', startDate);

    // FileUploadFetch('localhost:8080', 'api/SRM501W/file_upload', map)
    //         .then((res) => {
    //            if(res === 0) {
    //             CustomFetch('localhost:8080', 'api/SRM501W/sp2', {
    //                 divCd: '01',
    //                 custCd: custCd,
    //                 itemCd: itemCd,
    //               })
    //                 .then((res) => {
    //                   console.log('결과 : ', res);
    //                   setData({ Grid1: [...data.Grid1], Grid2: [...res.Grid2] });
    //                 })
    //                 .catch((error) => console.log(error));
    //            } 
    //   })
    //   .catch((error) => console.log(error));
    // form.appendChild(hiddenField);

    // document.body.appendChild(form);
    // form.submit();
  }

  const fileDownload = () => {
    // if(file === null)  {
    //   alert('파일을 선택해주세요');
    //   return;
    // }

    // if(itemCd === "" || custCd === "") {
    //     alert('품목코드가 설정되지 않았습니다.');
    //     return;
    // }

    // let select = document.getElementById('file_type');
    // let fileNo = select.options[select.selectedIndex].value; 
 
    // const map = new Map();
    // map.set('file', file);
    // map.set('itemCd', itemCd);
    // map.set('custCd', custCd);
    // map.set('fileNo', fileNo);
    // map.set('startDate', startDate);

    // FileUploadFetch('localhost:8080', 'api/SRM501W/file_upload', map)
    //     .then((res) => {
    //       if(res === 0) {
    //         CustomFetch('localhost:8080', 'api/SRM501W/sp2', {
    //             divCd: '01',
    //             custCd: custCd,
    //             itemCd: itemCd,
    //           })
    //             .then((res) => {
    //               console.log('결과 : ', res);
    //               setData({ Grid1: [...data.Grid1], Grid2: [...res.Grid2] });
    //             })
    //             .catch((error) => console.log(error));
    //       } 
    // }).catch((error) => console.log(error));
  }

  const searchCallBack = () => {
    if(startDate > endDate) {
      alert("날짜를 제대로 입력해주세요!");
      return;
    }

    let itemCdValue = document.getElementById('pocd_input').value;
    let itemNmValue = document.getElementById('ponm_input').value;
    if(itemCdValue === "") {
      itemCdValue = '%';
    }

    CustomFetch('localhost:8080','api/SRM705W/list', {
      divCd:'01',
      orderDtFr:startDate,
      orderDtTo:endDate,
      moldCd:itemCdValue,
      moldNm:itemNmValue,
    })
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

  return (
    <div>
      <NavBar searchCallBack={searchCallBack} />
      <div>
        <div className="conditions-wrapper">
            <div className='srm705w-grid-conditions-box-1'>
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
            </div>
            <div className='srm705w-grid-conditions-box-2'>
              <div  className='conditions-box-child' id='right'>금형코드 :&nbsp;</div>
              <div  className='conditions-box-child' id='left'> 
                  <div className='grid-box' >
                      &nbsp;<input id="pocd_input" type="text" className="pocd"></input>
                  </div>
              </div>
              <div  className='conditions-box-child' id='left'>
                <div className='grid-box' id='ponm-input-grid-box'>
                    &nbsp;<input id="ponm_input" type="text" className="ponm"></input>
                </div>
              </div>
            </div>
            <div className='grid-conditions-box-3'>
            </div>
        </div>
        <div className='mainContainer'>
            <TuiGrid
              ref={gridRef}
              columns={colHeader.filter((col) => col.MENU_TAB_NO === '1')}
              viewName={'PD_705W'}
              bodyHeight={"fitToParent"}
              data={data}
              // cmbItems={cmbItems}
              onClick={() => {}}
              buttonClick={buttonClick}
            />
        </div>
      </div>
    </div>
  );
};
export default SRM_705W;
