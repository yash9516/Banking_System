import java.util.Random;
import java.util.Scanner;

public class Acc 
{ 
    String name;
    
    int bal=0;
    int amount1;
    static int no=0;
    int pin_attempt=0;
   
    int custno;
    
    String pin;
    
    void getDetails()
    {
        Random r = new Random();
        
        System.out.print("Enter your name:");
        Scanner ob=new Scanner(System.in);
        name=ob.nextLine();      
        no++;
        
        custno = no;
        int z = r.nextInt(9999);
        if(z<1000 && z>100)
        {
            pin = "0"+z;
        }
        else if(z<100 && z>10)
        {
            pin = "00"+z;
        }
        else if (z>=0 &&z <10)
        {
            pin = "000"+z;
        }
        else
        {
            pin = ""+z;
        }
        
        System.out.println("Customer no.:" +custno);     
        System.out.println("Balance= Rs." +bal); 
        System.out.println("Pin= " +pin);
        
    }
    
    void showDetails()
    {   
        System.out.print("\t" + "CUSTOMER NO" + "\t");
        System.out.print("\t" + "NAME" + "\t");
        System.out.println("\t" + "BALANCE");
        System.out.print("\t"+custno+"\t");
        System.out.print("\t"+"\t"+name+"\t");     
        System.out.println("\t"+bal);       
        
    }
    
    int Deposit(int amount)
    {       
        bal=bal+amount;
        System.out.println("Trasaction Successfull!");
        System.out.println("Total Balance: Rs."+bal);
        return bal;
    }
  
    int Withdraw(int amount1)
    {        
        bal=bal-amount1;
        System.out.println("Transaction Successfull!");
        System.out.println("Total Balance: Rs."+bal);
        return bal;
    }
    
   /* int Transfer(int amount2 , Acc b1 ,Acc b2)
    {
        System.out.println("In Transfer");
        b1=b1-amount2;
        b2=amount2+b2;
        System.out.println("Transfer Successfull!");
        System.out.println("Balance: "+b2);
        return b2;
    }
    */
    void LoanApp(Acc b )
    {
        System.out.println("Your Balance:" + b.bal);
        
        double c=b.bal*0.5;
        System.out.print("You are eligible for a Loan of: Rs." +c);
        System.out.println("at the rate of 10% p.a");
        double interest1=c*0.1;
        double e=c+interest1;
        double interest2=e*0.1;
        double f=e+interest2;
        double interest3=f*0.1;
        double g=f+interest3;
        System.out.println("Amount to be paid after 1 Year:Rs."+e);
        System.out.println("Amount to be paid after 2 Years:Rs."+f);
        System.out.println("Amount to be paid after 3 Years:Rs."+g);
        
        System.out.println("Apply for Loan?");
        
        int ch1;
        
        {
                        
            System.out.println("\t" + "1.YES");
            System.out.println("\t" + "2.NO");
            Scanner ob6=new Scanner(System.in);
            ch1=ob6.nextInt();
            
            switch (ch1)
            {
                case 1: System.out.println("Enter Tenure of Loan in Years:");
                        Scanner ob5=new Scanner(System.in);
                        int d;
                        d=ob5.nextInt();
                        
                        System.out.println("     *****Loan Approved*****     ");
                        System.out.println("Before Loan:");
                        b.showDetails();
                        b.bal= (int) (b.bal+c);
                        System.out.println("After Loan:");
                        b.showDetails();
                        break;
                        
                case 2: System.out.println("ThankYou for using our services");
                        break;
                default:System.out.println("Please select a valid option");                        
                                              
            }   
            
       }
    }        
    
}
  
class MyException extends Exception
{
    MyException(String msg) 
    {
        super(msg);
    }
}

class NewException extends Exception
{
    NewException(String msg)
    {
        super(msg);
    }
}
class NewException1 extends Exception
{
    NewException1(String msg)
    {
        super(msg);
    }
}

class NewException2 extends Exception
{
    NewException2(String msg)
    {
        super(msg);
    }
}

class NewException3 extends Exception
{
    NewException3(String msg)
    {
        super(msg);
    }
}

