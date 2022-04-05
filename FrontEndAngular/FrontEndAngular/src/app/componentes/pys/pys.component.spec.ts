import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PysComponent } from './pys.component';

describe('PysComponent', () => {
  let component: PysComponent;
  let fixture: ComponentFixture<PysComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PysComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PysComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
