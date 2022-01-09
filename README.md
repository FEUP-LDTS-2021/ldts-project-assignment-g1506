# ldts-project-assignment-g1506
ldts-project-assignment-g1506 created by GitHub Classroom
## LDTS_1506 <SPACE RACE>

In a race against your opponent you have to reach the top to score one point. Along the way you can´t collide with the obstacles.
If you score more points that your opponent, before the time runs out, you win!
This project was developed by Hugo Castro (up202006770@fe.up.pt) and Luís Paiva (up202006094@fe.up.pt) for LDTS 2021/2022.

### IMPLEMENTED FEATURES

- **Moving Up** - The rocket number 1 will move up when 'w' is pressed, and the rocket number 2 will move up when Arrow Up is pressed.
- **Moving Down** - The rocket number 1 will move down when 's' is pressed and the rocket number 2 will move down when Arrow Down is pressed.

  ![image](https://user-images.githubusercontent.com/78104669/148663193-7cf36942-92de-4c83-8206-20f6da60b303.png)
  
  ![image](https://user-images.githubusercontent.com/78104669/148663210-31873a2c-914c-4a18-87ad-ff4092fdcb75.png)

### PLANNED FEATURES

- **Movement of the obstacles** - Obstacles will move horizontly.
- **Colisions with obstacles** - When any rocket is in the same position of an obstacle, the rocket will return to the initial position.
- **Points** - Points will be increased when one rocket reach the top.
- **Menu** - Menu with the options.
- **Time of the game** - A bar represents the time and goes down until the time runs out.
  
### DESIGN

  
#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

#### Duplicate Code

The 'Rocket()', 'Obstacle()' and 'Wall()' classes have duplicate code.

A way to improve the code would be the removal of the duplicate code and implementation of the 'Member()' abstact class. 'Rocket()', 'Obstacle()', 'Wall()' will extend this abstract class.
  
### TESTING
  
#### Coverage Report
![image](https://user-images.githubusercontent.com/78104669/148665118-24bcd794-16a6-4c02-afe6-e8e94a99e51e.png)

[Coverage Report ](https:spaceRace/CoverageReport/index.html)
  
#### Mutation Report
  

### SELF-EVALUATION
-Hugo Castro: 50%.
-Luís Paiva: 50%.
