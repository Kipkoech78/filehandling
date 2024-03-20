import java.io.File;
import java.io.IOException;

public class Createfilename {
    public static void main(String[] args) {
        try{
            File myobj = new File("data.txt");
            if(myobj.createNewFile()){
                System.out.println("File created: " + myobj.getName());
                System.out.println("absolute path " + myobj.getAbsolutePath());
            }
            else{
                System.out.println("file already exist");
            }
        }
        catch (IOException e ) {

            System.out.println("error ocured.");
            e.printStackTrace();
        }

    }

}

