import { Component, OnInit } from '@angular/core';
import { ToDo } from 'src/app/models/todo';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-pending-table',
  templateUrl: './pending-table.component.html',
  styleUrls: ['./pending-table.component.css']
})
export class PendingTableComponent implements OnInit {

  todos:ToDo[] = [];
  constructor(private todoService:TodoService) { }

  // gets called whenever a component is rendered to the screen for the first time
  ngOnInit(): void {
    this.todos = this.todoService.todos
  }

  markCompleted(todo:ToDo){
    todo.isComplete = true;
  }

}
