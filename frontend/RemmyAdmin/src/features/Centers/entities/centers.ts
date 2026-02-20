class Center{
    id: number;
    name: string;
    address: string;
    phone: string;
    email: string;
    createdAt: Date;
    updatedAt: Date;

    constructor(id: number, name: string, address: string, phone: string, email: string, createdAt: Date, updatedAt: Date){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
