import java.util.Arrays;
import java.util.Scanner;

/*
 Create a class Sim with below attributes:
simId - int
customerName - String
balance - double
ratePerSecond - double
circle - String
Write getters, setters and parameterized constructor as required.
Public class Solution is already created with main method.Code inside main method should not be altered else your solution might be
scored as zero.You may copy the code from main method in eclipse to verify your implementation.

Implement static method - transferCustomerCircle in Solution class.This method will take first parameter as array of Sim class objects,
second parameter as circle to be transferred (which is String parameter circle1) and third parameter as new circle (which is String parameter circle2).

Method will transfer the customer to new circle (circle2), where the circle attribute would match second parameter (circle1).

Method will return array of Sim objects for which circle is transferred.Return array should be sorted in descending order of ratePerSecond
(assuming ratePerSecond is not same for any of the Sim objects).
This method should be called from main method and display the simId,customerName,circle and ratePerSecond of returned objects(as per sample output).

Main method mentioned above already has Scanner code to read values,create objects and test above methods.Hence do not modify it.
************************************************************************
Consider below sample input and output:
Input:
1
raj
100
1.5
KOL
2
chetan
200
1.6
AHD
3
asha
150
1.7
MUM
4
kiran
50
2.2
AHD
5
vijay
130
1.8
AHD
AHD
KOL

Output:
4 kiran KOL 2.2
5 vijay KOL 1.8
2 chetan KOL 1.6
*/
public class Sim
{
    public static void main(String [] args)
    {
        Sime arr[]=new Sime[5];
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i < arr.length; i++)
        {
          int a= sc.nextInt();sc.nextLine();
          String b=sc.nextLine();
          double c=sc.nextDouble();sc.nextLine();
          double d= sc.nextDouble();sc.nextLine();
          String e=sc.nextLine();
          arr[i]=new Sime(a,b,c,d,e);
        }
        String inputCircle1=sc.nextLine();
        String inputCircle2=sc.nextLine();

        Sime msxx[]=transferCustomerCircle(arr,inputCircle1,inputCircle2);
        if(msxx==null)
        {
            System.out.println("nothing");
        }
        else
        {
            for (int i = 0; i < msxx.length ; i++)
            {
                System.out.println(msxx[i].simId+" "+msxx[i].customerName+" "+msxx[i].circle+" "+msxx[i].ratePerSecond);
            }
        }
    }
    public static Sime[] transferCustomerCircle(Sime arr[],String input1,String input2)
    {
        Sime[]ary=new Sime[0];
        for (int i = 0; i <arr.length ; i++)
        {
         if(arr[i].circle.equalsIgnoreCase(input1))
         {
             arr[i].circle=input2;
           ary= Arrays.copyOf(ary,ary.length+1);
           ary[ary.length-1]=arr[i];
         }
        }
        for (int i = 0; i <ary.length-1 ; i++)
        {
            for (int j = 0; j < ary.length-i-1 ; j++)
            {
                if(ary[j].ratePerSecond<ary[j+1].ratePerSecond)
                {
                    Sime temp=ary[j];
                    ary[j]=ary[j+1];
                    ary[j+1]=temp;
                }
            }
        }
        if(ary.length==0) {
            return null;
        }
        else {
            return ary;
        }

    }
}
class Sime
{
    int simId;
    String customerName;
    double balance;
    double ratePerSecond;
    String circle;
    public Sime(int simId,String customerName,double balance,double ratePerSecond,String circle)
    {
        this.simId=simId;
        this.customerName=customerName;
        this.balance=balance;
        this.ratePerSecond=ratePerSecond;
        this.circle=circle;
    }
}
