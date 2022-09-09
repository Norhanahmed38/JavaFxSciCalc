package calculator2;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
 import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class FXMLDocumentController implements Initializable {
    
    private double num1;
    private String op = "";
    private String bracketOp = "";
    private boolean start = true;
    private String out = "";
    private double outNum = 0;
    private boolean nd =true;
    private boolean open=false;
    private boolean firstTime =false;
    private double bracketElement;
    private boolean radOrDeg=false;
    private double saved=0;
    private boolean fixedOrExponent=false;
    private int n=0;
    private double decimalout=0;
    
    Image image11 = new Image("calculator2/assets/Screenshot_2022-04-20_134844-removebg-preview.png");
    Image image12 = new Image("calculator2/assets/Screenshot_2022-04-20_135028-removebg-preview.png");
    Image image21 = new Image("calculator2/assets/Screenshot 2022-04-20 135138.png");
    Image image22 = new Image("calculator2/assets/Screenshot 2022-04-20 135259.png");
    Image image31 = new Image("calculator2/assets/Screenshot_2022-04-20_135421-removebg-preview.png");
    Image image32 = new Image("calculator2/assets/Screenshot_2022-04-20_135658-removebg-preview.png");
    Image image41 = new Image("calculator2/assets/Screenshot_2022-04-20_135903-removebg-preview.png");
    Image image42 = new Image("calculator2/assets/Screenshot_2022-04-20_135929-removebg-preview.png");
    Image image5 = new Image("calculator2/assets/Screenshot_2022-04-20_140842-removebg-preview.png");
    Image image6 = new Image("calculator2/assets/Screenshot_2022-04-20_140900-removebg-preview.png");
        
    @FXML
    private Label output;
    
    @FXML
    private Button ND;
    
    @FXML
    private ImageView first;
     
    @FXML
    private ImageView second;

    @FXML
    private ImageView third;

    @FXML
    private ImageView fourth;
    
    @FXML
    private ImageView fifth;
    
    @FXML
    private ImageView sixth;
    
    @FXML
    private Button openbracket;
    
    @FXML
    private Button clear;
    
    @FXML
    private Button FE;

    @FXML
    private Button RadDeg;
    
    
    @FXML
    private Button ln;

    @FXML
    private Button log;
    
    @FXML
    private Button restore;
    
    @FXML
    private ComboBox<String> trigComb;
    
    @FXML
    private ComboBox<String> functionComb;
    
    
    // Function
    @FXML
    void choosefunction(ActionEvent event) {
        if (functionComb.getSelectionModel().getSelectedItem()!=null){
        String s = functionComb.getSelectionModel().getSelectedItem();
        out = calculatingFunc(s);
        output.setText(out); 
        functionComb.getSelectionModel().clearSelection();
        functionComb.setItems(FXCollections.observableArrayList("ceil","floor","abs","rand"));
        start=true;
        }
    }
    
    //Method of calculating Function
    String calculatingFunc(String s){
        double in = Double.parseDouble(output.getText());
        switch(s){
            case"ceil":
                return String.valueOf(Print(String.valueOf(Math.ceil(in))));
            case "floor":
                return String.valueOf(Print(String.valueOf(Math.floor(in))));
            case "rand":
                if (n==0)
                    return String.valueOf(Print(String.valueOf(Math.random())));
                return String.valueOf(Print(String.valueOf(in*Math.random())));
            case "abs":
                return String.valueOf(Print(String.valueOf(Math.abs(in))));  
        }
       return ""; 
    }

    // Trigonometry
    @FXML
    void choosetrigonometry(ActionEvent event){
        if (trigComb.getSelectionModel().getSelectedItem()!=null){
        String s = trigComb.getSelectionModel().getSelectedItem();
        out = calculatingTrig(s);
        output.setText(out); 
        trigComb.getSelectionModel().clearSelection();
        trigComb.setItems(FXCollections.observableArrayList("sin","cos","tan","sec","csc","cot","Arcsin","Arccos","Arctan","Arcsec","Arccsc","Arccot","sinh","cosh","tanh","sech","csch","coth","Arcsinh","Arccosh","Arctanh","Arcsech","Arccsch","Arccoth"));
        start=true;
        return;
        }    }
    //DEG or RAD Button
    @FXML
    void RadOrDegree(ActionEvent event) {
        if (radOrDeg){
            radOrDeg=false;
            ((Button) event.getSource()).setText("RAD");
        }
        else{
            radOrDeg=true;
            ((Button) event.getSource()).setText("DEG");
        }        
    }
    //Method for calculating Trigonemetry functions
    String calculatingTrig(String s){
        double in = Double.parseDouble(output.getText());
        switch (s){
            //Trigonometric functions
            case "sin":
                if (radOrDeg) in = Math.PI*in/180;
                return String.valueOf(Math.sin(in));
            case "cos":
                if (radOrDeg) in = Math.PI*in/180;
                return String.valueOf(Math.cos(in));
            case "tan":
                if (radOrDeg) in = Math.PI*in/180;
                return String.valueOf(Math.tan(in));
            case "cot":
                if (radOrDeg) in = Math.PI*in/180;
                return String.valueOf(1/Math.tan(in));
            case "csc":
                if (radOrDeg) in = Math.PI*in/180;
                return String.valueOf(1/Math.sin(in));
            case "sec":
                if (radOrDeg) in = Math.PI*in/180;
                return String.valueOf(1/Math.cos(in));
                
            // Inverse Trigonometric functions   
            case "Arcsin":
                if ((in <-1.0 )|| (in>1.0)){
                    return "ERROR";
                }
                if (radOrDeg) return String.valueOf(180*Math.asin(in)/Math.PI);
                else return String.valueOf(Math.asin(in));     
            case "Arccos":
                if (in<-1||in>1){
                    return "ERROR";
                }
                if (radOrDeg) return String.valueOf(180*Math.acos(in)/Math.PI);
                else return String.valueOf(Math.acos(in));  
            case "Arctan":
                if (radOrDeg) return String.valueOf(180*Math.atan(in)/Math.PI);
                else return String.valueOf(Math.atan(in));
            case "Arcsec":
                if ((in>-1 )&& (in<1.0)){
                    return "ERROR";
                }
                if (radOrDeg) return String.valueOf(180*Math.acos(1/in)/Math.PI);
                else return String.valueOf(Math.acos(1/in));   
            case "Arccsc":
                if ((in>-1 )&& (in<1.0)){
                    return "ERROR";
                }
                if (radOrDeg) return String.valueOf(180*Math.asin(1/in)/Math.PI);
                else return String.valueOf(Math.asin(1/in)); 
            case "Arccot":
                if (radOrDeg) return String.valueOf(180*Math.atan(1/in)/Math.PI);
                else return String.valueOf(Math.atan(1/in));
                
             // Hyperpolic Functions   
            case "sinh":
                return String.valueOf(Math.sinh(in));
            case "cosh":
                return String.valueOf(Math.cosh(in));
            case "tanh":
                return String.valueOf(Math.tanh(in));
                
            case "csch":
                return String.valueOf(1/Math.sinh(in));
            case "sech":
                return String.valueOf(1/Math.cosh(in));
            case "coth":
                return String.valueOf(1/Math.tanh(in));
            
            // Inverse Hyperpolic Functions 
            case "Arcsinh":
                return String.valueOf(Math.log(in+Math.sqrt(Math.pow(in, 2)+1)));     
            case "Arccosh":
                if (in <1){
                    return "ERROR";
                }
                else return String.valueOf(Math.log(in+Math.sqrt(Math.pow(in, 2)-1)));  
            case "Arctanh":
                if (in<=-1||in>=1){
                    return "ERROR";
                }
                else return  String.valueOf(0.5*Math.log((1+in)/(1-in))); 
            
            case "Arcsech":
                if ((in<=0 )|| (in>1.0)){
                    return "ERROR";
                }
                else return String.valueOf(Math.log(1/in+Math.sqrt(Math.pow(1/in, 2)-1)));   
            case "Arccsch":
                if ((in)==0){
                    return "ERROR";
                }
                else return String.valueOf(Math.log(1/in+Math.sqrt(Math.pow(1/in, 2)+1))); 
            case "Arccoth":
                if (in>=-1&&in<=1){
                    return "ERROR";
                }
                else return String.valueOf(0.5*Math.log((1+in)/(in-1)));     
        }
        return "";
    }
    
    @FXML
    void darker(MouseEvent event) {
        if (((Button) event.getSource()).getText().equals("(")||((Button) event.getSource()).getText().equals(")")){
            if(open)
                return;
        }
      ((Button) event.getSource()).setStyle("-fx-background-color: #A9A9A9; ");
      //x^y
       if (((Button) event.getSource()).getText().equals("x^y")){
           
           ((Button) event.getSource()).setTextFill(Color.DARKGREY);  
       }
       //log
       if (((Button) event.getSource()).getText().equals("log")){
           if (nd)
             ((Button) event.getSource()).setTextFill(Color.BLACK);
           else 
             ((Button) event.getSource()).setTextFill(Color. DARKGREY); 
       }
       
       //ln
        if (((Button) event.getSource()).getText().equals("ln")){
            if (nd)
              ((Button) event.getSource()).setTextFill(Color.BLACK);
            else 
              ((Button) event.getSource()).setTextFill(Color. DARKGREY); 
        }
        
    }
    
    @FXML
    void brighter(MouseEvent event) {
        if (((Button) event.getSource()).getText().equals("(")||((Button) event.getSource()).getText().equals(")")){
            if(open)
                return;
        }
        ((Button) event.getSource()).setStyle("-fx-background-color: #DCDCDC; "); 
        // x^y
        if (((Button) event.getSource()).getText().equals("x^y")){
           ((Button) event.getSource()).setTextFill(Color. GAINSBORO); 
        }
        
        //log
        if (((Button) event.getSource()).getText().equals("log")){
          
          if (nd)
              
             ((Button) event.getSource()).setTextFill(Color. BLACK);
          else 
             ((Button) event.getSource()).setTextFill(Color. GAINSBORO);   
        }
        
        //ln
        if (((Button) event.getSource()).getText().equals("ln")){
            if (nd)
              ((Button) event.getSource()).setTextFill(Color.BLACK);
            else 
              ((Button) event.getSource()).setTextFill(Color. GAINSBORO); 
        } 
    }
    
    @FXML
    void brighterNum(MouseEvent event) {
        ((Button) event.getSource()).setStyle("-fx-background-color: WHITE; "); 
    }
    
    @FXML
    void darkerNum(MouseEvent event) {
        ((Button) event.getSource()).setStyle("-fx-background-color: #A9A9A9; ");
    }
    @FXML
    void brighterNd(MouseEvent event) {
        if(!nd)
            return;
        ((Button) event.getSource()).setStyle("-fx-background-color: DCDCDC; "); 
    }
    
    @FXML
    void darkerNd(MouseEvent event) {
        if(!nd)
            return;
        ((Button) event.getSource()).setStyle("-fx-background-color: #A9A9A9; ");
    }
    
    // 2nd Button
    @FXML
    void select(ActionEvent event) {
        if(nd){
            nd = false;
            first.setImage(image12);
            second.setImage(image22);
            third.setImage(image32);
            fourth.setImage(image42);
            fifth.setImage(image5);
            sixth.setImage(image6);
            log.setTextFill(Color. GAINSBORO);
            ln.setTextFill(Color. GAINSBORO);
            ND.setStyle("-fx-background-color: #A9A9A9; ");
        }
        else {
            nd = true;
            first.setImage(image11);
            second.setImage(image21);
            third.setImage(image31);
            fourth.setImage(image41); 
            fifth.setImage(null);
            sixth.setImage(null);
            log.setTextFill(Color. BLACK);
            ln.setTextFill(Color. BLACK);
            ND.setStyle("-fx-background-color: #DCDCDC; ");
        }  
    }
    
    // Clear Button
    @FXML
    void Clear(ActionEvent event) {
        output.setText("0");
        num1=0;
        bracketElement=0;
        start = true;  
        open=false;
        op = "";
        bracketOp = "";
        start = true;
        out = "";
        outNum = 0;
        nd =false;
        select(event);
        firstTime =false;
        bracketElement=0;
        radOrDeg=false;
        saved=0;
        fixedOrExponent=false;
        decimalout=0;
        RadDeg.setText("RAD");
        openbracket.setStyle("-fx-background-color: #DCDCDC; ");
        ND.setStyle("-fx-background-color: #DCDCDC; ");
        FE.setStyle("-fx-background-color: #DCDCDC; ");   
    }
    
    // Clear last char Button
    @FXML
    void RemoveLastChar(ActionEvent event) {
       if ((output.getText() != null) && (output.getText().length() > 0))
            output.setText( output.getText().substring(0, output.getText().length() - 1));
        if (output.getText().length() == 0){
            output.setText("0");
            start=true;
        } 
    }
    
    // Memory save 
    @FXML
    void MS(ActionEvent event) {
        saved = Double.parseDouble(output.getText());
        clear.setDisable(false);
        restore.setDisable(false); 
        start=true;
    }
    //Memory clear
    @FXML
    void MC(ActionEvent event) {
        saved=0;
        clear.setDisable(true);
        restore.setDisable(true);
        start = true;
    }
    
    // Memory restore
    @FXML
    void MR(ActionEvent event) {
        output.setText(Print(String.valueOf(saved)));
        start=true;
    }
    
    // Subtracting number from saved number
    @FXML
    void Mminus(ActionEvent event) {
        saved -= Double.parseDouble(output.getText());
        start=true;
    }
    
    // Adding number from saved number
    @FXML
    void Mplus(ActionEvent event) {
        saved += Double.parseDouble(output.getText());
        start=true;
    }
    
    //F-E Button
    @FXML
    void FixedToExponent(ActionEvent event) { 
        if (fixedOrExponent){
            ((Button) event.getSource()).setStyle("-fx-background-color: #DCDCDC; ");
            fixedOrExponent = false;
            output.setText(Print(String.valueOf(decimalout*Math.pow(10, n))));
        }
        else{
            ((Button) event.getSource()).setStyle("-fx-background-color: #A9A9A9; ");
            outNum=Double.parseDouble(output.getText());
            n=0;
            do{
            n++;
            outNum /= 10;
            } while(outNum > 10.0);
            output.setText(outNum + " e+" + n);
            start = true;
            fixedOrExponent = true;
        }
        decimalout = outNum;
    }
    
   
    // Numbers Buttons
    @FXML
    public void Num(ActionEvent event){
        //To clear the label text to insert new number
        if (output.getText().equals("ERROR")){
            num1=0;
            op="";
            output.setText("");  
        }
        if (start){
            output.setText("");
            start = false;
        }
        String value =((Button) event.getSource()).getText();
        output.setText(output.getText()+ value);
        firstTime=false;
    }
    
    //Brackets
    @FXML
    void openBracket(ActionEvent event) {
        open=true;
        output.setText("(");  
        start=true;
        //inserting darker color as a sign of opened bracket
        openbracket.setStyle("-fx-background-color: #A9A9A9; ");   
    }
    
    @FXML
    void closBracket(ActionEvent event) {
        open=false;
        out = Calculate(bracketElement,Double.parseDouble(output.getText()),bracketOp);
        output.setText(Print(out));
        start=true;
        openbracket.setStyle("-fx-background-color: #DCDCDC; ");
    }
    
    // Decimal Button
    @FXML
    void Decimal(ActionEvent event) {
        if (output.getText().indexOf('.')!= -1)
            return;
        if (start){
            output.setText("0.");
            start=false;
            return;
        }
        else
            output.setText(output.getText()+ ".");
    }
    
    // e Button
    @FXML
    void e(ActionEvent event) {
        output.setText(String.valueOf( Math.E)); 
        start=true;  
    }
    
    // pi Button
    @FXML
    void pi(ActionEvent event) {
        output.setText(String.valueOf( Math.PI)); 
        start =true;
    }
    
    //power Button
    @FXML
    void Power(ActionEvent event) {
        if (nd)
            outNum= Math.pow(Double.parseDouble(output.getText()),2);
        else
            outNum= Math.pow(Double.parseDouble(output.getText()),3);
        
        output.setText(Print(String.valueOf(outNum)));
        start = true;
    }
    
  
    // root Button
    @FXML
    void root(ActionEvent event) {
        if (nd){
            if (Double.parseDouble(output.getText())<0){
                output.setText("ERROR");
                return;
            } 
            outNum= Math.pow(Double.parseDouble(output.getText()),0.5);
        }
        else
            outNum= Math.pow(Double.parseDouble(output.getText()),1.0/3);
        
        output.setText(Print(String.valueOf(outNum)));
        start = true;
    }
    
    //10^x or 2^x Button
    @FXML
    void tenPower(ActionEvent event) {
        if (nd)
            outNum = Math.pow(10,Double.parseDouble(output.getText()));
        else
            outNum = Math.pow(2,Double.parseDouble(output.getText()));
        
        output.setText(Print(String.valueOf(outNum)));
        start = true;
    }
    
    //x^y or x^1/y
    @FXML
    void powerOrRoot(ActionEvent event) { 

        Operator(event);
    }
    
    //log Button
    @FXML
    void log(ActionEvent event) {
        if (nd){
            if (Double.parseDouble(output.getText())<0){
            output.setText("ERROR");
            return;
            }
            outNum = Math.log10(Double.parseDouble(output.getText()));
            output.setText(Print(String.valueOf(outNum))); 
        }
        else{
            Operator(event);  
        }
        
        start = true;
    }
    
    //ln Button
    @FXML
    void ln(ActionEvent event) {
        if (nd){
            if (Double.parseDouble(output.getText())<0){
            output.setText("ERROR");
            return;
            }
            outNum = Math.log(Double.parseDouble(output.getText()));
        }
        
        else{
            outNum = Math.pow(Math.E,Double.parseDouble(output.getText()));
            
        }
        
        output.setText(Print(String.valueOf(outNum)));
        start = true;
    }  
    
    //Reciprocal Button
    @FXML
    void reciprocal(ActionEvent event) {
        if (Double.parseDouble(output.getText())==0){
            output.setText("ERROR");
            return;
        }
        outNum = 1/Double.parseDouble(output.getText());
        output.setText(Print(String.valueOf(outNum)));
        start = true;
    }
    
    //Absolute Button
    @FXML
    void abs(ActionEvent event) {
      outNum = Math.abs(Double.parseDouble(output.getText())); 
      output.setText(Print(String.valueOf(outNum)));
      start = true;
    }
    
    //Factorial Button
    @FXML
    void fact(ActionEvent event) {
        outNum=Double.parseDouble(output.getText());
        if (outNum<0||(outNum%(int)outNum)!=0){
            output.setText("ERROR");
            start=true;
            return;
        }
        outNum = factorial(Double.parseDouble(output.getText()));
        output.setText(Print(String.valueOf(outNum)));
        start = true;
    }
    // Method to get the Factorial
    double factorial (double n){
        if (n==0||n==1)
            return 1;
        else return (n*factorial(n-1));     
    }
    
    //Positive and Negative Button
    @FXML
    void negative(ActionEvent event) {
        outNum = Double.parseDouble(output.getText())*(-1);
        output.setText(Print(String.valueOf(outNum)));
        start = true;
    }  
    
    //Operators Buttons
    @FXML
    public void Operator(ActionEvent event){
        if (output.getText().equals("ERROR")){
            return;
        }
        
       String value =((Button) event.getSource()).getText();
//      
//       // opening inner operation in case of brackets
//       if(open){
//           
//           if(!value.equals("=")){
//               //To be able to make multi operatios inside the brackets
//               if (!bracketOp.isEmpty()){
//                   
//                   //to check if the user clicked on the operator twice
//                   if (firstTime){
//                       bracketOp = value;
//                       return;
//                   }
//                   firstTime=true;
//                   out = Calculate(bracketElement,Double.parseDouble(output.getText()),bracketOp);
//                   output.setText(Print(out));
//                   bracketOp = value;
//                   if (output.getText().equals("ERROR")){
//                       return;
//                       }
//                   bracketElement = Double.parseDouble(output.getText());
//                   start = true;
//                   return;
//               }
//               bracketOp = value;
//               bracketElement = Double.parseDouble(output.getText());
//               
//               start=true;
//               
//           }
//           // if the user entered "=" without closing the bracket
//           else output.setText("ERROR"); 
//           return;
//       }
       
       if(!value.equals("=")){
           //To be able to make multi operatios without enter =
           if (!op.isEmpty()){
     
               //to check if the user clicked on the operator twice
               if (firstTime){
                   op = value;
                   return;
               }
               firstTime=true;
               out = Calculate(num1,Double.parseDouble(output.getText()),op);
               output.setText(Print(out)); 
               op = value;
               if (output.getText().equals("ERROR")){
                   return;
               }
               num1 = Double.parseDouble(output.getText());
               start = true;
               return;
           }
           op = value;
           num1 = Double.parseDouble(output.getText());
           start=true;
       }
       else{
           if (op.isEmpty())
               return;
           if (output.getText().isEmpty()){
               output.setText("Error");
               op= "";
               start=true;
               return;
           }
           out = Calculate(num1,Double.parseDouble(output.getText()),op);
           if (out=="ERROR")
               output.setText("ERROR");
           else
               output.setText(Print (out));
           op = "";
           start=true;
       }   
    }
    
    // One Method involving the operations of Sum, Difference, Multiply and Division
    private String Calculate(double num1, double num2, String op){
        switch(op){
            case "+":
                return String.valueOf(num1+num2);
            case "-":
                return String.valueOf(num1-num2);
            case "×":
                return String.valueOf(num1*num2);
            case "x^y":
                if (nd){
                    return String.valueOf(Math.pow(num1,num2)); 
                }
                else {
                    
                    return String.valueOf(Math.pow(num1,1/num2));}
            case "log":
                if (num1<0){
                    return "ERROR";
                }
                return String.valueOf(Math.log10(num1)/Math.log10(num2)); 
            case "mod":
                return String.valueOf(num1%num2);
            case "exp":
                return String.valueOf(num1*Math.pow(10.0, num2));
            case "÷":
                if (num2==0)
                    return "ERROR";
                return String.valueOf(num1/num2);      
        }
        return "ERROR";
        }
    
    //Method to get Text without.0 if it is not decimal
    private String Print(String in){
        if (in=="ERROR")
            return in;
        
        if (Double.parseDouble(in)%((int)Double.parseDouble(in))==0)
               return String.valueOf((int)Double.parseDouble(in));
           else 
               return in;
    }

     @Override
    public void initialize(URL url, ResourceBundle rb) {
        trigComb.setItems(FXCollections.observableArrayList("sin","cos","tan","sec","csc","cot","Arcsin","Arccos","Arctan","Arcsec","Arccsc","Arccot","sinh","cosh","tanh","sech","csch","coth","Arcsinh","Arccosh","Arctanh","Arcsech","Arccsch","Arccoth"));
        functionComb.setItems(FXCollections.observableArrayList("ceil","floor","abs","rand"));
    }   

}
