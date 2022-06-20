import React from 'react';
import '../css/Gubun.css';

const Gubun = (props) => {
  const {
    dtGbn,
    setDtGbn,
    gbnTitle,
    gbnValue1,
    gbnValue2,
    gbnValue3,
    contact1,
    contact2,
    contact3,
    value1,
    value2,
    value3,
  } = props;

  const handleClickRadioBtn = (dtGbn) => {
    setDtGbn(dtGbn);
  };

  return (
    <form>
      <div className="gbn-Container">
        <span className="gbn-input-contact">{gbnTitle} &nbsp;&nbsp;</span>
        <input
          className="gbn-input-contact"
          id={contact1}
          type="radio"
          name="chk_dtGbn"
          value={value1}
          checked={dtGbn === value1}
          onChange={() => handleClickRadioBtn(value1)}
        />
        <label className="gbn-input-contact" htmlFor={contact1}>
          &nbsp; {gbnValue1}
        </label>
        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <input
          className="gbn-input-contact"
          id={contact2}
          type="radio"
          name="chk_dtGbn"
          value={value2}
          checked={dtGbn === value2}
          onChange={() => handleClickRadioBtn(value2)}
        />
        <label className="gbn-input-contact" htmlFor={contact2}>
          &nbsp; {gbnValue2}
        </label>
        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <input
          className="gbn-input-contact"
          id={contact3}
          type="radio"
          name="chk_dtGbn"
          value={value3}
          checked={dtGbn === value3}
          onChange={() => handleClickRadioBtn(value3)}
        />
        <label className="gbn-input-contact" htmlFor={contact3}>
          &nbsp; {gbnValue3}
        </label>
      </div>
    </form>
  );
};

export default Gubun;
