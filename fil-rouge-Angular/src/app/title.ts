import { Type } from "./type";
import { Style } from "./style";
import { Publication } from "./publication";

export interface Title {
    id : BigInteger;
    name : String;
    typeMusic : Type;
    styleMusic : Style;
    author : String;
    composer : String;
    publications : Publication[];


}
