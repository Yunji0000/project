package study.yunji.subject.phoneBook;

class PhoneBook {
    private Contact[] contacts;
    private int contactCurrentNum; // 현재 연락처 수

    // 생성자
    public PhoneBook() {
        this.contacts = new Contact[8]; // 최대 8개 저장
        this.contactCurrentNum = 0;
    }

    public void ADD(Contact newContact) {
        if (contactCurrentNum < 8) {
            contacts[contactCurrentNum] = newContact;
            contactCurrentNum++;
        } else {
            // 오래된 연락처 교체
            for (int i = 0; i < 7; i++) {
                contacts[i] = contacts[i + 1];
            }
            contacts[7] = newContact; // 새로운 연락처 추가
        }
    }

    public void SEARCH() {
        System.out.printf("%10s|%10s|%10s|%10s|%10s\n", "Index", "FirstName", "LastName", "NickName", "PhoneNumber"); // 오른쪽 정렬
        for (int i = 0; i < contactCurrentNum; i++) {
            System.out.printf("%10d|%10s|%10s|%10s|%10s\n", i,
                    formatString(contacts[i].getFirstName()),
                    formatString(contacts[i].getLastName()),
                    formatString(contacts[i].getNickName()),
                    formatString(contacts[i].getPhone_number())); // 전화번호 추가
        }
    }

    public Contact getContact(int index) {
        if (index >= 0 && index < contactCurrentNum) {
            return contacts[index];
        }
        return null;
    }

    public int getContactCount() {
        return contactCurrentNum;
    }

    private String formatString(String input) {
        String result = ""; // 결과를 저장

        // 10글자 초과 체크
        if (input.length() > 10) {
            for (int j = 0; j < 9; j++) {
                result += input.charAt(j);
            }
            result += "."; // 마지막에 '.' 추가
        } else {
            result = input; // 10글자 이하 -> 원래 문자열
        }

        for (int k = result.length(); k < 10; k++) {
            result = " " + result; // 왼쪽에 공백 추가
        }

        return result;
    }
}
