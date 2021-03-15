import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoDisplayTableComponent } from './info-display-table.component';

describe('InfoDisplayTableComponent', () => {
  let component: InfoDisplayTableComponent;
  let fixture: ComponentFixture<InfoDisplayTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfoDisplayTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InfoDisplayTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
