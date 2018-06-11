import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllAutoComponent } from './all-auto.component';

describe('AllAutoComponent', () => {
  let component: AllAutoComponent;
  let fixture: ComponentFixture<AllAutoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllAutoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllAutoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
