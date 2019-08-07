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
  /**
   * Metodo que se encarga de conectar con el web services permitiendo la validacion del Login 
   * recibe como parametros el emial y la contraseña 
   */
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
          console.log("paso");//validacion de entrada al metodo
          this.navCtrl.push(WelcomePage);//navegacion entre paginas 
          this.navCtrl.setRoot(WelcomePage);//vuelve a la nueva pagian como principal 
          this.navCtrl.canGoBack();//metodo que no permite ir  la vista anterior 
          this.navCtrl.canSwipeBack();//metodo que no permite ir atras 
        }
      },erro=>{
      });
    });
   }
   /**
    * Metodo que lleva a la pantalla de registro 
    * 
    */
   Registrar(){
    console.log("Se mueve de pagina ");//imprime una validacion para saber q entro al metodo
     this.navCtrl.push(InscribirsePage);//metodo que permite navigar entre las ventanas 
   }

}
