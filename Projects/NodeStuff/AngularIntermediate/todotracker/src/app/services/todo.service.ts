import { Injectable } from '@angular/core';
import { ToDo } from '../models/todo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  todos:ToDo[] = []
  constructor() { }

  getCompletedTodo():ToDo[]{
    return this.todos.filter((todo)=>{
      return todo.isComplete
    })
  }
}
