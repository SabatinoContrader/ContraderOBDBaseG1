import { TestBed, inject } from '@angular/core/testing';

import { MessaggiService } from './messaggi.service';

describe('MessaggiService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MessaggiService]
    });
  });

  it('should be created', inject([MessaggiService], (service: MessaggiService) => {
    expect(service).toBeTruthy();
  }));
});
