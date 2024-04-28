# Spring Boot Application README

## Configuration:

- **Tomcat port**: 8081
- **IDE used**: Eclipse for Web
- **App name**: History_local
- **Description**: This is the server side section of the project, added authentication, data base connectivity and combined all functionalities from previous assignments into one project
- **Corresponding Web Project**: Full_front_local





**How to run:

-First unzip all folders (they contain source code for both front and backend projects .

-Make sure a MySQL platform or service is installed on you machine.


-Run Spring boot project using mvn spring-boot:run from the app directory (configured to 8081).



-Run Tomcat Manager at default port configuration (8080), deploy the ROOT.war file and access the front end via the app deployed on the root specifier: "/"


You can check the SQL scripts in the resources folder, programmed to run on initialization of Spring boot app (DDL and DML clean install)

-You can try to access all of the different functionalities using the following account:
username: nancy.levant@info.org
password: password

This is an ADMIN account, all website features are available for this website.

Aditional accounts to test role permissions:
(USER)
howard.egypt@info.org   
password1

(WRITER)
joch.levant@info.org
password


the difference between these users is what type of access each has to different pages from the menu, if one attempts to access a page by typing in the URL directly, they will be redirected to te home page if they do not have sufficient priviliges. permissions are also managed by browser stored user token info and by security configuration in the spring app (endpoints regulated by role access).


Create New Articles from the New Article tab on the nav menu:

    Enter enough data in each field (requirement shown in placeholders).
    Each field has an input method.
    Tags are to be added as such (#tag1 #tag2 etc.).
    It's a good idea to pick a small value for user_id (1-4).
Please note that sometimes that input does not always submit successfully, this is due to the database refusing to connect on first submission,
to bypass this, reload the page, and reenter a different value for UserId (I tested it out, it's a connection issue with the DB)

Other functionalities:
all GET requests from Assignment 3 have been carried over to these files, you can access user records and article records independently, or use the Accordion list to display article-user relationships.


