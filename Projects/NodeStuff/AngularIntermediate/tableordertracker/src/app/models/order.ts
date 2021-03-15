import { Item } from "./item";

export class Order{
    constructor(
        public tableId:number=0,
        public items:Item[]=[]){}
}