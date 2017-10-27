import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions, Response, ResponseContentType} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {DotfuscatorInfo} from "../../dto/DotfuscatorInfo.model";
import {ApprovalResponse} from "../../dto/approval.response.model";

@Injectable()
export class ObfuscationRequestService {

  constructor(private http: Http) {
  }

  sendRequest(formValue:any):Observable<ApprovalResponse>
  {
    let headers = new Headers({'Content-Type': 'application/json'}); // ... Set content type to JSON
    let options = new RequestOptions({headers: headers});

    let url=`/esrequestobfuscation/request`;
    return this.http.post(url,JSON.stringify(formValue), options)
      .map((res: Response) => res.json()) // ...and calling .json() on the response to return data
      .catch((error: any) => Observable.throw(error.json().error || 'Server error')); //...errors if any
  }

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
