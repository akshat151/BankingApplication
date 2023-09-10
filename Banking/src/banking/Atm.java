package banking;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.*;
import java.text.*;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.rmi.Naming;

public class Atm
{
		public Atm(){};
		public void display() throws RemoteException,NotBoundException, MalformedURLException
		{
				Scanner in = null;
				BankInterface stub = (BankInterface) Naming.lookup("rmi://localhost:1913/BankInterface");
				in = new Scanner(System.in);
				
				try
				{
						while(true)
						{
								System.out.println("1 : check_balance");
								System.out.println("2 : deposit_money");
								System.out.println("3 : withdraw_money");
								System.out.println("4 : transaction details between dates") ;
								System.out.println("5 : transaction details") ;
								System.out.println("6 : addaccount");
								int type = in.nextInt() ;
								if(type == 0) break ;
								else if (type == 1)
								{
									System.out.println("Enter Account Number:");
										String ac = in.next();
										int b = stub.inquiry(ac);
										System.out.println("Av. Balance:" + b);
								}
								else if(type == 2)
								{
									System.out.println("Enter Account Number");
										String ac = in.next();
										System.out.println("Enter Amount:");
										int amount = in.nextInt();
										tuple ans = stub.deposit(ac,amount);
										if(ans.getId() ==0 && ans.getbalance()==0)
												System.out.println("Account doesnt exist");
										else
										{
												System.out.println("Amount deposited");
												System.out.println("Transaction Id:" + ans.getId() );
												System.out.println("Updated balance:" + ans.getbalance());
										}
								}
								else if(type == 3)
								{
									System.out.println("Enter Account Number");
										String ac = in.next();
										System.out.println("Enter Amount:");
										int amount = in.nextInt();
										
										tuple ans = stub.withdraw(ac,amount);
										if(ans.getId() ==0 && ans.getbalance()==0)
												System.out.println("Account doesnt exist");
										else
										{
												System.out.println("Amount deposited");
												System.out.println("Transaction Id:" + ans.getId() );
												System.out.println("Updated balance:" + ans.getbalance());
										}
								}
								else if(type == 4)
								{
									System.out.println("Enter Account Number");
										String ac = in.next();
										System.out.println("Enter dates in format yyyy-MM-dd");
										String date1 = in.next();
										String date2 = in.next();
										SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
										Date start_date = null;
										Date end_date = null;
										try
										{
												start_date = df.parse(date1);
												end_date = df.parse(date2);
										}
										catch (ParseException e)
										{
												System.out.println(e);
										}
										List<Transaction> ans = stub.transaction_history(ac,start_date,end_date);
										String leftAlignFormat = "| %-5s| %-30s |%n";
										System.out.format("+------+--------------------------------+%n");
										System.out.format("| ID   | Transaction Date and Time      |%n");
										System.out.format("+------+--------------------------------+%n");
										for(int i = 0;i < ans.size();++i)
										{
												System.out.format(leftAlignFormat,ans.get(i).getId() , ans.get(i).getDate()) ;
										}
										System.out.format("+------+--------------------------------+%n");
								}
								else if(type == 5)
								{
									System.out.println("Enter Account Number");
										String ac = in.next();
										List<Transaction> ans = stub.transaction_history(ac);
										String leftAlignFormat = "| %-5s| %-30s |%n";
										System.out.format("+------+--------------------------------+%n");
										System.out.format("| ID   | Transaction Date and Time      |%n");
										System.out.format("+------+--------------------------------+%n");
										for(int i = 0;i < ans.size();++i)
										{
												System.out.format(leftAlignFormat,ans.get(i).getId() , ans.get(i).getDate()) ;
										}
										System.out.format("+------+--------------------------------+%n");
								}
								else if(type == 6)
								{
									System.out.println("Enter Name:");
										String name = in.next();
										System.out.println("Enter account number");
										String ac = in.next();
										System.out.println("Enter contact number:");
										String contactinfo = in.next();
										System.out.println("Enter Type of account:\n1. Saving\n2.Current");
										String type2 = in.next();
										System.out.println("Enter Initial deposite");
										int balance = in.nextInt();
										stub.addaccount(name,ac,contactinfo,type2,balance);
								}
						}
				}
				catch(Exception e)
				{
						System.out.println(e) ;
				}

		}
}
