async function getAllItem() {

    let response = await fetch('http://localhost:8080/api/items')

    if (response.status === 200) {

        let data = await response.json()

        console.log(data);

        return Promise.resolve(data);

    }

    else {

        console.log(response);

        return Promise.reject({

            message: `Error ${response.status}`

        });

    }

}

async function getAlbumById(id) {

    let response = await fetch('http://localhost:8080/api/items/' + id)

    if (response.status === 200) {

        let data = await response.json()

        console.log(data)

        return Promise.resolve(data)

    }

    else {

        console.log(response)

        return Promise.reject({

            message: `Error ${response.status}`

        })

    }

}

async function saveAlbum(item) {

    let response = await fetch('http://localhost:8080/api/items', {

        method: 'POST',

        body: JSON.stringify(item),

        headers: {

            'Content-type': 'application/json; charset=UTF-8'

        }

    })

    if (response.status === 201) {

        let data = await response.json()

        console.log(data)

        return Promise.resolve(data);

    }

    else {

        console.log(response)

        return Promise.reject({

            message: `Error ${response.status}`

        })

    }

}

async function deleteItemById(id) {

    let response = await fetch('http://localhost:8080/api/items/' + id, {

        method: 'DELETE',

    });

    if (response.status === 200) {

        console.log('Album deleted');

        return Promise.resolve();

    }

    else {

        console.log(response);

        return Promise.reject({

            message: `Error ${response.status}`,

        });

    }

}