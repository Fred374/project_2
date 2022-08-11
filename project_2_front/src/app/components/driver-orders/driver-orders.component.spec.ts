import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DriverOrdersComponent } from './driver-orders.component';

describe('DriverOrdersComponent', () => {
  let component: DriverOrdersComponent;
  let fixture: ComponentFixture<DriverOrdersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DriverOrdersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DriverOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
