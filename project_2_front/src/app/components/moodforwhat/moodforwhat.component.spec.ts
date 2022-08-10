import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoodforwhatComponent } from './moodforwhat.component';

describe('MoodforwhatComponent', () => {
  let component: MoodforwhatComponent;
  let fixture: ComponentFixture<MoodforwhatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MoodforwhatComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MoodforwhatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
