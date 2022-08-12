import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BreakfastandbrunchComponent } from './breakfastandbrunch.component';

describe('BreakfastandbrunchComponent', () => {
  let component: BreakfastandbrunchComponent;
  let fixture: ComponentFixture<BreakfastandbrunchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BreakfastandbrunchComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BreakfastandbrunchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
