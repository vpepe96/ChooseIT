import {Component, OnInit} from '@angular/core';
import {TodoService} from "./todo.service";
import {Todo} from "./todo";

@Component({
  selector: 'todo-widget',
  templateUrl: './todo-widget.component.html',
  styles: [``],
  providers: [TodoService],

})
export class TodoWidgetComponent implements OnInit {

  public newTodo: Todo;

  public states : Array<any>;

  constructor(private todoService: TodoService) {
    this.states = this.todoService.states;
  }

  ngOnInit() {
  }

  createTodo() {
    this.todoService.createTodo(this.newTodo);
    this.newTodo = null

  }

  toggleAdd() {
    if (this.newTodo) {
      this.newTodo = null
    } else {
      this.newTodo = new Todo();
      this.newTodo.state = 'Important'

    }
  }

}
