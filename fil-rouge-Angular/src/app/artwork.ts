import { Publication } from "./publication";

export interface Artwork {
    id : BigInteger;
    name : String;
    editor : String;
    producer : String;
    publications : Publication[];
}
