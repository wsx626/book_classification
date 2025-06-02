package assignment;

public abstract class Book
{
    // 필드, 캡슐화 적용
    private String title;
    private String author;

    // 생성자
    Book(String title, String author)
    {
        this.title = title;
        this.author = author;
    }

    // getter
    public String getTitle(){
        return title;
    }
    public String getAuthor()
    {
        return author;
    }

    // 객체 -> csv
    // A,B,C,D 꼴로 저장
    public String toCSVLine() {
        return String.join(",", getType(), getTitle(), getAuthor(), getExtraInfo());
    }
    // 도서 출력
    // A / B, C 꼴로 출력
    @Override
    public String toString() {
        return String.format("%s / %s, %s", getTitle(), getAuthor(), getExtraInfo());
    }

    // Fiction, NonFiction
    protected abstract String getType();

    // nation, subject
    protected abstract String getExtraInfo();


    // csv -> 객체
    public static Book fromCSV(String line)
    {
        String[] parts = line.split(",",-1); // "".split(): 문자열 자르기

        // 자른 문자열을 각 변수에 저장
        String type = parts[0];
        String title = parts[1];
        String author = parts[2];
        String extra = parts[3];

        // type에 따라 분류
        return switch (type) {
            case "Fiction" -> new Fiction(title, author, extra);
            case "NonFiction" -> new NonFiction(title, author, extra);
            default -> null;
        };
    }
}