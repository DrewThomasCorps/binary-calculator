# binary-calculator
1 week project for CS 495

## Installation
```git clone https://github.com/DrewThomasCorps/binary-calculator.git```

Set up JAVA_HOME

Windows users should add %JAVA_HOME%\bin to Path environment variable

Install Maven Dependencies.



To run the project select `Maven` -> `Plugins` -> `javafx` -> `javafx:run` 

## User Manual
<strong>Binary Calculator</strong><br>
![Alt screenshot of Binary Calculator](https://github.com/DrewThomasCorps/binary-calculator/blob/master/src/main/resources/binarycalcshot.png?raw=true)

#### Number Buttons
##### Zero Button:  0
##### One Button:  1
Use number buttons to enter binary values into the calculator. 

#### Two Number Operations
##### Addition Button:  +
##### Subtraction Button:  -
##### Multiplication Button:  *
##### Division Button:  /
Use the Two Number Operation buttons to perform arithmetic operations on two binary integers. Using the number buttons,
a user enters the number for example '101'. Next the user presses a Two Number Operation button, for instance '+'. Then, the user 
enters the second number for example '1011' and finally presses the '=' operator to perform addition. The result of the addition '10000' is
displayed in the result label.

<strong>Input First Number</strong><br>
![Alt enter 101](https://github.com/DrewThomasCorps/binary-calculator/blob/master/src/main/resources/101.png?raw=true)<br>

<strong>Choose Operation</strong><br>
![Alt choose operation](https://github.com/DrewThomasCorps/binary-calculator/blob/master/src/main/resources/choose-operation.png?raw=true)<br>

<strong>Input Second Number</strong><br>
![Alt enter 1011](https://github.com/DrewThomasCorps/binary-calculator/blob/master/src/main/resources/1011.png?raw=true)

<strong>Click '=' Equals-Button</strong><br>
![Alt click equals-button](https://github.com/DrewThomasCorps/binary-calculator/blob/master/src/main/resources/click-equal-button.png?raw=true)


#### Single Number Operations

#### Sign Toggle
Switch signs from positive to negative and vice versa.

#### Decimal/Binary Toggle
Translate a number from its binary representation to its corresponding decimal translation as well as vice versa.

## Meetings
#### 09-05-2020 18:40–19:10
  Medium: Zoom
  
  Discussion: Review of Requirements and quick assignments (will need to discuss with others later)
  
  Attendees: Levi, Alan, Drew
<hr>

#### 09-06-2020 12:32-13:30
  Medium: Discord Call
  
  Discussion: Reconciliation of Maven project with preliminary JavaFX work
  
  Attendees: Drew, Alan
<hr>

#### 09-06-2020 14:00-14:05
  Medium: Zoom
  
  Discussion: Overview of what has been done, and what there is left to do.
  
  Attendees: Drew, Nathan
  <hr>
  
#### 09-07-2020 13:00-14:00
  Medium: Zoom
  
  Discussion: Project structure and next steps. Getting set up on local machines.
  
  Attendees: Drew, Alan, Nathan, Samuel, Levi
  <hr>
  
#### 09-07-2020 15:00-15:20
  Medium: Slack Call
  
  Discussion: How is the functionality implemented, and how should it be handled in the controller.
  
  Attendees: Drew, Levi 

#### 09-10-2020 20:00-20:10
  Medium: Phone Call / Slack Chat
  
  Discussion: Quick discussion on solutions to implement base two negatives vs. two's complement.
  
  Attendees: Drew, Alan
  
##Task Distribution
[Drew  Thomas] = [Create Github Repository, Add Team as Collaborators, Create Gitignore, Design Calculator Model/API,
Implement Various API Methods, Implement Various Error Handling, Switch to base 2 representation from two's complement,
Unit Tests for any added API Methods]

[Nathan Malitz] = [Implement Various Operations in Model, Implement Thrown Exceptions in Model, Implement Various Unit
Tests, Take Screenshots, Add Screenshots to README.md, Contribute Single Number Operations Descriptions to README.md ]

[Levi Connelly] = [Implement Operator Handling in GUI controller, Add Logic to Clear Result Display, Implement Various
Error Handling, Implement UX fixes for Usage after a Calculation]

[Samuel Guernsey] = [Implement Convert to Decimal in Controller and Model, Implement Binary Toggle in Controller, Work
on User Manual in README.md]

[Alan Bauer] = [Design GUI Mockup, Implement GUI in JavaFX, Configure GUI controller, Configure .fxml, Refactor UI for
Additional Input, Prevent Overflow in Controller, Design Various Controller Methods, Create/Edit README.md User Manual]
