<script>
    import { Col, Container, Row  } from 'sveltestrap';
    import Moment from '../moment.js';

    /*
        dates = [
            {
                value: Number,
                months: [
                    {
                        value: Number,
                        dates: [
                            date,
                            date,
                            date,
                            ...
                        ]
                    }
                ]
            }
        ]
    */
    const dates = (() => {
        const now = Moment();
        const startDateDeltaFromNow = 4;
        const datesContainer = [];
        const startDate = Moment().subtract(startDateDeltaFromNow, 'days');

        for(let i = 0; i < startDateDeltaFromNow * 2 - 1; i ++) {
            const targetDate = startDate.add(1, 'd').clone();
            const [year, month, date] = targetDate.format('YYYY-MM-DD').split('-');

            let yearContainer = datesContainer.find(e => e.value === year);
            if(!yearContainer) {
                yearContainer = {
                    value: year,
                    months: [],
                };
                datesContainer.push(yearContainer);
            }

            let monthContainer = yearContainer.months.find(e => e.value === month);
            if(!monthContainer) {
                monthContainer = {
                    value: month,
                    dates: [],
                };
                yearContainer.months.push(monthContainer);
            }
            monthContainer.dates.push(date);
        }

        return datesContainer;
    })();
    console.log(dates);
</script>
<Row>
    {#each dates as year}
        <Row>{year.value}</Row>
        {#each year.months as month}
            <Row>{month.value}</Row>
            {#each month.dates as date}
                <Col xs={1}>
                    {date}
                </Col>
            {/each}
        {/each}
    {/each}
</Row>
