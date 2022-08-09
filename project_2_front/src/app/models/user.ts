import { UserRole } from "./user-role";

export class User {

    constructor(
        public user_id: number,
        public user_username: string,
        public user_password: string,
        public user_first_name: string,
        public user_last_name: string,
        public user_email: string,
        public user_role_id: UserRole
    ) { }

}
