# long-short-url-api

Heare the API details 

**Shortern URL API : 
**

Method : POST
ENDPOINT : http://localhost:8080/api/v1/short-url
Request Body : 
{
    "fullUrl":"https://www.youtube.com/watch?v=wLzn1w8vgM4"
}
Response Body : 
{
    "shortUrl": "P"
}

**Long Redirect URL API  
**

Endpoint : http://localhost:8080/api/v1/{shortUrl}
Method : GET

Response : {

//view source of redirect url 

}
