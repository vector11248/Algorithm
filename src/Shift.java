public class Shift {
    public static void main(String[] args) {
        System.out.println(match("star","sart"));

    }
    private static boolean match(String a,String b){
        if(a.length()!=b.length()) return false;
        for(int i=0;i<a.length();i++){
            boolean flag = true;
            for (int j = 0; j < b.length(); j++) {
                if(a.charAt((i+j)%a.length()) != b.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
        }

        return false;

    }
}
