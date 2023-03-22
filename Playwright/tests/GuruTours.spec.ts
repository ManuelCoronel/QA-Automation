import {test} from '@playwright/test';
import { GuruToursPage } from '../src/pages/GuruToursPage';



test.beforeEach(async({page})=>{

await page.goto('https://demo.guru99.com/test/newtours/');
})

test(`
Given El usuario debe estar en la pagina de guru tours 
When ingresa credenciales  en guru tours con usuario "mngr480432" y la password "EtadUdy" 
Then Se valida  la cadena en el home de guru tours  "Login Successfully"
`,async({page}) => {
    const guruToursPage = new GuruToursPage(page);
    await guruToursPage.login(infoUser);
})

const infoUser = {
    user:'mngr480432',
    password:'EtadUdy'
}