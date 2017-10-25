import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ObfuscationComponent } from './obfuscation.component';

describe('ObfuscationComponent', () => {
  let component: ObfuscationComponent;
  let fixture: ComponentFixture<ObfuscationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ObfuscationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ObfuscationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
