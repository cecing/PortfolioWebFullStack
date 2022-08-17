import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { TokenService } from 'src/app/service/token.service';
// import { PortfolioService } from 'src/app/servicios/portfolio.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  /*
  miPortfolio:any;
  constructor(private datosPortfolio:PortfolioService) { }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatos().subscribe(data =>{
      this.miPortfolio=data;
    });
  }
*/

isLogged = false;
constructor(private router: Router, private tokenService: TokenService){ }

ngOnInit(): void {
  if(this.tokenService.getToken()){
    this.isLogged=true;
  } else{
    this.isLogged=false;
  }
}

onLogOut():void{
  this.tokenService.logOut();
  window.location.reload();
}

login(){
  this.router.navigate(['/login']);
}
}
