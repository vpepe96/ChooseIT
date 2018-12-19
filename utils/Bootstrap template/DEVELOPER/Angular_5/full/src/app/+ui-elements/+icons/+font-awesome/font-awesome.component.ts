import {Component, OnInit, Renderer, Input, ElementRef} from '@angular/core';
import {FadeInTop} from "../../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-font-awesome',
  templateUrl: './font-awesome.component.html',
})
export class FontAwesomeComponent implements OnInit {


  constructor(private el:ElementRef) {
  }

  containers:any

  ngOnInit() {
    this.containers = this.el.nativeElement.querySelectorAll('.demo-icon-font')
  }

  search = '';

  // without strong typing
  onKey(event:any) {
    this.search = event.target.value;

    Array.prototype.forEach.call(this.containers, (container)=> {
      if (container.querySelectorAll('[class*="' + this.search + '"]').length > 0) {
        container.style.display = 'block'
      } else {
        if (this.search) {
          container.style.display = 'none'
        } else {
          container.style.display = 'block'
        }
      }
    })


  }

}
