import {Request,Response} from  'express';

class IndexController{

   index (req:Request, res:Response){
       res.json({text:'Api is /api/index'})
   }

}

export const indexController =new IndexController();