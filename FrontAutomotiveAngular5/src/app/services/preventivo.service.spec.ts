import { TestBed, inject } from '@angular/core/testing';

import { PreventivoService } from './preventivo.service';

describe('PreventivoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PreventivoService]
    });
  });

  it('should be created', inject([PreventivoService], (service: PreventivoService) => {
    expect(service).toBeTruthy();
  }));
});