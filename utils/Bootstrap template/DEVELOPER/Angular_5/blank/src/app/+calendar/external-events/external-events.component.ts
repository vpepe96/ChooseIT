import { Component, OnInit } from '@angular/core';
import { DraggableEvent } from "../draggable-event/draggable-event.directive";
import { EventsService } from "../shared/events.service";

@Component({
  selector: 'sa-external-events',
  templateUrl: './external-events.component.html',
})
export class ExternalEventsComponent implements OnInit {

  public events: Array<any>;

  public removeAfterDrop = false;

  private sub: any;

  constructor(private eventsService: EventsService) { }

  ngOnInit() {
    this.events = this.eventsService.store.externalEvents;
    this.removeAfterDrop = this.eventsService.store.removeAfterDrop;
    this.sub = this.eventsService.subscribe((store) => { 
      this.events = store.externalEvents
    })
  }

  ngOnDestroy() {
    this.sub.unsubscribe()
  }

  toggleRemoveAfterDrop() {
    this.eventsService.setRemoveAfterDrop(this.removeAfterDrop)
  }

}
