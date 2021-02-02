import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecialDiet3Component } from './special-diet3.component';

describe('SpecialDiet3Component', () => {
  let component: SpecialDiet3Component;
  let fixture: ComponentFixture<SpecialDiet3Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpecialDiet3Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpecialDiet3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
