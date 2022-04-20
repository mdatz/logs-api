# Openhouse.ai Interview Challenge - [Backend Developer]
This is a repository for an interview challenge question at Openhouse.ai.

## Architecture Overview
This application uses the Java Spring Boot framework as a RESTful API, MongoDB hosted on MongoDB Atlas for log storage, and Heroku as a quick and easy cloud provider for our API.

<p align="center">
  <img width="600" src="https://user-images.githubusercontent.com/26133178/164140847-139dc4c9-00fd-4b6e-a32c-771a104d5b7b.png">
</p>

## REST API

The REST API to the example app is described below.

## Get list of logs

### Request

`GET /logs/`

    curl -i -H 'Accept: application/json' http://localhost:7000/logs?users=ABC123XYZ,XYZ123ABC&types=CLICK

#### Query Filter Parameters
- users: [Array of User Id's] - This parameter will filter out the results to only contain logs from the specified user array (Optional)
- types: [Array of Type's] - This parameter will filter out the results to only contain logs of the matching type (Optional)
- start: Date (YYYY-MM-DD) - This parameter will filter the results to contain logs AFTER the specified start date (Optional)
- end: Date (YYYY-MM-DD) - This  parameter will filter the results to contain logs BEFORE the specified start date (Optional)

### Response

[
  {
    "id": "625f2b756d0820fdd7b9e3d3",
    "userId": "ABC123XYZ",
    "sessionId": "XYZ456ABC",
    "actions": [
      {
        "time": "2018-10-18T21:37:28-06:00",
        "type": "CLICK",
        "properties": {
          "locationX": 52,
          "locationY": 11
        }
      }
    ]
  },
  {
    "id": "625f5ab26d0820fdd7b9e3d5",
    "userId": "XYZ123ABC",
    "sessionId": "789XYZ123",
    "actions": [
      {
        "time": "2018-10-20T21:37:28-06:00",
        "type": "CLICK",
        "properties": {
          "locationX": 120,
          "locationY": 40
        }
      }
    ]
  }
]

## Create a new log

### Request

`POST /logs/[sessionId]/[userId]`

    curl -i -H 'Accept: application/json' -d 'time=2018-10-18T21:37:30-06:00&type=VIEW&properties={viewedId: "FDJKLHSLD"}' http://localhost:7000/logs/XYZ456ABC

### Response

    HTTP/1.1 201 Created
    Date: Thu, 24 Feb 2011 12:36:30 GMT
    Status: 201 Created
    Connection: close
    Content-Type: application/json
    Location: /thing/1
    Content-Length: 36

    {"result": "success"}