class AccMain
{
    public static void main(String[] args) 
    {
        int x=-1;
        
        int ch;
        Acc a[]=new Acc[100];
        do
        {
            Scanner ob=new Scanner(System.in);
            System.out.println("\t" +"MENU");
            System.out.println("\t" + "1.Add Account");
            System.out.println("\t" + "2.Show Account");
            System.out.println("\t" + "3.Deposit");
            System.out.println("\t" + "4.Withdraw");
            System.out.println("\t" + "5.Check Balance");
            System.out.println("\t" + "6.Transer Funds");
            System.out.println("\t" + "7.Loan");
            System.out.println("\t" + "8.Exit");
            System.out.println();
            System.out.println("Enter Choice");
            ch=ob.nextInt();
            
            int i,y,amount,amount1,amount2,p,b1=0,b2=0;
            
            switch (ch)
            {
                case 1: x++;                         
                        a[x]=new Acc(); //IMP. CHECKOUT HOW OBJECT FROM AN ARRAY ACCESSES METHOD OF ANOTHER CLASS
                        a[x].getDetails();
                        break;
                        
                case 2: System.out.println("Enter Cust no.");
                        y=ob.nextInt();
                        p=-1;
                        for (i=0;i<x+1;i++)
                        {
                            if(y==a[i].custno)
                            {
                                p=i;                                                                                         
                            }
                                                                           
                        }
                        if(p==-1)
                        {
                            System.out.println("No Match Found");
                        }
                        else
                        { 
                            a[p].showDetails();
                        }
                        
                        break;
                        
                case 3: System.out.println("Enter Cust no.");
                        y=ob.nextInt();
                        //Check no
                        for(i=0;i<x+1;i++)
                        {
                            if (y==a[i].custno)
                            {
                                a[i].showDetails();
                                System.out.print("Enter amount to Deposit: Rs.");
                                try
                                {
                                    amount=ob.nextInt();
                                    if (amount<0) //Amount cannot be negative
                                    throw new NewException("Enter a valid amount");
                                    else
                                      a[i].Deposit(amount);  
                                } 
                                catch(NewException e1)  
                                {
                                    System.out.println(e1.getMessage());
                                }
                                 
                            }                             
                        }
                                               
                        
                        break;
                case 4: System.out.println("Enter Cust no.");
                        y=ob.nextInt();
                                               
                        
                        
                        String pin1;
                        String pin2;
                        String pin3;
                        
                        //Check no
                        for(i=0;i<x+1;i++)
                        {
                            if (y==a[i].custno) 
                            if (a[i].pin_attempt<3)
                          {      
              first:        {   
                                System.out.println("Enter PIN");
                                Scanner ob2=new Scanner(System.in);
                                pin1=ob2.nextLine();
                                if(a[i].pin.equals(pin1)) break first;
                                
               second:          
                                {
                                    a[i].pin_attempt++;
                                     System.out.println("Re-Enter PIN");
                                     Scanner ob3=new Scanner(System.in);
                                     pin2=ob3.nextLine();
                                     
                                     if(a[i].pin.equals(pin2)) break second;
                                     
                third:               {
                                        a[i].pin_attempt++;
                                        
                                        System.out.println("Re-Enter PIN");
                                        Scanner ob4=new Scanner(System.in);
                                        pin3=ob4.nextLine();
                                        if (a[i].pin.equals(pin3)) break third;
                                         //(a[i].pin!=pin3.intern())
                                         a[i].pin_attempt++;   
                                        if(a[i].pin_attempt==3)
                                        {
                                            System.out.println("Account Blocked");
                                            break;
                                        }   
                                    }
                                    
                                }
                            }            
                                if (a[i].pin_attempt<3)
                                {
                                    a[i].showDetails();
                                    System.out.print("Enter amount to Withdraw: Rs.");
                                    try
                                    {
                                        amount1=ob.nextInt();
                                        if (amount1<=0)
                                        throw new NewException3 ("Amount should be greater than 0");                                                            
                                        else if (amount1>a[i].bal) //Amount cannot be greater than Customer's Balance
                                        throw new NewException1("Insufficient Balance");                                    
                                        else if (amount1%10!=0)
                                        throw new NewException2("Amount should be in multiple of 10");                                                                      
                                        else
                                        a[i].Withdraw(amount1);  
                                    } 
                                        catch (NewException3 e3)
                                        {
                                            System.out.println(e3.getMessage());
                                        }   
                                        catch(NewException1 e1)  
                                        {
                                        System.out.println(e1.getMessage());
                                        }                                    
                                        catch(NewException2 e2)  
                                        {
                                        System.out.println(e2.getMessage());
                                        }
                                }    break;
                                
                                   /* else 
                                    {
                                        
                                        System.out.println("Blocked");
                                        
                                    }   */                            
                          } else System.out.println("Your Account is blocked.");
                                                                                                                                                 
                        }            
                                                                            
                            
                        break;

                case 5: int j;
                        String name1;
                        System.out.println("Enter name of customer");
                        Scanner ob1=new Scanner(System.in);
                        name1=ob1.nextLine();
                        for (j=0;j<x+1;j++)
                        {
                            if (a[j].name.equals(name1))
                                    
                             a[j].showDetails();
                        }
                        break;
                case 6: 
                        System.out.println("Enter Cust no.");
                        y=ob.nextInt();
                        int z,k;
                        //Check no
                        for(i=0;i<x+1;i++)
                        {
                            if (y==a[i].custno)
                            {
                                System.out.println("Enter PIN");
                                Scanner ob2=new Scanner(System.in);
                                pin1=ob2.nextLine();
                                if (a[i].pin.equals(pin1))
                                {
                                    a[i].showDetails();
                                    System.out.println("Rs."+a[i].bal);
                                    System.out.println("Enter Customer no. of Beneficiary");
                                    Scanner ob3= new Scanner (System.in); 
                                    z=ob3.nextInt();
                                    for(j=0;j<x+1;j++)
                                    {
                                        if (z==a[j].custno)
                                        {
                                                a[j].showDetails();
                                                b2=a[j].bal;
                                                System.out.print("Enter amount to Transfer: Rs.");
                                                amount2=ob.nextInt();
                                                
                                                a[j].bal=a[j].bal+amount2;
                                                a[i].bal=a[i].bal-amount2;
                                                System.out.println("Amount Transferred Successfully");
                                                a[j].showDetails();
                                                a[i].showDetails();
                                        }                           
                                    }    
                                }    
                                    
                            }       
                        } break;
                                /*System.out.println("Enter amount to Transfer");
                                    amount2=ob.nextInt();
                                    a[i].Transfer(amount2,a[i],a[j]);*/
                                    /*try
                                    {
                                        amount2=ob.nextInt();
                                        if (amount2<0)
                                        throw new NewException3 ("Amount should be greater than 0");                                                            
                                        else if (amount2>b1) //Amount cannot be greater than Customer's Balance
                                        throw new NewException1("Insufficient Balance");                                    
                                      //  else if (amount1%10!=0)
                                      //  throw new NewException2("Amount should be in multiple of 10");                                                                      
                                        else
                                        a[i].Transfer(amount2,b1,b2);  
                                    } 
                                        catch (NewException3 e3)
                                        {
                                            System.out.println(e3.getMessage());
                                        }   
                                        catch(NewException1 e1)  
                                        {
                                            System.out.println(e1.getMessage());
                                        }  
                                        catch (Exception e)
                                        {
                                            System.out.println(e.getMessage());
                                        }
                                       // catch(NewException2 e2)  
                                        //{
                                        //System.out.println(e2.getMessage());
                                        //}
                                }    
                                    else System.out.println("Incorrect Pin");                               
                            }                                                                                                                                                  
                        }  */   
                case 7: System.out.println("Enter Cust no.");
                        y=ob.nextInt();
                        
                        //Check no
                        for(i=0;i<x+1;i++)
                        {
                            if (y==a[i].custno)
                            { 
                                a[i].showDetails();
                                a[i].LoanApp(a[i]);
                            }
                        }
                        break;
                                
                case 8: System.out.println("Thank You for using this Programme");
                        break;
                default:
                        System.out.println("Enter Choices between 1 to 5");
        
            }                
        }
        while(ch!=8);                                    
    }                  
}
    