import axios from 'axios'

export const login = (userInfo) => {
    console.log('in login api');
    return axios({
        method: 'POST',
        url: '/login',
        data: userInfo,
    });
}