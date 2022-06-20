import 'react-datepicker/dist/react-datepicker.css';
import DatePicker from 'react-datepicker';
import '../css/DateBox.css';

const DateRage = (props) => {
  const { dtFrom, setDtFrom, dtTo, setDtTo, typeName } = props;

  return (
    <div className="date-picker-wrapper">
      <div className="datepicker-title">{typeName} </div>
      <DatePicker
        selected={dtFrom}
        onChange={(date) => setDtFrom(date)}
        selectsStart
        startDate={dtFrom}
        endDate={dtTo}
        dateFormat="yyyy-MM-dd"
      />

      <span> ~&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>
      <DatePicker
        selected={dtTo}
        onChange={(date) => setDtTo(date)}
        selectsStart
        startDate={dtFrom}
        endDate={dtTo}
        minDate={dtFrom}
        dateFormat="yyyy-MM-dd"
      />
    </div>
  );
};

export default DateRage;
