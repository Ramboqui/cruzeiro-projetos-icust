import { ComponentFixture, TestBed } from '@angular/core/testing';
import { SerachResultPage } from './serach-result.page';

describe('SerachResultPage', () => {
  let component: SerachResultPage;
  let fixture: ComponentFixture<SerachResultPage>;

  beforeEach(async(() => {
    fixture = TestBed.createComponent(SerachResultPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
