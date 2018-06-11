import { TestBed, inject } from '@angular/core/testing';

import { ScadenzenoleggiService } from './scadenzenoleggi.service';

describe('ScadenzenoleggiService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ScadenzenoleggiService]
    });
  });

  it('should be created', inject([ScadenzenoleggiService], (service: ScadenzenoleggiService) => {
    expect(service).toBeTruthy();
  }));
});
