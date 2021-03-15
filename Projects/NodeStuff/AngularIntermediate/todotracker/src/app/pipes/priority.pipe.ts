import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'priority'
})
export class PriorityPipe implements PipeTransform {

  transform(priority:number): string {
    if(priority<3){
      return "Very low priority"
    }
    if(priority<7){
      return "Medium priority"
    }
    else{
      return "URGENT"
    }
  }

}
