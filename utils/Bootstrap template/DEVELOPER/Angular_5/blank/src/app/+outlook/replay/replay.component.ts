import {Component, OnInit, OnDestroy} from '@angular/core';
import {Subscription} from "rxjs/Subscription";
import {ActivatedRoute, Router} from "@angular/router";
import {OutlookMessage} from "../shared/outlook-message.class";
import {OutlookService} from "../shared/outlook.service";

@Component({
  selector: 'sa-replay',
  templateUrl: './replay.component.html'
})
export class ReplayComponent implements OnInit, OnDestroy {

  public message:OutlookMessage;

  public replayTo:OutlookMessage;
  private replayToSub:Subscription;
  private paramsSub:Subscription;

  public carbonCopy:boolean = false;
  public blindCarbonCopy:boolean = false;
  public attachments:boolean = false;

  public sending:boolean = false;

  constructor(private route:ActivatedRoute,
              private router:Router,
              private service:OutlookService) {

  }

  ngOnInit() {
    this.paramsSub = this.route.params.subscribe((params)=> {
      this.replayToSub = this.service.getMessage(params['id']).subscribe(message =>
        this.replayTo = new OutlookMessage(message)
      )
    })
  }


  ngOnDestroy() {
    this.replayToSub.unsubscribe();
    this.paramsSub.unsubscribe()
  }

  send() {
    this.sending = true;
    setTimeout(()=> {
      this.router.navigate(['/outlook'])
    }, 2000)
  }
}
