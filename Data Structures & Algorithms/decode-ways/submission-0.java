class Solution {
    public int numDecodings(String s) {
        int n = s.length(); 
        if(n==0) return 0;
        if(n==1)
        {
            if(s.equals("0")) return 0;
            return 1;
        } 

        int a = 1;
        int b = (s.charAt(n-1)=='0') ? 0 : 1;
        int c=0;

        for(int i=n-2;i>=0;i--)
        {
            if(s.charAt(i)=='0'){
                c=0;
            }
            else{
                int num = (s.charAt(i)-'0')*10 + (s.charAt(i+1)-'0');
                if(num<=26)
                {
                    c=a+b;
                }
                else c=b;
            }
            a=b;
            b=c;
        }
        return c;
    }
}
