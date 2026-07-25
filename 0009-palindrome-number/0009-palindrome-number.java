class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int a=0,b=0;
        int c=x;
        while(x>0){
            a=x%10;
            b=b*10+a;
            x=x/10;
        }
            if(c==b){
                return true;
            }
            else{
                return false;
            }

        }
    }