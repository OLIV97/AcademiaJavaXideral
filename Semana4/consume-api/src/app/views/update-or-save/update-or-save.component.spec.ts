import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateOrSaveComponent } from './update-or-save.component';

describe('UpdateOrSaveComponent', () => {
  let component: UpdateOrSaveComponent;
  let fixture: ComponentFixture<UpdateOrSaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateOrSaveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateOrSaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
