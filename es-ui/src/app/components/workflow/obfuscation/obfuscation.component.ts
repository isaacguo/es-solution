import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-obfuscation',
  templateUrl: './obfuscation.component.html',
  styleUrls: ['./obfuscation.component.css']
})
export class ObfuscationComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  onSubmit(formValue: any)
  {
    console.log(formValue);
  }
}
