import { Component, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { RouterModule, Routes } from '@angular/router';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TrabajoClase10Component } from './trabajo-clase10/trabajo-clase10.component';

const router: Routes = [
  {
    path: 'clase10',
    component: TrabajoClase10Component
  }
];

@NgModule({
  declarations: [
    AppComponent,
    TrabajoClase10Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(router)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
