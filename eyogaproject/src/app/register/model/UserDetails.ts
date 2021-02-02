export class UserDetails {
    private firstName: string;
    private lastName: string;
    private email: string;
    private contactNumber: string;
    private password: string;

    constructor(firstName: any, lastName: any, email: any, contactNumber: any, password: any) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.password = password;
    }
}