package com.ams.demo_aws_ssm_parameter;

//import org.apache.log4j.BasicConfigurator;

public class MainClass 
{
	public static String dburl,dbpassword = null;
	
	public static void main(String args[]) 
	{
		//BasicConfigurator.configure();
		
		dburl = FetchSSMParameter.Fetch_SSM_Parameter("/my-app/dev/db-url");
		dbpassword = FetchSSMParameter.Fetch_SSM_Parameter("/my-app/dev/db-password");
		
				
		System.out.println("dburl :- " + dburl);
		System.out.println("dbpassword :- " + dbpassword);
		
		
		
    }


}
