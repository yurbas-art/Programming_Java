public class MyString {
    private char[] chars;

    public MyString(char[] chars) {
        this.chars = chars;
    }

    public MyString substring(int begin) {
        char[] newChars = new char[this.chars.length - begin];
        for (int i = 0; i < newChars.length; i++) {
            newChars[i] = this.chars[begin + i];
        }
        return new MyString(newChars);
    }

    public MyString substring(int begin, int end) {
        char[] newChars = new char[end - begin];
        for (int i = 0; i < newChars.length; i++) {
            newChars[i] = this.chars[begin + i];
        }
        return new MyString(newChars);
    }

    public boolean equals(Object obj) {
        if (obj instanceof MyString) {
            MyString2 other = (MyString) obj;
            if (this.chars.length != other.chars.length) return false;
            for (int i = 0; i < this.chars.length; i++) {
                if (this.chars[i] != other.chars[i]) return false;
            }
            return true;
        }
        return false;
    }

    public int compareTo(MyString obj) {
        int len1 = this.chars.length;
        int len2 = obj.chars.length;
        int min = Math.min(len1, len2);
        for (int i = 0; i < min; i++) {
            if (this.chars[i] != obj.chars[i]) {
                return this.chars[i] - obj.chars[i];
            }
        }
        return len1 - len2;
    }

    public char[] toChars() {
        return this.chars;
    }

    public static MyString valueOf(boolean b) {
        if (b) {
            return new MyString(new char[]{'t', 'r', 'u', 'e'});
        } else {
            return new MyString(new char[]{'f', 'a', 'l', 's', 'e'});
        }
    }

    public static void main(String[] args) {
        MyString2 s1 = new MyString(new char[]{'a', 'b', 'c'});
        MyString2 s2 = new MyString(new char[]{'a', 'b', 'c'});
        System.out.println(s1.equals(s2));
        System.out.println(s1.compareTo(s2));
        System.out.println(MyString.valueOf(true).toChars().length);
    }
}
