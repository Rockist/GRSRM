import { Navigate, Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import SRM_201W from './pages/SRM_201W';
import SRM_202W from './pages/SRM_202W';
import SRM_203W from './pages/SRM_203W';
import SRM_100R from './pages/SRM_100R';
import SRM_301R from './pages/SRM_301R';
import SideMenu from './components/SideMenu';
import './App.css';
import { useEffect, useState } from 'react';
import SRM_204W from './pages/SRM_204W';
import SRM_302R from './pages/SRM_302R';
import SRM_501W from './pages/SRM_501W';
import XM_101W from './pages/X/XM_101W';
import PreviewPage from './pages/PreviewPage';
function App() {
  const [inactive, setInactive] = useState(false);
  const modal = document.querySelector('#modal');

  useEffect(() => {
    modal.style.display = "none";
  })

  return (
    <div>
      <SideMenu
        onCollapse={(inactive) => {
          setInactive(inactive);
        }}
      />

      <div className={`myContainer ${inactive ? 'inactive' : ''}`}>
        <Routes>
          <Route path="/*" element={<Navigate to="/"></Navigate>} />
          <Route path="/" element={<Home />} />

          <Route path="/XM_101W" element={<XM_101W />} />

          <Route path="/SRM_100R" element={<SRM_100R />} />

          <Route path="/SRM_201W" element={<SRM_201W />} />
          <Route path="/SRM_202W" element={<SRM_202W />} />
          <Route path="/SRM_203W" element={<SRM_203W />} />
          <Route path="/SRM_204W" element={<SRM_204W />} />
          <Route path="/SRM_501W" element={<SRM_501W inActive={inactive}/>} />

          <Route path="/SRM_301R" element={<SRM_301R />} />
          <Route path="/SRM_302R" element={<SRM_302R />} />
          <Route path="/PreviewPage" element={<PreviewPage />} />
        </Routes>
      </div>
    </div>
  );
}

export default App;
