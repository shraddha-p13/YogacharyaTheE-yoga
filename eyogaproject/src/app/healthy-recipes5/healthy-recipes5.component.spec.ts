import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HealthyRecipes5Component } from './healthy-recipes5.component';

describe('HealthyRecipes5Component', () => {
  let component: HealthyRecipes5Component;
  let fixture: ComponentFixture<HealthyRecipes5Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HealthyRecipes5Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HealthyRecipes5Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
