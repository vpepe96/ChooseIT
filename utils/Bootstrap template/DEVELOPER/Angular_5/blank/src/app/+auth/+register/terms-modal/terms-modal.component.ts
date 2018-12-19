import { Component, OnInit, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'smart-terms-modal',
  templateUrl: './terms-modal.component.html',
})
export class TermsModalComponent {

  @Output() agree = new EventEmitter()
  @Output() close = new EventEmitter()

  constructor() {}
}
