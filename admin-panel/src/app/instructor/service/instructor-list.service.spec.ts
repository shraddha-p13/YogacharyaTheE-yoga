import { TestBed } from '@angular/core/testing';

import { InstructorListService } from './instructor-list.service';

describe('InstructorListService', () => {
  let service: InstructorListService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InstructorListService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
