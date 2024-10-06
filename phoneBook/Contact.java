package study.yunji.subject.phoneBook;

public class Contact {
    private String firstName;
    private String lastName;
    private String nickName;
    private String phoneNumber;
    private String darkestSecret;

    // 생성자
    public Contact(String firstName, String lastName, String nickName, String phoneNumber, String darkestSecret){
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
        this.darkestSecret = darkestSecret;
    }

    // Getter 메서드
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPhone_number() {
        return phoneNumber;
    }

    public String getDarkestSecret() {
        return darkestSecret;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", darkestSecret='" + darkestSecret + '\'' +
                '}';
    }

}

