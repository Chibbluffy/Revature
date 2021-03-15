import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/models/book/book';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-book-table',
  templateUrl: './book-table.component.html',
  styleUrls: ['./book-table.component.css']
})
export class BookTableComponent implements OnInit {

  books:Book[] = [];//= JSON.parse('[{"bookId":7,"title":"Jason and the Argonauts","author":"Homer","condition":1,"available":true,"returnDate":0},{"bookId":5,"title":"Howdy","author":"I","condition":1,"available":true,"returnDate":0},{"bookId":2,"title":"The Outsiders","author":"S. E. Hinton","condition":1,"available":true,"returnDate":0},{"bookId":4,"title":"A Christmas Carol","author":"A Charles Dickens","condition":3,"available":true,"returnDate":0},{"bookId":3,"title":"One Flew Over The Cuckoo\u0027s Nest","author":"Ken Kesey","condition":1,"available":true,"returnDate":0},{"bookId":6,"title":"The Pygmalion","author":"Smith","condition":2,"available":true,"returnDate":0}]');
  constructor(private bookService:BookService) { }

  ngOnInit(): void {
    // this.books = 
  }

  async printBooks(){
    console.log(await this.bookService.getAllBooks());
  }
  async updateBooks(){
    this.books = await this.bookService.getAllBooks();
  }

}
