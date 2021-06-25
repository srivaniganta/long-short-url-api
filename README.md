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

**DB Table changes : 
**
1) create Sequence : 

CREATE SEQUENCE public.seq_unique_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 10000000;
  
2) Insert Domain table values
  
insert into domain(full_domain,short_domain) values('www.youtube.com','https://yt.be/');
insert into domain(full_domain,short_domain) values('www.google.com','https://gg.te/');

