# Algorithm: Find the best matched keywords

Given a search term (a list of words) and a corresponding document (a list of words), find the shortest phrase of words from the document that includes all of the search tersm.

# Coding: Create a system / class to conduct word searches (tf-idf)

You'll want to create a term frequency-inverse document frequency system (https://en.wikipedia.org/wiki/Tf-idf).

# System Design: Design a system to prevent work being performed twice

You are given many clients which talk to many workers using a messaging system (in this case Amazon SQS). The messaging service may send the same message twice to different (or the same) worker, so how can we prevent a worker from performing the work twice.

# Coding: Design a TodoApp.

The app should have teh following features:
- The ability to add a TODO
- The ability to mark a TODO as complete
- The ability to get all TODOs
- If a TODO has a due date set, if the TODO is not complete at the due date time, then make a GET call to the dueURL if set.

See TodoApp.java for the soluton. 