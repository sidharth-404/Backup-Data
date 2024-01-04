async function getAllAlbum() {

    let response = await fetch('http://localhost:3000/albums')

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

    let response = await fetch('http://localhost:3000/albums/' + id)

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

async function saveAlbum(albums) {

    let response = await fetch('http://localhost:3000/albums', {

        method: 'POST',

        body: JSON.stringify(albums),

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

async function deleteAlbumById(id) {

    let response = await fetch('http://localhost:3000/albums/' + id, {

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