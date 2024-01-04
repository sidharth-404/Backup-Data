// const average=function(...nums){
//     let sum=0;
//     for(let num of nums)
//     {
//         sum+=num;
//     }
//     return sum/nums.length;
// }

// let avg=average(10,20,30,40);
// console.log(avg)
// let arr=[1,3,4,55,5];
// let [a,...b]=arr; //1 [ 3, 4, 55, 5 ]
// console.log(a,b);
// let [p,q]=arr //1 3
// console.log(p,q);
// let [z]=arr;//1
// console.log(z);
// let[x,,,y]=arr; // 1 55
// console.log(x,y);

let employee={
    id:1001,
    name:'rahul',
    email:'rahul@gamil.com',
    salary:34440
}
//let {id}=employee;
//console.log(id);
let {id,email}=employee;
console.log(id,email);