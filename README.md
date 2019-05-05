# Cuisines Registry

## The story:

Cuisines Registry is an important part of Book-That-Table Inc. backend stack. It keeps in memory customer preferences for restaurant cuisines and is accessed by a bunch of components to register and retrieve data. 


The first iteration of this component was implemented by rather inexperienced developer and now may require some cleaning while new functionality is being added. But fortunately, according to his words: "Everything should work and please keep the test coverage as high as I did"


## Your tasks:
1. **[Important!]** Adhere to the boy scout rule. Leave your code better than you found it.
It is ok to change any code as long as the CuisinesRegistry interface remains unchanged.
2. Make is possible for customers to follow more than one cuisine (return multiple cuisines in de.quandoo.recruitment.registry.api.CuisinesRegistry#customerCuisines)
3. Implement de.quandoo.recruitment.registry.api.CuisinesRegistry#topCuisines - returning list of most popular (highest number of registered customers) ones
4. Create a short write up on how you would plan to scale this component to be able to process in-memory billions of customers and millions of cuisines (Book-That-Table is already planning for galactic scale). (100 words max)

## Submitting your solution

+ Fork it to a **[!]**private**[!]** gitlab repository (go to `Settings -> General -> Visibility, project features, permissions -> Project visibility`).
+ Put the write up mentioned in point 4. into the end of this file.
+ Share the project with gitlab user *quandoo_recruitment_task* (go to `Settings -> Members -> Invite member`, find the user in `Select members to invite` and set `Choose a role permission` to `Developer`)
+ Send us an **ssh** clone link to the repository.

Scaling:
First of all I wouldn't say that having billions of objects in-memory is the most efficient way for solving this problem,
it will definitely slow down the application.
Secondly if we are planning to use Collections and/or arrays - they only support about two billion elements.
We can consider using ByteBuffer and save our serialized objects in that byteBuffer.
But the more objects we will have the slower it will become to work with it, and also we shouldn't forget that memory is not infinite. So having so much data in-memory is a bit risky decision I would say.
For billions of objects/data I would consider using some distributed DataBase systems like Cassandra, Hadoop, etc.
They keep some part of data in-memory some part on hard drive, and they are designed to be very fast as far as data is split across many nodes.