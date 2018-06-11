import { TestBed, inject } from '@angular/core/testing';

import { NoleggiService } from './noleggi.service';

describe('NoleggiService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NoleggiService]
    });
  });

  it('should be created', inject([NoleggiService], (service: NoleggiService) => {
    expect(service).toBeTruthy();
  }));
});
