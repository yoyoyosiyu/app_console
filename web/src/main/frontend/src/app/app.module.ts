import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { IconDefinition } from '@ant-design/icons-angular';
import { MinusSquareOutline, PlusSquareOutline } from '@ant-design/icons-angular/icons';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AboutComponent } from './about/about.component';
import {HttpClientModule} from "@angular/common/http";
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import {NgZorroAntdModule, NZ_I18N, NZ_ICONS, zh_CN} from 'ng-zorro-antd';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { registerLocaleData } from '@angular/common';
import zh from '@angular/common/locales/zh';
import { CategoriesComponent } from './categories/categories.component';

registerLocaleData(zh);

const icons: IconDefinition[] = [ MinusSquareOutline, PlusSquareOutline ];

@NgModule({
  declarations: [
    AppComponent,
    AboutComponent,
    PageNotFoundComponent,
    CategoriesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgZorroAntdModule,
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [
    { provide: NZ_I18N, useValue: zh_CN },
    { provide: NZ_ICONS, useValue: icons }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
