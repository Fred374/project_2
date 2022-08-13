import { Component, Input, OnInit } from '@angular/core';

/*
  To use this component, add its selector to your HTML.
    <app-spinner [isSpinnerNeeded]="areOrdersLoading"></app-spinner>

  In the brackets, leave it how it is, on the right side, in quotes provide a boolean value from
  your component.ts file according to which you would like to display/hide the spinner.
  True value will show the spinner, while false will hide it.

  In this example, areOrdersLoading in your component woudl be set to false, and once they finish loading,
  the value of areOrdersLoadin is set to false and the spinner will automatically hide itself.
*/

@Component({
  selector: 'app-spinner',
  templateUrl: './spinner.component.html',
  styleUrls: ['./spinner.component.css']
})
export class SpinnerComponent implements OnInit {

  @Input() isSpinnerNeeded = false;

  constructor() { }

  ngOnInit(): void {
  }

}
