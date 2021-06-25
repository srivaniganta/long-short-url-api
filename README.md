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
    "shortUrl": "https://yt.be/P7CG"
}

**Long Redirect URL API  
**

Endpoint : hhttp://localhost:8080/api/v1/long-url?shortUrl=https://yt.be/P7CG
Method : GET

Response : {

//view source of redirect url 

}
