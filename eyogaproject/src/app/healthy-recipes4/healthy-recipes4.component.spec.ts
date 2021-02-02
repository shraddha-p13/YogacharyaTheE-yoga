import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HealthyRecipes4Component } from './healthy-recipes4.component';

describe('HealthyRecipes4Component', () => {
  let component: HealthyRecipes4Component;
  let fixture: ComponentFixture<HealthyRecipes4Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HealthyRecipes4Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HealthyRecipes4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
