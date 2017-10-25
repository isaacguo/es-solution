import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DotfuscatorComponent } from './dotfuscator.component';

describe('DotfuscatorComponent', () => {
  let component: DotfuscatorComponent;
  let fixture: ComponentFixture<DotfuscatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DotfuscatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DotfuscatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
