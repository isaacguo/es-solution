import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions, Response, ResponseContentType} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {DotfuscatorInfo} from "../../dto/DotfuscatorInfo.model";
import {ApprovalResponse} from "../../dto/approval.response.model";
import {SlackBotInfo} from "../../dto/slack-bot-info.model";
import {SlackMessage} from "../../dto/slack-message.model";

@Injectable()
export class GraphiteService {

  constructor(private http: Http) {
  }


  postDataToGraphiteServer()
  {
    let url=`http://localhost:2003`;
    this.http.post("")

  }

}
