import {Injectable} from '@angular/core';
import {Subject} from "rxjs/Subject";
import {Todo} from "./todo";


@Injectable()
export class TodoService {

  public subject:Subject<any>;

  public todos: Array<Todo> = [
    new Todo('Release', 'Critical'),
    new Todo('Misc', 'Important'),
    new Todo('E-commerce', 'Important'),
  ];

  states = [
    {name: "Critical", title: "Critical Tasks", icon: "warning"},
    {name: "Important", title: "Important Tasks", icon: "exclamation"},
    {name: "Completed", title: "Completed Tasks", icon: "check"}
  ];

  constructor() {
    this.subject = new Subject();
  }

  createTodo(todo:Todo) {
    todo.createdAt = new Date();

    if(todo.state = 'Completed'){
      todo.completedAt = new Date();
    }

    this.todos.push(todo);
    this.subject.next(this.todos)
  }

  toggleTodo(todo:Todo) {
    if (todo.completedAt) {
      todo.state = 'Important';
      todo.completedAt = null

    } else {
      todo.state = 'Completed';
      todo.completedAt = new Date();
    }
    this.subject.next(this.todos)

  }


  updateTodo(id, state){
    this.todos.find(it => it.id == id).state = state.name;
    this.subject.next(this.todos)
  }

  deleteTodo(todo:Todo) {
    this.todos.splice(this.todos.indexOf(todo), 1)
    this.subject.next(this.todos)
  }

}
