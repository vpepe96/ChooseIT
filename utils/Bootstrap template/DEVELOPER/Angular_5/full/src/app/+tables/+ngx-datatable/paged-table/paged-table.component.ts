
import { Component, ViewEncapsulation, OnInit, ViewChild } from '@angular/core';
import { JsonApiService } from "app/core/api/json-api.service";
import { DatatableComponent } from "@swimlane/ngx-datatable/release";
@Component({
  selector: 'paged-table-demo',
  templateUrl: './paged-table.component.html'
})
export class PagedTableComponent implements OnInit {


  rows = [];
  temp = [];
  loadingIndicator: boolean = true;

  reorderable: boolean = true;

  pageSize: number = 10;

  controls: any = {
    pageSize:  10,
    filter: '',
  }

  columns = [
    { prop: 'name' },
    { name: 'Gender' },
    { name: 'Company' },
  ];


  @ViewChild(DatatableComponent) table: DatatableComponent;
  
 constructor(
    private jsonApiService:JsonApiService
  ) {

  }

  ngOnInit() {
    this.jsonApiService.fetch('/tables/companies.json').subscribe(data=> {

      // cache our list
      this.temp = [...data];

      // push our inital complete list
      this.rows = data;

      this.loadingIndicator = false;
    })
  }

   updateFilter(event) {
    const val = event.target.value.toLowerCase();

    // filter our data
    const temp = this.temp.filter(function(d) {
      return !val || ['name', 'gender', 'company'].some((field: any)=>{
        return d[field].toLowerCase().indexOf(val) !== -1
      }) 
    });

    // update the rows
    this.rows = temp;
    // Whenever the filter changes, always go back to the first page
    this.table.offset = 0;
  }


   updatePageSize(value) {
           
      if(!this.controls.filter){
        // update the rows
        this.rows = [...this.temp];
        // Whenever the filter changes, always go back to the first page
        this.table.offset = 0;
      }

      this.controls.pageSize = parseInt(value)

      this.table.limit = this.controls.pageSize; 
      
      window.dispatchEvent(new Event('resize'));

  }
}
