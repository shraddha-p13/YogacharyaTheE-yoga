import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HealthyRecipes2Component } from './healthy-recipes2.component';

describe('HealthyRecipes2Component', () => {
  let component: HealthyRecipes2Component;
  let fixture: ComponentFixture<HealthyRecipes2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HealthyRecipes2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HealthyRecipes2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
