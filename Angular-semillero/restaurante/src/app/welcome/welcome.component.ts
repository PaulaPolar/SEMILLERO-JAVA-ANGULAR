import { Component, OnInit } from '@angular/core';
import { Producto } from '../structuras';
import {MatTableDataSource} from '@angular/material/table';
import {MatDialog} from '@angular/material/dialog';
import { DialogComponent } from '../dialog/dialog.component';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})

export class WelcomeComponent implements OnInit {
 ELEMENT_DATA: Producto[] = [
    {id: 1, nombre: 'hamburguesa1', precio: 14.444, urlImagen: 'https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2012/01/comida-rapida-casera.jpg'},
    {id: 2, nombre: 'hamburguesa2', precio: 14.444, urlImagen: 'https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2012/01/comida-rapida-casera.jpg'},
    {id: 3, nombre: 'hamburguesa3', precio: 14.444, urlImagen: 'https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2012/01/comida-rapida-casera.jpg'},
    {id: 4, nombre: 'hamburguesa4', precio: 14.444, urlImagen: 'https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2012/01/comida-rapida-casera.jpg'},
    {id: 5, nombre: 'hamburguesa5', precio: 14.444, urlImagen: 'https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2012/01/comida-rapida-casera.jpg'},
    {id: 6, nombre: 'hamburguesa6', precio: 14.444, urlImagen: 'https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2012/01/comida-rapida-casera.jpg'},
    {id: 7, nombre: 'hamburguesa7', precio: 14.444, urlImagen: 'https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2012/01/comida-rapida-casera.jpg'},
    {id: 8, nombre: 'hamburguesa8', precio: 14.444, urlImagen: 'https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2012/01/comida-rapida-casera.jpg'},
    {id: 9, nombre: 'hamburguesa9', precio: 14.444, urlImagen: 'https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2012/01/comida-rapida-casera.jpg'},
    {id: 10, nombre: 'hamburguesa10', precio: 14.444, urlImagen: 'https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2012/01/comida-rapida-casera.jpg'},  
  ];
  
  mensaje: boolean = false;
  productoDel: any ;
  displayedColumns: string[] = ['id', 'nombre', 'precio', 'urlImagen', 'eliminar'];
  dataSource = new MatTableDataSource(this.ELEMENT_DATA);

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  eliminar(elemento: any): void{
    const num= this.ELEMENT_DATA.indexOf(elemento, 0);
    if (num > -1){
      this.ELEMENT_DATA.splice(num, 1);
      this.mensaje= true;
      this.productoDel=elemento.nombre;
      this.productoDel=elemento;
    }
    this.dataSource = new MatTableDataSource(this.ELEMENT_DATA);
  }

  openDialog() {
    this.dialog.open(DialogComponent);
  }
  constructor(public dialog: MatDialog) { 
    this.ELEMENT_DATA=this.ELEMENT_DATA;
    this.productoDel=this.productoDel;

  }

  ngOnInit(): void {}
}


