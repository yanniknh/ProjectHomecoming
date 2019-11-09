import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GroupSizeSelectionComponent } from './group-size-selection.component';

describe('GroupSizeSelectionComponent', () => {
  let component: GroupSizeSelectionComponent;
  let fixture: ComponentFixture<GroupSizeSelectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GroupSizeSelectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GroupSizeSelectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
