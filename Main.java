package assignment;

import java.util.*;

public class Main {
   public static void main(String[] args) {

      BookManager manager = new BookManager();

      // 책 추가 예시(문학 1개, 비문학 1개)
      // 추후 개별 미니프로젝트에서 사용자 입력으로 변경 예정
      manager.addBook(new Fiction("데미안", "헤르만 헤세", "독일"));
      manager.addBook(new NonFiction("자유론", "존 스튜어트 밀", "철학"));

      // list을 CSV로 저장
      String fileName = "books.csv";
      manager.saveCSV(fileName);
      
      // CSV파일 불러오기
      manager = new BookManager();
      manager.loadCSV(fileName);

      List<Book> books = manager.getBooks();
      for (Book book : books) {  // bookList의 객체들을 하나씩 book변수에 담고 실행
         System.out.println("- " + book.toString()); // 리스트 출력
      }
   }
}