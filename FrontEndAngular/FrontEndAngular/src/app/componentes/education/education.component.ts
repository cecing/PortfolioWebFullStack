import { Component, OnInit } from '@angular/core';
import { Educacion } from 'src/app/model/educación';
import { EducaciónService } from 'src/app/service/educación.service';
import { TokenService } from 'src/app/service/token.service';
// import { PortfolioService } from 'src/app/servicios/portfolio.service';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {
  /*
  miPortfolio:any;
  constructor(private datosPortfolio:PortfolioService) { }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatos().subscribe(data =>{
      this.miPortfolio=data;
    });
  }
 */
 educacion: Educacion[] = [];

  constructor(private educacionS: EducaciónService, private tokenService: TokenService){ }
  isLogged = false;

  ngOnInit(): void {
    this.cargarEducacion();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else {
      this.isLogged = false;
    }
  }

  cargarEducacion(): void{
    this.educacionS.lista().subscribe(data =>{
      this.educacion = data;
    })
  }

  delete(id?: number){
    if(id != undefined){
      this.educacionS.delete(id).subscribe(data =>{
        this.cargarEducacion();
      }, err =>{
        alert("No se pudo borrar esa educación");
      })
    }
  }
}
