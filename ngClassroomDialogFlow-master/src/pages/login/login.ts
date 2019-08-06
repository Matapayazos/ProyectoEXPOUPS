import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { AlertController } from 'ionic-angular';
import { WelcomePage } from '../welcome/welcome';
import {InscribirsePage} from '../inscribirse/inscribirse';
import { HttpClient } from '@angular/common/http';

/**
 * Generated class for the LoginPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {
@ViewChild('email') email;
 @ViewChild('password') password;
 
  constructor(public navCtrl: NavController, public navParams: NavParams,public alertCtrl: AlertController,public http:HttpClient) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad LoginPage');
  }

  login(){
    return new Promise(resolve =>{
      this.http.get('http://localhost:8080/FinalEXPO/rest/Aspiranteservicios/Login?email='+this.email.value+'&password='+this.password.value).subscribe(data=>{
        resolve(data);
        console.log(data.toString +" "+ this.email.value +this.password.value);
        if(data+" "=='false '){
          let alert = this.alertCtrl.create({
            title: 'Datos incorrectos',
            subTitle: 'Los datos ingresados son incorrectos.',
            buttons: ['OK']
             });
            alert.present(); 
        }else if(data+" "=='true ') {
          console.log("paso");
          this.navCtrl.push(WelcomePage);
          this.navCtrl.setRoot(WelcomePage);
          this.navCtrl.canGoBack();
          this.navCtrl.canSwipeBack();
        }
      },erro=>{
      });
    });
   }
   Registrar(){
    console.log("Se mueve de pagina ");
     this.navCtrl.push(InscribirsePage);
   }

}
