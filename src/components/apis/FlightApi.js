// export const SearchFlightApi = async (searchData) => {
//     const response = await fetch('http://localhost:8000/route',searchData) {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json'
//         }
//     });
//     const data = await response.json();
//     return data;
// }


// export const fetchCartItemsFromApi = async () => {
//     const response = await fetch('http://localhost:8888/api/cart/items');
//     try{
//     const data = await response.json();
//     return data;
//     }
//     catch(error){
//         return null;
//     }