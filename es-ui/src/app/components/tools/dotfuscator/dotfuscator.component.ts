import {Component, OnInit} from '@angular/core';
import {DotfuscatorService} from "../../../services/tool-support/dotfuscator.service";
import {saveAs as importedSaveAs} from "file-saver";

@Component({
  selector: 'app-dotfuscator',
  templateUrl: './dotfuscator.component.html',
  styleUrls: ['./dotfuscator.component.css']
})
export class DotfuscatorComponent implements OnInit {

  dotfuscatorInfo: string[];
  errorMessage: string;
  latest: string;


  constructor(private dotfuscatorService: DotfuscatorService) {
  }

  ngOnInit() {
    this.getDotfuscatorInfo();
    this.getLatestInfo();
  }

  getDotfuscatorInfo() {
    this.dotfuscatorService.getDotfuscatorInfo().subscribe(info => this.dotfuscatorInfo = info,
      error => this.errorMessage = <any>error);
  }

  onDownloadClicked(item) {
    this.dotfuscatorService.downloadDotfuscator(item).subscribe(blob => {
      importedSaveAs(blob, item);
    });
  }

  downloadLicenseFile() {
    this.dotfuscatorService.downloadLicense().subscribe(blob => {
      importedSaveAs(blob, "license.dat");
    });
  }

  getLatestInfo() {
    this.dotfuscatorService.getDotfuscatorLatestInfo().subscribe(info => {
        this.latest = info;
        console.log("in getLatestInfo()"+ this.latest);
      },
      error => this.errorMessage = <any>error);
  }

  downloadLatestDotfuscator() {
    this.dotfuscatorService.downloadLatestDotfuscator().subscribe(blob => {
      importedSaveAs(blob, this.latest);
    });
  }
}
