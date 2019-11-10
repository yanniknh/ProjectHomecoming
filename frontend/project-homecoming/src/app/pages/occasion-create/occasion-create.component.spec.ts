import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OccasionCreateComponent } from './occasion-create.component';

describe('OccasionCreateComponent', () => {
  let component: OccasionCreateComponent;
  let fixture: ComponentFixture<OccasionCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OccasionCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OccasionCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
