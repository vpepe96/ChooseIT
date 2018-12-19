import { Injectable } from '@angular/core';

import EVENTS_MOCK from './EVENTS_MOCK';
import { externalEvents } from './EXTERNAL_EVENTS_MOCK';
import { Subject } from "rxjs/Subject";


@Injectable()
export class EventsService {

  public store: any = {
    events: EVENTS_MOCK,
    externalEvents: externalEvents,
    removeAfterDrop: false,
  };

  private subject;

  constructor() {
    this.subject = new Subject();
  }

  subscribe(next, error?, complete?) {
    return this.subject.subscribe(next, error, complete)
  }

  addEvent(event) {
    const dropId = event.id;
    event.id = this.generateId();
    this.store.events.push(event);

    if (this.store.removeAfterDrop) {
      this.store.externalEvents.splice(this.store.externalEvents.findIndex(it => it.id == dropId), 1);
    }

    this.subject.next(this.store);
  }

  addExternalEvent(event) {
    this.store.externalEvents.push(event)
    this.subject.next(this.store)
  }

  setRemoveAfterDrop(value) {
    this.store.removeAfterDrop = value;
    this.subject.next(this.store);
  }


  generateId() {
    return Math.random().toString(36).slice(2)
  }
}
