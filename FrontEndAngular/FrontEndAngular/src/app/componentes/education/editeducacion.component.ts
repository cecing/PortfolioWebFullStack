import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Educacion } from 'src/app/model/educación';
import { EducaciónService } from 'src/app/service/educación.service';

@Component({
  selector: 'app-editeducacion',
  templateUrl: './editeducacion.component.html',
  styleUrls: ['./editeducacion.component.css']
})
export class EditeducacionComponent implements OnInit {
educacion: Educacion = null;

  constructor(private educacionS: EducaciónService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.educacionS.detail(id).subscribe(data => {
      this.educacion = data;
    }, err => {
      alert("Error al modificar la educación");
      this.router.navigate(['']);
    })
  }

  onUpdate(){
    const id = this.activatedRouter.snapshot.params['id'];
    this.educacionS.update(id, this.educacion).subscribe(data => {
      this.router.navigate(['']);
    }, err =>{
      alert("Error al modificar la educación");
      this.router.navigate(['']);
    }
    )
  }
}
