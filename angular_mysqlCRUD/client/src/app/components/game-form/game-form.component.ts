import {Component, HostBinding, OnInit} from '@angular/core';
import {Game} from "../../models/game";
import {GamesService} from "../../services/games.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-game-form',
  templateUrl: './game-form.component.html',
  styleUrls: ['./game-form.component.css']
})
export class GameFormComponent implements OnInit{

  @HostBinding('class') classes = 'row'

  game: Game = {
    id:0,
    title:"",
    description:"",
    image:'',
    created_at: new Date()
  };
  edit:boolean = false ;

  constructor(private gameService:GamesService, private  rout:Router, private activeRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    const params = this.activeRoute.snapshot.params;
    if (params['id']){
      console.log(params['id'])
      this.gameService.getGame(params['id']).subscribe(
        res=> {
          this.game = res,
            this.edit = true;
        },
        err=>console.log(err)
      )
    }
  }

  saveNewGame(){
    delete this.game.created_at;
    delete this.game.id;
    this.gameService.saveGame(this.game).subscribe(
      res=>{
        this.rout.navigate(['/games'])
      },
      err=> console.log(err)
    );
  }

  updateGame(){
    delete this.game.created_at;
    this.gameService.updateGame(this.game.id , this.game).subscribe(
      res=>{
        console.log("the game was updated")
        this.rout.navigate(['/games'])
      },
      error => console.log(error)
    )
  }
}
