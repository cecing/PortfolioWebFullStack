import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Educacion } from 'src/app/model/educación';
import { EducaciónService } from 'src/app/service/educación.service';

@Component({
  selector: 'app-neweducacion',
  templateUrl: './neweducacion.component.html',
  styleUrls: ['./neweducacion.component.css']
})
export class NeweducacionComponent implements OnInit {
  nombreE: string = '';
  descripcionE: string = '';
  fetchInicio: string = '';
  fetchFin: string = '';

  constructor(private educacionS: EducaciónService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const educacion = new Educacion (this.nombreE, this.descripcionE, this.fetchInicio, this.fetchFin);
    this.educacionS.save(educacion).subscribe(data => {
      alert("Experiencia agregada");
      this.router.navigate(['']);
    }, err => {
      alert("Falló");
      this.router.navigate(['']);
    }
    )
  }
}
