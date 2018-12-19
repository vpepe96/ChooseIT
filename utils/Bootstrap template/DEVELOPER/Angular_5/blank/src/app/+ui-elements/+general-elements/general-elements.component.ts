import {Component, OnInit, ViewChild} from '@angular/core';
import {ModalDirective} from "ngx-bootstrap";
import {NotificationService} from "../../shared/utils/notification.service";
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";



declare var $: any;

@FadeInTop()
@Component({
  selector: 'sa-general-elements',
  templateUrl: './general-elements.component.html',
})
export class GeneralElementsComponent implements OnInit {


  public state: any = {
    tabs: {
      demo1: 0,
      demo2: 'tab-r1',
      demo3: 'hr1',
      demo4: 'AA',
      demo5: 'iss1',
      demo6: 'l1',
      demo7: 'tab1',
      demo8: 'hb1',
      demo9: 'A1',
      demo10: 'is1'
    },

    carousel: {
      demo1: {
        interval: 2000,
        noWrap: false,
        slides: [
          {
            title: 'Title 1',
            text: 'Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.',
            src: 'assets/img/demo/m3.jpg',
          },
          {
            title: 'Title 2',
            text: 'Dolores justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.',
            src: 'assets/img/demo/m2.jpg',
          },
          {
            title: 'Title 3',
            text: 'Lorem justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.',
            src: 'assets/img/demo/m1.jpg',
          },
        ]
      },
      demo2: {
        interval: 3000,
        noWrap: false,
        slides: [
          {
            title: 'Title 2',
            text: 'Dolores justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.',
            src: 'assets/img/demo/m2.jpg',
          },
          {
            title: 'Title 1',
            text: 'Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.',
            src: 'assets/img/demo/m3.jpg',
          },
          {
            title: 'Title 3',
            text: 'Lorem justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.',
            src: 'assets/img/demo/m1.jpg',
          },
        ]
      }
    }
  };

  constructor(private notificationService: NotificationService) {
  }

  ngOnInit() {
  }


  @ViewChild('lgModal') public lgModal:ModalDirective;

  public showChildModal():void {
    this.lgModal.show();
  }

  public hideChildModal():void {
    this.lgModal.hide();
  }


  notificationExample1() {

    this.notificationService.bigBox({
      title: "Big Information box",
      content: "This message will dissapear in 6 seconds!",
      color: "#C46A69",
      //timeout: 6000,
      icon: "fa fa-warning shake animated",
      number: "1",
      timeout: 6000
    });
  }

  notificationExample2() {

    this.notificationService.bigBox({
      title: "Big Information box",
      content: "Lorem ipsum dolor sit amet, test consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
      color: "#3276B1",
      //timeout: 8000,
      icon: "fa fa-bell swing animated",
      number: "2"
    });

  }

  notificationExample3() {

    this.notificationService.bigBox({
      title: "Shield is up and running!",
      content: "Lorem ipsum dolor sit amet, test consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
      color: "#C79121",
      //timeout: 8000,
      icon: "fa fa-shield fadeInLeft animated",
      number: "3"
    });

  }

  notificationExample4() {

    this.notificationService.bigBox({
      title: "Success Message Example",
      content: "Lorem ipsum dolor sit amet, test consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
      color: "#739E73",
      //timeout: 8000,
      icon: "fa fa-check",
      number: "4"
    }, ()=> {
      this._closedthis();
    });

  }


  notificationExample5() {

    this.notificationService.smallBox({
      title: "Ding Dong!",
      content: "Someone's at the door...shall one get it sir? <p class='text-align-right'><a href-void class='btn btn-primary btn-sm'>Yes</a> <a href-void class='btn btn-danger btn-sm'>No</a></p>",
      color: "#296191",
      //timeout: 8000,
      icon: "fa fa-bell swing animated"
    });
  }


  notificationExample6() {

    this.notificationService.smallBox({
      title: "Big Information box",
      content: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam",
      color: "#5384AF",
      //timeout: 8000,
      icon: "fa fa-bell"
    });

  }

  notificationExample7() {
    this.notificationService.smallBox({
      title: "James Simmons liked your comment",
      content: "<i class='fa fa-clock-o'></i> <i>2 seconds ago...</i>",
      color: "#296191",
      iconSmall: "fa fa-thumbs-up bounce animated",
      timeout: 4000
    });
  }


  _closedthis() {
    this.notificationService.smallBox({
      title: "Great! You just closed that last alert!",
      content: "This message will be gone in 5 seconds!",
      color: "#739E73",
      iconSmall: "fa fa-cloud",
      timeout: 5000
    });
  }

  smartModEg1() {
    this.notificationService.smartMessageBox({
      title: "Smart Alert!",
      content: "This is a confirmation box. Can be programmed for button callback",
      buttons: '[No][Yes]'
    }, (ButtonPressed) => {
      if (ButtonPressed === "Yes") {

        this.notificationService.smallBox({
          title: "Callback function",
          content: "<i class='fa fa-clock-o'></i> <i>You pressed Yes...</i>",
          color: "#659265",
          iconSmall: "fa fa-check fa-2x fadeInRight animated",
          timeout: 4000
        });
      }
      if (ButtonPressed === "No") {
        this.notificationService.smallBox({
          title: "Callback function",
          content: "<i class='fa fa-clock-o'></i> <i>You pressed No...</i>",
          color: "#C46A69",
          iconSmall: "fa fa-times fa-2x fadeInRight animated",
          timeout: 4000
        });
      }

    });
  }

  smartModEg2() {
    this.notificationService.smartMessageBox({
      title: "Smart Alert: Input",
      content: "Please enter your user name",
      buttons: "[Accept]",
      input: "text",
      placeholder: "Enter your user name"
    }, (ButtonPress, Value) => {
      alert(ButtonPress + " " + Value);
    });
  }

  smartModEg3() {
    this.notificationService.smartMessageBox({
      title: "Smart Notification: Buttons",
      content: "Lots of buttons to go...",
      buttons: '[Need?][You][Do][Buttons][Many][How]'
    });

  }

  smartModEg4() {
    this.notificationService.smartMessageBox({
      title: "Smart Alert: Select",
      content: "You can even create a group of options.",
      buttons: "[Done]",
      input: "select",
      options: "[Costa Rica][United States][Autralia][Spain]"
    }, (ButtonPress, Value) => {
      alert(ButtonPress + " " + Value);
    });

  }

  smartModEg5() {

    this.notificationService.smartMessageBox({
      title: "Login form",
      content: "Please enter your user name",
      buttons: "[Cancel][Accept]",
      input: "text",
      placeholder: "Enter your user name"
    }, (ButtonPress, Value) => {
      if (ButtonPress == "Cancel") {
        alert("Why did you cancel that? :(");
        return 0;
      }

      let Value1 = Value.toUpperCase();
      let ValueOriginal = Value;
      this.notificationService.smartMessageBox({
        title: "Hey! <strong>" + Value1 + ",</strong>",
        content: "And now please provide your password:",
        buttons: "[Login]",
        input: "password",
        placeholder: "Password"
      }, (ButtonPress, Value) => {
        alert("Username: " + ValueOriginal + " and your password is: " + Value);
      });
    });

  }
}
