import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'image-editor-preview-panel',
  templateUrl: './preview-panel.component.html',
  styles: []
})
export class PreviewPanelComponent implements OnInit {

  public storeId = 'previewPanel';

  constructor() { }

  ngOnInit() {
  }

}
