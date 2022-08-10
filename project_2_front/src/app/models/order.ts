import { OrderStatus } from "./order-status";
import { OrderItem } from "./order-item";
import { User } from "./user";

export class Order {
    constructor(
        public orderCost: number,
        public restaurantIdFk: number,
        public orderItems: OrderItem[],
        public orderId?: number,
        public userId?: User,
        public orderStatusId?: OrderStatus
        // Probably need ot add list of OrderItems
    ) { }
}
