import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DispositiviComponent } from './dispositivi.component';

describe('DispositiviComponent', () => {
  let component: DispositiviComponent;
  let fixture: ComponentFixture<DispositiviComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DispositiviComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DispositiviComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
