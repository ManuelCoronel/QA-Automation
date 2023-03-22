import {test} from '@playwright/test';


const info ={
    type:'Demo',
    number:'2'
}
test.beforeEach(async({page})=>{
    await page.goto('https://testsheepnz.github.io/random-number.html');
});

test(`Given Necesita estar en la pagina de random nuber
when Ingreso el tipo de juegos, el numero y le doy roll
then visualizo  el mensaje de salida`,async({page})=>{
    const pagina= new homePage(page);
    await pagina.rollNumber(info);
    
});