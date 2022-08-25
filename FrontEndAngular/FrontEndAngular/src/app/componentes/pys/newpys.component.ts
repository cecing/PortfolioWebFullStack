import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pys } from 'src/app/model/pys';
import { PysService } from 'src/app/service/pys.service';

@Component({
  selector: 'app-newpys',
  templateUrl: './newpys.component.html',
  styleUrls: ['./newpys.component.css']
})
export class NewpysComponent implements OnInit {
  nombreP: string = '';
  descripcionP: string = '';
  fetchP: string = '';
  herrams: string = '';
  enlace: string = '';

  constructor(private pysS: PysService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const pys = new Pys (this.nombreP, this.descripcionP, this.fetchP, this.herrams, this.enlace);
    this.pysS.save(pys).subscribe(data => {
      alert("Proyecto agregado");
      this.router.navigate(['']);
    }, err => {
      alert("Falló");
      this.router.navigate(['']);
    }
    )
  }
}
