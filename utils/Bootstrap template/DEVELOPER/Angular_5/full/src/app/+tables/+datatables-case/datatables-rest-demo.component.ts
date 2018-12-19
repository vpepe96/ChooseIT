import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs/Observable";
import { HttpClient } from '@angular/common/http';

declare var $: any;

@Component({
  selector: 'datatables-rest-demo',
  templateUrl: './datatables-rest-demo.component.html',
  styles: []
})
export class DatatablesRestDemoComponent implements OnInit {

  public REST_ROOT = 'https://jsonplaceholder.typicode.com';

  options = {
    dom: "Bfrtip",
    ajax: (data, callback, settings) => {
      this.http.get(this.REST_ROOT + '/posts')
        .map((data: any)=>(data.data || data))
        .catch(this.handleError)
        .subscribe((data) => {
          console.log('data from rest endpoint', data);
          callback({
            aaData: data.slice(0, 100)
          })
        })
    },
    columns: [
      { data: "userId" },
      { data: "id" },
      { data: "title" },
      { data: "body" },
    ]
  };

  constructor(private http: HttpClient) { }

  ngOnInit() {}


  private handleError(error: any) {
    // In a real world app, we might use a remote logging infrastructure
    // We'd also dig deeper into the error to get a better message
    let errMsg = (error.message) ? error.message :
      error.status ? `${error.status} - ${error.statusText}` : 'Server error';
    console.error(errMsg); // log to console instead
    return Observable.throw(errMsg);
  }

}
