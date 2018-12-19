import {Injectable} from '@angular/core';
import {Outlook} from './outlook'
import {OutlookMessage} from "./outlook-message.class";
import {JsonApiService} from "../../core/api/json-api.service";
import { Subject } from 'rxjs/Subject';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class OutlookService {

  public activeFolder: Subject<any>;

  public messages: Subject<any>;

  private state = {
    lastFolder: '',
    messages: []
  };

  constructor(private jsonApiService: JsonApiService) {
    this.activeFolder = new Subject();
    this.messages = new Subject();
  }

  getOutlook(): Observable<Outlook> {
    return this.jsonApiService.fetch('/outlook/outlook.json')
  }

  getMessages(folder: string) {

    this.jsonApiService.fetch('/outlook/' + folder + '.json')

      .map(this.mapToMessages)
      .do(data => {
        this.state.lastFolder = folder;
        this.state.messages = data;

        this.activeFolder.next(folder);
        this.messages.next(this.state.messages);
        return data
      })

      .subscribe();

  }

  getMessage(id: string) {
    return this.jsonApiService.fetch('/outlook/message.json')
  }

  deleteSelected() {

    this.messages.next(this.state.messages.filter((it)=>!it.selected))
  }

  private mapToMessages(rawMessages): Array<OutlookMessage> {
    return rawMessages.map(it=>new OutlookMessage(it))
  }

}
