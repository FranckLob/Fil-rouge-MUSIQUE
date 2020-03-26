
import { User } from "./user";
import { Artist } from "./artist";
import { Artwork } from "./artwork";
import { Title } from "./title";

export interface Publication {
    id : BigInteger;
    appUser : User;
    artist : Artist;
    date : Date;
    artwork : Artwork;
    title : Title;
    snippet : String;

}
