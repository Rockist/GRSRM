import React, { useStatem, useEffect } from 'react';

const DropDown = (props) => {
  const { data, name, setIndex } = props;
  console.log("data : " + data);

  useEffect(() => {
    document.getElementById(name).selectedIndex = setIndex;
  }, [])

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
    <div id='left'>
          &nbsp;<select name={name} id={name}>
            { 
              addSelect(data)
            }
          </select>
    </div>
  );
};

export default DropDown;