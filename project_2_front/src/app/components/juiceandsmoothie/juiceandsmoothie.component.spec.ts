import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JuiceandsmoothieComponent } from './juiceandsmoothie.component';

describe('JuiceandsmoothieComponent', () => {
  let component: JuiceandsmoothieComponent;
  let fixture: ComponentFixture<JuiceandsmoothieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JuiceandsmoothieComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(JuiceandsmoothieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
