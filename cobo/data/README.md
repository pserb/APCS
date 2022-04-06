# team JIMIN
*\~Ryan Lau\~*\
*\~Melody Lew\~*
*\~Paul Serbanescu\~*\

data sets:

§ http://www.kaggle.com
§ http://www.data.gov
§ https://toolbox.google.com/datasetsearch


To make a JAR available to runtime environment (JRE)...

```
$ javac -classpath .:/path/to/sinbad.jar -d . Driver.java
$ java -classpath.:/path/to/sinbad.jar Driver
```

411 on sinbad
https://berry-cs.github.io/sinbad/install-java

## Activity 1
1. piazza.com and github.com
2. github.com: user information (username and password) and IP address
   piazza.com: registration info (name, email, password) posts, messages, events, and other user-generated content
3. Delimited data is data that fits a format that we deem important. You can delimit data to fit **your** needs
4. The first line tells you what type of data will be in the comment (ex: population, city name, etc.)
5. kpop and sports
6. What is the average increase in streams of a kpop group before an anticipated release of a new song/album?
   What is the height difference between the tallest NBA player and the shortest NBA player in the 2020-21 NBA season?
7. https://www.kaggle.com/datasets/justinas/nba-players-data
   https://www.kaggle.com/datasets/drgilermo/nba-players-stats
   We searched up 'nba players' on kaggle.com
8. https://www.kaggle.com/datasets/justinas/nba-players-data has 11699 records.
   https://www.kaggle.com/datasets/drgilermo/nba-players-stats has 3921 records.
   In larger datasets, trends are more accurate because outliers will have less of an effect.
9. Collecting user data is generally selfish to the website to which the user is on, and for that website it allows for more direted and targeted ads. Generally, bad, but saving usernames and passwords is essential for a functioning webpage, for example.
10. It is not clear where the data in the dataset is collected from. However, the data in our dataset seems to be on the official NBA website so this dataset may have just aggregated the data from the NBA website. 
11. Not at all. Personal data is invaluable and there is no benefit or quality of life feature that is worth giving up your personal information

## Activity 2
1. Cereal
2. No question was provided
3. public class Cereal
4. 15 instances variables
5. String name
   String type
   int calories
   int protein
   int fat
   int sodium
   double fiber
   double carbohydrates
   int sugar
   int potassium
   int vitamins
   int shelf
   double weight
   double cups
   double rating
8. What is the sweetest cereal?
9. Do sweeter cereals have higher ratings?
10. We can create an instance variable that represents a sugar to rating ratio.


## Activity 3
1. The temperature at Atlanta, Hartsfield - Jackson Atlanta International Airport, GA is 66.0F
2. KNYC
   The temperature at New York City, Central Park, NY is 49.0F
3. See code
4. 48
5. By latitude and longitude
6. NSTU: Pago Pago, AS, Samoa
7. What is the northernmost?
8. Very little (Change < to >)

## Activity 4
1. What is the height difference between the tallest NBA player and the shortest NBA player in the 2020-21 NBA season?
2. https://www.kaggle.com/datasets/justinas/nba-players-data, we searched up 'nba players' on kaggle.com
3. We downloaded the data as a csv from Kaggle and created a Player class to represent each record in the csv. 
   In our main method of our driver file, we will load the csv record-by-record/line-by-line and initalize an instance of the Player class for each record. We save these instances in an ArrayList and we will iterate through this ArrayList to find the shortest and tallest NBA player.
4. We created a Player class to represent a NBA player and we saved the player's season, name, and height. These were the only statistics that we were concerned with to answer our question.
5. See Activity4/Activity4.java
