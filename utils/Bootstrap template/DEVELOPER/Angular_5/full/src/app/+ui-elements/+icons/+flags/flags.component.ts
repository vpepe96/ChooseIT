import {Component, OnInit, ElementRef} from '@angular/core';
import {FadeInTop} from "../../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-flags',
  templateUrl: './flags.component.html',
})
export class FlagsComponent implements OnInit {

  constructor(private el:ElementRef) {
  }

  containers:any

  ngOnInit() {
    this.containers = this.el.nativeElement.querySelectorAll('.demo-icon-font')
  }

  search = '';


  onKey(event:any) {
    this.search = event.target.value;

    Array.prototype.forEach.call(this.containers, (container)=> {
      if (container.querySelectorAll('[class*="' + this.search + '"]').length > 0 ||

        (this.search.length > 1 && container.innerHTML.toLowerCase().search(this.search) > -1)
      ) {
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
