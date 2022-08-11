import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFoodComponent } from './add-food.component';

describe('AddFoodComponent', () => {
  let component: AddFoodComponent;
  let fixture: ComponentFixture<AddFoodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddFoodComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddFoodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
