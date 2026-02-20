class User{
    id: number;
    username: string;
    email: string;
    password_hashed: string;
    id_role: number;

    constructor(id: number, username: string, email: string, password_hashed: string, id_role: number){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password_hashed = password_hashed;
        this.id_role = id_role;
    }   
}