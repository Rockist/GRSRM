import React, { useEffect, useState } from 'react';
import NavBar from '../components/NavBar';
import CustomDateRagePicker from '../components/CustomDateRagePicker';
import TuiGrid from '../components/TuiGrid';
import CustomFetch from '../components/CustomFetch';

/**
 * 화면명 : 납품서(거래명세서)출력 (정현락)
 * 화면번호 : SRM_204W
 * @returns
 */

function showEmptyMessage() {
  alert("미리보기 데이터가 없습니다.");
}

function openPreview(dilvy_no_array, url) {
  let windowFeatures = "left=-9999,width=1500,height=9999,popup=1";
  localStorage.setItem('preview', dilvy_no_array);
  window.open(url,'미리보기',windowFeatures);
}

const SRM_204W = () => {
  const [colHeader, setColHeader] = useState([]);
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());
  const [data, setData] = useState({
    Grid1: [],
    Grid2: [],
  });

  const previewCallBack = (value) => {
    if(value) {
      const fillterData = data.Grid1.filter(value => value.CHK);
      if(fillterData.length > 0) {
        const dilvy_no = fillterData.map(data =>  data.DLVY_NO );
        openPreview(dilvy_no, "http://localhost:3000/PreviewPage");
      } else {
        showEmptyMessage()
      }
    }
  }
  
  const searchCallBack = () => {
    CustomFetch('localhost:8080','api/SRM204W/list', searchFormData)
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


  // 콤보박스용
  // const [cmbEmp, setCmbEmp] = useState([
  //   { text: '자재팀', value: '100' },
  //   { text: '이대선', value: '200' },
  //   { text: '박건민', value: '300' },
  //   { text: '정미옥', value: '400' },
  //   { text: '노동욱', value: '500' },
  // ]);
  // const [cmbCust, setCmbCust] = useState([
  //   {
  //     text: '거래처명',
  //     value: 'N',
  //   },
  //   { text: '거래처2', value: 'Y' },
  // ]);

  // 거래처 콤보박스
  // useEffect(() => {
  //   CustomFetch('localhost:8080', 'api/cmbItems/UserQuery', { query: 'select p from BA_BIZ_PARTNER p' })
  //     .then((data) => {
  //       console.log(data);
  //       if (data.length === 0) {
  //         setCmbCust([{}]);
  //       } else {
  //         setCmbCust(data);
  //       }
  //     })
  //     .catch((error) => console.log(error));
  // }, []);

  //Grid2 Data Click Event
  const useClickEventHandler = (ev) => {
    if (ev.rowKey === undefined) return;
    console.log(ev.rowKey);
    console.log('handleClick', data.Grid1[ev.rowKey].DLVY_NO);
    console.log('CHK : ', data.Grid1[ev.rowKey].CHK);

    data.Grid1[ev.rowKey].CHK = !data.Grid1[ev.rowKey].CHK;

    CustomFetch('localhost:8080', 'api/SRM204W/sp2', { dlvyNo: data.Grid1[ev.rowKey].DLVY_NO })
      .then((res) => {
        console.log('결과 : ', res);
        setData({ Grid1: [...data.Grid1], Grid2: [...res.Grid2] });
      })
      .catch((error) => console.log(error));
  };

  //컬럼헤더
  useEffect(() => {
    fetch('http://localhost:8080/api/XM102W/list?divCd=01&menuId=SRM_204W')
      .then((res) => res.json())
      .then((res) => {
        setColHeader(res);
      }); // 비동기 함수
  }, []); //2번째 인자 미입력시 최초 한번 실행

  // Grid1 검색 조건
  const searchFormData = {
    divCd: '01',
    dtFrom: startDate,
    dtTo: endDate,
    purCustCd: '1000',
    userGroup: 'S',
  };

  //저장
  ////
    return (
      <div>
        {/* <Header searchFormData={searchFormData} setData={setData} searchUrl={'api/SRM204W/list'} /> */}
        <NavBar searchCallBack={searchCallBack} previewCallBack={previewCallBack} />
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
          </div>
          <TuiGrid
            columns={colHeader.filter((col) => col.MENU_TAB_NO === '1')}
            viewName={'SRM_204W'}
            data={data.Grid1}
            //cmbItems={cmbEmp}
            bodyHeight={280}
            onClick={useClickEventHandler}
          />
        </div>
        <div>
          <TuiGrid
            columns={colHeader.filter((col) => col.MENU_TAB_NO === '2')}
            viewName={'SRM_204W'}
            data={data.Grid2}
            // cmbItems={cmbCust}
            bodyHeight={430}
            onClick={() => {}}
          />
        </div>
      </div>
    );
};
export default SRM_204W;
