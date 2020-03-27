import { Type } from "./type";
import { Style } from "./style";
import { Publication } from "./publication";

export interface Title {
    id : number;
    name : string;
    typeMusic : string;
    styleMusic : string;
    author : string;
    composer : string;
    publications : Publication[];


}
