import _ from 'lodash';

const convertKeys = (fn, o) => {
    if (_.isArray(o)) {
        return o.map((e) => convertKeys(fn, e));
    } else if (_.isObject(o)) {
        const n = {};
        Object.keys(o).forEach((k) => {
            n[fn(k)] = convertKeys(fn, o[k]);
        });
        return n;
    }
    return o;
};

export const keysToCamel = (o) => convertKeys(_.camelCase, o);

export const keysToSnake = (o) => convertKeys(_.snakeCase, o);
