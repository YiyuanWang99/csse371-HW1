


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeString.search;

class CSVParse {

    public static List<CSVRecord> readCSV(String filePath,String[] headers) throws IOException{

        CSVFormat formator = CSVFormat.DEFAULT.withHeader(headers);

        FileReader fileReader=new FileReader(filePath);

        CSVParser parser=new CSVParser(fileReader,formator);

        List<CSVRecord> records=parser.getRecords();

        parser.close();
        fileReader.close();

        return records;
    }

    public static void main(String a[]) {
        String[] headers = new String[]{"Title","Copyright","Contribute","Publisher","Description","License","ISBN13"};
        String path="textbooks.csv";
        try {
            List<CSVRecord> records = readCSV(path, headers);
//            if(null!=records){
//                System.out.println(records.size());
//            }
            List<textbooks> bookstorage = new LinkedList<textbooks>();
            Boolean exit = false;

                textbooks result;
                for (int i = 1; i < records.size(); i++) {
                    bookstorage.add(new textbooks(records.get(i).get("Title"), records.get(i).get("Copyright"), records.get(i).get("Contribute"), records.get(i).get("Publisher"), records.get(i).get("Description"), records.get(i).get("License"), records.get(i).get("ISBN13")));
//                System.out.println("**** NO." +i +" ****");
//                System.out.println("Title:" + records.get(i).get("Title"));
//                System.out.println("Copyright:" + records.get(i).get("Copyright"));
//                System.out.println("Publisher:" + records.get(i).get("Publisher"));
//                System.out.println("Description:" + records.get(i).get("Description"));
//                System.out.println("License:" + records.get(i).get("License"));;
                 // System.out.println("ISBN:" + records.get(i).get("ISBN13"));
//                System.out.println("\n");
                    //if(records.get(i).get("ISBN13").equals("")) System.out.println("null ISBN");// test the string is null or it's empty string
                }
                //System.out.println("done with a linkedlist" + bookstorage.size());
                System.out.println("Initialize finished");
                while (!exit) {
                    System.out.println("for search with ISBN13, TYPE Search -ISBN13=<ISBN13> to search book with ISBN, For exit, type Exit");
                Scanner inputScanner = new Scanner(System.in);
                String inputMess = inputScanner.nextLine();
                String[] inputs = inputMess.split("-",2);
                String command = inputs[0].trim();
                if (command.equals("Search")) {
                    String ISBN = inputs[1].split("=")[1].trim();
                    //System.out.println(ISBN);
                    result = ISBN.equals(null) ? null : searchwithISBN(bookstorage, ISBN);
                    if (result == null) {
                        System.out.println("The book you search Does not exist, Make suer you type the right,valid ISBN");
                    } else {
                        System.out.println(result.toString());
                    }
                }else if (command.equals("Exit") || command.equals("exite")) exit = true;
            }

            } catch(IOException e){
                e.printStackTrace();
            }

        return;


    }

    private static textbooks searchwithISBN(List<textbooks> bookstorage, String isbn) {
        Iterator<textbooks> iterator = bookstorage.iterator();
        while (iterator.hasNext()){
            textbooks textbook = iterator.next();
            //System.out.println(textbook.ISBN);
            if(textbook.ISBN.equals(isbn)) return textbook;
        }
        return null;
    }


}