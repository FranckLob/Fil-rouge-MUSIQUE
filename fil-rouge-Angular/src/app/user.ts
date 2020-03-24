import { Publication } from "./publication";

export interface User {
    id : BigInteger;
    nickName : String;
    email : String;
    authority : String;
    publicationlist : Publication[];
}
