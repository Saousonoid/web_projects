USE `assign_3`;
SET FOREIGN_KEY_CHECKS = 0;



--
-- Data for table `articles`
--

INSERT INTO articles (ID, TITLE, BODY, TAGS, USER_ID, WEBPAGE_ID, CREATE_DATE) 
VALUES 	(3,'The Mysteries of Ancient Egypt','The ancient civilization of Egypt continues to intrigue historians and archaeologists...','Egypt, History, Archaeology',1,3,'2024-03-17 02:52:15'),
		(4,'Uncovering the Secrets of Mesopotamia','Mesopotamia, often referred to as the cradle of civilization, holds numerous secrets...','Mesopotamia, History, Archaeology',2,2,'2024-03-17 02:52:15'),
		(5,'The Legacy of Ancient Greece','Ancient Greece has left an indelible mark on modern civilization with its contributions to philosophy, art, and governance...','Greece, History, Philosophy, Art',5,1,'2024-03-17 02:52:15'),
		(6,'The Wonders of the Inca Empire','The Inca Empire in South America thrived for centuries, leaving behind remarkable architectural marvels...','Inca, South America, History, Architecture',6,4,'2024-03-17 02:52:15'),
		(7,'Exploring the Ancient Civilization of China','China boasts a rich history dating back thousands of years, characterized by remarkable achievements...','China, History, Culture, Civilization',1,2,'2024-03-17 02:52:15'),
		(8,'BLA BLA BLA BAL','PAL LPLA HANNI AS LA NE BAAL MERI MAON PAL LPLA HANNI AS LA NE BAAL MERI MAON PAL LPLA HANNI AS LA NE BAAL MERI MAON ','#Schools #uni',5,2,'2024-03-29 01:17:14'),
		(9,'ZAME MANU EOL likanba ZAME MANU EOL likanba',' ZAME MANU EOL likanba ZAME MANU EOL likanbaZAME MANU EOL likanba ZAME MANU EOL likanba ZAME MANU EOL likanba ZAME MANU EOL likanba','#TAG1 #TAG2 #TAG3 #TAG99',2,3,'2024-04-03 01:36:36'),
		(10,'History in the Future','Understanding history is crucial for comprehending the present and shaping the future. It provides context, insights, and lessons that help societies navigate challenges and progress toward a better future.','#Futurism #Historical_Method',5,2,'2024-04-03 05:19:16'),
		(11,'Doubts About Certain Events Througout History','The recording of historical events often sparks controversy due to biases, omissions, and differing perspectives. These debates highlight the complexity of history and the importance of critical analysis.','#Skepticism #Minimalism #Positivism',6,4,'2024-04-03 05:23:29');

--
-- Data for table `roles`
--

INSERT INTO roles (ID, NAME, DESCRIPTION) 
VALUES  (1,'USER','Basic Access to login, articles'),
		(2,'ADMIN','Has access to all pages'),
		(3,'WRITER','Document and publish articles that cover late antiquity'),
		(4,'PREMIUM','Publish any type of article'),
		(5,'COMMENTATOR','Provide Voice-Overs and Narration to articles');


--
-- Data for table `users`
--

INSERT INTO users (ID, FNAME, LNAME, USERNAME, EMAIL, PASSWORD, PHONE, ROLE_ID, CREATE_DATE) 
VALUES  (1,'Howard','Carter','the_how_carter','howard.egypt@info.org','password1','9423423434',1,'2024-04-03 04:11:08'),
		(2,'Nancy','Johnnes','nan_jo','nancy.levant@info.org','password','53418310203',2,'2024-04-03 04:11:25'),
		(5,'Jochebed','Dimir','joch_avad','joch.levant@info.org','password','234293365343',3,'2024-04-03 04:12:06'),
		(6,'Ergan','Urguluz','ergo_sum','ergan.trukiye@info.org','password','',4,'2024-03-12 13:54:06'),
		(7,'Alice','Johnson','alicej','alicej@example.com','password123','1234567890',1,'2024-03-20 03:00:32'),
		(8,'Bob','Smith','bobs','bobs@example.com','password456','0987654321',2,'2024-03-20 03:00:32'),
		(9,'Charlie','Anderson','charliea','charliea@example.com','password789','9876543210',1,'2024-03-20 03:00:32'),
		(10,'Ella','Wilson','ellaw','ellaw@example.com','passwordabc','1230987654',2,'2024-03-20 03:00:32'),
		(11,'Frank','Davis','frankd','frankd@example.com','passwordxyz','4561237890',1,'2024-03-20 03:00:32'),
		(12,'Susan','Noaul','RosanaSa','alrosana@info.org','Password123@','+6423456734',4,'2024-04-03 02:49:14');

--
-- Data for table `webpages`
--

INSERT INTO webpages (ID, NAME, ARTICLE_CO, MOD_DATE) 
VALUES  (1,'Articles',0000000004,'2024-03-19 13:41:13'),
		(2,'History of The Near East',0000000002,'2024-03-19 13:41:13'),
		(3,'Development of Language',0000000001,'2024-03-19 13:41:13'),
		(4,'UNESCO World Heritage Sites',0000000000,'2024-03-19 13:41:13'),
		(5,'Current Issues',0000000004,'2024-03-27 03:02:08');
SET FOREIGN_KEY_CHECKS = 1;

