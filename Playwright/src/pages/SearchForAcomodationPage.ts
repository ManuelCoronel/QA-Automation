import { Page } from "@playwright/test";

export class SearchForAcomodationPage{

    readonly page: Page;
    constructor(page:Page){
    this.page=page;
    }

}