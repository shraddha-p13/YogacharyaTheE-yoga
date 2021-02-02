import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HealthyRecipes3Component } from './healthy-recipes3.component';

describe('HealthyRecipes3Component', () => {
  let component: HealthyRecipes3Component;
  let fixture: ComponentFixture<HealthyRecipes3Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HealthyRecipes3Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HealthyRecipes3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
