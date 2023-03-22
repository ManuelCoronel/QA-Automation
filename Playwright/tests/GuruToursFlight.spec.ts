import {test} from '@playwright/test';
import { GuruToursFlightPage } from '../src/pages/GuruToursFlightPage';
import { GuruToursPage } from '../src/pages/GuruToursPage';

test.beforeEach(async({page})=>{
await page.goto('https://demo.guru99.com/test/newtours/');
const guruToursPage = new GuruToursPage(page);
//await guruToursPage.login();
})

test(`
Given be in the page flight "New Tours Flight Page"
When select fligth with the parameters
Then validate the reservation with the text "After flight finder - No Seats Avaialble  "
`,async({page}) => {
    const guruToursPage = new GuruToursFlightPage(page);
    await guruToursPage.doReservation();
    
})