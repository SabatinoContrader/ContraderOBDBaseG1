import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ScadenzenoleggiComponent } from './scadenzenoleggi.component';

describe('ScadenzenoleggiComponent', () => {
  let component: ScadenzenoleggiComponent;
  let fixture: ComponentFixture<ScadenzenoleggiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ScadenzenoleggiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScadenzenoleggiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
