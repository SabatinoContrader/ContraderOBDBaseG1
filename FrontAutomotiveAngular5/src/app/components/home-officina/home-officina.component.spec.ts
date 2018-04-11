import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeOfficinaComponent } from './home-officina.component';

describe('HomeOfficinaComponent', () => {
  let component: HomeOfficinaComponent;
  let fixture: ComponentFixture<HomeOfficinaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeOfficinaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeOfficinaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
