import { Component, ViewChild } from '@angular/core';//importamos ViewChild para referenciar el contenido de la vista
import { NavController, Content } from 'ionic-angular';//importanmos content para controlar el deslizamiento al pie de página
import { ApiAiClient, ApiAiConstants } from 'api-ai-javascript';
ApiAiConstants.DEFAULT_CLIENT_LANG = ApiAiConstants.AVAILABLE_LANGUAGES.EN; //Aqui controlamos el lenguaje para comunicarnos con el agente

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  @ViewChild(Content) content: Content;
  /**
   * Clase encargada del chatbot
   */
  client;
  accessToken = '5a72253a28f84ad682aba460ae430d86'; //esta es la llave que nos otroga DialogFlow

  user_textToSend: string; //contiene lo qu el usuario escriba
  messageHistory: any[] = []; //aqui se almacenan los objetos con los mensajes que se pintan en pantalla

  constructor(public navCtrl: NavController) {

    //establecemos la comunicación
    this.client = new ApiAiClient({
      accessToken: this.accessToken
    });

  }//fin constructor

  //enviar mensaje al agente
  sendMessage() {

    //creamos un objeto con un nuevo mensaje
    let newMessage_user = {
      fromUser: true, //en true es un mensaje del usuario
      text: this.user_textToSend
    }
    this.user_textToSend = ''; //limpiamos la caja de texto en la que el usuario escribe

    this.messageHistory.push(newMessage_user); //adiciona lo que el usuario escriba al array de mensajes para que se muestre en pantalla
    this.scrollToBottom();//se desliza hacia el pie de página para que se vea el ultimo mensaje

    //hace envia la petición post al agente
    this.client.textRequest(newMessage_user.text).then(response => {

        let newMessage_bot = {
          fromUser: false, //en false es un mensaje del agente
          text: response.result.fulfillment.speech //contiene el texto que devuelve el agente
        }

        this.messageHistory.push(newMessage_bot); //adiciona lo que el agente escriba al array de mensajes para que se muestre en pantalla
        this.scrollToBottom();//se desliza hacia el pie de página para que se vea el ultimo mensaje

      }).catch(error => {
        //algo salió mal
        this.user_textToSend = ''; //limpiamos la caja de texto en la que el usuario escribe
        console.log(error); //se imprime en consola el error
      });

  }//fin sendMessage

  //desliza la vista al pie de página
  scrollToBottom() {
    setTimeout(() => {
      this.content.scrollToBottom();
    }, 100);
  }//fin scrollToBottom

}//fin clase
