import { OrderStatus } from "./order-status";
import { User } from "./user";

export class Order {
    constructor(
        public order_id: number,
        public order_cost: number,
        public user_id: User,
        public order_status_id: OrderStatus,
        public restaurant_id_fk: number
        // Probably need ot add list of OrderItems
    ) { }
}
