import { Page } from "@playwright/test";

export class GuruToursPage {

    readonly page: Page;
    constructor(page:Page){
    this.page=page;
    }

    async login(infoUser){

          await this.page.locator('input[name="userName"]').fill(infoUser.user);
          await this.page.locator('input[name="password"]').click();
          await this.page.locator('input[name="password"]').fill(infoUser.password);
          await this.page.getByRole('button', { name: 'Submit' }).click();


    }

}

