import Grid from '@toast-ui/react-grid';
import React from 'react';
import 'tui-grid/dist/tui-grid.css';

const PopupGrid = React.forwardRef((props, ref) => {
    const { columns, data, bodyHeight, onDblclick, onClick } = props;
  
    return (
      <div>
        <Grid
          ref={ref}
          data={data}
          columns={columns}
          rowHeight={29}
          minRowHeight={20}
          bodyHeight={bodyHeight}
          heightResizable={true}
          rowHeaders={['rowNum']}
          columnOptions={{ resizable: true }}
          usageStatistics={false}
          onDblclick={onDblclick}
          onClick={onClick}
        />
      </div>
    );
  });
  
  export default PopupGrid;