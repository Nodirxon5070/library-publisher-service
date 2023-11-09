package com.company.publisherservice.constants;


public class Constants {

    public static final String EXAMPLE_PUBLISHER_SUCCESS = """
            {
                 "success":"true",
                 "code":"0",
                 "message":"OK",
                 "data": {
                    "loadId": "Value ...",
                    "customerId": "Value ...",
                    "amount": "Value ...",
                    "status": "Value ..."
                 }
            }
            """;


    public static final String EXAMPLE_PUBLISHER_NOT_FOUND = """
            {
                 "success":"false",
                 "code":"-1",
                 "message":"Publisher with  :: id is not found"
            }
            """;



}


