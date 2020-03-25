import { Type } from "./type";
import { Style } from "./style";
import { Publication } from "./publication";

export interface Title {
    id : BigInteger;
    name : String;
    type : Type;
    style : Style;
    author : String;
    composer : String;
    publications : Publication[];


}
