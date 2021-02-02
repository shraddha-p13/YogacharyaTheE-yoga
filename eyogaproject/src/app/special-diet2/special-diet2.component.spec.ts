import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecialDiet2Component } from './special-diet2.component';

describe('SpecialDiet2Component', () => {
  let component: SpecialDiet2Component;
  let fixture: ComponentFixture<SpecialDiet2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpecialDiet2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpecialDiet2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
