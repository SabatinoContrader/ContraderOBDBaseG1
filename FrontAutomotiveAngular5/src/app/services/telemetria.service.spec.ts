import { TestBed, inject } from '@angular/core/testing';

import { TelemetriaService } from './telemetria.service';

describe('TelemetriaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TelemetriaService]
    });
  });

  it('should be created', inject([TelemetriaService], (service: TelemetriaService) => {
    expect(service).toBeTruthy();
  }));
});
