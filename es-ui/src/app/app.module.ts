import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {routing} from "../app.routing";
import {HttpModule} from "@angular/http";
import {HashLocationStrategy, LocationStrategy} from "@angular/common";
import {IndexComponent} from "./components/index/index.component";
import {LoginComponent} from "./components/login/login.component";
import {DotfuscatorComponent} from './components/tools/dotfuscator/dotfuscator.component';
import {ObfuscationComponent} from './components/workflow/obfuscation/obfuscation.component';
import {FormsModule} from "@angular/forms";
import {DotfuscatorService} from "./services/tool-support/dotfuscator.service";
import {ObfuscationRequestService} from "./services/requests/obfuscation.request.service";
import {Ng2Bs3ModalModule} from "ng2-bs3-modal/ng2-bs3-modal";
import { SlackComponent } from './components/business/slack/slack.component';
import {SalckService} from "./services/business/slack.service";

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    LoginComponent,
    DotfuscatorComponent,
    ObfuscationComponent,
    SlackComponent,
  ],
  imports: [
    BrowserModule, routing, HttpModule,  FormsModule, Ng2Bs3ModalModule
  ],
  providers: [
    {provide: LocationStrategy, useClass: HashLocationStrategy},
    DotfuscatorService,
    ObfuscationRequestService,
    SalckService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
