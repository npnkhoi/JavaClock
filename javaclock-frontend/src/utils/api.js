import axios from 'axios'

export const login = (userInfo) => axios({
    method: 'POST',
    url: '/login',
    data: userInfo,
});