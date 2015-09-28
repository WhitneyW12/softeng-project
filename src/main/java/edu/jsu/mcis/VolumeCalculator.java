//Unit tests


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class VolumeCalculator{

    public VolumeCalculator(){

    }
    public float length;
    public float height;
    public float width;
    public float volume;

    public static void main(String[] args) {

        VolumeCalculator v = new VolumeCalculator();


        try{
            Scanner scan = new Scanner(System.in);
            System.out.println("enter the length, width, height");

            v.length = scan.nextFloat();
            //add try catch to each variable

            v.width = scan.nextFloat();



            v.height = scan.nextFloat();

            System.out.println(v.volume(v.length,v.width,v.height));
        } catch (InputMismatchException e) {

            System.out.println("Error, please enter a valid float.");




        }
    }


    public float volume(float l, float w, float h){

        float volume = l*w*h;

        return volume;
    }
}