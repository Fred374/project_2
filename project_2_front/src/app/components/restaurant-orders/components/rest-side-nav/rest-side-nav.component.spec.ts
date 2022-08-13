import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestSideNavComponent } from './rest-side-nav.component';

describe('RestSideNavComponent', () => {
  let component: RestSideNavComponent;
  let fixture: ComponentFixture<RestSideNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestSideNavComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RestSideNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
