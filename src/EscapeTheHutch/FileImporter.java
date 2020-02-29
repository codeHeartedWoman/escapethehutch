/*
 *  Alicia Moreland 2018;
 */

package EscapeTheHutch;

import EscapeTheHutch.behaviorTree.Routine;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author codeHeartedWoman
 */
public class FileImporter 
{

    
     String csvFileName;  
     String [] array;
     String line;
     String cvsSplitBy;
     
     FileImporter(String csvFileName)  {
        
        line = "##";
        cvsSplitBy = "$$";
        
        this.csvFileName = csvFileName;
     }
     
     public void load(String csvFileName){
        try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {
        
                while ((line = br.readLine()) != null) {
                    // use comma as separator
                    array = line.split(cvsSplitBy);
            }

            } catch (IOException e) {
                e.printStackTrace();
            }
      
        }
     
     public void load(String csvFileName, int[] stuff){
        try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {
        
                while ((line = br.readLine()) != null) {
                    // use comma as separator
                    array = line.split(cvsSplitBy);
            }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }  

     public Coordinates setCoordinates(Coordinates coordinates){
         
         return coordinates;}
     
     public void loadImages(String csvFileName){
     
        this.csvFileName = csvFileName;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] Images = line.split(cvsSplitBy);

                

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
     
     public void loadFriends(String csvFileName){
         try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                array = line.split(cvsSplitBy);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
     
     }
     
     public void loadEnemies(String csvFileName){
         try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                array = line.split(cvsSplitBy);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
     
     }
     
     public void loadObstacles(String csvFileName){
         try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                array = line.split(cvsSplitBy);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }   
     }
     
     public void loadPowerups(String csvFileName){
         try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                array = line.split(cvsSplitBy);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
     }
   
}
