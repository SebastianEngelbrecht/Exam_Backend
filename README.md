
*This project is meant as start code for projects and exercises given in Flow-1+2 (+3 using the security-branch) at http://cphbusiness.dk in the Study Program "AP degree in Computer Science"*

*Projects which are expected to use this start-code are projects that require all, or most of the following technologies:*
 - *JPA and REST*
- *Testing, including database test*
- *Testing, including tests of REST-API's*
- *CI and CONTINUOUS DELIVERY*

## Flow 2 week 1

### Preconditions
*In order to use this code, you should have a local developer setup + a "matching" droplet on Digital Ocean as described in the 3. semester guidelines* 

### Getting Started

This document explains how to use this code (build, test and deploy), locally with maven, and remotely with maven controlled by Github actions
 - [How to use](https://docs.google.com/document/d/1rymrRWF3VVR7ujo3k3sSGD_27q73meGeiMYtmUtYt6c/edit?usp=sharing)

### JPA snippets

### Setup in Intellij
- open view->too windows->persistence
- open the Database tab and create a new data source (remember to point to a database event though this is already written in the persistence unit. This is necessary in order to use the JPQL console)
- in the persistence window right click the pu or an entity and choose "console"
- write a jpql query in the console and execute it.
### In netbeans it is much simpler
- just right click the pu and choose: "Run JPQL query"

### Create model in workbench (cannot be done from Intellij - No model designer yet)
- file-> new model
- dobbelclick the mydb icon and change to relevant database (create one first if needed)
- click the Add Diagram icon
- click the table icon in the left side panel and click in the squared area to insert new table
- dobbelclick the new table and change name and add columns (remember to add a check mark in 'ai' for the primary key)
- do the process again to add a second table
- now in the panel choose the 'non identifying relationship' on to many
- click first on the child table (the one that should hold the foreign key) and then on the parent. A new relationship was now added.
- When done with designing - goto top menu: Database->forward engineer.
  - Check that all settings looks right and click continue
  - click continue again (no changes needed here)
  - Make sure the 'Export mysql table objects' is checked and Show filter to make sure that all your tables are in the 'objects to process' window -> click continue
  - Verify that the generated script looks right -> click continue
  - click close and open the database to see the new tables, that was just created.

### create entities from database in Intellij (Persistence mappings)
- From inside the Persistence window:
- Right-click a persistence unit, point to Generate Persistence Mapping and select By Database Schema.
- Select the 
  - data source 
  - package
  - tick tables to include
  - open tables to see columns and add the ones with mapped type: Collection<SomeEntity> and SomeEntity
  - click OK.

### In netbeans it is much easier
- Right click project name -> new -> persistence -> Entity classes From Database -> choose database connection from list -> add the tables you need -> Finish



CREATE & COPY GITHUB REPOSITORY

1. First go to Github.com, sign up and create a Repository. Then search and find the backend repository of the project.

2. When you have chosen the repo, click on Code (green button), and then copy the link.

3. Open up your terminal and navigate to your own repo. You can do this with the command “ls” or “ls -a” to be more specific. Then you “cd ‘folder name’”. You have now chosen this folder and you can now move on.

4. The URL you copied on GitHub can now be used with this command “git clone ‘URL’ ”. Now you copy the entire repo into your own repository.

DOWNLOADS.

1. You have to install JAVA on your device.

2. You have to install either IntelliJ or Netbeans on your device.

3. You have to install a JDK on your device.

4. You have to install Tomcat on your device.

5. You have to install mySQL workbench on your device.

6. You have to install Docker on your device

7. You have to install Visual studio code on your device.

8. You have to install Nginx.


OPEN PROJECT AND CREATE DATABASE.

1. Open up your project in IntelliJ.

2. Change the Config. To Tomcat.

3. Create a database for the project
1.	4. In the persistence.xml file change the persistence-unit “pu” to use the new database.
2.	5. Create the database and tables, using the create strategy in the persistence-file.
3.	6.  Clean and build the project.

7.  Run the project by pressing the green run button.

FRONT END PART

1. Choose the frontend repo and copy the url.

2. Create a folder and open a terminal in the folder.

3. Run the command git clone “URL”.

4. In the terminal navigate to your new folder and cd into the folder.

5. Then type the command “code .” .

6. To open the project in a browser you can open a new terminal in your new folder and run the command “npm start”. 



# Sem3Backend
