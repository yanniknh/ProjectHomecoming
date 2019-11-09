import { TestBed } from '@angular/core/testing';

import { OccasionServiceService } from './occasion-service.service';

describe('OccasionServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OccasionServiceService = TestBed.get(OccasionServiceService);
    expect(service).toBeTruthy();
  });
});
