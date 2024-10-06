package study.yunji.subject.phoneBook;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        for (;;) {
            System.out.print("명령어 입력 (ADD, SEARCH, EXIT): ");
            String command = scanner.nextLine().toUpperCase(); // 입력 대문자로 변환

            if (command.equals("ADD")) {
                addContact(scanner, phoneBook);
            } else if (command.equals("SEARCH")) {
                searchContacts(scanner, phoneBook);
            } else if (command.equals("EXIT")) {
                System.out.println("프로그램 종료.");
                break;
            } else {
                System.out.println("잘못된 명령어입니다. (ADD, SEARCH, EXIT 중 입력하세요.)");
            }
        }
    }

    private static void addContact(Scanner scanner, PhoneBook phoneBook) {
        String firstName = "";
        for (;;) {
            System.out.print("성: ");
            firstName = scanner.nextLine();
            if (firstName.equals("")) {
                System.out.println("성은 필수 입력입니다.");
            } else {
                break;
            }
        }

        String lastName = "";
        for (;;) {
            System.out.print("이름: ");
            lastName = scanner.nextLine();
            if (lastName.equals("")) {
                System.out.println("이름은 필수 입력입니다.");
            } else {
                break;
            }
        }

        String nickName = "";
        for (;;) {
            System.out.print("닉네임: ");
            nickName = scanner.nextLine();
            if (nickName.equals("")) {
                System.out.println("닉네임은 필수 입력입니다.");
            } else {
                break;
            }
        }

        String phoneNumber = "";
        for (;;) {
            System.out.print("전화번호: ");
            phoneNumber = scanner.nextLine();
            if (phoneNumber.equals("")) {
                System.out.println("전화번호는 필수 입력입니다.");
            } else {
                break;
            }
        }

        System.out.print("비밀 메세지(선택 사항): ");
        String darkestSecret = scanner.nextLine();

        Contact contact = new Contact(firstName, lastName, nickName, phoneNumber, darkestSecret);
        phoneBook.ADD(contact); // 연락처 추가
        System.out.println("연락처가 추가되었습니다.");
    }

    private static void searchContacts(Scanner scanner, PhoneBook phoneBook) {
        phoneBook.SEARCH(); // 연락처 목록 출력
        int index = -1;

        for (;;) {
            System.out.print("조회할 연락처의 Index를 입력하세요: ");
            String input = scanner.nextLine();

            // 입력값이 숫자인지 확인
            boolean isNumeric = true;

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch < '0' || ch > '9') {
                    isNumeric = false;
                    break;
                }
            }

            if (isNumeric) { // 숫자
                index = Integer.parseInt(input);
                if (index < 0 || index >= phoneBook.getContactCount()) {
                    System.out.println("유효하지 않은 Index 입니다. 다시 입력하세요.");
                } else {
                    break;
                }
            } else {
                System.out.println("Index를 입력하세요.");
            }
        }

        // 인덱스로 연락처 조회
        Contact contact = phoneBook.getContact(index);
        if (contact != null) {
            System.out.println("이름: " + contact.getFirstName());
            System.out.println("성: " + contact.getLastName());
            System.out.println("닉네임: " + contact.getNickName());

            System.out.print("비밀 메시지를 보시겠습니까? (YES or NO): ");
            String response = scanner.nextLine().toUpperCase(); // 대문자로 변환

            if (response.equals("YES")) {
                String darkestSecret = contact.getDarkestSecret();
                if (darkestSecret == null || darkestSecret.isEmpty()) {
                    System.out.println("비밀 메시지가 없습니다.");
                } else {
                    System.out.println("비밀 메시지: " + darkestSecret);
                }
            } else {
                System.out.println("비밀 메시지를 보지 않습니다.");
            }
        } else {
            System.out.println("해당 연락처가 없습니다.");
        }
    }
}
