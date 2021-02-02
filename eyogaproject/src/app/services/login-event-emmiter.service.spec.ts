import { TestBed } from '@angular/core/testing';

import { LoginEventEmmiterService } from './login-event-emmiter.service';

describe('LoginEventEmmiterService', () => {
  let service: LoginEventEmmiterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoginEventEmmiterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
