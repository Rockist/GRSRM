import React, { useEffect, useState } from 'react';
import logo from '../assets/logo/webscript.png';
import MenuItem from './MenuItem';
import '../css/SideMenu.css';

const menuItems = [
  {
    name: 'MANAGER',
    iconClassName: 'bi bi-speedometer2',
    subMenus: [
      { name: '프로그램메뉴등록', to: '/XM_101W' },
      { name: '메뉴컬럼등록', to: '/XM_102W' },
      { name: '사용자등록', to: '/XM_201W' },
      { name: '사용자별권한관리', to: '/XM_202W' },
      { name: '권한조회', to: '/XM_203R' },
    ],
  },
  {
    name: '발주관리',
    // to: '/SRM_100R',
    iconClassName: 'bi bi-speedometer2',
    subMenus: [{ name: '발주현황조회', to: '/SRM_100R' }],
  },
  {
    name: '납품관리',
    //to: '/content',
    iconClassName: 'bi bi-vector-pen',
    subMenus: [
      { name: '납품등록', to: '/SRM_201W' },
      { name: '원단부착라벨 발행', to: '/SRM_202W' },
      { name: '원단부착라벨 발행내역', to: '/SRM_203W' },
      { name: '납품서(거래명세서)출력', to: '/SRM_204W' },
      { name: '품목별 성적서 파일등록', to: '/SRM_501W' },
    ],
  },
  {
    name: '마감관리',
    //to: '/design',
    iconClassName: 'bi bi-vector-pen',
    subMenus: [
      { name: '납품현황조회', to: '/SRM_301R' },
      { name: '매출마감조회', to: '/SRM_302R' },
    ],
  },
];

const SideMenu = (props) => {
  const [inactive, setInactive] = useState(false);

  useEffect(() => {
    if (inactive) {
      document.querySelectorAll('.sub-menu').forEach((el) => {
        el.classList.remove('active');
      });
    }
    props.onCollapse(inactive);
  }, [inactive, props]);

  return (
    <div className={`side-menu ${inactive ? 'inactive' : ''}`}>
      <div className="top-section">
        <div className="logo">
          <img src={logo} alt="webscript" />
        </div>
        <div className="toggle-menu-btn" onClick={() => setInactive(!inactive)}>
          {inactive ? (
            <i className="bi bi-arrow-right-square-fill"></i>
          ) : (
            <i className="bi bi-arrow-left-square-fill"></i>
          )}
        </div>
      </div>

      <div className="divider"></div>

      <div className="main-menu">
        <ul>
          {menuItems.map((menuItem, index) => (
            <MenuItem
              key={index}
              name={menuItem.name}
              // to={menuItem.to}
              iconClassName={menuItem.iconClassName}
              subMenus={menuItem.subMenus || []}
              onClick={() => {
                if (inactive) {
                  setInactive(false);
                }
              }}
            />
          ))}
        </ul>
      </div>
    </div>
  );
};

export default SideMenu;
