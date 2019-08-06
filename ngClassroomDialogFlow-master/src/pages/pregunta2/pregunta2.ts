import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the Pregunta2Page page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-pregunta2',
  templateUrl: 'pregunta2.html',
})
export class Pregunta2Page {
  unNumeroRecibido: number; 

  constructor(public navCtrl: NavController, public navParams: NavParams) {
    this.unNumeroRecibido = navParams.get("unNumero");
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad Pregunta2Page');
  } 
  pregunta3 = "Pregunta3Page";
  a: boolean;
  b:boolean;
  c:boolean;
  d:boolean;
  
 
  updatea() {
    console.log('Nuevo estado:' + this.a);
    
    
  }
  updateb() {
    console.log('Nuevo estado:' + this.b);
  
  }
  updatec() {
    console.log('Nuevo estado:' + this.c);
    
  }
  updates() {
    console.log('Nuevo estado:' + this.d);
   
  }

}
