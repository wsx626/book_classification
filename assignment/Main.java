package assignment;

import java.util.*;

public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      BookManager manager = new BookManager();
      String fileName = "books.csv";

      while(true)
      {
         // menu 출력
         System.out.println("\n===== 관리 메뉴 =====");
         System.out.println("[1] 책 추가");
         System.out.println("[2] 책 삭제");
         System.out.println("[3] 책 목록 보기");
         System.out.println("[4] 저장");
         System.out.println("[5] 불러오기");
         System.out.println("[0] 종료");
         System.out.print("번호 선택: ");

         // 번호 받기
         String input = sc.nextLine();

         switch(input)
         {
            // 책 추가
            case "1":
               System.out.print("[1] 문학\n[2] 비문학\n번호를 선택하세요: ");
               String type = sc.nextLine();
               System.out.print("책 제목: ");
               String title = sc.nextLine();
               System.out.print("저자: ");
               String author = sc.nextLine();
               if(type.equals("1")){
                  System.out.print("분류_국가: ");
                  String nation = sc.nextLine();
                  manager.addBook(new Fiction(title, author, nation));
               }
               else if(type.equals("2"))
               {
                  System.out.print("분류_주제: ");
                  String subject = sc.nextLine();
                  manager.addBook(new NonFiction(title, author, subject));
               }
               else  System.out.println("잘못된 입력입니다.");
               break;
            // 책 삭제
            case "2":
               break;
            // 책 목록 보기
            case "3":
               List<Book> books = manager.getBooks();
               if (books.isEmpty()) {
                  System.out.println("책 목록이 비어 있습니다.");
               } else {
                  System.out.println("=== 책 목록 ===");
                  for (Book book : books) { // bookList의 객체들을 하나씩 book변수에 담고 실행
                     System.out.println("- " + book); // toString()은 자동 호출됨, 리스트 출력
                  }
               }
               break;
            // 저장
            case "4":
               manager.saveCSV(fileName);
               break;
            // 불러오기
            case "5":
               manager.loadCSV(fileName);
               break;
            // 종료
            case "0":
               System.out.println("프로그램을 종료합니다.");
               System.out.println("202478092 이유진");
               sc.close();
               return;
            default:
               System.out.println("잘못된 압력입니다."); // 예외처리

         }
      }

      // manager.addBook(new Fiction("데미안", "헤르만 헤세", "독일"));
      // manager.addBook(new NonFiction("자유론", "존 스튜어트 밀", "철학"));

      // List<Book> books = manager.getBooks();
   }
}