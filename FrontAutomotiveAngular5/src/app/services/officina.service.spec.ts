import { TestBed, inject } from '@angular/core/testing';

import { OfficinaService } from './officina.service';

describe('OfficinaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OfficinaService]
    });
  });

  it('should be created', inject([OfficinaService], (service: OfficinaService) => {
    expect(service).toBeTruthy();
  }));
});
