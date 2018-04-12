import { TestBed, inject } from '@angular/core/testing';

import { GuastiService } from './guasti.service';

describe('GuastiService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GuastiService]
    });
  });

  it('should be created', inject([GuastiService], (service: GuastiService) => {
    expect(service).toBeTruthy();
  }));
});
