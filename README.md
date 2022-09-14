# transactional-springboot
** In this project describe how to use transactional in spring boot **
How to implement transactional in spring-boot
Prerequisite
1. You understand the concept of transactions in jdbc and have tried using transactions in jdbc
2. understand ACID Properties in DBMS
3. Familiar create spring boot from scratch
4. familiar config spring boot app with database postgresql or mysql
5. understand how to use post man for testing API

what the mean transaction?
- A transaction is a set of one or more statements that is executed as a unit, so either all of the statements are executed, or none of the statements is executed.

In this tutorial, I will use a scenario when new user registers to company website
A. SAVE JOB NAME USER
	1. user input important data (first name, last name, age, email, phone , job name)
	2. check the job name, if already exist update the job name. if not exist save the new job name that the user sends through the request
B. SAVE USER
	1. validation, not null(first name, last name, email, phone, job name)
	2. validation if age >=18
	3. check if the email, or phone number not exists
	4. if all validation succeeds save the user
	5. if validation failed all statements already runed rollback

noted:SAVE JOB NAME and SAVE USER AS A UNIT


Let's jump right in
1. my pom.xml
3. my packages
4. create entity User
5. create entity Job
6. create User repository
7. create JobRepository
7. create Registration
9. create ErrorMessage
10. create ResourceNotSatisfiable
11. ResourceEmptyException
12. ResourceAlreadyExistException
13. GlobalErrorHandler
14. Create user Services
15. create Job services
16. create Registration service
17. create Registration Controller
18. try to test app without transaction
we expected when validation failed all statement already runed rollback
- check table job(statement not rollback)
19. try to run with annotation transactional

Noted : spring automatic rollback on runtimeexception or no nedd rollbackFor property(unchecked exception) and checked exception need rollbackFor property

succeed happy learning and happy sharing!!!
