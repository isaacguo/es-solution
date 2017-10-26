import {Component, OnInit} from '@angular/core';
import {DotfuscatorService} from "../../../services/tool-support/dotfuscator.service";

@Component({
  selector: 'app-dotfuscator',
  templateUrl: './dotfuscator.component.html',
  styleUrls: ['./dotfuscator.component.css']
})
export class DotfuscatorComponent implements OnInit {

  dotfuscatorInfo: String[];
  errorMessage: string;


  constructor(private dotfuscatorService: DotfuscatorService) {
  }

  ngOnInit() {
    this.getDotfuscatorInfo();
  }

  getDotfuscatorInfo() {
    this.dotfuscatorService.getDotfuscatorInfo().subscribe(info => this.dotfuscatorInfo = info,
      error => this.errorMessage = <any>error);
  }

  onDownloadClicked(item) {
    this.dotfuscatorService.downloadDotfuscator(item).subscribe();
  }

}
