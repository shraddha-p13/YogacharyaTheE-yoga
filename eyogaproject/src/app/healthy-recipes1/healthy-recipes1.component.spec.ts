import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HealthyRecipes1Component } from './healthy-recipes1.component';

describe('HealthyRecipes1Component', () => {
  let component: HealthyRecipes1Component;
  let fixture: ComponentFixture<HealthyRecipes1Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HealthyRecipes1Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HealthyRecipes1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
