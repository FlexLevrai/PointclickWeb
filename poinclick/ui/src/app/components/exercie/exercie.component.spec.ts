import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExercieComponent } from './exercie.component';

describe('ExercieComponent', () => {
  let component: ExercieComponent;
  let fixture: ComponentFixture<ExercieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExercieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExercieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
