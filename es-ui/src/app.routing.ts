import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {IndexComponent} from "./app/components/index/index.component";
import {DotfuscatorComponent} from "./app/components/tools/dotfuscator/dotfuscator.component";
import {ObfuscationComponent} from "./app/components/workflow/obfuscation/obfuscation.component";
import {LoginComponent} from "./app/components/login/login.component";


const appRoutes: Routes = [
  {
    path: '',
    component: IndexComponent,
    children: [
      {
        path: 'dotfuscator',
        component: DotfuscatorComponent
      },
      {
        path: 'obfuscation',
        component: ObfuscationComponent
      }
    ]
  },
  {
    path: 'login',
    component: LoginComponent
  }

]


export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
