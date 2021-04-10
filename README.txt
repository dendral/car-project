http://localhost:8080/api/query?date=2020-02-02&id=1
http://localhost:8080/api/download

Para enviar los logs a MongoDB se necesita usar una instancia local con configuración por default
Localmente la colección de mongoBD tiene la siguiente estructura
> db.api_calls.find();
{ "_id" : "f03a9a7f-6c75-48d1-93f5-44129882ffaf", "ip" : "1.1.1.1", "date" : ISODate("2021-04-09T23:14:07.257Z"), "service" : "/api/Request", "_class" : "com.dev.center.dao.LogRecord" }
{ "_id" : "4bd9ceb5-c49f-42a9-bf14-5796a2c3a7f3", "ip" : "0:0:0:0:0:0:0:1", "date" : ISODate("2021-04-09T23:38:21.567Z"), "service" : "http://localhost:8080/api/query", "_class" : "com.dev.center.dao.LogRecord" }
{ "_id" : "0a152b07-98fa-448e-a9b9-0e4e3f0c9f33", "ip" : "0:0:0:0:0:0:0:1", "date" : ISODate("2021-04-09T23:42:18.129Z"), "service" : "/api/query?date=2020-02-02&id=1", "_class" : "com.dev.center.dao.LogRecord" }