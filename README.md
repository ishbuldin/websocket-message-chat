# websocket-message-chat
Проект написан с помощью Spring-Boot, данные хранятся во встроенной БД H2 (in memory mode)

Собирать проект с помощью /other/apache-maven-3.6.0
Из командной строки в корне проекта:
	mvn clean package
	
В папке /other/ собранный проект со всеми зависимостями websocket-message-chat-0.0.1
Разрешены пользователи:
```
	Andrey = true
	Sergey = true
	Petr = true
	Semen = true
```

Необходима установленная JRE 1.8+
Запуск из командной строки:
```
	java -jar websocket-message-chat-0.0.1
```
	
Зайти в чат можно по порту 8080 (localhost:8080)

Можно получить сообщения через api:
```
	localhost:8080/api/all
	localhost:8080/api/{sender}
```