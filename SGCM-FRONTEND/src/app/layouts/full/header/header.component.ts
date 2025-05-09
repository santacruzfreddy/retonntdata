import {
  Component,
  Output,
  EventEmitter,
  Input,
  ViewEncapsulation,
} from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import {LoginService} from 'src/externalService/service/login/login.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  encapsulation: ViewEncapsulation.None,
})
export class HeaderComponent {
  @Input() showToggle = true;
  @Input() toggleChecked = false;
  @Output() toggleMobileNav = new EventEmitter<void>();
  @Output() toggleMobileFilterNav = new EventEmitter<void>();
  @Output() toggleCollapsed = new EventEmitter<void>();

  showFiller = false;
  userName: string = '';

  logout(){
    this.loginService.logout();
  }

  

  constructor(public dialog: MatDialog, private loginService: LoginService) {

  }

   ngOnInit() {
    this.loginService.userName.subscribe(name => {
      this.userName = 'Bienvenida - '+name;
    });
  }
}
