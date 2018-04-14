import { TestBed, inject } from '@angular/core/testing';

import { ScadenzeService } from './scadenze.service';

describe('ScadenzeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ScadenzeService]
    });
  });

  it('should be created', inject([ScadenzeService], (service: ScadenzeService) => {
    expect(service).toBeTruthy();
  }));
});
