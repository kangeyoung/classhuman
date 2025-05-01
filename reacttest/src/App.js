import './App.css';
import {useState} from "react";

function App() {
    let [글제목, 글제목변경] = useState(['강남 카페 추천', '성수 전시회 추천', '노원 디저트 추천']);
    let [하트, 하트변경] = useState(0);

    function 제목바꾸기() {
        let newList = [...글제목]; // deep copy하는 방법 ...객체
        newList[0] = '여의도 카페 추천';
        글제목변경(newList);
    }

    return (
        <div className="App">
            <div className="black-nav">
                <div>React Blog</div>
            </div>
            <div className="list">
                <h4>{글제목[0]}<span onClick={() => {
                    하트변경(하트 + 1)
                }}>❤</span>{하트}</h4>
                <p>작성자: 강이영</p>
                <hr/>
                <h4>{글제목[1]}</h4>
                <p>작성자: 강이영</p>
                <hr/>
                <h4>{글제목[2]}</h4>
                <p>작성자: 강이영</p>
                <hr/>
                <button onClick={제목바꾸기}>제목 변경</button>
            </div>
            <Modal></Modal>
        </div>
    );
}
function Modal(){ // Component이름은 대문자로 시작한다.
    return(
        <div className="modal">
            <h2>큰제목</h2>
            <p>날짜</p>
            <p>상세 내용</p>
        </div>
    )
}

export default App;
