# Victor's Journal
## Week 1 Adding MySQL 10/31/2021 - 11/07/2021
NOTE: Reason why the project is named as spring gumball is because the group decided to utilize spring-gumball-v2 as the backbone for the project and not v3 since none of us implemented v3 correctly so it didn't contain a working MySQL. So my task for the first week was to figure out how to implement it.

Worked on getting MySQL to run on our project. Link [MySQL](https://github.com/nguyensjsu/fa21-172-rvn/projects/1#card-72179787) card
![images](https://github.com/nguyensjsu/fa21-172-rvn/blob/main/Journals/images/vm1.png)

### Challenges:
![images](https://github.com/nguyensjsu/fa21-172-rvn/blob/main/Journals/images/vm2.png)
Close to getting it to work but I've been facing multiple issues with the connection.
There couldn't be any connection because it keeps saying that the datasource 'url' isn't specified even though it's specified in application.properties. The other MySQL lab works fine, spring-mysql, I can get it connected to MySQL and everything works how it's supposed to but when it comes to implementing it to our project we get this error.

### Accomplishments:
Later that day I got it to work!
Looks like the code I had was corrupted? So I created a new project and added the same classes. Made sure everything was the same but it was a new project being built. With that everything seemed to be resolved, had no more connection problems with it.

Link to my [commits](https://github.com/nguyensjsu/fa21-172-rvn/commit/b9b0570e1b30b193d5a6d690436c4ef4c0645857) for when I uploaded the implementated version of MySQL

![images](https://github.com/nguyensjsu/fa21-172-rvn/blob/main/Journals/images/vm3.png)
- Image of MySQL being implemented onto our project.

Week 1 done and MySQL has been implemented to our project, now we just have to figure out which tables to create.
![images](https://github.com/nguyensjsu/fa21-172-rvn/blob/main/Journals/images/vm4.png)
- MySQL is implemented

## Week 2 Adding Cybersource/Payment 11/15/2021 - 11/21/2021

Worked on adding Cybersource/Payment to our project. Link [Cybersource/Payments](https://github.com/nguyensjsu/fa21-172-rvn/projects/1#card-72179587) card
![images](https://github.com/nguyensjsu/fa21-172-rvn/blob/main/Journals/images/vm5.png)


### Challenges:
- The only challenge I had while trying to integrate cybersouce/payments to our project was figuring out how to connect it with MYSQL. I solved it by just adding mysql dependencies and everythink worked, just had to change h2database to mysql database and made sure the files lined up to work with eachother.


### Accomplishments:
![images](https://github.com/nguyensjsu/fa21-172-rvn/blob/main/Journals/images/vm7.png)
- Got payments running on our project

![images](https://github.com/nguyensjsu/fa21-172-rvn/blob/main/Journals/images/vm8.png)
- With mysql working with it as well

Week 2 done with Payments/Cybersource now being implemented to our project, fully functioning with MySQL.
![images](https://github.com/nguyensjsu/fa21-172-rvn/blob/main/Journals/images/vm6.png)

