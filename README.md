#A very basic banking app in Java.

##Banking Application Design using Java. App will focus on core functionality, minimal transaction and token authentication.

##The problem statement of the code is included in the */problem* dir.

##The app begins executing from com.banking.main.App.java.

##Unit tests for most of the core classes is included in com.banking.tests

Here is a sample I/O format log:

```
Enter the no of records:
1
Enter the record no:1
anurag|anurag@gmail.com|8105720566|7|2708|2708
Record written to the transaction file: anurag|anurag@gmail.com|8105720566|7|2708|2708
Enter the no of transactions:
1
Enter the transaction no:1
mo|7|7|200|2708|2708|anurag@eanurag.com
User found in the transaction file: anurag|anurag@gmail.com|8105720566|7|2708|2708
8105720566:PIN authenticated
User found in the transaction file: anurag|anurag@gmail.com|8105720566|7|2708|2708
Record written to the transaction file: anurag|anurag@eanurag.com|8105720566|7|2708|2708
8105720566:Update completed for mo|7|7|200|2708|2708|anurag@eanurag.com
```

##I'd love to receive any feedback on my coding style, design, code reviews or anything else.
##Please shoot an email to anurag[at]eanurag.com