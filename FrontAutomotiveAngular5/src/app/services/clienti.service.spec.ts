import { TestBed, inject } from '@angular/core/testing';

import { ClientiService } from './clienti.service';

describe('ClientiService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ClientiService]
    });
  });

  it('should be created', inject([ClientiService], (service: ClientiService) => {
    expect(service).toBeTruthy();
  }));
});
