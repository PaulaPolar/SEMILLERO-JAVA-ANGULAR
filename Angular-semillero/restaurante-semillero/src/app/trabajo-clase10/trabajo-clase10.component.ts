import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-trabajo-clase10',
  templateUrl: './trabajo-clase10.component.html',
  styleUrls: ['./trabajo-clase10.component.scss']
})
export class TrabajoClase10Component implements OnInit {

  nombre: string;
  ciudad: string;


  constructor() { 
    this.nombre = "Paula andrea Ramos Peña";
    this.ciudad = "Neiva";
  }

  ngOnInit(): void {
  }

}