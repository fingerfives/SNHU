Application Reflection
===
-----------------

### Requirements
This project was created to demonstrate several core skills using the Android platform learned 
    throughout this course in order to create an application meant for use by a client managing
    a warehouse. Their request encompasses features including:<br>
    <li> Login/Account creation
    <li> Notification for out of stock items
    <li> Adding items to the database
    <li> Editing item quantities
    <li> Deleting an item
    <br><br>

### UI/UX Design
Based on these requirements, a user interface was designed with the principles of clean code
    and intuitive UI design in mind. As I am not a UI/UX designer, some elements like color 
    and icon choice would be different; and there would be some nice to haves
    such as transitions between activities to make it more engaging. With the elements already in
    use, however, are all icons which are familiar to most users. For example, when an item's quantity
    needs to be updated, there are only 5 buttons on that screen:<br><br>
    <li>Delete (signified by a button with text)
    <li>Add/Increase Quantity(signified by a plus)
    <li>Close (signified by an 'X' icon)
    <li>Save (signified by a button with text) <br><br>

### Code Architecture
With the screens having been created and refined, architecting the code to match it was a much easier
    task. Certain UI elements such as a popup window being used to either add or edit an item meant
    that a common class could be used to create the appropriate View based on the params passed in.
    Having prior experiences with SqlLite, and databases in general, made the process of ensuring the
    backend portion of this application matched the given requirements. Design patterns such as
    Singleton were used to limit the instantiation of unnecessary objects, thereby promoting the
    optimization of memory use in terms of the Java heap.

### Testing
Testing the application was done ultimately completed through a manual process. This was a missed
    opportunity as there are frameworks such as Selenidroid and TestComplete which run automated
    tests. In the future, this is something I would explore more of as it is much faster and provides
    single source to maintain and run many scenarios. Either way, having a robust testing strategy
    is vital to ensure that the application doesn't crash even when hit with extreme edge case
    scenarios.

### Lessons Learned
The biggest takeaway from this project as a full stack developer is an appreciation for a quality 
    UI/UX design. As I stated before, I went into this project knowing that it was one of my weaker
    skills. Having worked on mobile applications before this which utilize a backend service, I was
    already familiar with concepts such as dependency management, asynchronous tasking, and the
    MVC design pattern.