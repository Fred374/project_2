import { Component, Input, OnInit } from '@angular/core';

/*
  To use this component, add its selector on top of your HTML as ususal:
    <app-alert></app-alert>

  In your component.ts file, include the following in your class:
    @ViewChild(AlertComponent) alertComponent! : AlertComponent;

  Now your component has access to displayAlert method of the alertComponent.
  To call it we need to pass two parameters ("Message String", "styleString"), an example of a call:
    this.alertComponent.displayAlert("Failed to log it.", "danger");

  Styling string options:
    primary
    secondary
    success
    danger
    warning
    info
    light
    dark

  The style string parameter options correspond with bootstrap styling. 
  If you would like to see what styling string corresponds to which color, follow this link: https://getbootstrap.com/docs/5.0/components/alerts/
*/

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css'],
})
export class AlertComponent implements OnInit {
  isAlertActive = false;

  message: string = '';

  primary: boolean = false;
  secondary: boolean = false;
  success: boolean = false;
  danger: boolean = false;
  warning: boolean = false;
  info: boolean = false;
  light: boolean = false;
  dark: boolean = false;

  constructor() {}

  ngOnInit(): void {
    // this.displayAlert("Heeey", "success")
  }

  displayAlert(message: string, type: string) {
    this.message = message;

    this.resetTypeBools();
    this.setType(type)

    this.isAlertActive = true;

    setTimeout( () => {
      this.isAlertActive = false;
    }, 3000);
  }

  resetTypeBools() {
    this.primary = false;
    this.secondary = false;
    this.success = false;
    this.danger = false;
    this.warning = false;
    this.info = false;
    this.light = false;
    this.dark = false;
  }

  setType(type: string) {
    switch (type) {
      case 'primary':
        this.primary = true;
        break;
      case 'secondary':
        this.secondary = true;
        break;
      case 'success':
        this.success = true;
        break;
      case 'danger':
        this.danger = true;
        break;
      case 'warning':
        this.warning = true;
        break;
      case 'info':
        this.info = true;
        break;
      case 'light':
        this.light = true;
        break;
      case 'dark':
        this.dark = true;
        break;
      default:
        console.log("ERROR: Alert type unrecognized. Please double-check type parameter spelling")
    }
  }
}
