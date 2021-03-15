import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/models/book/book';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-book-creator',
  templateUrl: './book-creator.component.html',
  styleUrls: ['./book-creator.component.css']
})
export class BookCreatorComponent implements OnInit {

  title:string = '';
  author:string = '';
  condition:number = 0;

  constructor(private bookService:BookService) { }

  ngOnInit(): void {
  }

  async createBook(){
    let book:Book = new Book(0,this.title,this.author,this.condition,true,0);
    book = await this.bookService.createBook(book);
    console.log(book)
  }

}
