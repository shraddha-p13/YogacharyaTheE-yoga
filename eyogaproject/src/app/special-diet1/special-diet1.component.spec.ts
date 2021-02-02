import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecialDiet1Component } from './special-diet1.component';

describe('SpecialDiet1Component', () => {
  let component: SpecialDiet1Component;
  let fixture: ComponentFixture<SpecialDiet1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpecialDiet1Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpecialDiet1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
