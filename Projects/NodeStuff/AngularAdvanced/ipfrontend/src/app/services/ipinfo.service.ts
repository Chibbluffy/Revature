import { Injectable } from '@angular/core';
import { Ipinfo } from '../models/ipinfo';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class IpinfoService {
  ipInfo:Ipinfo = new Ipinfo();
  constructor(private http:HttpClient) { }
  
  async getInfo(ipa:string){
    const endpoint:string = "http://ip-api.com/json/";
    const options={
      method: "GET"
    };
    // const xhr:XMLHttpRequest = new XMLHttpRequest();
    // let response=null;
    // xhr.onreadystatechange = function() {
    //     if (this.readyState == 4 && this.status == 200) {
    //         response = JSON.parse(this.responseText);
    //         if(response.status !== 'success') {
    //             console.log('query failed: ' + response.message);
    //             return
    //         }else{
    //             const ipInfo:Ipinfo = JSON.parse(this.responseText);
    //         }
    //         console.log(response)
            
    //     }
    // };
    // await xhr.open('GET', endpoint+ipa, true);
    // xhr.send();
    this.ipInfo = await this.http.get<Ipinfo>(endpoint+ipa).toPromise();
    console.log(this.ipInfo)
    return this.ipInfo;
  }
}
