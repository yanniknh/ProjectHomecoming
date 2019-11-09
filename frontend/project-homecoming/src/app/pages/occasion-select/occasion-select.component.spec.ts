import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OccasionSelectComponent } from './occasion-select.component';

describe('OccasionSelectComponent', () => {
  let component: OccasionSelectComponent;
  let fixture: ComponentFixture<OccasionSelectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OccasionSelectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OccasionSelectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
