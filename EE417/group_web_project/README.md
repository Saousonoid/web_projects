**README: Deploying EE417 Group K Assignment on Amazon EC2**

This guide will walk you through the process of deploying the EE417 Group K Assignment web application on an Amazon EC2 server. Before you begin, make sure you have an EC2 instance set up and running.

### Prerequisites
1. An Amazon EC2 instance with Java and Apache Tomcat installed.
2. Access to the instance via SSH.
3. The WAR file named `EE417 Group K Assignment.war`.
4. Database schema file `schema.sql`.
5. Database data backup file `data.sql`.

### Step 1: Upload Required Files to Your EC2 Instance
Use `scp` to securely copy the required files to your EC2 instance:

```bash
scp -i your-key.pem "EE417 Group K Assignment.war" ec2-user@your-ec2-instance-public-ip:/path/to/your/
scp -i your-key.pem "schema.sql" ec2-user@your-ec2-instance-public-ip:/path/to/your/
scp -i your-key.pem "data.sql" ec2-user@your-ec2-instance-public-ip:/path/to/your/
```

### Step 2: Connect to Your EC2 Instance
Use SSH to connect to your EC2 instance:

```bash
ssh -i your-key.pem ec2-user@your-ec2-instance-public-ip
```

### Step 3: Install and Configure Apache Tomcat
If Apache Tomcat is not installed, follow the steps below:

```bash
sudo yum install tomcat
```

Configure Tomcat to run on port 80 if needed.

### Step 4: Deploy the Web Application
1. Navigate to the Tomcat webapps directory:

```bash
cd /usr/share/tomcat/webapps
```

2. Replace the existing `ROOT` folder with your WAR file. Rename your WAR file to `ROOT.war`:

```bash
sudo rm -rf ROOT
sudo rm -f ROOT.war
sudo mv /path/to/your/ROOT.war .
```

### Step 5: Create the Database
1. Connect to your MySQL database:

```bash
mysql -u root -p
```

(change username and password accordingly)

2. Create the database and import the schema:

```sql
CREATE DATABASE catering;
USE catering;
source /path/to/your/schema.sql;
```

3. Import the data:

```sql
source /path/to/your/data.sql;
```

### Step 6: Configure the Database Connection
Update the database connection details in the web application configuration file (`application.properties`) to point to the Amazon RDS database.

### Step 7: Restart Apache Tomcat
Restart Tomcat to apply the changes:

```bash
sudo systemctl restart tomcat
```

### Step 8: Access the Web Application
Open a web browser and navigate to your EC2 instance's public IP address. You should see the deployed web application running successfully.

That's it! EE417 Group K Assignment web application is now deployed and running on your Amazon EC2 server. If you encounter any issues, please refer to the logs in Tomcat's `logs` directory for troubleshooting.