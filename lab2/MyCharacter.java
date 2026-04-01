public class MyCharacter {
    private char value;

    public MyCharacter(char value) {
        this.value = value;
    }

    public char charValue() {
        return value;
    }

    public int compareTo(MyCharacter anotherCharacter) {
        return this.value - anotherCharacter.value;
    }

    public boolean equals(Object obj) {
        if (obj instanceof MyCharacter) {
            return this.value == ((MyCharacter) obj).value;
        }
        return false;
    }

    public boolean isDigit() {
        return Character.isDigit(value);
    }

    public static boolean isDigit(MyCharacter ch) {
        return Character.isDigit(ch.value);
    }

    public static boolean isLetter(MyCharacter ch) {
        return Character.isLetter(ch.value);
    }

    public static boolean isLetterOrDigit(MyCharacter ch) {
        return Character.isLetterOrDigit(ch.value);
    }

    public static void main(String[] args) {
        MyCharacter c1 = new MyCharacter('5');
        MyCharacter c2 = new MyCharacter('a');
        System.out.println(c1.isDigit());
        System.out.println(c2.isLetter());
        System.out.println(c1.compareTo(c2));
    }
}
