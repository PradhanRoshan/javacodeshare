import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeStatComponent } from './employee-stat.component';

describe('EmployeeStatComponent', () => {
  let component: EmployeeStatComponent;
  let fixture: ComponentFixture<EmployeeStatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeStatComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmployeeStatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
