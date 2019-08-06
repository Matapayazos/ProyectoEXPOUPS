import { Component, ViewChild } from '@angular/core';
import {  Nav,Platform } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { HomePage } from '../pages/home/home';
import { LoginPage } from '../pages/login/login';
import {WelcomePage} from '../pages/welcome/welcome'
import {TestPage} from '../pages/test/test';
import { MateriasPage } from '../pages/materias/materias';
//import {InscribirsePage}  from '../pages/inscribirse/inscribirse';
@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  @ViewChild(Nav) nav: Nav;

  rootPage:any = LoginPage;

  text: string = '';


  pages: Array<{title: string, component: any}>;
 


  constructor(public platform: Platform,public statusBar: StatusBar, splashScreen: SplashScreen) {
 
    platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      statusBar.styleDefault();
      splashScreen.hide();
    });

    this.pages = [
      //{ title: 'ChatBoot', component: HomePage },
      //{ title: 'Login', component: LoginPage },
      { title: 'Welcome', component: WelcomePage },
      { title: 'Test', component: TestPage },
      { title: 'Materias', component: MateriasPage }
     // { title: 'Inscripcion', component: InscribirsePage}
    ];
  }



  openPage(page) {
    // Reset the content nav to have just this page
    // we wouldn't want the back button to show in this scenario
    this.nav.setRoot(page.component);
  }

  rightMenuClick() {
    this.nav.push(HomePage);
  }

  
  
}

