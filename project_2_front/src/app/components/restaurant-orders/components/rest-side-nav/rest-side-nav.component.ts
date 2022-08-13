import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-rest-side-nav',
  templateUrl: './rest-side-nav.component.html',
  styleUrls: ['./rest-side-nav.component.css'],
})
export class RestSideNavComponent implements OnInit {
  // Emmiter to send the the selected view option to parent which will in turn send it to OrdersTable
  @Output() newViewOptionEvent = new EventEmitter<number>();
  public selectedViewOption = 1;

  constructor() {}

  ngOnInit(): void {}

  sideButtonPressed(buttonOption: number) {
    this.newViewOptionEvent.emit(buttonOption);
    this.selectedViewOption = buttonOption;
  }
}
