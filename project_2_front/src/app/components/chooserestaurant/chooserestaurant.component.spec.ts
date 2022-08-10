import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChooserestaurantComponent } from './chooserestaurant.component';

describe('ChooserestaurantComponent', () => {
  let component: ChooserestaurantComponent;
  let fixture: ComponentFixture<ChooserestaurantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChooserestaurantComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChooserestaurantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
