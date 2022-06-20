import { ko } from 'date-fns/locale';
import DatePicker from 'react-datepicker';
import styledComponents from 'styled-components';
import '../css/CustomDateRagePicker.css';
import 'react-datepicker/dist/react-datepicker.css'; // 스타일 맥이기

const MyDatePicker = styledComponents(DatePicker)`
  width:100px;
  height:1.5rem;
`; // styled-components 이용 스타일링

const CustomDateRagePicker = (props) => {
  const { dateTitle, startDate, setStartDate, endDate, setEndDate } = props;

  return (
    <div className="calender-container">
        <div className="datepicker-items">{dateTitle}&nbsp;</div>
        <div className="datepicker-items">
          <MyDatePicker
            selected={startDate}
            locale={ko}
            dateFormat="yyyy-MM-dd"
            onChange={(date) => setStartDate(date)}
          />
      </div>
        <div className="datepicker-items">~</div> 
        <div className="datepicker-items">
          <MyDatePicker selected={endDate} locale={ko} dateFormat="yyyy-MM-dd" onChange={(date) => setEndDate(date)} />
        </div>
    </div>
  );
};

export default CustomDateRagePicker;
