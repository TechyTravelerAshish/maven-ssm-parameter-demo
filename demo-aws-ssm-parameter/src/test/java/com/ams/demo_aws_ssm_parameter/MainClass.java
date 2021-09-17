package com.ams.demo_aws_ssm_parameter;

//import org.apache.log4j.BasicConfigurator;

public class MainClass 
{
	public static String dburl,dbusername,dbpassword = null;
	
	public static void main(String args[]) 
	{
		//BasicConfigurator.configure(); // Use this line to suppress log4j warning, but it will add many debug log lines to output
		
		dburl = FetchSSMParameter.Fetch_SSM_Parameter("/ams-transformation/nonprod/rds-mysql/dburl");
		dbusername = FetchSSMParameter.Fetch_SSM_Parameter("/ams-transformation/nonprod/rds-mysql/db-username");
		dbpassword = FetchSSMParameter.Fetch_SSM_Parameter("/ams-transformation/nonprod/rds-mysql/db-password");
		
		System.out.println(" ");	
		System.out.println("------------ SSM PARAMETER STORE ------------");
		System.out.println(" ");
		System.out.println("dburl :- " + dburl);
		System.out.println("dbusername :- " + dbusername);
		System.out.println("dbpassword :- " + dbpassword);
		System.out.println(" ");
		System.out.println("---------------------------------------------");
	
    }


}
