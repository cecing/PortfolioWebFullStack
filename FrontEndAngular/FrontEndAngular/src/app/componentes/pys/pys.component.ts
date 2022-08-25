import { Component, OnInit } from '@angular/core';
import { Pys } from 'src/app/model/pys';
import { PysService } from 'src/app/service/pys.service';
import { TokenService } from 'src/app/service/token.service';
// import { PortfolioService } from 'src/app/servicios/portfolio.service';

@Component({
  selector: 'app-pys',
  templateUrl: './pys.component.html',
  styleUrls: ['./pys.component.css']
})
export class PysComponent implements OnInit {
  /*
  miPortfolio:any;
  constructor(private datosPortfolio:PortfolioService) { }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatos().subscribe(data =>{
      this.miPortfolio=data;
    });
  }
*/
pys: Pys[] = [];

constructor(private pysS: PysService, private tokenService: TokenService){ }
  isLogged = false;

  ngOnInit(): void {
    this.cargarPys();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else {
      this.isLogged = false;
    }
  }

  cargarPys(): void{
    this.pysS.lista().subscribe(data =>{
      this.pys = data;
    })
  }

  delete(id?: number){
    if(id != undefined){
      this.pysS.delete(id).subscribe(data =>{
        this.cargarPys();
      }, err =>{
        alert("No se pudo borrar ese Proyecto");
      })
    }
  }
}
