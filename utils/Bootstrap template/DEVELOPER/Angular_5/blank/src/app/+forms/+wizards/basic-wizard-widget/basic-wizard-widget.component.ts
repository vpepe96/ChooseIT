import {
  Component, OnInit, DoCheck,
} from '@angular/core';

import { trigger,
  state,
  style,
  transition,
  animate} from '@angular/animations'

@Component({
  selector: 'basic-wizard-widget',
  templateUrl: './basic-wizard-widget.component.html',
  animations: [
    trigger('changePane', [
      state('out', style({
        height: 0,
      })),
      state('in', style({
        height: '*',
      })),
      transition('out => in', animate('250ms ease-out')),
      transition('in => out', animate('250ms 300ms ease-in'))
    ])
  ]
})
export class BasicWizardWidgetComponent implements OnInit, DoCheck {

  constructor() {
  }

  ngOnInit() {
  }

   public model = {
    email: '',
    firstname: '',
    lastname: '',
    country: '',
    city: '',
    postal: '',
    wphone: '',
    hphone: ''
  };

  public steps = [
    {
      key: 'step1',
      title: 'Basic information',
      valid: false,
      checked: false,
      submitted: false,
    },
    {
      key: 'step2',
      title: 'Billing information',
      valid: false,
      checked: false,
      submitted: false,
    },
    {
      key: 'step3',
      title: 'Domain Setup',
      valid: true,
      checked: false,
      submitted: false,
    },
    {
      key: 'step4',
      title: 'Save Form',
      valid: true,
      checked: false,
      submitted: false,
    },
  ];

  public activeStep = this.steps[0];

  setActiveStep(steo) {
    this.activeStep = steo
  }

  prevStep() {
    let idx = this.steps.indexOf(this.activeStep);
    if (idx > 0) {
      this.activeStep = this.steps[idx - 1]
    }
  }

  nextStep() {
    this.activeStep.submitted = true;
    if(!this.activeStep.valid){
      return;
    }
    this.activeStep.checked = true;
    if (this.steps.every(it=>(it.valid && it.checked))) {
      this.onWizardComplete(this.model)
    } else {
      let idx = this.steps.indexOf(this.activeStep);
      this.activeStep = null;
      while (!this.activeStep) {
        idx = idx == this.steps.length - 1 ? 0 : idx + 1;
        if (!this.steps[idx].valid || !this.steps[idx].checked ) {
          this.activeStep = this.steps[idx]
        }
      }
    }
  }


  onWizardComplete(data) {
    console.log('basic wizard complete', data)
  }


  private lastModel;

  // custom change detection
  ngDoCheck() {
    if (!this.lastModel) {
      // backup model to compare further with
      this.lastModel = Object.assign({}, this.model)
    } else {
      if (Object.keys(this.model).some(it=>this.model[it] != this.lastModel[it])) {
        // change detected
        this.steps.find(it=>it.key == 'step1').valid = !!(this.model.email && this.model.firstname && this.model.lastname);
        this.steps.find(it=>it.key == 'step2').valid = !!(this.model.country && this.model.city && this.model.postal);
        this.lastModel = Object.assign({}, this.model)
      }
    }
  }

}
