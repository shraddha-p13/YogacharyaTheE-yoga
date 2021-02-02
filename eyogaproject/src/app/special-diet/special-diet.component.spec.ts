import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecialDietComponent } from './special-diet.component';

describe('SpecialDietComponent', () => {
  let component: SpecialDietComponent;
  let fixture: ComponentFixture<SpecialDietComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpecialDietComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpecialDietComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
