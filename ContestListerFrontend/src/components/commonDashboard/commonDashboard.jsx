import React, { Component } from 'react'
import DataGrid, { Scrolling, Pager, Paging, SearchPanel } from 'devextreme-react/data-grid';
import { convertDuration } from '../../services/utilityService';
import "./commonDashboard.css";
import moment from 'moment';
import calenderLogo from'../../assets/icons/calendar.png';
import timerLogo from'../../assets/icons/timer.png';

class CommonDashboard extends Component {
  
  handleOnCellClick(row){
    let gapi = window.gapi
    const CLIENT_ID = "675902373402-56fnj4jgce8p5h4uq0oibffu5uc6jatp.apps.googleusercontent.com"
    const API_KEY = "AIzaSyA7xdPQp5cLwD1GyfvcvdpRsl6iO4aWXrA"
    const DISCOVERY_DOCS = ["https://www.googleapis.com/discovery/v1/apis/calendar/v3/rest"]
    const SCOPES = "https://www.googleapis.com/auth/calendar.events"
    const {data,column} = row;
    const {onGoing,name,platform,startTime,endTime} = data;
    if(column.index===11&&!onGoing){
      gapi.load('client:auth2', () => {
        gapi.client.init({
          apiKey: API_KEY,
          clientId: CLIENT_ID,
          discoveryDocs: DISCOVERY_DOCS,
          scope: SCOPES,
          plugin_name:process.env.REACT_APP_GOOGLE_PLUGIN_NAME,
        })
        gapi.client.load('calendar', 'v3', () => console.log('Popup'))
        gapi.auth2.getAuthInstance().signIn()
        .then(() => {
          var event = {
            'summary': name,
            'location': platform,
            'start': {
              'dateTime': startTime,
            },
            'end': {
              'dateTime': endTime,
            },
            "visibility": "public"
          }
          var request = gapi.client.calendar.events.insert({
            'calendarId': 'primary',
            'resource': event,
          })
          request.execute(event => {
            window.open(event.htmlLink)
          })
        })
      })
    }
  }
  customizeColumns(columns) {
    if(!columns[0]) return;
    // [0,7,8,9,10].forEach(element=>columns[element].visible=false);
    [0,7,8,9,10].forEach(element => {
      if (columns[element]) {  // Check if the column exists
          columns[element].visible = false;  // Set the visible property if the column is defined
      }
      else{
        console.log(element);
      }
  });
    columns[2].width = 100;

    columns[3].encodeHtml=false;
    columns[3].calculateDisplayValue= rowdata=>`<a href="${rowdata.url}" target="_blank">${rowdata.url}</a>`;

    columns[4].width = 130;
    columns[4].calculateDisplayValue=rowdata=> convertDuration(rowdata.duration); 
    columns[4].allowSorting = false;
    columns[4].alignment="left";

    columns[4].width = 200;
    columns[4].calculateDisplayValue= rowdata=> moment(rowdata.startTime).format('lll');

    columns[5].width = 200;
    columns[5].calculateDisplayValue= rowdata=> moment(rowdata.endTime).format('lll');


    // columns[6].width = 200;
    // columns[6].calculateDisplayValue= rowdata=> moment(rowdata.endTime).format('YYYY-MM-DD HH:mm');

      // columns[11]={
      //   encodeHtml:false,
      //   dataField:"Add to Calender",
      //   width:130,
      //   calculateDisplayValue : rowdata=>{
      //     return `<img id=calender src= ${rowdata.onGoing?timerLogo:calenderLogo}></img>
      //     <div class=tooltip>   
      //       <span class=tooltiptext>${rowdata.onGoing?"Ongoing Contest":"Add to calender"}</span>
      //     </div>`
      //   },
      //   alignment:"center",
      //   allowSorting : false
      // }
  }

  render() { 
    return (<div>
      <h1 className='p-2'>{this.props.section} Schedule</h1>
      <DataGrid
        className='container'
        id='gridContainer'
        dataSource={this.props.data}
        keyExpr="id"
        showBorders={true}
        customizeColumns={this.customizeColumns}
        showColumnLines={true}
        showRowLines={false}
        rowAlternationEnabled={true}
        onCellClick={this.handleOnCellClick}
      >
        <Scrolling ></Scrolling>
        <Paging defaultPageSize={12} />
        <Pager
          visible={true}
          allowedPageSizes={5}
         />
        <SearchPanel visible={true} />
      </DataGrid>
    </div>);
  }
}
 
export default CommonDashboard;