import { Component, OnInit } from '@angular/core';
import { Ipinfo } from 'src/app/models/ipinfo';
import { IpinfoService } from 'src/app/services/ipinfo.service';

@Component({
  selector: 'app-input-box',
  templateUrl: './input-box.component.html',
  styleUrls: ['./input-box.component.css']
})
export class InputBoxComponent implements OnInit {
  ipAddress:string = "";
  constructor(private ipinfoService:IpinfoService) { }

  ngOnInit(): void {
  }
  sendRequest(ipa:string){
    let requestString:string=ipa;
    console.log(requestString);
    this.ipinfoService.getInfo(requestString);
  }

  
}
