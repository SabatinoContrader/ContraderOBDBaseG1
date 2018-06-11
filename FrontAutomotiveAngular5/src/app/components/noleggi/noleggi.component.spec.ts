import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NoleggiComponent } from './noleggi.component';

describe('NoleggiComponent', () => {
  let component: NoleggiComponent;
  let fixture: ComponentFixture<NoleggiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NoleggiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NoleggiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
