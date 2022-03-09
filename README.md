# income-service

## About The Project

### Terms
1. A regular amount consists of a frequency and amount. Regular amounts are used to collect the value of regular payments or income for a citizen.
2. A frequency defines a regular interval at which a payment is made or income received.
   Frequency may be one of:
    -   WEEK
    -   TWO_WEEK
    -   FOUR_WEEK
    -   MONTH
    -   QUARTER
    -   YEAR
3. An amount contains a value of pounds and pence entered as a String with an optional decimal point. Assume that amount is being validated by a
   different JSR-303 annotation.

### Requirements
1. Create a JSR-303 annotation and associated ConstraintValidator
2. Annotation must validate a regular amount instance:
    - If frequency is a multiple of a week, monetary amount must be divisible to a weekly value that is a whole number of pence.
3. The annotation should not require knowledge of the specific value to be entered, only that it may be divided exactly to a weekly value,
   when entered at a multiple of one week frequency.


## Running the application locally

- Download the zip or clone the Git repository. Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml and run the command to
  install all the dependencies

```
mvn clean install
```


To run in local

``` 
mvn clean spring-boot:run
```

After this you can access the application from following url:
POST http://localhost:8000/api/v1/income

Request Body:
{
"frequency": "QUARTER",
"amount": "100"
}

Success Response: 200 OK
"Success"

Error Response: 400 Bad Request
{
"errors": [
{
"code": "BAD_REQUEST",
"message": "Invalid Amount! Not a whole number."
}
]
}