let arr=[10,20,30,40,50,60,70,80]
//filtering data
//find all the elements which are multiple of 20.
let arr20=arr.filter(e=>e%20==0)
//console.log(arr20)

//find a element
let arr30=arr.filter(e=>e%30==0)
//console.log(arr30)
//applying some changes to the element.
let arr10=arr.map(e=>e/10)
//console.log(arr10)
//count some reduce
let arr20s=arr.filter(e=>e%20==0).length
//console.log(arr20s);
//find the sum of all the element.
let sum=arr.reduce((x,y)=>x+y).toFixed()
//console.log(sum)

let add=arr.concat(5) //push(5)
//console.log(add)
//-------------------------------------------------------

let names=['sidharth','ansiya','rohith','rejin']
names.sort()
//console.log(names)
//using set and map
let set=new Set([10,20,50,60,10])
set.add(100)
//console.log(set)

let map=new Map()
map.set(1,'sidharth')
map.set(2,'ansiya')
map.set(3,'rohith')
console.log(map)
console.log(map.get(2))