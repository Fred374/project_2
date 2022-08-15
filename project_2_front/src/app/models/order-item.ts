import { FoodItem } from "./food-item";

export class OrderItem {

    constructor(
        public orderItemId: number,
        public foodItemId: FoodItem,
        public orderItemNum: number,
        public orderItemTotalCost: number,

    ) { }
}
