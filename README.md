# JavaFxSciCalc
Our project is a simple construction of scientific calculator (The 
version of Microsoft applications), constructed by JaveFx and Java 
Fxml. The project is an approximate construction to all the methods 
and functions of real scientific calculator.
# The main GUI construction contains:
  • An Anchorpane as the main container.  
  • VBox containing all the other layouts.   
  • HBox containing the top 2 buttons.   
  • HBox containing 5 buttons.   
  • HBox containing 2 ComboBoxes and 2 ImageViews.  
  • GridPane (5*7) containing 35 buttons.    
# Used libraries
![Capture](https://user-images.githubusercontent.com/112608294/189385593-e3d47ae0-fdb4-4012-be3b-8d7230b8e490.PNG)
# Design and GUI implementation  
![Capt66ure](https://user-images.githubusercontent.com/112608294/189385792-b8643522-291c-46bf-a9be-8aa1ff7d2a44.PNG)
# GUI is built with scene builder
#    UML Diagram
![Cببapture](https://user-images.githubusercontent.com/112608294/189385940-8b2d86f6-cd6a-4778-a7b9-beda13f37367.PNG)
![Caبببببببpture](https://user-images.githubusercontent.com/112608294/189385978-9d821309-eec7-4c9b-b6d4-9cdc55ede571.PNG)
# Buttons and its function
#  Numbers
Display numbers as it will be shown on the label as clicked
#    Operators 
The main operators for mathematical operations.
Note:
- There is an option of making multi operations as you can insert more than one operator without clicking =,but its mechanism depends on the order of operators 
not the priority
#    Clearing   
• The first one to clear the all the data   
• The second one is to clear the last shown number on label    
![Cap55ture](https://user-images.githubusercontent.com/112608294/189390765-526c24fc-6b46-44ee-98c2-f31ce165b29d.PNG)  
#    Constants  
• e: mathematical constant that equal 2.718  
• π: is a constant that equal 3.1415    
#    Rad and F-E   
• Rad: convert the input between radian and degree   
• F-E: convert the number shown on the label to the formula "X+eY"
Note:  
- Disability of dealing (making operations on it) with the "X+eY" formula, you can convert the number to this formula and return it only  
#  Storing
• MS: storing a specific number  
• M+ and M-: adding or subtracting other number to the saved one  
• MR: showing the stored number on the label  
• MC: clear the stored number     
#    Functions  
2nd: It switches between the functions of the buttons  
## Case 1  
• X^2: Finding the square of the number   
• 2√𝒙: Finding the square root of the number   
• 𝒙^y: We consider this button as operator that it finds the number power another number  
• 𝟏𝟎^𝒙: Finding 10 power x   
• Log: Finding Base 10 logarithm of Number  
• Ln: Finding Base e logarithm of Number  
## Case 2  
• X^3: Finding the cube of the number  
• 3√𝒙: Finding the cubic root of the number  
• y√𝒙: We consider this button as operator that it finds the number root of another number  
• 2^x: Finding 2 power x  
• logy.x: We consider this button as operator that it finds the Finding Base y logarithm of x  
• e^x: Finding e power of x  
# Other operators  
• 1/X: The inverse for a number X  
• |X|: Return the positive value of x  
• exp: It returns 10 to the power of x  
#   ComboBoxes and its functions  
## Function  
Consists of a set of approximate functions (Ceil-Floor-rand-abs)   
Ceil: It’s used to round a fraction to the nearest upward number  
Floor: It’s used to round a fraction to the nearest downward number  
rand: it’s used to Choose a random value its range between 0 and the number shown on the label  
abs: It’s used to obtain the standard of a number (the absolute value)  
## Trigonometry  
### Consists of a set of functions (Trigonometry-Inverse Trigonometry-Hyperpolic-Inverse Hyperpolic)  
• Trigonometric functions: <sin-cos-tan-cot-csc-sec>  
• Inverse Trigonometric functions: < Arcsin-Arccos-Arctan-Arcsec-Arccsc-Arccot>  
• Hyperpolic functions:  <sinh-cosh-tanh-csch-sech-coth.>  
• Inverse Hyperpolic functions: <Arcsinh-Arccosh-Arctanh-ArccschArcsech-Arccoth>  

 
