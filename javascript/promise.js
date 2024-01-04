 let count=5;
 promise=new Promise(
     (resolve,reject)=>{
         if(count)
         
         resolve('promise Resolved')
         else
         reject('promise rejected')
     }
 )
 

 
    console.log(promise)

 