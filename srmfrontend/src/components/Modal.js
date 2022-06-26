
import React, { useEffect, useState } from 'react';
import CustomFetch from '../components/CustomFetch';
import '../css/Modal.css';
import PopupGrid from './PopupGrid';

const Modal = (props) => {
  const { open, close, header, api, rowCallBack, popupNumber } = props;

  const [data, setData] = useState([{}]);
  const [clickNumber, setClickNumber] = useState(-1);
  const [isDataOpen, setDataOpen] = useState(true);
  const [columns, setColums] = useState([{}]);
 
  useEffect(() => {
    if(open && isDataOpen) {
      console.log("????");
      let input = document.getElementById('word').value;
      console.log("input : " + input);
      CustomFetch('localhost:8080', api, input+"")
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
    document.getElementById('word').value = "";
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
    <div className={open ? 'openModal modal' : 'modal'}>
      {open ? (
        <section>
          <header>
            <span>{header}</span>
            <button className="close" onClick={closeClick}>
              &times;
            </button>
          </header>
          <div className='searchInput'>
            <div className='inputWrapper'>
              <span>코드</span>
              <input type="text" id="word" name="word" required></input>
              <button className='clearButton' onClick={clearClick}>&#10226;</button>
            </div>
            <button className="searchButton" onClick={searchClick}>조회</button>
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
    
export default Modal