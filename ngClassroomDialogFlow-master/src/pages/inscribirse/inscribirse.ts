import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';
import { Headers, RequestOptions } from '@angular/http';
import { WelcomePage } from '../welcome/welcome';

/**
 * Generated class for the InscribirsePage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-inscribirse',
  templateUrl: 'inscribirse.html',
})
export class InscribirsePage {
  [x: string]: any;
  @ViewChild('nombre') nombre;
 @ViewChild('apellido') apellido;
  @ViewChild('email') email;
 @ViewChild('password') password;
 resultados: string[];
  constructor(public navCtrl: NavController, public navParams: NavParams,public http:HttpClient) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad InscribirsePage');
  }
  
  Resgistrarse(){
    return new Promise((resolve,reject)=>{
      var data={
        nombre:this.nombre,
        apellido:this.apellido,
        email:this.email,
        password:this.password
      };
      //no vale el web service o algo :(
    this.http.post('http://localhost:8080/FinalEXPO/rest/Aspiranteservicios/insert' , data).subscribe((result:any)=>{
      this.navCtrl.push(WelcomePage);
      console.log(result.json());
      resolve(result.json());
    },(error)=>{
      
      console.log(error.json());
      reject(error.json());
    })
  });
}
}
