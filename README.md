Инструкция по сборке и запуску приложения

Для сборки приложения необходимо установить:
1)Java Development Kit 
2) Maven

Для полноценного функционирования java-приложений необходимо указать системе пути
к каждому из установленных компонентов.

Для Windows:
В системной переменной Path следует указать путь к программам Java и Maven (к папкам bin).

Запуск можно произвести разными способами:

1.  Используя IDE (на примере IntellijIdea)
    Выбрать в меню Run-> run Application
    
2.  Из консоли как jar архив

    Перейти в папку проекта.
    Создать jar архив и запустить приложение используя java -jar , как показано
    на примере ниже
    $ java -jar target/move-count-1.jar
    
3.  Используя Maven Plugin из консоли

    Как только Вы установили spring-boot-starter-parent в pom.xml
    у вас есть команда run которую вы можете использовать для старта приложения.
    Spring Boot Maven Plugin включает в себя команду "run", которая быстро 
    компилирует и выполняет приложение. Приложения выполняются также как на IDE.
    
    Необходимо открыть консоль в папке проекта и выполнить команду
    $ mvn spring-boot:run

    Для выхода из приложения наберите ctrl-c
    
        



