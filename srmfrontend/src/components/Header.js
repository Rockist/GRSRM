import React from 'react';
import { Container, Nav, Navbar, Button } from 'react-bootstrap';
import '../css/Header.css';
import CustomFetch from './CustomFetch';

const Header = (props) => {
  const { searchFormData, setData, searchUrl, saveUrl, data } = props;

  // 조회버튼 옵션
  const searchList = (e) => {
    e.preventDefault();
    console.log('searchUrl', searchUrl);
    console.log('searchFromData', searchFormData);
    CustomFetch('localhost:8080', searchUrl, searchFormData)
      .then((res) => {
        console.log('결과 : ', res);
        if (res.length === 0) {
          setData([{}]);
        } else {
          setData(res);
          console.log('결과 : ', res);
        }
      })
      .catch((error) => console.log(error));
  };

  const activeNewForm = (e) => {
    console.log('신규 버튼 클릭');
  };

  return (
    <div>
      <Navbar bg="light" expand="lg">
        <Container>
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <div className="header-btn">
                <Button variant="light btn-active">
                  <i className="bi bi-arrow-clockwise" onClick={activeNewForm}>
                    신규
                  </i>
                </Button>
              </div>
              <div className="header-btn">
                <Button variant="light btn-active" onClick={searchList}>
                  <i className="bi bi-search"> 조회</i>
                </Button>
              </div>
              <div className="header-btn">
                <Button variant="light btn-active">
                  <i className="bi bi-file-earmark-plus"> 추가</i>
                </Button>
              </div>
              <div className="header-btn">
                <Button variant="light btn-active">
                  <i className="bi bi-save"> 저장</i>
                </Button>
              </div>
              <div className="header-btn">
                <Button variant="light btn-active">
                  <i className="bi bi-trash"> 삭제</i>
                </Button>
              </div>
              <div className="header-btn">
                <Button variant="light btn-active">
                  <i className="bi bi-x-circle"> 취소</i>
                </Button>
              </div>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </div>
  );
};

export default Header;
