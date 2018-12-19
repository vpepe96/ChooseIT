import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-forgot',
  templateUrl: './forgot.component.html',
  styles: []
})
export class ForgotComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  submit(event){
    event.preventDefault();
    this.router.navigate(['/dashboard/+analytics'])
  }
}
