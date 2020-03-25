import { Publication } from "./publication";

export interface Artist {
    id : BigInteger;
    name : String;
    publicationSet : Publication[];
}
