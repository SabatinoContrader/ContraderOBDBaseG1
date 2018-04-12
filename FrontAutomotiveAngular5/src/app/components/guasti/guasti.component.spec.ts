import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GuastiComponent } from './guasti.component';

describe('GuastiComponent', () => {
  let component: GuastiComponent;
  let fixture: ComponentFixture<GuastiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GuastiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GuastiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
