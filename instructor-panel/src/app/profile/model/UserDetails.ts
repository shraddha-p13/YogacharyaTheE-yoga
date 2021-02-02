import { VirtualTimeScheduler } from "rxjs";

export class UserDetails {
    private id: string;
    private firstName: string;
    private lastName: string;
    private email: string;
    private contactNumber: string;
    private password: string;
    constructor(id: any, firstName: any, lastName: any, email: any, contactNumber: any, password: any) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.password = password;

    }
}