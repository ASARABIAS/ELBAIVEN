const BASE_URL = process.env.REACT_APP_BASE_URL;

const header = {
    mode: 'cors',
    headers: {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json'
    }
}

export const get = async (route) => {
    const response = await fetch(`${BASE_URL}/${route}`, header);
    const data = response.json();
    return data;
}

export const getApiOutside = async (route) => {
    const response = await fetch(`${route}`);
    const data = response.json();
    return data;
}

export const post = async (route, form) => {
    const response = await fetch(`${BASE_URL}/${route}`, {
        ...header,
        body: JSON.stringify(form),
        method: 'POST'
    });
    const data = response.json();
    return data;
}

export const put = async (route, form) => {
    const response = await fetch(`${BASE_URL}/${route}`, {
        ...header,
        body: JSON.stringify(form),
        method: 'PUT'
    });
    const data = response.json();
    return data;
}

export const delet = async (route, messenger )=> {
    if(window.confirm(`Estas seguro de eliminar ${messenger}?`)){
        await fetch(`${BASE_URL}/${route}`, {
            ...header,
            method: 'DELETE'
        });
    }
}

