# LDTS_T15_G06 - SPACE RACE

## Game Description

In a race against your opponent you have to reach the top to score one point. Along the way you can´t collide with the obstacles.
If you score more points that your opponent, before the time runs out, you win!

This project was developed by Hugo Castro (up202006770@fe.up.pt) and Luís Paiva (up202006094@fe.up.pt) for LDTS 2021/2022.

## Implemented Features

## Planned Features

All the planned features were successfuly implemented.

## Design

#### SWITCH BETWEEN MULTIPLE STATES

**Problem in Context**

The application start in the menu and three options appear. In each option a different thing happen and the actions in there are different.
When instructions option is selected it shows the instructions and then returns to the menu. When play option is selected the game runs and in the end returns to the menu.

**The Pattern**

We used the **State** Pattern. This pattern allowed us to represent different states and switch between those states.
This pattern resolve the identified problems because we create MenuState, PlayState, InstructionsState. 
In the menu when we choose the play option, it switch to the PlayState, when we choose instructions option it switch to the InstructionsState, in both situations at the end switchs back to the menu (MenuState).

**Implementation**

The following figure shows how the pattern's roles were mapped to the application classes.

Imagem. (qual a imagem a pôr)

The classes can be found in the following files:

- [MenuState]
(https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g1506/blob/master/spaceRace/src/main/java/State/MenuState.java)

- [PlayState]
(https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g1506/blob/master/spaceRace/src/main/java/State/PlayState.java)

- [InstrucionsState]
(https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g1506/blob/master/spaceRace/src/main/java/State/InstructionsState.java)

**Consequences**

The use of the State Pattern in the current design allows the following benefits:

- Make state transitions explicit.
- We don´t need to have conditional statements associated with the various states. Instead each state activate the right behavior.
- More classes and instances to manage, but there are organized and therefore not difficult to deal with.

#### GENERAL STRUCTURE

**Problem in Context**

Having a way to manage each state and objects in different parts. 

**The Pattern**

We used the **Model-View-Controller** pattern that belongs to **Architectural Patterns**. This pattern allow us to divide the application into three different parts.
So we can control each state and each object in different parts: one works only with its model, another works with the way it is seen and the last one works with the different actions.

**Implementation**

**Consequences**

The use of this pattern int the current design allows the following benefits:

- Easy modification of the entire application.
- Any changes in a certain section of the application will never affect the entire architecture.
- Increase the flexibility and scalability of the application.

#### OBSERVERS AND LISTENERS
Observer Pattern

#### GUI
Facade Pattern

#### ARENA BUILDER
Factory method and builder pattern

#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

### TESTING

### Screenshot of coverage report

### Link to mutation testing report

## SELF-EVALUATION

-Hugo Castro: 50%
-Luís Paiva: 50%