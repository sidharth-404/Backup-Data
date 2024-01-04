function greet(message,callback)
{
    console.log(message)
    callback()
}
function callMe()
{
    console.log('callback function called')
}
greet('good after noon',callMe)
greet('hello world',()=>console.log('I am a better callback'))