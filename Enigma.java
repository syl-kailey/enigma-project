public class Enigma{

    String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){
        System.out.println("hello");
        System.out.println("ENIGMA");
        System.out.println(id1 + " " + id2 + " " + id3);
        System.out.println(start);
        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        //TODO

        String output = "";
        int rotate_d = 0;
        for (int i =0; i<message.length(); i++){
            int index1 = rotors[2].indexOf(message.charAt(i));
            char char1 = rotors[1].charAt(index1);
            int index2 = rotors[2].indexOf(char1);
            char char2 = rotors[0].charAt(index2);
            output += char2;
            rotors[0].rotate();
            rotate_d++;
            if(rotate_d%27==0){
                rotors[1].rotate();
            }
        }
        return output;

    }


    
    public String encrypt(String message){
        //TODO

        String output = "";
        int rotate_e = 0;
        for (int i =0; i<message.length(); i++){
            int index1 = rotors[0].indexOf(message.charAt(i));
            char char1 = rotors[2].charAt(index1);
            int index2 = rotors[1].indexOf(char1);
            char char2 = rotors[2].charAt(index2);
            output += char2;
            rotors[0].rotate();
            rotate_e++;
            if(rotate_e%27==0){
                rotors[1].rotate();
            }
        }
        return output;
    }
    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}