import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderFinalDetailsComponent } from './order-final-details.component';

describe('OrderFinalDetailsComponent', () => {
  let component: OrderFinalDetailsComponent;
  let fixture: ComponentFixture<OrderFinalDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderFinalDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderFinalDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
