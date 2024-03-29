import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        for(String filename : files) {
            System.out.println(filename);
        }
    }

    /**
     * List the names of files matching the given search string.
     * @param searchString The string to match.
     */
    public void listMatching(String searchString)
    {
        for(String filename : files) {
            if(filename.contains(searchString)) {
                System.out.println(filename);
            }
        }
    }
    
    


    public int findFirst(String searchString)
    {
        int index = 0; //index die gebruikt wordt
        boolean searching = true; //Zoekt net zo lang tot er een match is gevonden

        do { //de loop
           String filename = files.get(index); //
           if(filename.contains(searchString)) { //controleren of de filename de stringnaam bevat
                searching = false; //dan stoppen met zoeken
            }else { //anders
                index++; //index met 1 verhogen en opnieuw porberen
            }
        } while(searching && index < files.size()); //de index moet kleiner zijn dan het totaal aantal tracks

        if(searching) { //als er geen match is gevonden retourneer -1
            return -1;
        }
        else { // is er wel een match gevonden, retourneer de index van desbetreffende match
            return index;
        }
    }
    
    /**
    
    public int findFirst(String searchString)
    {
        int index = 0;
        // Record that we will be searching until a match is found.
        boolean searching = true;

        while(searching && index < files.size()) {
            String filename = files.get(index);
            if(filename.contains(searchString)) {
                // A match. We can stop searching.
                searching = false;
            }
            else {
                // Move on.
                index++;
            }
        }
        if(searching) {
            // We didn't find it.
            return -1;
        }
        else {
            // Return where it was found.
            return index;
        }
    }
    
    */

    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
}
