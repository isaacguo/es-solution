import {Component, OnInit} from '@angular/core';
import {SalckService} from "../../../services/business/slack.service";
import {SlackBotInfo} from "../../../dto/slack-bot-info.model";

@Component({
  selector: 'app-slack',
  templateUrl: './slack.component.html',
  styleUrls: ['./slack.component.css']
})
export class SlackComponent implements OnInit {

  constructor(private slackService: SalckService) {
  }

  private slackbotInfo: SlackBotInfo=[];
  private testMessage:string;

  ngOnInit() {
    this.getSlackBotInfo();
  }

  getSlackBotInfo() {
    this.slackService.getSlackBotInfo().subscribe(r=>{
      this.slackbotInfo=r[0];
      console.log(r);
    })
  }

  sendMessage()
  {
    this.slackService.sendMessage(this.testMessage).subscribe(r=>{
    });
  }


}
