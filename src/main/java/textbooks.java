public class textbooks {

    String title;
    String copyright;
    String contributor;
    String publisher;
    String description;
    String license;
    String ISBN;


    public textbooks(String title, String copyright, String contributor, String publisher, String description, String license, String ISBN ){
        this.title = title;
        this.contributor = contributor;
        this.copyright = copyright;
        this.description = description;
        this.publisher = publisher;
        this.license = license;
        this.ISBN = ISBN;
        if(this.ISBN.contains(".00")) this.ISBN = this.ISBN.substring(0,this.ISBN.length()-3);
    }

    public String toString(){
        String textString = "****************** Book information ******************" + "\n" + "* Book Title: " + this.title +"\n" + "* Contributor: " + this.contributor+"\n" + "* Copyright: " + this.copyright
              +"\n"  + "* Description: " + this.description +"\n"+ "* Publisher: " + this.publisher+"\n" + "* License: " + this.license +"\n"+ "* ISBN13 " + this.ISBN + "\n" +"******************************************************";
        return textString;
    }
}
