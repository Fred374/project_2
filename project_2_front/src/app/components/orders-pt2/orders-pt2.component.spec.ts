import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdersPt2Component } from './orders-pt2.component';

describe('OrdersPt2Component', () => {
  let component: OrdersPt2Component;
  let fixture: ComponentFixture<OrdersPt2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrdersPt2Component ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrdersPt2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
