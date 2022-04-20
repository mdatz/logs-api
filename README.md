# Openhouse.ai Interview Challenge - [Backend Developer]
This is a repository for an interview challenge question at Openhouse.ai.

## Architecture Overview
This application uses the Java Spring Boot framework as a RESTful API, MongoDB hosted on MongoDB Atlas for log storage, and Heroku as a quick and easy cloud provider for our API.

<p align="center">
  <img width="600" src="https://user-images.githubusercontent.com/26133178/164140847-139dc4c9-00fd-4b6e-a32c-771a104d5b7b.png">
</p>

# REST API

The REST API and it's available calls are described below.

## Get a filtered list of logs

### Request

`GET /logs/`

    curl -i -H 'Accept: application/json' http://localhost:7000/logs?users=ABC123XYZ,XYZ123ABC&types=CLICK

#### Query Filter Parameters

- <b>users</b>: [Array of User Id's] - This parameter will filter out the results to only contain logs from the specified user array (Optional)
- <b>types</b>: [Array of Type's] - This parameter will filter out the results to only contain logs of the matching type (Optional)
- <b>start</b>: Date (YYYY-MM-DD) - This parameter will filter the results to contain logs AFTER the specified start date (Optional)
- <b>end</b>: Date (YYYY-MM-DD) - This  parameter will filter the results to contain logs BEFORE the specified start date (Optional)

### Response

```json
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
```


## Create a new log action

### Request

`POST /logs/[sessionId]/[userId]`

    curl -i -H 'Accept: application/json' -d 'time=2018-10-18T21:37:30-06:00&type=VIEW&properties={viewedId: "FDJKLHSLD"}' http://localhost:7000/logs/XYZ456ABC

### Response

```json
{"result": "success"}
```
    
