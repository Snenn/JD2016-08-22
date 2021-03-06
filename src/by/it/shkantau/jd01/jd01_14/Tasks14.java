package by.it.shkantau.jd01.jd01_14;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

class Tasks14 {

    private static String src = System.getProperty("user.dir")+"/src/by/it/shkantau/";

    static void taskA() throws IOException {
         int arraySize = 20;
         String fileName = src + "jd01_14/Tasks.dat";
         File file = new File(fileName);
// File creation
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
            for (int i = 0; i < arraySize; i++) {
                dos.writeInt((int)(Math.random()*100));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file Exception "+ fileName);
        }
// File reading
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))){
            int mean = 0, count = 0;
            while(dis.available() > 0){
                mean += dis.readInt();
                count++;
            }
            System.out.println("mean = "+(double)mean/(double) count);
        }catch(IOException e){
            System.out.println(e.toString());
        }
        Charset charset;
    }

    static void taskB() throws FileNotFoundException {
        String fileName = src + "jd01_14/TaskB.txt";
        File file = new File(fileName);

        int punctCounter = 0, wordsCounter = 0;
        Scanner scanner = new Scanner(file);

        scanner.useDelimiter("[.,!?]+");
//Count punctuation symbols
        while (scanner.hasNext()){
            punctCounter++;
            scanner.next();
        }
        scanner = new Scanner(file);
        scanner.useDelimiter("[a-zA-Z]+");
//Count punctuation symbols
        while (scanner.hasNext()){
            wordsCounter++;
            scanner.next();
        }
        scanner.close();
        System.out.println("punctCounter = " + punctCounter + ", wordsCounter = "+wordsCounter);
    }

    static void taskC(){
        String rootDir = System.getProperty("user.dir") + "/src/by/it/shkantau/";

        File file  = null;
        try {
            file = new File(rootDir);
        } catch (NullPointerException e) {
            System.out.println("Path can't be empty.");
        }
        assert file != null;
        if (file.exists()) {
//Print root directory
            System.out.println(file.getName());
            recursiveFilePrinter(file, 1);
        }else{
            System.out.println("Wrong source path.");
        }
    }

    private static void recursiveFilePrinter(File file, int depth){
        String [] filesNameArray = file.list();
        File tmpFile;
        if (filesNameArray != null) {
            for (String fileName : filesNameArray) {
                tmpFile = new File(file.getPath() + "/" + fileName);
                if (tmpFile.isDirectory() && !tmpFile.isHidden()) {
                    for (int i = 0; i < depth; i++) {
                        System.out.print("\t");
                    }
                    System.out.println(fileName);
                    recursiveFilePrinter(tmpFile, depth+1);
                }
                else{
                    for (int i = 0; i < (depth); i++) {
                        System.out.print("\t");
                    }
                    System.out.println(fileName);

                }
            }
        }
    }

}
