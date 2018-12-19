import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {OutlookMessage} from "../shared/outlook-message.class";
import {Subscription} from "rxjs/Subscription";
import {OutlookService} from "../shared/outlook.service";

@Component({
  selector: 'sa-details',
  templateUrl: './details.component.html',
})
export class DetailsComponent implements OnInit {

  public message:OutlookMessage;
  public messageSub:Subscription;
  public paramsSub:Subscription;

  constructor(private route:ActivatedRoute,
              private service:OutlookService) {

  }

  ngOnInit() {
    this.paramsSub = this.route.params.subscribe((params)=> {
      this.messageSub = this.service.getMessage(params['id']).subscribe(message =>
        this.message = new OutlookMessage(message)
      )
    })
  }
}


