import {Component, Host, HostBinding, OnInit} from '@angular/core';
import {GamesService} from "../../services/games.service";

@Component({
  selector: 'app-game-list',
  templateUrl: './game-list.component.html',
  styleUrls: ['./game-list.component.css']
})
export class GameListComponent implements OnInit{
  @HostBinding('class') classes = 'row'

  games: any = [];
  displayedColumns: any;

  constructor(private gameService:GamesService) {
  }

  ngOnInit(): void {
    this.getGames()
  }

  getGames(){

    this.gameService.getGames().subscribe(
      res => {
        this.games = res;
      },
      err=> console.log(err)
    );
  }

  deleteGame(id:string|number){
    this.gameService.deleteGame(id).subscribe(
      res =>{ console.log(res)
        this.getGames()

      },
      err=>console.log("Mal" ,err)
    )
  }


}
