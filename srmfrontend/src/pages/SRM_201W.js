import React, { useEffect, useRef, useState } from 'react';
import Header from '../components/Header';
import CustomDateRagePicker from '../components/CustomDateRagePicker';
import Gubun from '../components/Gubun';
import TuiGrid from '../components/TuiGrid';
import NavBar from '../components/NavBar';

/**
 * 화면명 : 납품등록 (정현락)
 * 화면번호 : SRM_201W
 * @returns
 */

const SRM_201W = () => {
  const gridRef1 = useRef();
  const gridRef2 = useRef();
  const [colHeader, setColHeader] = useState([]);
  const [dtGbn, setDtGbn] = useState('D');
  const [dlvyGbn, setDlvyGbn] = useState('N');
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());
  const [dlvyStartDate, setDlvyStartDate] = useState(new Date());
  let dateTo = new Date();
  dateTo.setDate(dateTo.getDate() + 7);
  const [dlvyEndDate, setDlvyEndDate] = useState(dateTo);
  const [data, setData] = useState({
    Grid1: [],
    Grid2: [],
  });

  // 거래처 콤보박스
  // useEffect(() => {
  //   CustomFetch('localhost:8080', 'api/cmbItems/UserQuery', { query: 'select p from BA_BIZ_PARTNER p' })
  //     .then((data) => {
  //       console.log(data);
  //       if (data.length === 0) {
  //         setCmbCust([{}]);
  //       } else {
  //         setCmbCust(data);
  //       }
  //     })
  //     .catch((error) => console.log(error));
  // }, []);

  // 콤보박스용
  const [cmbGrid1, setCmbGrid1] = useState({
    PUR_USER_ID: [
      { text: '자재팀', value: '100' },
      { text: '이대선', value: '200' },
      { text: '박건민', value: '300' },
      { text: '정미옥', value: '400' },
      { text: '노동욱', value: '500' },
    ],
    // B9102: [
    //   { text: '아니오', value: 'N' },
    //   { text: '예', value: 'Y' },
    // ],
  });

  const [cmbCust, setCmbCust] = useState([
    { value: '1000', text: '	**' },
    { value: 'A1001', text: '	한국니또덴꼬' },
    { value: 'A1002', text: '	솔루에타' },
    { value: 'A1003', text: '	유아이' },
    { value: 'A1004', text: '	우남테크' },
    { value: 'A1005', text: '	코닉스' },
    { value: 'A1006', text: '	도레이첨단소재' },
    { value: 'A1007', text: '	한국이엠' },
    { value: 'A1008', text: '	선경화학' },
    { value: 'A1009', text: '	한국코스틱' },
    { value: 'A1010', text: '	이송이엠씨' },
    { value: 'A1011', text: '	동도물산' },
    { value: 'A1012', text: '	두리프린텍' },
    { value: 'A1014', text: '	비엘코리아' },
    { value: 'A1015', text: '	엘앤에프' },
    { value: 'A1016', text: '	서브원' },
    { value: 'A1017', text: '	성지하이텍' },
    { value: 'A1018', text: '	진흥무역' },
    { value: 'A1019', text: '	에스엔케이폴리텍' },
    { value: 'A1020', text: '	나노캠텍' },
    { value: 'A1021', text: '	예선테크' },
    { value: 'A1022', text: '	메탈라인' },
    { value: 'A1023', text: '	유엔티코리아' },
    { value: 'A1024', text: '	건영머트리얼스' },
    { value: 'A1025', text: '	대현에스티' },
    { value: 'A1026', text: '	성하하이텍' },
    { value: 'A1027', text: '	모두테크' },
    { value: 'A1028', text: '	두이산업' },
    { value: 'A1029', text: '	동도트레이딩' },
    { value: 'A1030', text: '	율촌화학' },
    { value: 'A1031', text: '	프로피아' },
    { value: 'A1032', text: '	서광테크' },
    { value: 'A1033', text: '	듀폰코리아' },
    { value: 'A1034', text: '	제이엘프로텍' },
    { value: 'A1035', text: '	신양테크놀러지' },
    { value: 'A1036', text: '	연우' },
    { value: 'A1038', text: '	보우테이프' },
    { value: 'A1039', text: '	대상에스티' },
    { value: 'A1040', text: '	두성산업' },
    { value: 'A1041', text: '	다보씨앤엠' },
    { value: 'A1042', text: '	이엔씨테크' },
    { value: 'A1043', text: '	엔에스엠' },
    { value: 'A1044', text: '	대산티에스티' },
    { value: 'A1045', text: '	테프-온' },
    { value: 'A1046', text: '	지흥' },
    { value: 'A1047', text: '	덕성폴리켐' },
    { value: 'A1048', text: '	지현테크' },
    { value: 'A1049', text: '	유비하이테크' },
    { value: 'A1050', text: '	성보잉크' },
    { value: 'A1051', text: '	엘투와이' },
    { value: 'A1052', text: '	창림테크' },
    { value: 'A1053', text: '	지엔씨티(G&CT)' },
    { value: 'A1054', text: '	BSM KOREA' },
    { value: 'A1055', text: '	CI테크' },
    { value: 'A1056', text: '	이녹스' },
    { value: 'A1057', text: '	형성산업' },
    { value: 'A1058', text: '	선경에스티' },
    { value: 'A1059', text: '	영보화학' },
    { value: 'A1060', text: '	에이치알에스' },
    { value: 'A1061', text: '	디앤디주식회사' },
    { value: 'A1063', text: '	이에스디윅            ' },
    { value: 'A1065', text: '	지에스테크' },
    { value: 'A1066', text: '	미라클' },
    { value: 'A1067', text: '	영우' },
    { value: 'A1068', text: '	유티에스' },
    { value: 'A1069', text: '	한국필름재단' },
    { value: 'A1070', text: '	화인솔루션' },
    { value: 'A1071', text: '	우성테크놀러지' },
    { value: 'A1072', text: '	제이엔케이테크' },
    { value: 'A1073', text: '	지엠케이' },
    { value: 'A1074', text: '	케이에스피코퍼레이션' },
    { value: 'A1075', text: '	태인' },
    { value: 'A1076', text: '	더블유티엑스' },
    { value: 'A1077', text: '	가드넥' },
    { value: 'A1078', text: '	테이프월드' },
    { value: 'A1079', text: '	케이엠텍' },
    { value: 'A1080', text: '	비엘케이' },
    { value: 'A1081', text: '	창성시트' },
    { value: 'A1082', text: '	일신케미칼' },
    { value: 'A1083', text: '	대성상사' },
    { value: 'A1084', text: '	스카이뷰' },
    { value: 'A1085', text: '	지앤지텍' },
    { value: 'A1086', text: '	지앤씨에스' },
    { value: 'A1087', text: '	소이' },
    { value: 'A1088', text: '	테이팩스(양감)' },
    { value: 'A1089', text: '	우리텍' },
    { value: 'A1090', text: '	폴리머사이언스' },
    { value: 'A1091', text: '	해치' },
    { value: 'A1092', text: '	디에스 트레이딩' },
    { value: 'A1093', text: '	대광기계' },
    { value: 'A1094', text: '	에프엔디컴퍼니' },
    { value: 'A1095', text: '	태영옵티칼' },
    { value: 'A1096', text: '	오메이리더스' },
    { value: 'A1097', text: '	세인블루텍' },
    { value: 'A1098', text: '	에이치앤에스' },
    { value: 'A1099', text: '	남경법인' },
    { value: 'A1100', text: '	예손기업' },
    { value: 'A1101', text: '	대흥소재' },
    { value: 'A1102', text: '	하나기업' },
    { value: 'A1103', text: '	켐코' },
    { value: 'A1104', text: '	은광인더스트리' },
    { value: 'A1105', text: '	럭스템' },
    { value: 'A1106', text: '	엔티에프' },
    { value: 'A1111', text: '	유광테크' },
    { value: 'A1112', text: '	코리아하이테크' },
    { value: 'A1113', text: '	금오에스피엘' },
    { value: 'A1114', text: '	금성프라스틱' },
    { value: 'A1115', text: '	대세기업' },
    { value: 'A1116', text: '	미래포장' },
    { value: 'A1117', text: '	미래피엔티' },
    { value: 'A1118', text: '	한일테크놀러지' },
    { value: 'A1119', text: '	씨엔디팩' },
    { value: 'A1121', text: '	디노' },
    { value: 'A1122', text: '	한빛상사' },
    { value: 'A1123', text: '	미소르씨에스티' },
    { value: 'A1124', text: '	대운산업' },
    { value: 'A1125', text: '	우양상사' },
    { value: 'A1126', text: '	만년산업안전' },
    { value: 'A1127', text: '	동우에스티' },
    { value: 'A1128', text: '	원진고무롤' },
    { value: 'A1129', text: '	탑런테크' },
    { value: 'A1130', text: '	스마일유통' },
    { value: 'A1131', text: '	(주)모던테크' },
    { value: 'A1132', text: '	화성테크' },
    { value: 'A1133', text: '	켐코스' },
    { value: 'A1134', text: '	(주)동양테이프' },
    { value: 'A1135', text: '	탑런토탈솔루션' },
    { value: 'A1136', text: '	포엘비테크' },
    { value: 'A1137', text: '	(주)기산테이프' },
    { value: 'A1138', text: '	UTC' },
    { value: 'A1139', text: '	더필립' },
    { value: 'A1140', text: '	서암' },
    { value: 'A1141', text: '	상언전자' },
    { value: 'A1142', text: '	반도' },
    { value: 'A1143', text: '	JKD' },
    { value: 'A1144', text: '	제이앤제이' },
    { value: 'A1145', text: '	아산공장' },
    { value: 'A1146', text: '	에이스실리콘(구 아성)' },
    { value: 'A1147', text: '	현무역' },
    { value: 'A1148', text: '	정진넥스텍' },
    { value: 'A1149', text: '	씨엔에스' },
    { value: 'A1150', text: '	유니즌 이엠씨' },
    { value: 'A1151', text: '	이트라' },
    { value: 'A1152', text: '	동우씨엔에스' },
    { value: 'A1153', text: '	데카닉스' },
    { value: 'A1154', text: '	세기컨버텍' },
    { value: 'A1155', text: '	아주스틸' },
    { value: 'A1157', text: '	인터켐텍' },
    { value: 'A1158', text: '	이원시스템' },
    { value: 'A1159', text: '	혜성패키징' },
    { value: 'A1160', text: '	화인테크코리아' },
    { value: 'A1161', text: '	제이엔티' },
    { value: 'A1162', text: '	디에스코텍' },
    { value: 'A1163', text: '	에스티씨' },
    { value: 'A1164', text: '	아이엔씨티' },
    { value: 'A1165', text: '	모디크' },
    { value: 'A1166', text: '	FM코리아' },
    { value: 'A1167', text: '	서브원테크놀로지' },
    { value: 'A1168', text: '	JH하이테크' },
    { value: 'A1169', text: '	유원인더스트리' },
    { value: 'A1170', text: '	플러스알파' },
    { value: 'A1171', text: '	아주스틸' },
    { value: 'A1172', text: '	오에프테크' },
    { value: 'A1173', text: '	베트남법인' },
    { value: 'A1174', text: '	동현산업 ' },
    { value: 'A1175', text: '	씨테크' },
    { value: 'A1176', text: '	세광테이프' },
    { value: 'A1177', text: '	티엠에스' },
    { value: 'A1178', text: '	유아이(본사)' },
    { value: 'A1179', text: '	동관법인' },
    { value: 'A1180', text: '	이에스디코리아' },
    { value: 'A1181', text: '	엘에스케이테크' },
    { value: 'A1182', text: '	현진케미칼' },
    { value: 'A1183', text: '	메인일렉콤' },
    { value: 'A1184', text: '	영창첨단소재' },
    { value: 'A1185', text: '	파인테크' },
    { value: 'A1186', text: '	대광기업' },
    { value: 'A1187', text: '	에스제이테크' },
    { value: 'A1188', text: '	삼아알미늄(주)' },
    { value: 'A1189', text: '	지원금속' },
    { value: 'A1190', text: '	더블유엔티' },
    { value: 'A1191', text: '	성우코리아' },
    { value: 'A1192', text: '	호만케미칼' },
    { value: 'A1193', text: '	KSP' },
    { value: 'A1194', text: '	한국가네마쯔' },
    { value: 'A1195', text: '	LG화학' },
    { value: 'A1196', text: '	지에스알' },
    { value: 'A1197', text: '	태승테크' },
    { value: 'A1198', text: '	B&F' },
    { value: 'A1199', text: '	나성산업' },
    { value: 'A1200', text: '	동원인텍' },
    { value: 'A1201', text: '	파인테크닉스' },
    { value: 'A1202', text: '	전영' },
    { value: 'A1203', text: '	뉴프로텍' },
    { value: 'A1204', text: '	인성' },
    { value: 'A1205', text: '	에이엔에스' },
    { value: 'A1206', text: '	세방기업' },
    { value: 'A1207', text: '	HMT' },
    { value: 'A1208', text: '	TOMOEGAWA' },
    { value: 'A1209', text: '	히타치금속' },
    { value: 'A1210', text: '	(주)굿케미칼' },
    { value: 'A1211', text: '	너나들이' },
    { value: 'A1212', text: '	LSK' },
    { value: 'A1213', text: '	제이와이테크' },
    { value: 'A1214', text: '	세진산업' },
    { value: 'A1215', text: '	카프솔루션' },
    { value: 'A1216', text: '	아이엠씨' },
    { value: 'A1217', text: '	호원' },
    { value: 'A1218', text: '	해솔' },
    { value: 'A1219', text: '	한국이와타니산업' },
    { value: 'A1220', text: '	아이티사인' },
    { value: 'A1221', text: '	한국신요' },
    { value: 'A1222', text: '	SHINYOH' },
    { value: 'A1223', text: '	대경하이테크' },
    { value: 'A1224', text: '	개발업체' },
    { value: 'A1225', text: '	영진아스텍 ' },
    { value: 'A1226', text: '	한석인터내셔날' },
    { value: 'A1227', text: '	한성케미칼' },
    { value: 'A1228', text: '	에펠컴' },
    { value: 'A1229', text: '	성진글로벌' },
    { value: 'A1230', text: '	청당기업' },
    { value: 'A1231', text: '	피셀테크' },
    { value: 'A1232', text: '	치린' },
    { value: 'A1233', text: '	베오텍' },
    { value: 'A1234', text: '	영우화인텍' },
    { value: 'A1235', text: '	에이치엔지트레이딩' },
    { value: 'A1236', text: '	서환전자' },
    { value: 'A1237', text: '	동명금속' },
    { value: 'A1238', text: '	DNMT' },
    { value: 'A1239', text: '	SP테크 ' },
    { value: 'A1240', text: '	동방소재' },
    { value: 'A1241', text: '	안텍' },
    { value: 'A1242', text: '	삼지산업' },
    { value: 'A1243', text: '	넥쏠' },
    { value: 'A1244', text: '	에스제이폼웍스' },
    { value: 'A1245', text: '	(주)국보화학' },
    { value: 'A1246', text: '	(주)대원디앤씨' },
    { value: 'A1247', text: '	에이치에스메탈' },
    { value: 'A1248', text: '	에이앤티' },
    { value: 'A1249', text: '	시트러스' },
    { value: 'A1250', text: '	지오엔지니어링' },
    { value: 'A1251', text: '	테사테이프코리아' },
    { value: 'A1252', text: '	티앤티코리아' },
    { value: 'B2001', text: '	동서전자' },
    { value: 'B2004', text: '	엘지디스플레이' },
    { value: 'B2005', text: '	레이젠' },
    { value: 'B2007', text: '	영동아이앤디' },
    { value: 'B2008', text: '	아바텍' },
    { value: 'B2010', text: '	희성전자(주)대구공장' },
    { value: 'B2013', text: '	엑트' },
    { value: 'B2014', text: '	에이플러스' },
    { value: 'B2015', text: '	에프엠에스' },
    { value: 'B2017', text: '	화인알텍' },
    { value: 'B2018', text: '	성우무역' },
    { value: 'B2020', text: '	이피네트' },
    { value: 'B2021', text: '	가산고철' },
    { value: 'B2022', text: '	성보잉크' },
    { value: 'B2024', text: '	대우디스플레이' },
    { value: 'B2027', text: '	아이엔티' },
    { value: 'B2028', text: '	디오브이' },
    { value: 'B2029', text: '	태성' },
    { value: 'B2030', text: '	글로닉스' },
    { value: 'B2031', text: '	에스제이' },
    { value: 'B2032', text: '	INT' },
    { value: 'B2033', text: '	희성전자(주)파주공장' },
    { value: 'B2034', text: '	(주)SK HASS' },
    { value: 'B2035', text: '	뉴옵틱스' },
    { value: 'B2036', text: '	희성전자(주)대구2공장' },
    { value: 'B2037', text: '	(주)오성디스플레이 양주공장' },
    { value: 'B2038', text: '	후타바전자부품한국(주)' },
    { value: 'B2039', text: '	SDC' },
    { value: 'B2040', text: '	진흥무역(주)' },
    { value: 'B3001', text: '	GIS' },
    { value: 'B3002', text: '	라이바오' },
    { value: 'B3003', text: '	남경법인' },
    { value: 'B3004', text: '	동관법인' },
    { value: 'B3005', text: '	(주)윌닉스' },
    { value: 'B3007', text: '	LG이노텍' },
    { value: 'B3008', text: '	금성정공' },
    { value: 'B3009', text: '	지엔씨티(G&CT)' },
    { value: 'B3010', text: '	희성전자(주)연태법인' },
    { value: 'B3011', text: '	베트남법인' },
    { value: 'B3012', text: '	대구특수금속' },
    { value: 'B3013', text: '	(주)브이디에스' },
    { value: 'B3014', text: '	쉬홍광전' },
    { value: 'B3016', text: '	(주)탑런몰드텍' },
    { value: 'B3017', text: '	LENS' },
    { value: 'B3018', text: '	고월드' },
    { value: 'B3019', text: '	월드샤인' },
    { value: 'B3020', text: '	LG화학' },
    { value: 'B3030', text: '	일진디스플레이' },
    { value: 'B3031', text: '	진롱하오' },
    { value: 'B3032', text: '	화성테크' },
    { value: 'B306', text: '	토비스' },
    { value: 'B307', text: '	아산공장' },
    { value: 'B308', text: '	티엠에스' },
    { value: 'B309', text: '	*' },
    { value: 'B310', text: '	지에스알' },
    { value: 'B311', text: '	B&F' },
    { value: 'B312', text: '	영성전자' },
    { value: 'B313', text: '	BOE' },
  ]);

  const [cmbGrid2, setCmbGrid2] = useState({
    CUST_CD: cmbCust,
    // B9102: [
    //   { text: '아니오', value: 'N' },
    //   { text: '예', value: 'Y' },
    // ],
  });

  //컬럼헤더
  useEffect(() => {
    fetch('http://localhost:8080/api/XM102W/list?divCd=01&menuId=SRM_201W')
      .then((res) => res.json())
      .then((res) => {
        setColHeader(res);
      }); // 비동기 함수
  }, []); //2번째 인자 미입력시 최초 한번 실행

  const searchFormData = {
    divCd: '01',
    dtFrom: startDate,
    dtTo: endDate,
    purCustCd: '1000',
    dtGbn: dtGbn,
    userGroup: 'S',
    npYn: dlvyGbn,
    dlvyFr: dlvyStartDate,
    dlvyTo: dlvyEndDate,
    dlvyNo: '',
  };

  //저장
  const handleSaveList = (e) => {
    e.preventDefault();
    fetch('http://localhost:8080/api/SRM201W/save', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        // SRM302RDto: data1,
        // SRM100RVO: searchFormData,
      }),
    })
      .then((res) => res)
      .then((res) => {
        //console.log(res.status);
      });
  };

  // 추가
  const useAddRowHandler = () => {
    console.log(gridRef1.current);
    console.log(gridRef2.current);

    console.log(gridRef1.current.getInstance().store.focus.rowKey);

    if (gridRef1.current.getInstance().store.focus.rowKey === null) {
      return;
    }
    if (gridRef2 === undefined) return;

    let idx = gridRef2.current.getInstance().store.focus.rowKey;
    if (idx === null) {
      gridRef2.current.getInstance().appendRow({});
    } else {
      gridRef2.current.getInstance().appendRow({ CU: 'C' }, { at: idx + 1 });
    }
  };

  return (
    <div>
      {/* <Header searchFormData={searchFormData} setData={setData} searchUrl={'api/SRM201W/list'} /> */}
      <NavBar
        searchFormData={searchFormData}
        setData={setData}
        searchUrl={'api/SRM201W/list'}
        useAddRowHandler={useAddRowHandler}
      />
      <div>
        <div className="conditions-wrapper">
          <div className="conditions-box">
            <Gubun
              dtGbn={dtGbn}
              setDtGbn={setDtGbn}
              gbnTitle={'기간구분'}
              gbnValue1={'납기일자'}
              gbnValue2={'발주일자'}
              contact1={'ops_dt_d'}
              contact2={'ops_dt_p'}
              value1={'D'}
              value2={'P'}
            />
          </div>
          <div className="conditions-box">
            <CustomDateRagePicker
              dateTitle={'기간 '}
              startDate={startDate}
              setStartDate={setStartDate}
              endDate={endDate}
              setEndDate={setEndDate}
            />
          </div>
          <div className="conditions-box">
            <Gubun
              dtGbn={dlvyGbn}
              setDtGbn={setDlvyGbn}
              gbnTitle={'납품구분'}
              gbnValue1={'미납'}
              gbnValue2={'입고완료'}
              contact1={'ops_np_n'}
              contact2={'ops_np_y'}
              value1={'N'}
              value2={'Y'}
            />
          </div>
        </div>
        <TuiGrid
          ref={gridRef1}
          columns={colHeader.filter((col) => col.MENU_TAB_NO === '1')}
          viewName={'SRM_201W'}
          data={data.Grid1}
          cmbItems={cmbGrid1}
          bodyHeight={280}
          onClick={() => {}}
        />
      </div>
      <div>
        <div className="conditions-wrapper">
          <div className="conditions-box">
            <CustomDateRagePicker
              dateTitle={'기간 '}
              startDate={dlvyStartDate}
              setStartDate={setDlvyStartDate}
              endDate={dlvyEndDate}
              setEndDate={setDlvyEndDate}
            />
          </div>
          <div className="conditions-box">
            <label>납품번호 &nbsp;</label>
            <input type="text" style={{ height: '25px' }}></input>
          </div>
        </div>
        <TuiGrid
          ref={gridRef2}
          columns={colHeader.filter((col) => col.MENU_TAB_NO === '2')}
          viewName={'SRM_201W'}
          data={data.Grid2}
          cmbItems={cmbGrid2}
          bodyHeight={350}
          onClick={() => {}}
        />
      </div>
    </div>
  );
};

export default SRM_201W;
