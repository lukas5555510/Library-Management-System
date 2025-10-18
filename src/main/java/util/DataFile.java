package util;

public enum DataFile {
    BOOK("saved_books.dat"),
    MEMBER("saved_members.dat");
    private final String filename;

    DataFile(String filename) {this.filename=filename;}
    public String getFilename(){return filename;}

}
