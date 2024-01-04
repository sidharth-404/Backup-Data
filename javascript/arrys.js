// // let arr=[0,1,3,2,1,2,3,'ramesh'];
// let s='sidjjbd bdvd bhbd'
// // for(let i of arr)
// // {
// // console.log(i);
// // }


// //adding a new element
// //arr.push(100);
// //arr.pop();
// let arr1=[];
// arr1=s.split(" ");
// console.log(arr1);
// // arr.splice(2,1);
// // arr.sort();
// // console.log(arr);


let data=[{"price":200},{"price":300}];
for(let i=0;i<data.length;i++)
{
    const orderData=JSON.parse(data[i]);
    console.log(orderData);
}