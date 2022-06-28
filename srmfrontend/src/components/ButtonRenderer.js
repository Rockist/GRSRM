class ButtonRenderer {
    constructor(props) {
      const button = document.createElement('button');
      button.className = 'button-rr';

      const { grid, rowKey } = props;
      const { text, clickEvent } = props.columnInfo.renderer.options;
      button.innerText = text;
      button.style.backgroundColor = "#42aaf5";
      button.style.padding = "2px";
      button.style.border = "";
      button.style.color = "white";
      button.style.fontSize = "11px";
      button.style.fontWeight = "bold"

      button.addEventListener('mousedown', (ev) => {
        ev.preventDefault();
        button.style.backgroundColor = "#0484e0";
        // 다운로드, 삭제, 열기 콜백 
        clickEvent(rowKey, text);
      });

      button.addEventListener('mouseup', (ev)=> {
        ev.preventDefault();
        button.style.backgroundColor = "#42aaf5";
      });
      this.el = button;
    }
    
    getElement() {
      return this.el;
    }
  }
  
  export default ButtonRenderer;
  