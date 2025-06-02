package assignment;

public class Fiction extends Book {
    private String nation;
    // 생성자
    public Fiction(String title, String author, String nation) {
        super(title, author);
        this.nation = nation;
    }

    // getter
    public String getNation() {
        return nation;
    }

    // 문학으로 분류
    @Override
    protected String getType() {
        return "Fiction";
    }
    // 문학임으로 추가정보는 국가
    @Override
    protected String getExtraInfo() {
        return nation;
    }

}