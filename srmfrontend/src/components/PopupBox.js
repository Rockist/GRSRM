import React from 'react';
import TuiGrid from './TuiGrid';

const PopupBox = () => {
  return (
    <div>
      <TuiGrid
        ref={gridRef}
        columns={columns}
        viewName={viewName}
        data={data}
        cmbItems={cmbItems}
        bodyHeight={700}
        onClick={() => {}}
      />
    </div>
  );
};

export default PopupBox;
