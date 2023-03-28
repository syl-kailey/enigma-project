public class Rotor {

    
    private String rotorValues;
    private char startChar;
    private char topChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        //TODO
        String newRotor = "";
        int lastValue = rotorValues.length();
        for(int i=0; i< lastValue; i++){
            if (i==0){
                newRotor+=rotorValues.charAt(lastValue-1);
            }
            else{
                newRotor+=rotorValues.charAt(i-1);
            }
        }
        rotorValues=newRotor;
        topChar=rotorValues.charAt(0);
    
        if (rotorValues.charAt(0)==startChar){
            return true;
        }
        else{
            return false;
        }
    }

    public int indexOf(char c){
        //TODO
        return rotorValues.indexOf(c);
    }

    public char charAt(int idx){
        //TODO
        return rotorValues.charAt(idx);
    }
}
   