import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailJourneeComponent } from './detail-journee.component';

describe('DetailJourneeComponent', () => {
  let component: DetailJourneeComponent;
  let fixture: ComponentFixture<DetailJourneeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailJourneeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailJourneeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
