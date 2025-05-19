package assignment;

public class NonFiction extends Book {
    private String subject;
    // 생성자
    public NonFiction(String title, String author, String subject) {
        super(title, author);
        this.subject = subject;
    }

    // getter
    public String getSubject() {
        return subject;
    }

    @Override
    protected String getType() {
        return "NonFiction";
    }
    // 비문학임으로 추가정보는 과목
    @Override
    protected String getExtraInfo() {
        return subject;
    }
}
