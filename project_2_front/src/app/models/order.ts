import { OrderStatus } from "./order-status";
import { User } from "./user";

export class Order {
    constructor(
        public orderId: number,
        public orderCost: number,
        public userId: User,
        public orderStatusId: OrderStatus,
        public restaurantIdFk: number
        // Probably need ot add list of OrderItems
    ) { }
}
