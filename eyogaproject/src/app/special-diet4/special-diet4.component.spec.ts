import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecialDiet4Component } from './special-diet4.component';

describe('SpecialDiet4Component', () => {
  let component: SpecialDiet4Component;
  let fixture: ComponentFixture<SpecialDiet4Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpecialDiet4Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpecialDiet4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
