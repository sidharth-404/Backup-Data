import React from 'react'

const CustomButton = ({buttonName,buttonIcon,OnClick}) => {
  return (
    <div onClick={()=>{OnClick()}} style={{display:'flex', justifyItems:"center" , alignItems:"center", gap:"5px", backgroundColor:"transparent", border:"1px solid", padding:"5px",paddingLeft:"10px",paddingRight:"10px", borderRadius:"5px", cursor:'pointer'}}>
        <img src={buttonIcon} alt="na" style={{width:"20px", height:'18px'}}/>
        <h6>{buttonName}</h6>
    </div>
  )
}

export default CustomButton