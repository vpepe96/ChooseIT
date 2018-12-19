import {Component, OnInit, Input} from '@angular/core';
import {EventsService} from "../shared/events.service";


class CalendarEvent {
  constructor (
    public id: string, 
    public title: string,
    public description: string,
    public className: string,
    public icon?
  ){}
}

@Component({

  selector: 'sa-add-event',
  templateUrl: './add-event.component.html',
})
export class AddEventComponent implements OnInit {

  public icons:Array<string> = [
    'fa-info',
    'fa-warning',
    'fa-check',
    'fa-user',
    'fa-lock',
    'fa-clock-o'
  ];
  public colorClassNames:Array<any> = [
    {
      bg: 'bg-color-darken',
      txt: 'txt-color-white'
    },
    {
      bg: 'bg-color-blue',
      txt: 'txt-color-white'
    },
    {
      bg: 'bg-color-orange',
      txt: 'txt-color-white'
    },
    {
      bg: 'bg-color-greenLight',
      txt: 'txt-color-white'
    },
    {
      bg: 'bg-color-blueLight',
      txt: 'txt-color-white'
    },
    {
      bg: 'bg-color-red',
      txt: 'txt-color-white'
    }
  ];

  public activeIcon:string;
  public activeColorClass:any;
  @Input() public title: string;
  @Input() public description: string;

  constructor(private eventsService: EventsService) {
  }

  ngOnInit() {
    this.activeIcon = this.icons[0];
    this.activeColorClass = this.colorClassNames[0]
  }

  setIcon(icon:string) {
    this.activeIcon = icon
  }

  setColorClass(colorClassName) {
    this.activeColorClass = colorClassName
  }

  addExternalEvent() {
    if(!this.description || !this.title){
      return
    }
    let event = new CalendarEvent(
      this.eventsService.generateId(),
      this.title,
      this.description,
      this.activeColorClass.bg + ' ' + this.activeColorClass.txt,
      this.activeIcon
    );

    this.eventsService.addExternalEvent(event);

    this.description = '';
    this.title = ''
  }
}
