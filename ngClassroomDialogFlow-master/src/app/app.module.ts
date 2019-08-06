import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { HttpClientModule } from '@angular/common/http';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import {LoginPage} from '../pages/login/login';
import {WelcomePage} from '../pages/welcome/welcome' ;
import {TestPage} from '../pages/test/test';
import {InscribirsePage} from '../pages/inscribirse/inscribirse';
import {MateriasPage} from '../pages/materias/materias';
import {Pregunta1Page} from '../pages/pregunta1/pregunta1'



@NgModule({
  declarations: [
    MyApp,
    HomePage,
    LoginPage,
    WelcomePage,
    TestPage,
    InscribirsePage,
    MateriasPage,
    Pregunta1Page
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    IonicModule.forRoot(MyApp)
    
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    LoginPage,
    WelcomePage,
    TestPage,
    InscribirsePage,
    MateriasPage,
    Pregunta1Page
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
