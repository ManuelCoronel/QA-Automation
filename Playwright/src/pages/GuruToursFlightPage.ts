import { expect, Page } from "@playwright/test";

export class GuruToursFlightPage {

    readonly page: Page;
    constructor(page: Page) {
        this.page = page;
    }

    async doReservation() {

       

        await this.page.getByRole('link', { name: 'Flights' }).click();
        await expect(this.page).toHaveURL('https://demo.guru99.com/test/newtours/reservation.php')
        await expect(this.page.locator('select[name="passCount"]')).toBeVisible;
        await this.page.locator('select[name="passCount"]').selectOption('3');
        await this.page.locator('select[name="fromPort"]').selectOption('Frankfurt');
        await this.page.locator('select[name="fromMonth"]').selectOption('10');
        await this.page.locator('select[name="fromDay"]').selectOption('8');
        await this.page.locator('select[name="toPort"]').selectOption('Sydney');
        await this.page.locator('select[name="toMonth"]').selectOption('12');
        await this.page.locator('select[name="toDay"]').selectOption('19');
        await this.page.getByRole('radio').nth(3).check();
        await this.page.locator('select[name="airline"]').selectOption('Pangea Airlines');
        await this.page.getByRole('button', { name: 'Submit' }).click();

    }

}

