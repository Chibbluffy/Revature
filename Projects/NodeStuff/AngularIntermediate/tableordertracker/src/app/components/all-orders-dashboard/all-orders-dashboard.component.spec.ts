import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllOrdersDashboardComponent } from './all-orders-dashboard.component';

describe('AllOrdersDashboardComponent', () => {
  let component: AllOrdersDashboardComponent;
  let fixture: ComponentFixture<AllOrdersDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllOrdersDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllOrdersDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
