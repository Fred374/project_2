import { UserRole } from "./user-role";

export class User {

    constructor(
        public userId: number,
        public userUsername: string,
        public userPassword: string,
        public userFirstName: string,
        public userLastName: string,
        public userEmail: string,
        public userRoleId: UserRole
    ) { }

}
