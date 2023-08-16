package activities;

public class Activity4 {
    public static void main(String[] args) {
        int[] a={4,3,2,10,12,1,5,6};
        int i,j;
        System.out.println("Before sorting:");
        for(i=0;i<a.length;i++) {
            System.out.println(a[i]+ " ");
        }

        for(i=1;i<a.length;i++){
            int temp= a[i];
            int k=i-1;
            while((k>=0 && a[k] > temp)){
                a[k+1] = a[k];
                k=k-1;
                }
            a[k+1]= temp;
        }
        System.out.println("After sorting:");
        for(i=0;i<a.length;i++) {
            System.out.println(a[i]+" ");
        }

    }
}
