import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {routing} from "../app.routing";
import {HttpModule} from "@angular/http";
import {HashLocationStrategy, LocationStrategy} from "@angular/common";
import {BsModalModule} from "ng2-bs3-modal";
import {IndexComponent} from "./components/index/index.component";
import {LoginComponent} from "./components/login/login.component";
import { DotfuscatorComponent } from './components/tools/dotfuscator/dotfuscator.component';
import { ObfuscationComponent } from './components/workflow/obfuscation/obfuscation.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    LoginComponent,
    DotfuscatorComponent,
    ObfuscationComponent
  ],
  imports: [
    BrowserModule, routing, BrowserModule, HttpModule, BsModalModule, FormsModule
  ],
  providers: [
    {provide: LocationStrategy, useClass: HashLocationStrategy},
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
