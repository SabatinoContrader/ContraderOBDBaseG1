import { TestBed, inject } from '@angular/core/testing';

import { DispositiviService } from './dispositivi.service';

describe('DispositiviService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DispositiviService]
    });
  });

  it('should be created', inject([DispositiviService], (service: DispositiviService) => {
    expect(service).toBeTruthy();
  }));
});
