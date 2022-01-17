import lodash from 'lodash';
import qs from 'qs';
import axios from 'axios';

import { SERVER_URL } from '../constants/config';
import { keysToCamel, keysToSnake } from '../utils';

export const apiClient = axios.create({
    baseURL: SERVER_URL,
    withCredentials: true,
    headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
    },
    transformRequest: [
        (data, headers) => {
            if (data instanceof FormData) {
                const copy = new FormData();
                for (let [key, value] of data.entries()) {
                    copy.append(lodash.snakeCase(key), value);
                }
                data = copy;
                headers['Content-Type'] = 'multipart/form-data';
            }
            return data;
        },
        (data, headers) => {
            if (headers['Content-Type'] === 'application/json') {
                data = keysToSnake(data);
                return JSON.stringify(data);
            }
            return data;
        },
    ],
    transformResponse: [
        (data) => {
            try {
                return keysToCamel(JSON.parse(data));
            } catch {
                return data;
            }
        },
    ],
    paramsSerializer: (params) =>
        qs.stringify(keysToSnake(params), { arrayFormat: 'repeat' }),
});
