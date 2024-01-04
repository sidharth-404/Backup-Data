function greet(message)
{
    console.log(message)

}
function callMe()
{
    console.log('callMe function called')
}

setTimeout(()=>greet('good afternoon'),5000)
callMe()