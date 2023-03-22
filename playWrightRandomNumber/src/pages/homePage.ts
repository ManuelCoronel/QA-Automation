import {Page} from "@playwright/test";
export class homePage{

    readonly page:Page;
    constructor(page:Page){
        this.page=page;
    }

    async rollNumber(infoUser){
        
        const selectBuild=this.page.locator('//*[@id="buildNumber"]');
        const btnRoll =this.page.locator('//*[@id="rollDiceButton"]');
        const inputNumber=this.page.locator('//*[@id="numberGuess"]');
        const btnSubmit = this.page.locator('//*[@id="submitButton"]');
        const textWin = this.page.locator("//label[@id='feedbackLabel']//i");
        
        await this.page.goto('https://testsheepnz.github.io/random-number.html');
        await this.page.getByRole('button', { name: 'Roll the dice' }).click();
        await this.page.getByRole('combobox', { name: 'Select build:' }).selectOption('1');
        await this.page.getByRole('button', { name: 'Roll the dice' }).click();
        await this.page.locator('#numberGuess').click();
        await this.page.locator('#numberGuess').fill('2');
        await this.page.getByRole('button', { name: 'Submit' }).click();
        await this.page.getByText('Correct, it took 1 turns!').click();
  }
        
};