import React, { useState } from 'react';

const DropDown = (props) => {
  const { data, name } = props;
  console.log("data : " + data);

  const addSelect = ((data) => {
    var array = [];
    array.push(<option value="%">ALL</option>)
    for(var i=0; i<data.length; i++) {
      array.push(
        <option value={data[i].text}>{data[i].value}</option>
      )
    }
    return array;
  })

  return (
    <div className='conditions-box-child' id='left'>
          &nbsp;<select name={name} id={name}>
            { addSelect(data)}
          </select>
    </div>
  );
};

export default DropDown;