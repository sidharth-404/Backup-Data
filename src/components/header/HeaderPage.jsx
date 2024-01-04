
import CustomButton from "../CustomButton";
import { useHistory } from "react-router-dom";
import "./Header.css";

const HeaderPage = () => {
  const history = useHistory();
  return (
    <div className="m-3 d-flex justify-content-between align-items-center">
        <div className="d-flex align-items-center">
          <h1 className="">Orbitz</h1>
          <img
            src={"images/airplane.png"}
            class="img-fluid rounded-top"
            alt=""
           style={{width:"40px", height:"40px"}}
          />
        </div>
        <div style={{display:"flex", gap:"15px"}}>
        <CustomButton buttonName="One Way" buttonIcon={'images/right.png'} OnClick={()=>{history.push('/')}}/>
        <CustomButton buttonName="Round Trip" buttonIcon={'images/right-and-left.png'}  OnClick={()=>{history.push('/round-trip')}}/>
        </div>
    </div>
  );
};

export default HeaderPage;
