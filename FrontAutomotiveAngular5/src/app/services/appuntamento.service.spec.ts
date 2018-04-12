import { TestBed, inject } from '@angular/core/testing';

import { AppuntamentoService } from './appuntamento.service';

describe('AppuntamentoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AppuntamentoService]
    });
  });

  it('should be created', inject([AppuntamentoService], (service: AppuntamentoService) => {
    expect(service).toBeTruthy();
  }));
});
