import Grid from '@toast-ui/react-grid';
import React from 'react';
import 'tui-grid/dist/tui-grid.css';
import '../css/TuiGrid.css';
import ButtonRenderer from './ButtonRenderer';
import CheckboxRenderer from './CheckboxRenderer';

const TuiGrid = React.forwardRef((props, ref) => {
  const { columns, data, cmbItems, bodyHeight, width, height, onClick, buttonClick, selectOnly } = props;
  const cusCols = [];

  //console.log('TuiGrid : ', data);

  const copyHeaders = [...columns]; //컬럼헤더 깊은복사

  copyHeaders.map((menu) => {
    console.log("menu : " + menu);
    //세로정렬
    let valign = menu.COL_VA === '0' ? 'middle' : menu.COL_VA === '1' ? 'top' : 'bottom';

    //가로정렬
    let align = menu.COL_HA === '0' ? 'center' : menu.COL_VA === '1' ? 'left' : 'right';

    //숨김여부
    let colHidden = false;

    //수정여부
    let colEdit = menu.COL_EDIT === 'Y' ? "editor: 'text'" : '';
    if (menu.COL_HIDDEN === 'Y') colHidden = true;

    if(selectOnly) {
      cusCols.push({
        header: menu.COL_NM,
        name: menu.COL_ID,
        minWidth: menu.COL_WIDTH,
        hidden: colHidden,
        valign: valign,
        align: align,
        colEdit,
      });
    } else {
    //컬럽타입
    
    switch (menu.COL_TYPE) {
      case '0':
        console.log(0);
        cusCols.push({
          header: menu.COL_NM,
          name: menu.COL_ID,
          minWidth: menu.COL_WIDTH,
          hidden: colHidden,
          valign: valign,
          align: align,
          colEdit,
        });
        break;
      case '1':
        console.log(1);
        cusCols.push({
          header: menu.COL_NM,
          name: menu.COL_ID,
          minWidth: menu.COL_WIDTH,
          valign: valign,
          align: align,
          hidden: colHidden,
          type: 'checkbox',
          renderer: {
            type: CheckboxRenderer,
          },
        });
        break;
      case '2':
        console.log(2);
        cusCols.push({
          header: menu.COL_NM,
          name: menu.COL_ID,
          minWidth: menu.COL_WIDTH,
          valign: valign,
          align: align,
          hidden: colHidden,
          renderer: {
            type: ButtonRenderer,
            options: {
              text: menu.COL_NM,
              clickEvent : buttonClick
            }
          },
        });
        break;
      case '3':
        console.log(3);
        if (menu.COL_MCD === '') {
        } else {
          // CustomFetch('localhost:8080', 'api/CmbItems/SubCd', {
          //   COL_MCD: menu.COL_MCD,
          // })
          //   .then((data) => {
          //     //setcmbItems(data);
          //   })
          //   .catch((error) => console.log(error));
          // fetch('http://192.168.0.148:8080/api/CmbItems/SubCd', {
          //   method: 'POST',
          //   headers: { 'Content-Type': 'application/json' },
          //   body: JSON.stringify({
          //     COL_MCD: menu.COL_MCD,
          //   }),
          // })
          //   .then((res) => res.json())
          //   .then((res) => {
          //     //setcmbItems(res);
          //     console.log(res);
          //   });
        }
        //const listItems = cmbItems.map((item) => console.log(item));
        cusCols.push({
          header: menu.COL_NM,
          name: menu.COL_ID,
          minWidth: menu.COL_WIDTH,
          formatter: 'listItemText',
          editor: {
            type: 'select',
            options: {
              listItems: cmbItems[menu.COL_ID],
            },
          },
          hidden: colHidden,
          valign: valign,
          align: align,
        });
        break;
      case '4':
        console.log(4);
        cusCols.push({
          header: menu.COL_NM,
          name: menu.COL_ID,
          minWidth: menu.COL_WIDTH,
          hidden: colHidden,
          valign: valign,
          align: align,
          editor: {
            type: 'datePicker',
            options: {
              format: 'yyyy/MM/dd',
            },
          },
        });
        break;

      default:
        console.log('d');
        cusCols.push({
          header: menu.COL_NM,
          name: menu.COL_ID,
          minWidth: menu.COL_WIDTH,
          hidden: colHidden,
          valign: valign,
          align: align,
          editor: 'text',
        });
        break;
    }
  }
  });

  return (
    <div className='grid-wrapper'>
      <Grid
        ref={ref}
        data={data}
        columns={cusCols}
        rowHeight={29}
        minRowHeight={20}
        bodyHeight={bodyHeight}
        heightResizable={true}
        rowHeaders={['rowNum']}
        columnOptions={{ resizable: true }}
        usageStatistics={false}
        onClick={onClick}
      />
    </div>
  );
});

export default TuiGrid;

//toast grid 예시
// const columns = [
//   {
//     header: '발주일',
//     name: 'PUR_ORDER_DT',
//     editor: {
//       type: 'datePicker',
//       options: {
//         format: 'yyyy/MM/dd',
//       },
//     },
//   },
//   { name: 'PUR_CUST_CD', header: '발주처코드', editor: 'text', visible: false },
//   { name: 'BP_NM', header: '발주처', editor: 'text' },
//   { name: 'PUR_ORDER_NO', header: '발주번호', editor: 'text' },
//   { name: 'PUR_ORDER_SEQ', header: '발주순번', editor: 'text' },
//   { name: 'PUR_USER_ID', header: '발주자명' },
//   {
//     name: 'PLANT_TYPE',
//     header: '발주공장',
//     formatter: 'listItemText',
//     editor: {
//       type: 'select',
//       options: {
//         listItems: [
//           { text: '공장1', value: '1' },
//           { text: '공장2', value: '2' },
//           { text: '공장3', value: '3' },
//         ],
//       },
//     },
//   },
//   { name: 'PUR_STATUS', header: '발주상태' },
//   {
//     type: 'checkbox',
//     header: (
//       <label for="all-checkbox" class="checkbox">
//         <input type="checkbox" id="all-checkbox" class="hidden-input" name="_checked"></input>
//         <span className="custom-input"></span>
//       </label>
//     ),
//     name: 'SUPPLY_TYPE',
//     renderer: {
//       type: CheckboxRenderer,
//     },
//   },
//   { name: 'ITEM_CD', header: '품목코드', editor: 'text' },
//   { name: 'ITEM_NM', header: '원단사모델명', editor: 'text' },
//   { name: 'SPEC', header: 'SPEC', editor: 'text' },
//   { name: 'THICK', header: '두께', editor: 'text' },
//   { name: 'WIDTH', header: '폭', editor: 'text' },
// ];

// 더미데이터
// const [data, setData] = useState([
//   {
//     PUR_ORDER_DT: '2022-04-01',
//     PUR_CUST_DT: 'S11',
//     BP_NM: '어느곳',
//     PUR_ORDER_NO: 123,
//     PUR_USER_ID: '거림',
//     PLANT_TYPE: '발주공장',
//     PUR_STATUS: '발주상태',
//     SUPPLY_TYPE: 'Y',
//     ITEM_CD: '품목코드',
//     ITEM_NM: '품목명',
//     SPEC: 'SPEC',
//     THICK: '두께',
//     WIDTH: '폭',
//   },
// ]);
