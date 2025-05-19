package assignment;

import java.io.*; // try, IOException, BufferedWriter 기능 사용
import java.util.*;

public class BookManager {
    private List<Book> bookList = new ArrayList<>();

    // 책 추가
    public void addBook(Book book) {
        bookList.add(book);
    }

    // 전체 목록 반환
    public List<Book> getBooks() {
        return bookList;
    }

    // CSV 파일로 저장
    public void saveCSV(String fileName) {
        // try, catch문을 활용하여 프로그램 오류 방지, 예외처리
        // BufferedWriter(): 문자열 효율적으로 처리를 위하여 사용
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName)))
        {
            // bookList의 객체들을 하나씩 book변수에 담고 실행
            for (Book book : bookList) {
                writer.write(book.toCSVLine());
                writer.newLine();
            }
            // 상태 출력
            System.out.println("저장 완료: " + fileName);
        } catch (IOException e) {   // 예외처리
            System.err.println("저장 실패: " + e.getMessage());
        }
    }

    // CSV 파일에서 불러오기
    public void loadCSV(String fileName) {
        bookList.clear(); // 목록 초기화
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Book book = Book.fromCSV(line);
                if (book != null)
                    bookList.add(book);
            }
            // 상태 출력
            System.out.println("불러오기 완료: " + fileName);
        } catch (IOException e) {   // 예외처리
            System.err.println("불러오기 실패: " + e.getMessage());
        }
    }
}
