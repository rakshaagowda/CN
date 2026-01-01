package CN_LAB;

import java.util.*;
class FrameSort {
    int fnum;
    String content;
    FrameSort(int a,String b){
        this.fnum=a;
        this.content=b;
    }
    public static void sort(int n,FrameSort[] F){
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(F[j].fnum>F[j+1].fnum){
                    FrameSort temp=F[j];
                    F[j]=F[j+1];
                    F[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of frames: ");
        int n=sc.nextInt();
        FrameSort[] F=new FrameSort[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter frame number andf"+(i+1)+": ");
            int a=sc.nextInt();
            System.out.print("Enter content of frame "+(i+1)+": ");
            String b=sc.next();
            F[i]=new FrameSort(a,b);
        }

        List<FrameSort> list=Arrays.asList(F);
        Collections.shuffle(list);
        F=list.toArray(new FrameSort[0]);

         System.out.println("\nBefore Sorting (Shuffled frames):");
        for (int i = 0; i < n; i++) {
            System.out.print(F[i].content + " ");
        }

        sort(n,F);

         System.out.println("\n\nAfter Sorting the frames:");
        for (int i = 0; i < n; i++) {
            System.out.print(F[i].content + " ");
        }
        System.out.println();

        sc.close();
    }
}