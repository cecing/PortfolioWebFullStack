import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Pys } from 'src/app/model/pys';
import { PysService } from 'src/app/service/pys.service';

@Component({
  selector: 'app-editpys',
  templateUrl: './editpys.component.html',
  styleUrls: ['./editpys.component.css']
})
export class EditpysComponent implements OnInit {
pys: Pys = null;

  constructor(private pysS: PysService, private router: Router, private activatedRouter: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.pysS.detail(id).subscribe(data => {
      this.pys = data;
    }, err => {
      alert("Error al modificar el proyecto");
      this.router.navigate(['']);
    })
  }

  onUpdate(){
    const id = this.activatedRouter.snapshot.params['id'];
    this.pysS.update(id, this.pys).subscribe(data => {
      this.router.navigate(['']);
    }, err =>{
      alert("Error al modificar el proyecto");
      this.router.navigate(['']);
    }
    )
  }
}
