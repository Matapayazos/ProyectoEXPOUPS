import { Component  } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
//import { Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';
import { HttpClient } from '@angular/common/http';

/**
 * Generated class for the WelcomePage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-welcome',
  templateUrl: 'welcome.html',
})
export class WelcomePage  {
  nombre :string =" ";
  items
  resultados: string[];
  myDate: String = new Date().toISOString();
  //dia:number =new Date().getDay();
  //Mes:number =new Date().getMonth();
  //YEAR:number =new Date().getFullYear();
  constructor(public navCtrl: NavController, public navParams: NavParams,public http:HttpClient) {
    this.initializeItems();
  }
  
  ionViewDidLoad() {
    console.log('ionViewDidLoad WelcomePage'); 
  }

  public itemSelected (item: string){
    
    //Falta dar formato para que se listen los eventos :(
    return new Promise((resolve,reject )=>{
      this.http.get('http://localhost:8080/FinalEXPO/rest/Eventoservicios/ObtenerFecha?fecha='+this.myDate) .subscribe ( datos => {
          console.log(datos);
          console.log('entro pero no hay datos ');

      }) , err => {
        console.log ( "Error" + err +this.myDate+'la fecha esta mal ');
      }
    });
    
    }
 

  initializeItems() {
    this.items = ["Cultural", "Social","Educativo","Varios","Extras" ];
  }
  getItems(ev) {
    // Reset items back to all of the items
    this.initializeItems();

    // set val to the value of the ev target
    var val = ev.target.value;

    // if the value is an empty string don't filter the items
  
      if (val && val.trim() != '') {
        this.items = this.items.filter((item) => {
          return (item.toLowerCase().indexOf(val.toLowerCase()) > -1);
        })
      }
    
  }

  

}
