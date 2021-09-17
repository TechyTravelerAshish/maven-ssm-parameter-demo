package com.ams.demo_aws_ssm_parameter;

import org.apache.log4j.BasicConfigurator;

public class MainClass 
{
	public static String dburl = null;
	
	public static void main(String args[]) 
	{
		BasicConfigurator.configure();
		
		dburl = FetchSSMParameter.Fetch_SSM_Parameter("/my-app/dev/db-url");
		
		System.out.println("dburl :- " + dburl);
		
		
		
		
    }


}
