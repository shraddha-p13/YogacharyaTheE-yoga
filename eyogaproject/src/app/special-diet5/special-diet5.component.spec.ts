import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecialDiet5Component } from './special-diet5.component';

describe('SpecialDiet5Component', () => {
  let component: SpecialDiet5Component;
  let fixture: ComponentFixture<SpecialDiet5Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpecialDiet5Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpecialDiet5Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
