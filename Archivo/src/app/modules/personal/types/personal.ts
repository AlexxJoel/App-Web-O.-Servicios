import {Entity} from "../../../types/entity";

export type  Personal = Entity<number> & {
    name:String;
    surname:String;
    lastname:String;
    brithday:String;
    salary:number;
    position:any;
    user:any;
}

