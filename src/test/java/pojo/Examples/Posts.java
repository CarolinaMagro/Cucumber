package pojo.Examples;

import lombok.Builder;
import lombok.Data;

@Data

public class Posts {
    private int id;
    private String title;
    private String author;


/*    Posts (){}

    public Posts (int id, String title, String author){

    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }


    public static class Builder{

        private int id;
        private String title;
        private String author;

        public Builder(){}

        public Builder setId(int id) {

            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {

            this.title = title;
            return this;
        }

        public Builder setAuthor(String author) {

            this.author = author;
            return this;
        }

    public Posts build(){
            return new Posts(id, title,author);
    }

    }

*/


}
