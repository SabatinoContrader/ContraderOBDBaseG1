import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SingolaTelemetriaComponent } from './singola-telemetria.component';

describe('SingolaTelemetriaComponent', () => {
  let component: SingolaTelemetriaComponent;
  let fixture: ComponentFixture<SingolaTelemetriaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SingolaTelemetriaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SingolaTelemetriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
