import { Publication } from "./publication";

export interface User {
    id : number;
    nickName : string;
    email : string;
    authority : string;
    publicationlist : Publication[];
}
