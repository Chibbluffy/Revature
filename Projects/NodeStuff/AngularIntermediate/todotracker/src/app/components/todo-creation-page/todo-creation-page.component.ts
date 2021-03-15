import { Component, OnInit } from '@angular/core';
import { ToDo } from 'src/app/models/todo';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-todo-creation-page',
  templateUrl: './todo-creation-page.component.html',
  styleUrls: ['./todo-creation-page.component.css']
})
export class TodoCreationPageComponent implements OnInit {

  description:string = ''
  priority:number = 0
  constructor(private toDoService:TodoService) { }

  ngOnInit(): void {
  }
  createToDo(){
    const todo:ToDo = new ToDo(this.description, this.priority, false)
    this.toDoService.todos.push(todo); // adds todo to todoservice list
    
    alert("Successfully created a new todo")
  }

}
