import {Component, OnInit} from '@angular/core';
import {SalckService} from "../../../services/business/slack.service";
import {SlackBotInfo} from "../../../dto/slack-bot-info.model";

@Component({
  selector: 'app-slack',
  templateUrl: './slack.component.html',
  styleUrls: ['./slack.component.css']
})
export class SlackComponent implements OnInit {

  isEditing: boolean = false;

  constructor(private slackService: SalckService) {
  }

  slackbotInfo: SlackBotInfo = {};
  testMessage: string;

  ngOnInit() {
    this.getSlackBotInfo();
  }

  getSlackBotInfo() {
    this.slackService.getSlackBotInfo().subscribe(r => {
      if (r.length > 0) {
        this.slackbotInfo = r[0];
        console.log(r);
      }
    })
  }

  sendMessage() {
    this.slackService.sendMessage(this.testMessage).subscribe(r => {
    });
  }

  onEditButtonClicked() {
    console.log("in onEditButtonClicked");
    this.isEditing = !this.isEditing;
    if (!this.isEditing) {
      this.slackService.setSlackBotInfo(this.slackbotInfo).subscribe(r => {
      });
    }
  }

}
