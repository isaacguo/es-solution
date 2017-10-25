import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {IndexComponent} from "./app/components/public/index/index.component";
import {DotfuscatorComponent} from "./app/components/public/dotfuscator/dotfuscator.component";


const appRoutes: Routes = [
  {
    path: '',
    component: IndexComponent,
    children: [
      {
        path: 'dotfuscator',
        component: DotfuscatorComponent
      }
    ]
  },

]


export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
