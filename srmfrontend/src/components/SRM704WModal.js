
import React, { useEffect, useState } from 'react';
import CustomFetch from '../components/CustomFetch';
import '../css/SRM704WModal.css';
import PopupGrid from './PopupGrid';
import DropDown from '../components/DropDown';

const SRM704WModal = (props) => {
  const { open, close, header, api, rowCallBack, popupNumber } = props;

  const [data, setData] = useState([{}]);
  const [clickNumber, setClickNumber] = useState(-1);
  const [isDataOpen, setDataOpen] = useState(true);
  const [columns, setColums] = useState([{}]);
  const [drop1, setDropData1] = useState([]);
  const [drop2, setDropData2] = useState([]);

  useEffect(() => {
    CustomFetch('localhost:8080', 'api/CmbItems/SubSubCd', {
            COL_MCD: '1002',
          }).then((data) => {
              setDropData1(data);
          }).catch((error) => console.log(error));

    CustomFetch('localhost:8080', 'api/CmbItems/SubSubCd', {
             COL_MCD: 'B0004',
          }).then((data) => {
            console.log(data);
            setDropData2(data);
          }).catch((error) => console.log(error));
          
    CustomFetch('localhost:8080', api, {
             divCd : '01',
             acct : '10',
             clAss : '',
             item : '',
             itemNm : '',
             procTp : '%',
         }).then((res) => {
           console.log(data);
           setColums(res.HEADER_LIST);
           setData(res.POPUP_LIST);
         }).catch((error) => console.log(error));             
  }, []);
 
  useEffect(() => {
    if(open && isDataOpen) {
      let acct = document.getElementById('acct');
      let acct_value = acct.options[acct.selectedIndex].value; 

      let clAss = document.getElementById('br');
      let clAss_value = acct.options[clAss.selectedIndex].value; 

      let pocd_input = document.getElementById('pocd_input').value;
      let ponm_input = document.getElementById('ponm_input').value;
 
      CustomFetch('localhost:8080', api, {
        divCd : '01',
        acct : acct_value,
        clAss : clAss_value,
        item : pocd_input,
        itemNm : ponm_input,
        procTp : '%',
      })
      .then((res) => {
        setColums(res.HEADER_LIST);
        setData(res.POPUP_LIST);
        setDataOpen(false);
      })
      .catch((error) => console.log(error));
    }
  });

  // event
  const onClick = (ev) => {
    if (ev.rowKey === undefined) return;
    setClickNumber(ev.rowKey);
  }

  const onDblclick = (ev) => {
    if (ev.rowKey === undefined) return;
    rowCallBack(data[ev.rowKey], popupNumber);
    closeClick();
  }

  const searchClick = () => {
    setDataOpen(true);
  }

  const clearClick = () => {
    document.getElementById('pocd_input').value = "";
    document.getElementById('ponm_input').value = "";
  }

  const submitClick = () => {
    if(clickNumber === -1) return
    rowCallBack(data[clickNumber], popupNumber);
    closeClick();
  }

  const closeClick = () => {
    setDataOpen(true);
    close(false);
  }

  return (
    // 모달이 열릴때 openModal 클래스가 생성된다.
    <div className={open ? 'openModal srm_704w_modal' : 'srm_704w_modal'}>
      {open ? (
        <section>
          <header>
            <span>{header}</span>
            <button className="close" onClick={closeClick}>
              &times;
            </button>
          </header>
          <div className='searchInput'>
            <div className='input-grid-wrapper'>
                <div className='search-grid'>
                    <div className='grid-box' id='right'>
                        품목계정&nbsp;
                    </div>
                    <div className='grid-box' id='left'>
                        <DropDown
                            data={drop1}
                            name="acct"
                            setIndex={1}
                            >
                        </DropDown>
                    </div>
                    <div className='grid-box' id='right'>
                        품목분류&nbsp;
                    </div>
                    <div className='grid-box' >
                        <DropDown
                            data={drop2}
                            name="br">
                        </DropDown>
                    </div>
                    <div className='grid-box' id='right'>
                        품목&nbsp;
                    </div>
                    <div className='grid-box' >
                          &nbsp;<input id="pocd_input" type="text" className="pocd"></input>
                    </div>
                    <div className='grid-box' id='ponm-input-grid-box'>
                          &nbsp;<input id="ponm_input" type="text" className="ponm"></input>
                    </div>
                </div>
                <div className='reset-grid'>
                    <div className='grid-box'>
                        <button className='clearButton' onClick={clearClick}>&#128260;초기화</button>
                    </div>
                    <div className='grid-box'>
                        <button className="searchButton" onClick={searchClick}>&#128269;조회</button>
                    </div>
                </div>
            </div>
          </div>
          <main>{<PopupGrid
                    columns={columns}
                    data={data}
                    bodyHeight={280}
                    onDblclick={onDblclick}
                    onClick={onClick}>
                 </PopupGrid>}</main>
          <footer>
            <button className="submit" onClick={submitClick}>
            &#128504;확인
            </button>
            <button className="close" onClick={closeClick}>
            &times;취소
            </button>
          </footer>
        </section>
      ) : null}
    </div>
  );
};
    
export default SRM704WModal