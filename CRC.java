package CN_LAB;
import java.util.*;
public class CRC {
    public static String divide(char[] divident,char[] divisor){
        int n=divident.length;
        int m=divisor.length;
        for(int i=0;i<n;i++){
            if(n-i<m)
                    break;
            for(int j=0;j<m;j++){
                divident[i+j]=divisor[j]=='0'?divident[i+j]:divident[i+j]=='1'?'0':'1';
            }
        }
        return new String(divident).substring(n-m+1);
    }

    public static String  encode(String data,String key){
        String Zeroes="";
        for(int i=0;i<key.length()-1;i++){
            Zeroes+="0";
        }
        return data+divide((data+Zeroes).toCharArray(),key.toCharArray());

    }
    public static boolean decode(String codeword,String key){
        return divide(codeword.toCharArray(),key.toCharArray()).contains("1");
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter data: ");
        String data=sc.nextLine();
        System.out.print("Enter key: ");
        String key=sc.nextLine();

        String codeword=encode(data,key);
        System.out.println("Encoded data (codeword): "+codeword);

        System.out.print("Enter received codeword: ");
        String recv_codeword=sc.nextLine();
        if(decode(recv_codeword,key)){
            System.out.println("Error detected in received codeword.");
        }else{
            System.out.println("No error detected in received codeword.");
        }
        sc.close();
    }
}
