import { Injectable } from '@angular/core';
import { YogaService } from 'src/app/services/yoga.service';
import { UserDetails } from '../model/UserDetails';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private yogaService: YogaService) { }

  public registerUser(userDetails: UserDetails) {
    return this.yogaService.post('api/register/trainee', userDetails);
  };
}
