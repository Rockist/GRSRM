import React from 'react';
import '../css/SearchDiv.css';
import CustDatePicker from './CustDatePicker';
import Gubun from './Gubun';

const SearchBox = (props) => {
  const { gubunBox } = props;

  return (
    <div className="conditions-wrapper">
      <div className="conditions-box">
        <Gubun gubunBox={gubunBox} />
      </div>
      <div className="conditions-box">
        <CustDatePicker />
      </div>

      <div className="conditions-box">
        <CustDatePicker />
      </div>
      <div className="conditions-box">
        <Gubun gubunBox={gubunBox} />
      </div>
    </div>
  );
};

SearchBox.defaultProps = {
  gubunBox: {
    dtGbn: 'D',
  },
};

export default SearchBox;
