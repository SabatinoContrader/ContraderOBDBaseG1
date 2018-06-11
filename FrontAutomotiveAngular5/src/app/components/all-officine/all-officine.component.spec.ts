import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllOfficineComponent } from './all-officine.component';

describe('AllOfficineComponent', () => {
  let component: AllOfficineComponent;
  let fixture: ComponentFixture<AllOfficineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllOfficineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllOfficineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
