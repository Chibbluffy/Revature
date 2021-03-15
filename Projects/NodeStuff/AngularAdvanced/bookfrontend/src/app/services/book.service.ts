import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book } from '../models/book/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http:HttpClient) { }
  
  // must use async for all or you will get a promise
  async getAllBooks(){
    const books:Book[] = await this.http.get<Book[]>("http://34.122.186.39:7000/books").toPromise();
    return books;
  }

  async createBook(book:Book){
    book = await this.http.post<Book>( "http://34.122.186.39:7000/books",book).toPromise();
    return book;
  }
}
