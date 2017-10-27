import {Component, OnInit} from '@angular/core';
import {ObfuscationRequestService} from "../../../services/requests/obfuscation.request.service";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";

@Component({
  selector: 'app-obfuscation',
  templateUrl: './obfuscation.component.html',
  styleUrls: ['./obfuscation.component.css']
})
export class ObfuscationComponent implements OnInit {


  constructor(private obfuscationRequestService: ObfuscationRequestService) {
  }

  ngOnInit() {
  }

  onSubmit(formValue: any,modal:ModalComponent ) {
    this.obfuscationRequestService.sendRequest(formValue).subscribe(
      res => {
        modal.open();
      });
  }
}
