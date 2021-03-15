import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'dollars'
})
export class DollarsPipe implements PipeTransform {

  transform(money:number): string {
    return `$${money.toFixed(2)}`
  }

}
