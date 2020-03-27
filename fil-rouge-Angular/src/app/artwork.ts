import { Publication } from "./publication";

export interface Artwork {
    id : number;
    name : string;
    editor : string;
    producer : string;
    publicationSet : Publication[];
}
