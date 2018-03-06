import { TestBed, inject } from '@angular/core/testing';

import { PopulateService } from './populate.service';

describe('PopulateService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PopulateService]
    });
  });

  it('should be created', inject([PopulateService], (service: PopulateService) => {
    expect(service).toBeTruthy();
  }));
});
