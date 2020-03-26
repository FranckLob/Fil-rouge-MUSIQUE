import { Publication } from "./publication";

export interface Artist {
    id : number;
    name : string;
    publicationSet : Publication[];
}
