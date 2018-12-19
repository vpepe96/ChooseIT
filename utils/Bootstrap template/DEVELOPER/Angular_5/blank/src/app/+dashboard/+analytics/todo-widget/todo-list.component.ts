import {Component, OnInit, Input, AfterContentInit, ElementRef} from '@angular/core';
import {TodoService} from "./todo.service";
import {Todo} from "./todo";

@Component({
  selector: 'todo-list',
  templateUrl: './todo-list.component.html',
})
export class TodoListComponent implements OnInit {

  public items: Array<Todo> = [];

  @Input() public state: any;

  constructor(private el: ElementRef, private todoService: TodoService) { }

  ngOnInit() {
    this.todoService.subject.subscribe((todos: Array<Todo>)=>{
      this.setItems(todos);
    });

    this.setItems(this.todoService.todos)
  }

  setItems(todos: Array<Todo>){
    this.items = todos.filter(it => it.state == this.state.name)
  }

  toggleTodo(todo: Todo){
    this.todoService.toggleTodo(todo)
  }

  deleteTodo(todo: Todo){
    this.todoService.deleteTodo(todo)
  }

}
