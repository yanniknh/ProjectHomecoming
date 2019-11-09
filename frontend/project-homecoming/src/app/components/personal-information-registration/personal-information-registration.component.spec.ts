import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonalInformationRegistrationComponent } from './personal-information-registration.component';

describe('PersonalInformationRegistrationComponent', () => {
  let component: PersonalInformationRegistrationComponent;
  let fixture: ComponentFixture<PersonalInformationRegistrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonalInformationRegistrationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonalInformationRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
