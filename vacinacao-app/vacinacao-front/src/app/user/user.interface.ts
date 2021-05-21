export interface User {
    id?: number;
    name: string;
    dtNasc: Date;
    gender: string;
    publicPlace: string;
    number: number;
    sector?: string;
    city?: string;
    uf?: string;
}