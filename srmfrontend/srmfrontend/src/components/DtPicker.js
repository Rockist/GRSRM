import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import '../css/DateBox.css';

const DtPicker = (props) => {
  const { dtFrom, setDtFrom, dtTo, setDtTo } = props;

  return (
    <div>
      <DatePicker
        selected={dtFrom}
        onChange={(date) => setDtFrom(date)}
        selectsStart
        startDate={dtFrom}
        endDate={dtTo}
        dateFormat="yyyy-MM-dd"
      />
    </div>
  );
};

export default DtPicker;
