
package funzioni.pkg15.pkg03.pkg2020;
import java.util.Scanner;
public class Funzioni15032020 
{
    
    /**riempivett
     * 
     * semplice funzione per riempire un vettore e determinarne il numero
     * di oggetti.
     * 
     * @param vett
     * @return 
     */
    static int riempivett(int vett[])
    {
        int n=0;
        Scanner scannervar = new Scanner(System.in);
        System.out.print("quanti n?");
        n = scannervar.nextInt();
        for(int i=0; i<n; i++)
        {
            vett[i] = scannervar.nextInt();
        }
        return n;
    }
    
    /**multiminimo
     * 
     * determina se tutti gli oggetti del vetttore sono multipli del
     * minimo. per fare questo prima trova il minimo e poi cerca il resto
     * della divisione di ogni oggetto con esso.
     * 
     * @param vett
     * @param n
     * @return 
     */
    static int multiminimo(int vett[], int n)
    {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++)
        {
            if(vett[i]<min)
            {
                min = vett[i];
            }
        }
        for(int i=0; i<n; i++)
        {
            if(vett[i]%min!=0)
            {
                return 0;
            }
        }
        return 1;
    }
    
    
    
    /**quantimassimi
     * 
     * determina il numero massimo del vettore (è un po' buggato con solo 
     * un massimo ma Hey, non mi pagano abbastanza per questo). una volta 
     * trovato ne determina le coordinate e le inserisce in un secondo
     * vettore.
     * 
     * @param vett
     * @param n 
     */
    static void quantimassimi(int vett[], int n)
    {
        int max = Integer.MIN_VALUE, coordmax[] = new int[100], massimi=0, k=0;
        for(int i=0; i<n; i++)
        {
            if(vett[i]>max)
                max = vett[i];
        }
        for(int i=0; i<n; i++)
        {
            if(vett[i]==max)
            {
                massimi++;
                coordmax[k] = i;
                k++;                
            }
        }
        if(massimi!=0)
        {
            System.out.print("ci sono "+k+" numeri massimi e sono alle coordinate ");
            for(int i=0; i<k; i++)
            {
                System.out.print((coordmax[i]+1)+" ");
            }
        }
        System.out.println();        
    }
    
    
    /**CRE.DE.MIST
     * Crescente
     * Decrescente
     * Misto
     * 
     * determina l'ordine degli oggetti di un vettore, dividendolo in
     * ordine crescente, decrescente o misto.
     * 
     * @param vett
     * @param n 
     * 
     * (side note, uno switch potrebbe essere aggiunto per comodità)
     */
    static void credemist(int vett[], int n)
    {
        int crescente =0, decrescente=0;
        for(int i=0; i<n-1; i++)
        {
            if(vett[i]<vett[i+1])
            {
                crescente++;
            }
            if(vett[i]>vett[i+1])
            {
                decrescente++;
            }
        }
        
        if(decrescente == n-1)
        {
            System.out.println("gli oggetti sono in ordine decrescente");
        }
        if(crescente == n-1)
        {
            System.out.println("gli oggetti sono in ordine crescente");
        }
        if(crescente != n-1 && decrescente != n-1)
        {
            System.out.println("gli oggetti sono in ordine misto");
        }
    }
    
    
    //main
    public static void main(String[] args) 
    {
        Scanner scannervar = new Scanner(System.in);
        int n=0, isminimo=0;
        int vett[] = new int[100];
        n = riempivett(vett);
        isminimo = multiminimo(vett,n);
        if(isminimo==1)
            System.out.println("tutti i numeri sono multipli del minimo.");
        if(isminimo==0)
            System.out.println("c'è qualche numero che non è multiplo del minimo.");
        quantimassimi(vett, n);
        credemist(vett,n);
    }
    
}
