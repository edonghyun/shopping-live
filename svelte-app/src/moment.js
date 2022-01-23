import moment from 'moment-timezone';
import 'moment/locale/ko';

moment.locale('ko');

export default (...args) => {
    return moment(...args).tz('Asia/Seoul');
};
