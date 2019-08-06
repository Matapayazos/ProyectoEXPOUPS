import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the Pregunta1Page page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-pregunta1',
  templateUrl: 'pregunta1.html',
})
export class Pregunta1Page {
 
 

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad Pregunta1Page');
  }
  pregunta2 = "Pregunta2Page";
  a: boolean;
  b:boolean;
  c:boolean;
  d:boolean;
  x:number  =0;
  
  updatea() {
    console.log('Nuevo estado:' + this.a); 
  }
  updateb() {
    console.log('Nuevo estado:' + this.b);
  }
  updatec() {
    console.log('Nuevo estado:' + this.c);
  }
  updated() {
    console.log('Nuevo estado:' + this.d);
  }
  paramsParaSegPag = {
    unNumero:30
  };
  
}
