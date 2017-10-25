import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {PublicComponent} from './components/public/public.component';
import {SecureComponent} from './components/secure/secure.component';
import {routing} from "../app.routing";
import {HttpModule} from "@angular/http";
import {HashLocationStrategy, LocationStrategy} from "@angular/common";
import {BsModalModule} from "ng2-bs3-modal";
import {IndexComponent} from "./components/public/index/index.component";
import {LoginComponent} from "./components/public/login/login.component";
import { DotfuscatorComponent } from './components/public/dotfuscator/dotfuscator.component';

@NgModule({
  declarations: [
    AppComponent,
    PublicComponent,
    SecureComponent,
    IndexComponent,
    LoginComponent,
    DotfuscatorComponent
  ],
  imports: [
    BrowserModule, routing, BrowserModule, HttpModule, BsModalModule
  ],
  providers: [
    {provide: LocationStrategy, useClass: HashLocationStrategy},
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
