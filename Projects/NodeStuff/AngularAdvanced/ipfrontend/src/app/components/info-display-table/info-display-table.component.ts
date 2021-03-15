import { Component, OnInit } from '@angular/core';
import { Ipinfo } from 'src/app/models/ipinfo';
import { IpinfoService } from 'src/app/services/ipinfo.service';

@Component({
  selector: 'app-info-display-table',
  templateUrl: './info-display-table.component.html',
  styleUrls: ['./info-display-table.component.css']
})
export class InfoDisplayTableComponent implements OnInit {

  ipinfo:Ipinfo = new Ipinfo();
  constructor(private ipinfoService:IpinfoService) { }

  ngOnInit(): void {
  }
  async refresh(){
    this.ipinfo = await this.ipinfoService.ipInfo;
  }


}
