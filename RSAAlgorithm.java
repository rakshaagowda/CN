package CN_LAB;
import java.math.*;
import java.util.*;
class RSAAlgorithm{
    BigInteger puk,prk,mod;
    void getKeys(int bitlen ){
        Random r = new Random();
        BigInteger p = BigInteger.probablePrime(bitlen,r);
        BigInteger q =   BigInteger.probablePrime(bitlen,r);
        mod=p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        puk= BigInteger.probablePrime(bitlen/2,r);
        while(!(phi.gcd(puk).equals(BigInteger.ONE))||puk.compareTo(phi)>=0){
            puk=BigInteger.probablePrime(bitlen/2,r);
        }
        prk=puk.modInverse(phi);
    }
    BigInteger encrypt(BigInteger m){
        return m.modPow(puk,mod);
    }
    BigInteger decrypt(BigInteger c){
        return c.modPow(prk,mod);
    }
}
class RSA {
    public static void main(String args[]){
        RSAAlgorithm rsa =  new RSAAlgorithm();
        rsa.getKeys(512);
        Scanner sc = new Scanner(System.in);
        BigInteger m = new BigInteger(sc.nextLine().getBytes());
        BigInteger c = rsa.encrypt(m);
        BigInteger d = rsa.decrypt(c);
      //  System.out.println("Original Message: " + new String(m.toByteArray()));
        System.out.println("Encrypted Message: " + c);
        System.out.println("Decrypted Message: " + new String(d.toByteArray()));
        sc.close();
    }
}
