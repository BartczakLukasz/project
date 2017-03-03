SPACE INVADERS CLONE

This is space invaders clone created with Kevin Glass tutorial
http://www.cokeandcode.com/info/tut2d.html

It is a shoot'em up game created by Tomohiro Nishikado in 1978 for arcade machines. It is one of the earliest game of this genre. In this game you have to eliminete all the enemies at the top of the screen. Getting hit by the enemy's shot or when the enemies will get to the bottom of the screen ends the game.

To lose the game 

1. Controls 

left - left arrow key

right - right arrow key

shoot - SPACE

pause - Enter

quit - esc

2. Objects

player is an object of ShipEntity class player can move in two directions left and right shooting small blasts

enemies are objects of AlienEntity class they move from left to right and go back taking little step down shooting small blasts

boss is an object of BossEntity class it moves from left to right and right to left performing devastating attacks

3. Working schedule

first and second week - work with tutorial

third week - create enemy shots and backgroud

fourth week - adding sounds to the game and create boss

fifth week - create boss shots and add pause mechanics

sixth week - create sprites and additional game mechanics (health,score)

4. Used technologies
  javax.swing.Jframe
  javax.swing.JPanel
  java.awt.Canvas
  java.awt.Color
  java.awt.Dimension
  java.awt.Graphics2D
  import java.awt.event.KeyAdapter
  java.awt.event.KeyEvent
  java.awt.event.WindowAdapter
  java.awt.event.WindowEvent
  java.awt.image.BufferStrategy
  java.util.ArrayList


Jest to gra typu shoot’em up oryginalnie stworzona przez Tomohiro Nishikado w 1978 roku na maszynę arcade’ową. Jest to jedna z pierwszych gier tego gatunku. Gra polega na wyeliminowaniu wszystkich wrogów znajdujących się u góry ekranu. 

Przegrać można kiedy zostaniesz trafiony przez pocisk wroga, bądź gdy wrogowie przemieszczą się na dół ekranu. W oryginale celem gracza było zdobycie jak największej ilości punktów. 

W mojej wersji zamierzam dodać potężnego przeciwnika (bossa), zmianę(ulepszenie) strzału po zdobyciu odpowiedniej ilości punktów, punkty zdrowia(tarczy), kilka plansz, wzmocnienie wrogów co kolejną planszę, stan krytyczny gracza, odnowa zdrowia po uzyskaniu odpowiedniej ilości punktów. 

W grze można poruszać się w lewo i w prawo. Przeciwnicy po doleceniu do krawędzi ekranu zmieniają kierunek lotu i przybliżają się do dolnej granicy ekranu.

