import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MealTimeSelectionComponent } from './meal-time-selection.component';

describe('MealTimeSelectionComponent', () => {
  let component: MealTimeSelectionComponent;
  let fixture: ComponentFixture<MealTimeSelectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MealTimeSelectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MealTimeSelectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
