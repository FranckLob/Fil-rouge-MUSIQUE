import { Type } from "./type";
import { Style } from "./style";
import { Publication } from "./publication";

export interface Title {
    id : number;
    name : string;
    type : Type;
    style : Style;
    author : string;
    composer : string;
    publications : Publication[];
}
