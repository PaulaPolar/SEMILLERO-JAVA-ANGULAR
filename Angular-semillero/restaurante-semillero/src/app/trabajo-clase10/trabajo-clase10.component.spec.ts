import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrabajoClase10Component } from './trabajo-clase10.component';

describe('TrabajoClase10Component', () => {
  let component: TrabajoClase10Component;
  let fixture: ComponentFixture<TrabajoClase10Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrabajoClase10Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrabajoClase10Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
