import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { YogaService } from 'src/app/services/yoga.service';
import { LoginDetails } from '../model/LoginDetails';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private yogaService: YogaService) { }

  public login(loginDetails: LoginDetails) {
    return this.yogaService.post('api/login', loginDetails);
  }
}
