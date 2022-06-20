import React from 'react'
import '../css/PreviewPopup.css';
import * as DecimalFormat from '../common/DecimalFormat.js';

const PreviewPopup = (props) => {
    console.log("ddd : " + props);
    
    const { pdata } = props;

    function dynamicTrRow() {
      var array = [];

      for(var i=1; i<=10; i++) {
        if(i <= pdata.nestedList.length) {
          array.push(
          <tr key={pdata.id+i}>
            <td className="t_number">{i}</td>
            <td className='t_center'>{pdata.nestedList[i-1].ITEM_NM}</td>
            <td className='t_center'>{pdata.nestedList[i-1].SPEC}</td>
            <td className='t_center'>{pdata.nestedList[i-1].BASIC_UNIT}</td>
            <td className='t_right'>{pdata.nestedList[i-1].DLVY_QTY}</td>
            <td className='t_right'>{pdata.nestedList[i-1].DLVY_ROLL}</td>
            <td className='t_right'>{pdata.nestedList[i-1].SCRAP_QTY}</td>
            <td className='t_right'>{pdata.nestedList[i-1].ITEM_PRICE}</td>
            <td className='t_right'>{pdata.nestedList[i-1].AMT}</td>
        </tr>)
        }else {
          array.push(
            <tr key={pdata.id+i}>
            <td className="t_number" />
            <td />
            <td />
            <td />
            <td />
            <td />
            <td />
            <td />
            <td />
          </tr>
          )
        }
      }
      
      array.push(
        <tr key={pdata.id+"-1"} style={{borderTop: '4px', borderTopStyle: 'double'}}>
          <td className="t_center" colSpan={4}><pre>소{"     "}계</pre></td>
          <td className="t_right">{pdata.total_dlvy_qty}</td>
          <td className="t_right">{pdata.total_dlvy_roll}</td>
          <td className="t_right">{pdata.total_scrap_qty}</td>
          <td className="t_right"></td>
          <td className="t_right">{pdata.total_amt}</td>
        </tr>
      )
      return array;
    }
    return (
        <div className='container-wrapper'>
          {/* Hello world */}
          <div className="container">
            {/* 네비게이션 부분 */}
              <div className="nav">
                <div className="delivery_date_container">
                  <table>
                    <tbody><tr className="dt_row">
                        <td className="delivery_date_td">
                          <pre> 납품년월일{"   "}:{"   "}</pre>
                          <span className="delivery_date">{pdata.nestedList[0].DLVY_DT}</span>
                        </td>
                      </tr>
                      <tr className="dt_row">
                        <td>
                          <pre>증 빙 번 호{"   "}:{"   "}</pre>
                          <span className="proof_number">{pdata.nestedList[0].DLVY_NO}</span>
                        </td>
                      </tr>
                    </tbody></table>
                </div>
                <div className="title_container">
                  <div className="title_name">거 래 명 세 서</div>
                  <div className="sp">공급자용</div>
                  <div className="barcode">dddddddddddddd</div>
                </div>
                <div className="confirm_container">
                  <table>
                    <tbody><tr className="ct_r1">
                        <th rowSpan={2}>결<br /><br />재 
                        </th><th>담당</th> 
                        <th>검토</th> 
                        <th>승인</th> 
                      </tr>
                      <tr className="ct_r2">
                        <td style={{height: '70px'}} />
                        <td />
                        <td />
                      </tr>
                    </tbody></table>
                </div>
              </div>
              {/* 공급자 부분 */}
              <div className="supplyer_container">
                <table>
                  <tbody><tr>
                      <td className="t_center" rowSpan={5}>공<br />급<br /><br />받<br />는<br />자</td>
                      <td className="t_center">등록 번호</td>
                      <td className="tl_width" colSpan={3} >{"503 - 81 - 53553"}</td>
                      <td className="t_center" rowSpan={5} style={{borderLeftWidth: '4px', borderStyle: 'double'}}>공<br /><br />급<br /><br />자</td>
                      <td className="t_center">등록번호</td>
                      <td className="tl_width" colSpan={3} >{pdata.nestedList[0].BP_RGIST_NO}</td>
                    </tr>
                    <tr>
                      <td className="t_center"><pre>상{"   "}호</pre></td>
                      <td className="ts_width" >{"거림테크 주식회사"}</td>
                      <td className="t_center"><pre>성{"   "}명</pre></td>
                      <td className="ts_width" >{"이창원"}</td>
                      <td className="t_center"><pre>상{"   "}호</pre></td>
                      <td className="ts_width" >{pdata.nestedList[0].BP_NM}</td>
                      <td className="t_center"><pre>성{"   "}명</pre></td>
                      <td className="ts_width" >{pdata.nestedList[0].REPRE_NM}</td>
                    </tr>
                    <tr>
                      <td className="t_center" ><pre>주{"   "}소</pre></td>
                      <td className="tl_width" id='address' colSpan={3} >{"대구 달서구 월암동 1094(성서4차첨단로 171"}</td>
                      <td className="t_center"><pre>주{"   "}소</pre></td>
                      <td className="tl_width" id='address' colSpan={3} >{pdata.nestedList[0].ADDR}</td>
                    </tr>
                    <tr>
                      <td className="t_center">전화번호</td>
                      <td className="ts_width" >{"053-593-3003"}</td>
                      <td className="t_center">팩스번호</td>
                      <td className="ts_width" >{"053-593-3006"}</td>
                      <td className="t_center">전화번호</td>
                      <td className="ts_width" >{pdata.nestedList[0].TEL_NO1}</td>
                      <td className="t_center">팩스번호</td>
                      <td className="ts_width" >{pdata.nestedList[0].FAX_NO}</td>
                    </tr>
                    <tr>
                      <td className="t_center"><pre>업{"   "}태</pre></td>
                      <td className="ts_width" >{"제조, 도매, 서비스"}</td>
                      <td className="t_center"><pre>종{"   "}목</pre></td>
                      <td className="td_work" >{"전자부품, 무역, 연구개발업"}</td>
                      <td className="t_center"><pre>업{"   "}태</pre></td>
                      <td className="ts_width" >{pdata.nestedList[0].IND_TYPE}</td>
                      <td className="t_center"><pre>종{"   "}목</pre></td>
                      <td className="td_work" >{pdata.nestedList[0].IND_CLASS}</td>
                    </tr>
                  </tbody></table>
              </div>
              {/* 내용 부분 */}
              <div className="contents_container">
                <table>
                  <tbody>
                    <tr>
                      <th className="t_center" id="no">NO.</th>
                      <th className="t_center" id="name"><pre>품{"     "}명</pre></th>
                      <th className="t_center" id="standard"><pre>규{"    "}격</pre></th>
                      <th className="t_center" id="unit">단위</th>
                      <th className="t_center" id="width"><pre>면{"    "}적</pre></th>
                      <th className="t_center" id="roll">ROLL</th>
                      <th className="t_center" id="scrab">스크랩수</th>
                      <th className="t_center" id="unit_price"><pre>단{"    "}가</pre></th>
                      <th className="t_center" id="price"><pre>금{"     "}액</pre></th>
                    </tr>
                    { dynamicTrRow() }
                  </tbody>
                </table>
              </div>
              {/* 푸터 부분 */}
              <div className="footer">
                <table className="f_ta_1">
                  <tbody><tr>
                      <td className="t_center">비<br /><br />고</td>
                      <td className="f1_width" />
                    </tr>
                    <tr>
                      <td className="t_center">인<br />수<br />자</td>
                      <td className="f1_width">(인)</td>
                    </tr>
                  </tbody></table>
                <table className="f_ta_2">
                <tbody><tr>
                      <td className="footer_price">공 급 가 액 합 계</td>
                      <td className='f2_width'>{pdata.total_amt_sup}</td>
                    </tr>
                    <tr>
                      <td className="footer_price">부 가 가 치 세</td>
                      <td className="f2_width">{pdata.add_value_price}</td>
                    </tr>
                    <tr>
                      <td className="footer_price"><pre>총{"       "}계</pre></td>
                      <td className="f2_width" >{pdata.total}</td>
                    </tr>
                  </tbody></table>
              </div>
              <div className="add_price">부가가치세 별도</div>
              {/* 네비게이션 부분 */}
              <div className="nav" style={{borderTop: '1px dotted black'}}>
                <div className="delivery_date_container">
                <table>
                    <tbody><tr className="dt_row">
                        <td className="delivery_date_td">
                          <pre> 납품년월일{"   "}:{"   "}</pre>
                          <span className="delivery_date">{pdata.nestedList[0].DLVY_DT}</span>
                        </td>
                      </tr>
                      <tr className="dt_row">
                        <td>
                          <pre>증 빙 번 호{"   "}:{"   "}</pre>
                          <span className="proof_number">{pdata.nestedList[0].DLVY_NO}</span>
                        </td>
                      </tr>
                    </tbody></table>
                </div>
                <div className="title_container">
                  <div className="title_name">거 래 명 세 서</div>
                  <div className="sp">공급받는자용</div>
                  <div className="barcode">dddddddddddddd</div>
                </div>
                <div className="confirm_container">
                  <table>
                    <tbody><tr className="ct_r1">
                        <th rowSpan={2}>결<br /><br />재 
                        </th><th>담당</th> 
                        <th>검토</th> 
                        <th>승인</th> 
                      </tr>
                      <tr className="ct_r2">
                        <td style={{height: '70px'}} />
                        <td />
                        <td />
                      </tr>
                    </tbody></table>
                </div>
              </div>
              {/* 공급자 부분 */}
              <div className="supplyer_container">
                <table>
                  <tbody><tr>
                      <td className="t_center" rowSpan={5}>공<br />급<br /><br />받<br />는<br />자</td>
                      <td className="t_center">등록 번호</td>
                      <td className="tl_width" colSpan={3} >{"503 - 81 - 53553"}</td>
                      <td className="t_center" rowSpan={5} style={{borderLeftWidth: '4px', borderStyle: 'double'}}>공<br /><br />급<br /><br />자</td>
                      <td className="t_center">등록번호</td>
                      <td className="tl_width" colSpan={3} >{pdata.nestedList[0].BP_RGIST_NO}</td>
                    </tr>
                    <tr>
                      <td className="t_center"><pre>상{"   "}호</pre></td>
                      <td className="ts_width" >{"거림테크 주식회사"}</td>
                      <td className="t_center"><pre>성{"   "}명</pre></td>
                      <td className="ts_width" >{"이창원"}</td>
                      <td className="t_center"><pre>상{"   "}호</pre></td>
                      <td className="ts_width" >{pdata.nestedList[0].BP_NM}</td>
                      <td className="t_center"><pre>성{"   "}명</pre></td>
                      <td className="ts_width" >{pdata.nestedList[0].REPRE_NM}</td>
                    </tr>
                    <tr>
                      <td className="t_center"><pre>주{"   "}소</pre></td>
                      <td className="tl_width" id='address' colSpan={3} >{"대구 달서구 월암동 1094(성서4차첨단로 171"}</td>
                      <td className="t_center" ><pre>주{"   "}소</pre></td>
                      <td className="tl_width" id='address' colSpan={3} >{pdata.nestedList[0].ADDR}</td>
                    </tr>
                    <tr>
                      <td className="t_center">전화번호</td>
                      <td className="ts_width" >{"053-593-3003"}</td>
                      <td className="t_center">팩스번호</td>
                      <td className="ts_width" >{"053-593-3006"}</td>
                      <td className="t_center">전화번호</td>
                      <td className="ts_width" >{pdata.nestedList[0].TEL_NO1}</td>
                      <td className="t_center">팩스번호</td>
                      <td className="ts_width" >{pdata.nestedList[0].FAX_NO}</td>
                    </tr>
                    <tr>
                      <td className="t_center"><pre>업{"   "}태</pre></td>
                      <td className="ts_width" >{"제조, 도매, 서비스"}</td>
                      <td className="t_center"><pre>종{"   "}목</pre></td>
                      <td className="td_work" >{"전자부품, 무역, 연구개발업"}</td>
                      <td className="t_center"><pre>업{"   "}태</pre></td>
                      <td className="ts_width" >{pdata.nestedList[0].IND_TYPE}</td>
                      <td className="t_center"><pre>종{"   "}목</pre></td>
                      <td className="td_work" >{pdata.nestedList[0].IND_CLASS}</td>
                    </tr>
                  </tbody></table>
              </div>
              {/* 내용 부분 */}
              <div className="contents_container">
                <table>
                  <tbody>
                    <tr>
                      <th className="t_center" id="no">NO.</th>
                      <th className="t_center" id="name"><pre>품{"     "}명</pre></th>
                      <th className="t_center" id="standard"><pre>규{"    "}격</pre></th>
                      <th className="t_center" id="unit">단위
                      </th><th className="t_center" id="width"><pre>면{"    "}적</pre></th>
                      <th className="t_center" id="roll">ROLL
                      </th><th className="t_center" id="scrab">스크랩수
                      </th><th className="t_center" id="unit_price"><pre>단{"    "}가</pre></th>
                      <th className="t_center" id="price"><pre>금{"     "}액</pre></th>
                    </tr>
                    {dynamicTrRow()}
                  </tbody>
                </table>
              </div>
              {/* 푸터 부분 */}
              <div className="footer">
                <table className="f_ta_1">
                  <tbody><tr>
                      <td className="t_center">비<br /><br />고</td>
                      <td className="f1_width" />
                    </tr>
                    <tr>
                      <td className="t_center">인<br />수<br />자</td>
                      <td className="f1_width"><span>(인)</span></td>
                    </tr>
                  </tbody></table>
                <table className="f_ta_2">
                  <tbody>
                    <tr>
                      <td className="footer_price">공 급 가 액 합 계</td>
                      <td className='f2_width'>{pdata.total_amt_sup}</td>
                    </tr>
                    <tr>
                      <td className="footer_price">부 가 가 치 세</td>
                      <td className="f2_width">{pdata.add_value_price}</td>
                    </tr>
                    <tr>
                      <td className="footer_price"><pre>총{"       "}계</pre></td>
                      <td className="f2_width" >{pdata.total}</td>
                    </tr>
                  </tbody></table>
              </div>
              <div className="add_price">부가가치세 별도</div>
          </div>
        </div>
    );
};
    
export default PreviewPopup