import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions, Response, ResponseContentType} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {DotfuscatorInfo} from "../../dto/DotfuscatorInfo.model";
import {ApprovalResponse} from "../../dto/approval.response.model";
import {SlackBotInfo} from "../../dto/slack-bot-info.model";
import {SlackMessage} from "../../dto/slack-message.model";

@Injectable()
export class SalckService {

  constructor(private http: Http) {
  }


  setSlackBotInfo(slackBotInfo:SlackBotInfo):Observable<boolean> {
    let url = `/esslack/message/create`;

    let headers = new Headers({'Content-Type': 'application/json'}); // ... Set content type to JSON
    let options = new RequestOptions({headers: headers});

    return this.http.post(url, JSON.stringify(slackBotInfo), options)
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  getSlackBotInfo(): Observable<SlackBotInfo[]> {

    let url = `/esslack/message`;
    return this.http.get(url)
      .map(this.extractData)
      .catch(this.handleError);
  }

  sendMessage(testMessage: string):Observable<string> {

    let slackMessage = new SlackMessage();
    slackMessage.message = testMessage

    let headers = new Headers({'Content-Type': 'application/json'}); // ... Set content type to JSON
    let options = new RequestOptions({headers: headers});

    let url = `/esslack/message`;
    return this.http.post(url, JSON.stringify(slackMessage), options)
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }
  /*
  sendSlackMessage(): Observable<string> {

  }
  */

  private extractData(res: Response) {
    let body = res.json();
    return body || {};
  }

  private handleError(error: Response | any) {
    // In a real world app, we might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }


}

